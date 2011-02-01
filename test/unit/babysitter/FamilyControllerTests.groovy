package babysitter

import grails.test.*

class FamilyControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testControllerReturnsFamilyAndSatSessions() {
		//this set up is making it clear that we need to inject some services into the equation
		def familyId = 3
		def testFam = new Family(name: "X",id: familyId)
		mockDomain(Family,[testFam])
		testFam.save()
		def ses = new SittingSession(id:1,hoursAwake:2,hoursAsleep:2,children:1,date: new Date())
		def ses2 = new SittingSession(id:2,hoursAwake:2,hoursAsleep:2,children:1,date: new Date())
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
