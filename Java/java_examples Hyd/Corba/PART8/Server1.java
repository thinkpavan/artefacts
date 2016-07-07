/* A sample program that creates a corba server object
* version : 1.0
* Author : Team -J*/
import INetMod.*;
import java.util.*;
import java.io.*;

public class Server1 {

  public static void main(String[] args) throws Exception {
    // Initialize the ORB.
	File f2 = new File("myior2");
	FileWriter fos2 = new FileWriter(f2);
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
    System.out.println("Orb Implementation " +orb.getClass());
    // Initialize the BOA.
    // we need an adapter, here we are using basic object adapter
    org.omg.CORBA.BOA boa = ((com.visigenic.vbroker.orb.ORB)orb).BOA_init();
        GreetingImpl gi = new GreetingImpl("GreetingServer");
    // Let us say that our object is ready to provide service now
    boa.obj_is_ready(gi);
    // get IOR interoperable Object Refernce.
	String ior2 = orb.object_to_string(gi);
	fos2.write(ior2);
	fos2.close();

    // Wait for incoming requests
    boa.impl_is_ready();
  }

}