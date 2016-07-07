/* A sample program that creates a corba server object
* version : 1.0
* Author : Team -J*/
import INetMod.*;

public class Server {

  public static void main(String[] args)throws Exception {
    // Initialize the ORB.
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
    // Initialize the BOA.
    // we need an adapter, here we are using basic object adapter
    org.omg.CORBA.BOA boa = ((com.visigenic.vbroker.orb.ORB)orb).BOA_init();
        attribImpl io1 = new attribImpl("attribServer");
    // Let us say that our object is ready to provide service now
    boa.obj_is_ready(io1);
    System.out.println("attrib Server is Ready");
    // Wait for incoming requests
   // boa.impl_is_ready();
//	while(true); // can we use this???
	Thread.currentThread().sleep(120000);
	boa.deactivate_obj(io1);
	System.out.println("Object is deactivated");
	while(true);
// we continue with other tasks
  }

}