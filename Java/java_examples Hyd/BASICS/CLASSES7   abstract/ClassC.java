/* This  is a class  with a single method and constant used to demonstrate some
properties of interface
Author : Team - J 
Version: 1.0*/
class ClassC implements InterfaceA  { 
	public static final int CONST = 30;
	public int donothing(){
		System.out.println(" Donothing in Class C");
		System.out.println(" class c "+CONST);
		return 100;
	}
	public static void main(String args[]){}
}
 