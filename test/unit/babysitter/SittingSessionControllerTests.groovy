package babysitter

import grails.test.*
import org.joda.time.*
import grails.plugins.springsecurity.*

class SittingSessionControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }
	
	void testShow(){
		
		def ses = DomainGenerator.createSittingSession()
		ses.satFamily = new Family(name:'x',id:1)
		mockDomain(SittingSession,[ses])
		def c = new SittingSessionController()
		c.params.id = 1
		def s = c.show()["sessionInstance"]
		assertNotNull s
		assertEquals s,ses
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
		
		def c = new SittingSessionController()
		c.params['satFamily.id'] = 1
		c.params.hoursAwake = 2d
		c.params.hoursAsleep = 1d
		c.params.children = 1
		c.params.startDate = new DateTime()
		c.params.endDate = new DateTime()
		
		def res = c.save()
		assertEquals SittingSession.list().size(),1
		assertEquals c.redirectArgs.action,"show"
		assertEquals c.redirectArgs.id,1
				
	}
}
