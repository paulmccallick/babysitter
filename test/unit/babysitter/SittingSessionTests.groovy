package babysitter

import grails.test.*
import org.joda.time.*

class SittingSessionTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }
	
	void testWhenSavingSatFamilyMustBeSetSittingFamilyCanBeNull(){

		mockForConstraintsTests(SittingSession)
		def sat = new Family(name:'x')
		def ses = DomainGenerator.createSittingSession()
		
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
