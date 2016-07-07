/* This class is an concrete class derived from RatePlan
Author : Team - J 
Version: 1.0*/

abstract class abssubclass extends supclass  { 
	public int CalculateBill(){
		System.out.println(" ** Bill calculated using Regular Plan ** ");
		return (100);//return some value to avoid compilation error
	}
	abstract public void aaa();
	public static void main(String ags[]) {
System.out.println( " i'am in main");
abssubclass abs;
}

}
 