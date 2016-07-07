/*  Shows how a business method is invoked on EJB
    Author : Team -J
    Version : 1.0 , with this example we set transaction attribute
    to requires_new
 */

package part6;

import part6.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.*;

public class TransClient1 {

   public static void main(String[] args) {

       try {
		// get the initial context of the naming services , this
// step depends on the service provider of JNDI
           Context initial = getInitialContext();
// using naming service get reference to home interface
           Object obj= initial.lookup("Trans");
           TransHome home =(TransHome)obj;
           TransRemote h = home.create();
	     String emplist[] = h.listEmp();
	     for(int i=0;i<5;i++)
	        System.out.println("emp no .."+emplist[i]);
	    h.updatesal(1,7369);
	    Thread.sleep(10000);
          h.updatesal(100,10);
        System.out.println(" after update");
       }catch(Exception e){ System.out.println(e);}
   }

//method to get the initial context specific to bea weblogic, we may
// need to slightly modify the props in order to run this on other
// servers
  static public Context getInitialContext() throws Exception {
    Hashtable h = new Hashtable();
    h.put(Context.INITIAL_CONTEXT_FACTORY,
        "weblogic.jndi.WLInitialContextFactory");
    h.put(Context.PROVIDER_URL, "t3://localhost:7001");
      h.put(Context.SECURITY_PRINCIPAL, "admin");//user
      h.put(Context.SECURITY_CREDENTIALS, "admin"); //password
    return new InitialContext(h);
  }
}
