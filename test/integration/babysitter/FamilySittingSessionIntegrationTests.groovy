package babysitter

import grails.test.*

class FamilySittingSessionIntegrationTests extends GroovyTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testAddingSessionsToFamilyAndFindingSittingSession() {
		def fam1 = new Family(name:'fam1')
		def fam2 = new Family(name:'fam2')
		def ses = new SittingSession(satFamily:fam1, sittingFamily:fam2, children:2,hours:1)
		assert fam1.save()
		assert fam2.save()

		sittingFamily:fam1
		def sesid = ses.id
		assertNotNull sesid

		ses = SittingSession.findBySatFamily(fam1)
		assertNotNull ses
		assert ses.class == SittingSession
		
		assert ses.sittingFamily.id == fam2.id
		assert ses.satFamily.id == fam1.id
    }
}
