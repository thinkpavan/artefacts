/*  Shows how a business method is invoked on EJB Object
    Author : Team -J
    Version : 1.0
 Note:  To practically check how and when activation/passivation occurs
    start weblogic (jvm) with less heap size, we are able to see
    this by running the server with 7 ejb's out of which only
    part5.SFSes is accessed by 20 clients on nt 4.0 with 128 MB ram
    and jvm heap size of 64 MB and the thread sleep of 10 minutes.
    if u are not able to observer ejb activate and passivate methods
    being called then try to increase time for thread sleep or reduce
    initial and max heap sizes.
 */

package part5;

import part5.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.*;

// following class is used to start multiple threads from these
// threads we will try to create multiple ejbobjects to overload
// the server
class CliThread extends Thread{
    SFSesHome home;
    String name ;
    public CliThread(SFSesHome home,String name){
        this.home = home;
    }
    public void run(){
     try{
        SFSesRemote h = home.create();
	    String res = h.BusinessMethod1("last name");
        Thread.currentThread().sleep(10000);
        // we will simulate time gap between method calls on the objects
        // and also we will create more objects to overload server. By doing
        // this we can observe ejbactivate and ejbpassivate
        System.out.println("name set by client 2");
        res= h.BusinessMethod2();
        System.out.println("name returned by BusinessMethod2" +res);
        h.remove(); // here we are removing server object also
     }catch(Exception e){System.out.println(e);}
    }
}

public class SFSesClient3 {

   public static void main(String[] args) {

       try {
		// get the initial context of the naming services , this
// step depends on the service provider of JNDI
           Context initial = getInitialContext();
// using naming service get reference to home interface
           Object obj= initial.lookup("SFSes");
           SFSesHome home =(SFSesHome)obj;
// we can now invoke a method on home interface to create EJB Object
        for( int i =0;i <20;i++){
            CliThread t = new CliThread(home," Name" +
            		""+i);
            t.start();
        }
       }catch(Exception e){ System.out.println(e);}
   }

//method to get the initial context specific to bea weblogic, we may
// need to slightly modify the props in order to run this on other
// servers
  static public Context getInitialContext() throws Exception {
    Hashtable h = new Hashtable();
    h.put(Context.INITIAL_CONTEXT_FACTORY,
        "weblogic.jndi.WLInitialContextFactory");
    h.put(Context.PROVIDER_URL, "t3://192.168.6.17:7001");
      h.put(Context.SECURITY_PRINCIPAL, "admin");//user
      h.put(Context.SECURITY_CREDENTIALS, "admin"); //password
    return new InitialContext(h);
  }
}
