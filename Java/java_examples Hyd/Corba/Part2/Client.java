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
    INetMod.BServer bs = INetMod.BServerHelper.bind(orb,"BServer");
    System.out.println("Founf Basic Server");
    System.out.println("some Short = "+ bs.someShort());
System.out.println("some Long = "+ bs.someLong());
System.out.println("some ULong = "+ bs.someULong());
System.out.println("some char = "+ (int)bs.someChar());
System.out.println("some Wchar = "+ (int)bs.someWChar());
System.out.println("some boolean = "+ bs.someBoolean());
  }
}