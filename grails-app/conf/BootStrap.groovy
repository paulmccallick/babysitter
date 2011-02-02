import babysitter.Family
import babysitter.SittingSession
import org.joda.time.*

class BootStrap {

    def init = { servletContext ->
		if(!Family.count()){
			new Family(name:'Scorcese').save(failOnError:true)
			new Family(name:'Kubrick').save(failOnError:true)
			new Family(name:'Tarantino').save(failOnError:true)	
			
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
