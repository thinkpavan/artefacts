/* m800 is a concrete class derived from  abstract class cars
Author : Team - J 
Version: 1.0*/

abstract class m800 extends car{ 
	int regno;
	public m800(int rno){
		super(rno);
	}
	// we know that all cars will have a break and staring but different
	// cars will have different breaking and stearing mechanism.
	public void break(int force){
		System.out.println(" Brake is applied");
		System.out.println(" This car uses oil break system");
	}
	public void turn(int direction,int angle){
		System.out.println(" This car uses manual stearing mechanism");
	}
}
 