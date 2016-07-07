/* Version : 1.0 
Author : Team -J
 */

package otm;

import otm.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.*;

public class Client {

   public static void main(String[] args) {

       try {
		OrderPK opk = new OrderPK("2");
           Context initial = getInitialContext();
           Object obj= initial.lookup("Order");
           OrderHome home =(OrderHome )obj;
	     OrderRemote r = home.findByPrimaryKey(opk);
	     System.out.println(" Order Date: "+r.getOrdDate());
	     System.out.println(" Cust Name: "+r.getCustName());
	     System.out.println(" No OF Lines: "+r.getLineCount());


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
