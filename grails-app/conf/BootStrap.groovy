import babysitter.Family
import babysitter.SittingSession
import org.joda.time.*

class BootStrap {

	def springSecurityService
	
    def init = { servletContext ->
		if(!Family.count()){
			new Family(name:'Scorcese',username:'scorcese',password:springSecurityService.encodePassword('scorcese'),enabled:true).save(failOnError:true)
			new Family(name:'Kubrick',username:'kubrick',password:springSecurityService.encodePassword('kubrick'),enabled:true).save(failOnError:true)
			new Family(name:'Tarantino',username:'tarantino',password:springSecurityService.encodePassword('tarantino'),enabled:true).save(failOnError:true)	
			
		}
		if(!SittingSession.count()){
			new SittingSession(hoursAwake:2,hoursAsleep:1,children:1, startDate: new DateTime(), endDate: new DateTime(),
				satFamily:Family.findByName('Scorcese'),
				sittingFamily:Family.findByName('Kubrick')).save(failOnError:true)
				
			new SittingSession(hoursAwake:1,hoursAsleep:2,children:1, startDate: new DateTime(), endDate: new DateTime(),
				satFamily:Family.findByName('Tarantino'),
				sittingFamily:Family.findByName('Kubrick')).save(failOnError:true)
				
			new SittingSession(hoursAwake:1,hoursAsleep:2,children:1, startDate: new DateTime(), endDate: new DateTime(),
				satFamily:Family.findByName('Tarantino'),
				sittingFamily:Family.findByName('Scorcese')).save(failOnError:true)
				
			new SittingSession(hoursAwake:1,hoursAsleep:2,children:1, startDate: new DateTime(), endDate: new DateTime(),
				satFamily:Family.findByName('Scorcese'),
				sittingFamily:Family.findByName('Tarantino')).save(failOnError:true)

			
		}
    }
    def destroy = {
    }
}
