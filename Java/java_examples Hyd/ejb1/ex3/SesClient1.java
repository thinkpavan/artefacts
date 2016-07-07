/*  Shows how a business method is invoked on EJB Object
    Author : Team -J
    Version : 1.0
 */

package part3;

import part3.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.*;

public class SesClient1 {

   public static void main(String[] args) {

       try {
		// get the initial context of the naming services , this 
// step depends on the service provider of JNDI
           Context initial = getInitialContext();
// using naming service get reference to home interface
           Object obj= initial.lookup("inetsolv.ses");
           SesHome home =(SesHome)obj;
// we can now invoke a method on home interface to create EJB Object
           SesRemote h = home.create();
	     String res = h.BusinessMethod1(" Client1 ");
		System.in.read();
		System.in.read();
           System.out.println("name set by client 1");
           
        res= h.BusinessMethod2();
        System.out.println("name returned by BusinessMethod2" +res);
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
