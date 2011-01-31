package babysitter

import grails.test.*

class FamilyServiceTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testGivenAFamilyHasSatTwiceFor10PointsAndWasSatFor10PointsTheirPointsAreStarterPoints() {
		def sats = [[points:3],[points:7]]
		def sits = [[points:7],[points:3]]
		
		def family = new Family(name:'x')
		SittingSession.metaClass.'static'.findAllBySittingFamily = { Family f -> sits }
		SittingSession.metaClass.'static'.findAllBySatFamily = { Family f -> sats }
	
		def points = 6D
		def familyService = new FamilyService()
		points = familyService.calculatePointsForFamily(family)
		assertEquals points,Family.starterPoints
		
		
    }
}
