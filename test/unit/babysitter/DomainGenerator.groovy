package babysitter

import org.joda.time.*

class DomainGenerator {
	
	static SittingSession createSittingSession(){
		new SittingSession(hoursAwake:2d,hoursAsleep:1d,children:1,startDate:new DateTime(),endDate: new DateTime(),id:1)
	}

}
