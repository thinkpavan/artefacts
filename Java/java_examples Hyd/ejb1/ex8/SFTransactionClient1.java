/*  Shows how a business method is invoked on EJB 
    Author : Team -J
    Version : 1.0 , with this example we set transaction attribute
    to requires_new
 */

package part8;

import part8.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.*;

public class SFTransactionClient1 {

   public static void main(String[] args) {

       try {
		// get the initial context of the naming services , this 
// step depends on the service provider of JNDI
           Context initial = getInitialContext();
// using naming service get reference to home interface
           Object obj= initial.lookup("part8.SFTransactionHome");
           SFTransactionHome home =(SFTransactionHome)obj;
           SFTransactionRemote h = home.create();
          h.updatesal();
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
      h.put(Context.SECURITY_PRINCIPAL, "system");//user
      h.put(Context.SECURITY_CREDENTIALS, "posanisuresh"); //password
    return new InitialContext(h);
  }
} 
