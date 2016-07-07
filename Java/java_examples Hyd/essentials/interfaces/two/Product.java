/* Example on how program behaviour can be changed without changing code
In this example we will use the configuration file config.txt
Author : Team - J 
Version: 1.0*/

import java.io.*;

class Product{
	public static void main(String args[]) throws Exception{
	ICallMe  cm;
	Class cl;
	FileReader fr;
	String classname;
// get the name of the class from config.txt file
	fr = new FileReader("Config.txt");
	LineNumberReader lnr = new LineNumberReader(fr);
	classname = lnr.readLine(); 
	System.out.println("Now Loading " + classname);
	cl = Class.forName(classname);
	cm =  (ICallMe)cl.newInstance();
	cm.callme();
	} 
	
}
 