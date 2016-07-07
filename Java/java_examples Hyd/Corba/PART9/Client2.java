/* A sample program that calls a method on corba server
* version : 1.0
* Author : Team -J*/


import java.util.*;
import org.omg.CORBA.*;
import INetMod.*;

public class Client2 {

public static void main(String[] args)throws Exception {
    // Initialize the ORB.
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
    attrib g = attribHelper.bind(orb,"attribServer");
	try{
	  g.dooperation();
	}catch(Exception e){System.out.println(e);}
//attributes

	int i = g.count();
	System.out.println(i);
	System.out.println(" Press Enter to read count value again");
	System.in.read();
		g.count(100);
	i = g.count();
	System.out.println(i);
  }
}