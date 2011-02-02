package babysitter

import grails.test.*
import org.joda.time.*

class SittingSessionControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testGivenCompleteDataSaveIsCalledAndControllerRedirectsToShow() {
		mockDomain(Family,[new Family(name:'x',id:1)])
		mockDomain(SittingSession)
		
		def c = new SittingSessionController()
		c.params['satFamily.id'] = 1
		c.params.hoursAwake = 2d
		c.params.hoursAsleep = 1d
		c.params.children = 1
		c.params.startDate = new DateTime()
		c.params.endDate = new DateTime()
		
		def res = c.create()
		def ses = res['sessionInstance']
		assertEquals ses.class,SittingSession
		assertEquals ses.errors.errorCount,0
		assertEquals ses.satFamily.name,'x'
		assertNotNull ses.id
		assertEquals SittingSession.list().size(),1
    }
}
