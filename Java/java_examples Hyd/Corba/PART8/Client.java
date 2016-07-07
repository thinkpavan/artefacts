/* A sample program that calls a method on corba server
* version : 1.0
* Author : Team -J*/
import INetMod.*;
import java.util.*;

public class Client {

public static void main(String[] args) {
    // Initialize the ORB.
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
    System.out.println(args[0]);
	org.omg.CORBA.Object obj = orb.string_to_object(args[0]);
// narrow object to appropriate type.
	INetMod.Greeting g = INetMod.GreetingHelper.narrow(obj);
    String greeting = g.TGreeting();// call a  method on Server Object
    System.out.println(greeting);
  }
}