package babysitter

class SittingSession {

    static constraints = {
		sittingFamily(nullable:true)
    }
	
	double hoursAwake
	double hoursAsleep
	int children
	Family sittingFamily
	Family satFamily
	Date date
	def sittingSessionService
	
	def getPoints(){
		sittingSessionService.getPointsForSession(this)
	}

}
