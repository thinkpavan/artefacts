/* A sample program that calls a method on corba server
* version : 1.0
* Author : Team -J*/
import INetMod.*;
import java.util.*;

public class Client {

public static void main(String[] args) {
    // Initialize the ORB.
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
    // Locate Greeting Server, for this we are using visigenic specific method.
    INetMod.Greeting g = INetMod.GreetingHelper.bind(orb,"GreetingServer");
    String greeting = g.TGreeting();// call a  method on Server Object
    System.out.println(greeting);
  }
}