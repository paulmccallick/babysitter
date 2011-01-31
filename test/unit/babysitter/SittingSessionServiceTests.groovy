package babysitter

import grails.test.*

class SittingSessionServiceTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testGivenAThreeHourAwakeSessionWithOneKidsThePointsAre6() {
		def session = new SittingSession(sittingFamily: new Family(name:'x'),satFamily:new Family(name:'y'),children:1,hoursAwake:3,hoursAsleep:0)
		assertEquals new SittingSessionService().getPointsForSession(session),6D
    }
	
	void testGivenAThreeHourAwakeAndThreeHoursAsleepSessionWithOneKidsThePointsAre9() {
		def session = new SittingSession(sittingFamily: new Family(name:'x'),satFamily:new Family(name:'y'),children:1,hoursAwake:3,hoursAsleep:3)
		assertEquals new SittingSessionService().getPointsForSession(session),9D
	}
	
	void testGivenAThreeHourAwakeAndThreeHoursAsleepSessionWithTwoKidsThePointsAre18() {
		def session = new SittingSession(sittingFamily: new Family(name:'x'),satFamily:new Family(name:'y'),children:2,hoursAwake:3,hoursAsleep:3)
		assertEquals new SittingSessionService().getPointsForSession(session),18D
	}
	
	void testGivenAZeroHourAwakeAndThreeHoursAsleepSessionWithOneKidsThePointsAre3() {
		def session = new SittingSession(sittingFamily: new Family(name:'x'),satFamily:new Family(name:'y'),children:1,hoursAwake:0,hoursAsleep:3)
		assertEquals new SittingSessionService().getPointsForSession(session),3D
	}
	

}
