package babysitter

class SittingSessionService {

    static transactional = false

	
	double getPointsForSession(SittingSession session){
		(session.hoursAsleep + (2 * session.hoursAwake)) * session.children
	}
}
