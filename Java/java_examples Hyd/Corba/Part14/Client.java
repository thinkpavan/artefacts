/* A sample program that calls a method on corba server
* version : 1.0
* Author : Team -J*/
import INetSolv.*;
import java.util.*;

public class Client {

public static void main(String[] args) {
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
//get our factory server so that we can construct transient objects 
    INetSolv.PerFactory fs = INetSolv.PerFactoryHelper.bind(orb,"FactoryServer");
	fs.dosomeThing();
	// get transient object 1
	INetSolv.NPObj npo1= fs.CreateNPObj();
	npo1.name("I am first object"); //set name
	// get transient object 2
	INetSolv.NPObj npo2= fs.CreateNPObj();
	npo2.name("I am second object"); //set name
	System.out.println(npo1.name());
	System.out.println(npo2.name());
// we can develop stateful objects like this which holds the state between calls
// this technique reduces scalability
  }
}