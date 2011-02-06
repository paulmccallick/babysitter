package babysitter

class Family extends User {
	
	def familyService
	static final double starterPoints = 30
    static constraints = {
    }
	
	String name;
	def getPoints(){
		familyService.calculatePointsForFamily(this)
	}

}
