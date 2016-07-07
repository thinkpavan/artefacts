/* Shows how to use class Object
Author : Team -J
Version : 1.0
*/

import java.io.*;
import java.net.*;

public class Cls{
	public static void main(String args[])throws Exception{
		// methods to get a refernce to class object
		//method 1
		String s = new String();
		Class c = s.getClass();
		System.out.println(c);
		//method 2
		c = Class.forName("java.lang.String");
		System.out.println(c);
		//method 3
		c = java.lang.String.class;
		System.out.println(c);
		// where is this useful ???
		//Class class can be used by a tool to find/reflect what is
		// there like details of methods, constructors, interfaces implemented
		// by the class.

		// to get the refernrce to class loaders, in some jvm impl
		// this may return null to represent bootstrap class loader
		ClassLoader cl = c.getClassLoader();
		System.out.println(cl);
	}	
}

