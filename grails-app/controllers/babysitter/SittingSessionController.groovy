package babysitter
import org.joda.time.*
import grails.plugins.springsecurity.Secured

class SittingSessionController {

    def index = { }
	
	def springSecurityService
	
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
		def ses = SittingSession.get(params.id)
		def currentFam = springSecurityService.getCurrentUser()
		def canAccept = (ses.status == SittingSessionStatus.REQUESTED & currentFam.id != ses.satFamily.id)
		[sessionInstance:SittingSession.get(params.id),canAccept:canAccept]
	}
	
	@Secured(['IS_AUTHENTICATED_REMEMBERED'])
	def accept = {
		def ses = SittingSession.get(params.id)
		ses.sittingFamily = springSecurityService.getCurrentUser()
		ses.status = SittingSessionStatus.ACCEPTED
		ses.save()
		redirect(action:'show',id:ses.id)
	}
	
	@Secured(['IS_AUTHENTICATED_REMEMBERED'])
	def create = {
		def startDate = new DateMidnight().toDateTime().plusHours(17)
		def endDate = new DateMidnight().toDateTime().plusHours(22)
		def currentFamily = springSecurityService.getCurrentUser()
		def ses = new SittingSession(startDate:startDate,endDate:endDate,satFamily:currentFamily)
		[sessionInstance:ses]
	}
}
