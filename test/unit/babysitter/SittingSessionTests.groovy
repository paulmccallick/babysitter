package babysitter

import grails.test.*

class SittingSessionTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
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
