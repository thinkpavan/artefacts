/* This is an abstract class
Author : Team - J 
Version: 1.0*/

abstract class car  { 
	int regno;
	public car(int rno){
		regno = rno;
	}
	// we know that all cars will have a break and staring but different
	// cars will have different breaking and stearing mechanism.
	public abstract void break(int force);
	 public abstract void turn(int direction,int angle);
	// here let us assume that all the cars uses the same
	// mechanism to open petrol tank.
	public void opentank(){
		System.out.println(" Tank is opened, now you can fill the tank");
	}
}
 