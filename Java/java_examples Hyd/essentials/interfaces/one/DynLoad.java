/* Example on Dynamic Loading
Author : Team - J 
Version: 1.0*/

class DynLoad{
	public static void main(String args[]) throws Exception{
	Contract  con;
	Class cl;
	String classname="Person2";
	System.out.println("Now Loading " + classname);
	cl = Class.forName(classname);
	con = (Contract) cl.newInstance();
	con.toSchool();
	} 
	
}
 