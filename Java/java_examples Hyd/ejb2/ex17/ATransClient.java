/*  Shows how to control transactions from client
    Author : Team -J
    Version : 1.0 , with this example we set transaction attribute
    to mandatory
 */

package atrans;

import atrans.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.*;

public class ATransClient {

   public static void main(String[] args) {

       try {
           Context initial = getInitialContext();
           Object obj= initial.lookup("rolltrans");
           ATransHome home =(ATransHome)obj;
           ATransRemote h = home.create();
           h.PerformSomeDBOperation(1000);
	     System.out.println("Transaction Completed");
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
      h.put(Context.SECURITY_CREDENTIALS, "inetadmin"); //password
    return new InitialContext(h);
  }
} 
// run this example by commenting out the part that is gets the transaction
// context and check.