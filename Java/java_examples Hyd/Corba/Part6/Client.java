/* A sample program that calls a method on corba server
* version : 1.0
* Author : Team -J*/
import INetMod.*;
import java.util.*;
import org.omg.CORBA.*;
import INetMod.*;
public class Client {

public static void main(String[] args) {
    // Initialize the ORB.
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
    // Locate Passval Server, for this we are using visigenic specific method.
    INetMod.OneWay g = INetMod.OneWayHelper.bind(orb,"OneWayServer");
    System.out.println("before calling one way");
	g.owmethod((short)22);
    System.out.println("before calling normal method");  
      g.normalmethod();
    System.out.println("before calling normal method 1 ");  
      int i = g.normalmethod1();
 System.out.println("Normal Method Output "+i);
 System.out.println("before calling one way 1 ");
 ShortHolder s = new ShortHolder();
 s.value = (short)999; 
	g.owmethod1(s);
 System.out.println("---------------------");
 System.out.println("One way 1 output = "+s.value);
  }
}