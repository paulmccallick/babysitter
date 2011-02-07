package babysitter
import org.joda.time.*
import org.joda.time.contrib.hibernate.*

class SittingSession {

    static constraints = {
		hoursAwake(nullable:false,min:0d)
		hoursAsleep(nullable:false,min:0d)
		children(nullable:false,min:1)
		startDate(nullable:false)
		endDate(nullable:false)
		sittingFamily(nullable:true)
		notes(nullable:true)
		status(nullable:false)
    }
	
	static mapping = {
		startDate type: PersistentDateTime
		endDate type: PersistentDateTime
		
	}
	
	double hoursAwake = 0
	double hoursAsleep = 0
	int children = 0
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
