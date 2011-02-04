package babysitter

import org.joda.time.*

class DomainGenerator {
	
	static SittingSession createSittingSession(){
		new SittingSession(hoursAwake:2,hoursAsleep:1,children:1,startDate:new DateTime(),endDate: new DateTime(),id:1)
	}

}
