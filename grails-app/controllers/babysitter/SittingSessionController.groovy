package babysitter

class SittingSessionController {

    def index = { }
	
	def sittingSessionService
	
	def create = { 
		def ses = new SittingSession(params)
		ses.save()
		[sessionInstance:ses]
	}
}
