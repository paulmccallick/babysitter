package babysitter

import grails.test.*
import org.joda.time.*
import grails.plugins.springsecurity.*
import groovy.mock.interceptor.MockFor;

class SittingSessionControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }
	
	void testShowGetsTheCorrectInstance(){
		def ses = DomainGenerator.createSittingSession()
		def secControl = mockFor(SpringSecurityService)
		secControl.demand.getCurrentUser{-> new Family(name:'x',id:4)}
		ses.satFamily = new Family(name:'x',id:1)
		mockDomain(SittingSession,[ses])
		def c = new SittingSessionController()
		c.springSecurityService = secControl.createMock()
		c.params.id = 1
		def s = c.show()["sessionInstance"]
		assertNotNull s
		assertEquals s,ses
	}
	
	void testWhenCurrentFamilyIsNotSatFamilyAndStatusIsRequestedAcceptIsDisplayed(){
		createSittingSessionWithAFamilyAndMockDomain()
		def currentFam = new Family(name:'c',username:'c')
		def secControl = mockFor(SpringSecurityService)
		secControl.demand.getCurrentUser{->currentFam}
		def c = new SittingSessionController()
		c.springSecurityService = secControl.createMock()
		c.params.id = 1
		def a = c.show()["canAccept"]
		assertNotNull a
		assertTrue a
	}

	void testWhenCurrentFamilyIsSatFamilyAcceptIsNotDisplayed(){
		def ses = createSittingSessionWithAFamilyAndMockDomain()
		def secControl = mockFor(SpringSecurityService)
		secControl.demand.getCurrentUser{->ses.satFamily}
		def c = new SittingSessionController()
		c.springSecurityService = secControl.createMock()
		c.params.id = 1
		def a = c.show()["canAccept"]
		assertNotNull a
		assertFalse a
	}
	
	void testWhenStatusIsNotRequestedAcceptIsNotDisplayed(){
		def ses = createSittingSessionWithAFamilyAndMockDomain()
		ses.status = SittingSessionStatus.ACCEPTED
		def secControl = mockFor(SpringSecurityService)
		secControl.demand.getCurrentUser{->new Family(name:'c',username:'c',id:3)}
		def c = new SittingSessionController()
		c.springSecurityService = secControl.createMock()
		c.params.id = 1
		def a = c.show()["canAccept"]
		assertNotNull a
		assertFalse a
	}
	
	def createSittingSessionWithAFamilyAndMockDomain(){
		def ses = DomainGenerator.createSittingSession()
		ses.satFamily = new Family(name:'x',id:1)
		mockDomain(SittingSession,[ses])
		ses
	}
	
	void testAcceptingASittingSessionUpdatesSittingFamilyAndStatus(){
		def currentFamily = new Family(name:'x',username:'y')
		def secControl = mockFor(SpringSecurityService)
		secControl.demand.getCurrentUser{->currentFamily}
		def ses = DomainGenerator.createSittingSession()
		mockDomain(SittingSession,[ses])
		SittingSessionController c = new SittingSessionController()
		c.springSecurityService = secControl.createMock()
		c.params.id = 1
		c.accept()
		secControl.verify()
		def ses2 = SittingSession.list()[0]
		assertEquals ses2.id,ses.id
		assertEquals ses2.status,SittingSessionStatus.ACCEPTED
		assertEquals ses2.sittingFamily.name,'x'
		assertEquals c.redirectArgs.action,'show'
		assertEquals c.redirectArgs.id,ses2.id
		
				
	}

    void testCreateNewsUpASittingSessionWithTheRightDefaults() {
		def currentFamily = new Family(name:'x',username:'y')
		def secControl = mockFor(SpringSecurityService)
		secControl.demand.getCurrentUser{->currentFamily}
		def c = new SittingSessionController()
		c.springSecurityService = secControl.createMock()
		def res = c.create()
		def ses = res['sessionInstance']
		
		
		assertNotNull ses.startDate
		assertEquals ses.startDate.getMonthOfYear(),new DateTime().getMonthOfYear()
		assertEquals ses.startDate.getDayOfMonth(), new DateTime().getDayOfMonth()
		assertEquals ses.startDate.getHourOfDay(), 17
		assertNotNull ses.endDate
		assertEquals ses.endDate.getMonthOfYear(),new DateTime().getMonthOfYear()
		assertEquals ses.endDate.getDayOfMonth(), new DateTime().getDayOfMonth()
		assertEquals ses.endDate.getHourOfDay(), 22
		
		assertNotNull ses.satFamily.name, 'x'	
		secControl.verify()
    }
	
	
	void testSaveCreatesASessionWithTheParamsAndRedirectsToShowWhenNoErrors(){
		mockDomain(Family,[new Family(name:'x',id:1)])
		mockDomain(SittingSession)
		def now = new DateTime()
		def later = now.plusHours(2)
		def c = new SittingSessionController()
		c.params['satFamily.id'] = 1
		c.params.hoursAwake = 2d
		c.params.hoursAsleep = 1d
		c.params.children = 1
		c.params.startDate = now
		c.params.endDate = later
		c.params.notes = 'some kind of instructions'
		
		def res = c.save()
		assertEquals SittingSession.list().size(),1
		def ses = SittingSession.list()[0]
		assertEquals ses.hoursAwake,2d
		assertEquals ses.hoursAsleep,1d
		assertEquals ses.children,1
		assertEquals ses.startDate, now
		assertEquals ses.endDate, later
		assertEquals ses.notes,'some kind of instructions'
		
		assertEquals c.redirectArgs.action,"show"
		assertEquals c.redirectArgs.id,1
				
	}
}
