package babysitter

class FamilyService {

    static transactional = true
	
	

    def calculatePointsForFamily(family) {
		def satPoints = 0D
		def sitPoints = 0D
		def satSessions = SittingSession.findAllBySatFamily(family).each{ses -> satPoints+=ses.points}
		def sitSessions = SittingSession.findAllBySittingFamily(family).each{ses -> sitPoints+=ses.points}
		satPoints - sitPoints + Family.starterPoints
    }
}
