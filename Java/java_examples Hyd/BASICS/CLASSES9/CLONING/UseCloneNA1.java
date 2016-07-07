/* This class shows how to use cloning method
Author : Team - J 
Version: 1.0*/

class UseCloneNA1  { 
	public static void main( String args[]) throws Exception{
		CloneNA1 c1,c2,c3;
		c1 = new CloneNA1(10,20);
		c2 = c1;
		c1.showstate();
		c2.showstate();
		// let us try to create a clone of c1 
		c3 = (CloneNA1) c1.clone();
		// why is cloning not allowed here
	}
}
 