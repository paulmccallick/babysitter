package babysitter

class SittingSession {

    static constraints = {
    }
	
	double hoursAwake
	double hoursAsleep
	int children
	Family sittingFamily
	Family satFamily
	def sittingSessionService
	
	def getPoints(){
		sittingSessionService.getPointsForSession(this)
	}

}
