/*  Shows how to use entity bean from a client. In general it is not
recommended to handle entity beans over network in remote clients.
It is better to use session bean to access entity bean and send back
the data to client as a java object
Version : 1.0 
Author : Team -J
 */

package home;

import home.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.*;

public class StudClient1 {

   public static void main(String[] args) {

       try {
		StudRemote sr;
		// get the initial context of the naming services , this 
// step depends on the service provider of JNDI
           Context initial = getInitialContext();
// using naming service get reference to home interface
           Object obj= initial.lookup("studhome");
           StudHome home =(StudHome)obj;
		Collection list = home.findStudentsWithName("%one%"); 
		java.util.Iterator it = list.iterator();
     while (it.hasNext()) {
		sr = (StudRemote) it.next();
		System.out.println(sr.getData());
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
    h.put(Context.PROVIDER_URL, "t3://localhost:7001");
      h.put(Context.SECURITY_PRINCIPAL, "admin");//user
      h.put(Context.SECURITY_CREDENTIALS, "inetadmin"); //password
    return new InitialContext(h);
  }
} 