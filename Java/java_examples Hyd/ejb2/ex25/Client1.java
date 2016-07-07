/* Version : 1.0 
Author : Team -J
 */

package otm;

import otm.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.*;

public class Client1 {

   public static void main(String[] args) {

       try {
		OrderPK opk = new OrderPK("1");
           Context initial = getInitialContext();
           Object obj= initial.lookup("Order");
           OrderHome home =(OrderHome )obj;
	     OrderRemote r = home.findByPrimaryKey(opk);
System.out.println("Trying to remove the bean");
	     r.remove();
System.out.println("successfully removed");

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
