package babysitter

import grails.test.*
import org.joda.time.*

class FamilyControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }
	
	void testListReturnsAllFamilyRows(){
		def fam1 = new Family(name:'x',id:1)
		def fam2 = new Family(name:'y',id:2)
		def fam3 = new Family(name:'z',id:2)
		mockDomain(Family,[fam1,fam2,fam3])
		def c = new FamilyController()
		def r = c.list()['familyList']
		assertNotNull r
		assertEquals r.size(),3
	}

    void testControllerReturnsFamilyAndSatSessions() {
		//this set up is making it clear that we need to inject some services into the equation
		def familyId = 3
		def testFam = new Family(name: "X",id: familyId)
		mockDomain(Family,[testFam])
		testFam.save()
		def ses = new SittingSession(id:1,hoursAwake:2,hoursAsleep:2,children:1,startDate: new DateTime(),endDate: new DateTime())
		def ses2 = new SittingSession(id:2,hoursAwake:2,hoursAsleep:2,children:1,startDate: new DateTime(),endDate: new DateTime())
		mockDomain(SittingSession,[ses,ses2])
		ses.setSatFamily(testFam)
		ses.setSittingFamily(testFam)
		assert ses.save(failOnError:true)
		ses2.setSatFamily(testFam)
		ses2.setSittingFamily(testFam)
		assert ses2.save(failOnError:true)
		
		def c = new FamilyController()
		c.params.id = familyId
		def res = c.show()
		def fam = res['familyInstance']
		assertNotNull fam
		assertEquals testFam,fam
		
		def sats = res['satSessions']		
		assertNotNull sats
		assertEquals sats.size(),2
    }
}
