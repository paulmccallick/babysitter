package babysitter

import grails.test.*

class SittingSessionTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }
	
	void testWhenSavingSatFamilyMustBeSetSittingFamilyCanBeNull(){
		//mockForConstraints(Family)
		mockForConstraintsTests(SittingSession)
		def sat = new Family(name:'x')
		def ses = new SittingSession(hoursAwake:2,hoursAsleep:1,children:1,date:new Date())
		
		assertFalse ses.validate()
		assertEquals "nullable", ses.errors["satFamily"] 
		assertEquals null,ses.errors["sittingFamily"]
		
		ses.setSatFamily sat
		assertTrue ses.validate()
		
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
