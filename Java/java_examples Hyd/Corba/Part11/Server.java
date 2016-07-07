/* A sample program that creates a corba server object
* version : 1.0
* Author : Team -J*/
import INetSolv.*;

public class Server {

  public static void main(String[] args)throws Exception {
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
    org.omg.CORBA.BOA boa = ((com.visigenic.vbroker.orb.ORB)orb).BOA_init();
     SequenceBasicImpl io1 = new SequenceBasicImpl("SeqBasicServer");
    boa.obj_is_ready(io1);
    System.out.println("SeqBasic Server is Ready");
     boa.impl_is_ready();
  }

}