package babysitter
import org.joda.time.*
import org.joda.time.contrib.hibernate.*

class SittingSession {

    static constraints = {
		sittingFamily(nullable:true)
		notes(nullable:true)
    }
	
	static mapping = {
		startDate type: PersistentDateTime
		endDate type: PersistentDateTime
		
	}
	
	double hoursAwake
	double hoursAsleep
	int children
	Family sittingFamily
	Family satFamily
	DateTime startDate
	DateTime endDate
	String notes
	SittingSessionStatus status = SittingSessionStatus.REQUESTED
		
	def sittingSessionService
	
	def getPoints(){
		sittingSessionService.getPointsForSession(this)
	}

}
