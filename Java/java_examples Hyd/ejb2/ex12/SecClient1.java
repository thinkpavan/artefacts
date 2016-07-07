/*  Shows how to control transactions from client
    Author : Team -J
    Version : 1.0 , with this example we set transaction attribute
    to mandatory
 */


// run this example by using different user names
package sec;

import sec.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.*;

public class SecClient1 {

   public static void main(String[] args) {

       try {
		// get the initial context of the naming services , this 
// step depends on the service provider of JNDI
           Context initial = getInitialContext();
// using naming service get reference to home interface
           Object obj= initial.lookup("Sec");
           SecHome home =(SecHome)obj;
           SecRemote h = home.create();
// let us try to execute the method
                h.busMethod2();
                h.busMethod1();
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
      h.put(Context.SECURITY_PRINCIPAL, "stud1");//user
      h.put(Context.SECURITY_CREDENTIALS, "weblogic"); //password
    return new InitialContext(h);
  }
} 
// run this example by commenting out the part that is gets the transaction
// context and check.