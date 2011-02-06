package babysitter

import grails.test.*

class FamilyTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testPointsDefersToFamilyService() {
		def pts =2d
		def fam = new Family()
		def famArg
		def contr = mockFor(FamilyService)
		contr.demand.calculatePointsForFamily{f -> famArg = f;return pts}
		fam.familyService = contr.createMock()
		assertEquals pts,fam.points
		assertEquals famArg,fam
		
		
    }
}
