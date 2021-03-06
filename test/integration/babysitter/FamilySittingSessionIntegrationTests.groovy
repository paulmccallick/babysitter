package babysitter

import grails.test.*
import org.joda.time.*

class FamilySittingSessionIntegrationTests extends GroovyTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testAddingSessionsToFamilyAndFindingSittingSession() {
		def fam1 = new Family(name:'fam1',username:'fam1',password:'x',enabled:true,email:'x@x.com')
		def fam2 = new Family(name:'fam2',username:'fam2',password:'x',enabled:true,email:'x@x.com')
		assert fam1.save(failOnError:true)
		assert fam2.save(failOnError:true)
		def ses = new SittingSession(satFamily:fam1, sittingFamily:fam2, children:2,hours:1,startDate:new DateTime(),endDate: new DateTime())


		ses.save(failOnError:true)
		def sesid = ses.id
		assertNotNull sesid

		ses = SittingSession.findBySatFamily(fam1)
		assertNotNull ses
		assert ses.class == SittingSession
		
		assert ses.sittingFamily.id == fam2.id
		assert ses.satFamily.id == fam1.id
    }
}
