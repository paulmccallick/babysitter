package babysitter
import org.joda.time.*

class SittingSessionController {

    def index = { }
	
	def sittingSessionService
	
	def save = {

		def ses = new SittingSession(params)
		if(ses.save(flush:true)){
			redirect(action: "show", id: ses.id)
		}
		else{
			render(view: "create", model: [sessionInstance: ses])
		}
	}
	
	def show = {
		[sessionInstance:SittingSession.get(params.id)]
	}
	
	def create = {
		def startDate = new DateMidnight().toDateTime().plusHours(17)
		def endDate = new DateMidnight().toDateTime().plusHours(22)
		def ses = new SittingSession(startDate:startDate,endDate:endDate)
		[sessionInstance:ses]
	}
}
