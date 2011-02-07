package babysitter

import grails.test.*
import org.joda.time.*




class SittingSessionTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
		SittingSession.metaClass.testConstraint{error,property -> assertFalse validate();assertEquals error,errors[property]}
    }

    protected void tearDown() {
        super.tearDown()
    }
	
	void testThatValidValuesHaveNoValidationErrors(){
		def ses = createValidSittingSessionWithConstraintsOn()
		assertTrue ses.validate()
	}
	
	void testWhenSavingSatFamilyMustBeSet(){
		def ses = createValidSittingSessionWithConstraintsOn()
		ses.satFamily = null
		ses.testConstraint("nullable","satFamily")
	}
	
	void testWhenSavingSitFamilyCanBeNull(){
		def ses = createValidSittingSessionWithConstraintsOn()
		ses.sittingFamily = null
		assertTrue ses.validate()
	}

	void testWhenSavingHoursAwakeIsPositive(){
		def ses = createValidSittingSessionWithConstraintsOn()
		ses.hoursAwake = -1d
		ses.testConstraint("min","hoursAwake")
	}
	
	void testWhenSavingHoursAsleepIsPositive(){
		def ses = createValidSittingSessionWithConstraintsOn()
		ses.hoursAsleep = -1d
		ses.testConstraint("min","hoursAsleep")
	}
	
	void testWhenSavingChildrenIsGreaterThan0(){
		def ses = createValidSittingSessionWithConstraintsOn()
		ses.children = 0
		ses.testConstraint("min","children")
	}
	
	void testWhenSavingStartDateIsNotNull(){
		def ses = createValidSittingSessionWithConstraintsOn()
		ses.startDate = null
		ses.testConstraint("nullable","startDate")
	}
	
	void testWhenSavingEndDateIsNotNull(){
		def ses = createValidSittingSessionWithConstraintsOn()
		ses.endDate = null
		ses.testConstraint("nullable","endDate")
	}
	
	def testConstraint(ses,error,property){
		
	}
	
	def createValidSittingSessionWithConstraintsOn(){
		mockForConstraintsTests(SittingSession)
		def sat = new Family(name:'sit')
		def sit = new Family(name:'sat')
		def ses = DomainGenerator.createSittingSession()
		ses.sittingFamily = sit
		ses.satFamily = sat
		ses
	}

    void testPoints() {
		def sessionServiceControl = mockFor(SittingSessionService)
		sessionServiceControl.demand.getPointsForSession{SittingSession ses->5D}
		def pts = 0D
		def ses = new SittingSession()
		ses.sittingSessionService = sessionServiceControl.createMock()
		pts = ses.points
		assertEquals pts,5D
		sessionServiceControl.verify()
    }
}
