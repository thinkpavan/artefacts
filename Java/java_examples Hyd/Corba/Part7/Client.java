/* A sample program that calls a method on corba server
* version : 1.0
* Author : Team -J*/


import java.util.*;
import org.omg.CORBA.*;
import com.INetMod.*;
import com.*;

public class Client {

public static void main(String[] args) {
    // Initialize the ORB.
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
    // Locate Passval Server, for this we are using visigenic specific method.
    attrib g = attribHelper.bind(orb,"attribServer");
	try{
	  g.dooperation();
	}catch(Exception e){System.out.println(e);}
//attributes
	g.count(10);
	int i = g.count();
	System.out.println(i);
	System.out.println(g.ro());
// constants
	System.out.println(com.count.value);
  }
}