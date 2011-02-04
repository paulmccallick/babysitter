package babysitter

public enum SittingSessionStatus {
	REQUESTED('requested'),
	ACCEPTED('accepted'),
	COMPLETED('completed'),
	CANCELED('cancelled')
	
	String name
	SittingSessionStatus(String name){
		this.name = name
	}
	static list(){
		[REQUESTED,ACCEPTED,COMPLETED,CANCELED]
	}
	

}
