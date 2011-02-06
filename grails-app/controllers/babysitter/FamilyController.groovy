package babysitter

class FamilyController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

	def list = {
		[familyList:Family.list()]
	}

    def show = {
        def familyInstance = Family.get(params.id)
        if (!familyInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'family.label', default: 'Family'), params.id])}"
            redirect(action: "list")
        }
        else {
            [familyInstance: familyInstance,satSessions: SittingSession.findAllBySatFamily(familyInstance)]
        }
    }
}
