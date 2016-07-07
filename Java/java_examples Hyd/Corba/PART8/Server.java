/* A sample program that creates a corba server object
* version : 1.0
* Author : Team -J*/
import INetMod.*;
import java.util.*;
import java.io.*;

public class Server {

  public static void main(String[] args) throws Exception {
    // Initialize the ORB.
	File f1 = new File("myior1");
	FileWriter fos1 = new FileWriter(f1);
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
    System.out.println("Orb Implementation " +orb.getClass());
    // Initialize the BOA.
    // we need an adapter, here we are using basic object adapter
    org.omg.CORBA.BOA boa = ((com.visigenic.vbroker.orb.ORB)orb).BOA_init();
        GreetingImpl gi = new GreetingImpl("GreetingServer");
    // Let us say that our object is ready to provide service now
    boa.obj_is_ready(gi);
    // get IOR interoperable Object Refernce.
	String ior1 = orb.object_to_string(gi);
	fos1.write(ior1);
	fos1.close();
    // Wait for incoming requests
    boa.impl_is_ready();
  }

}