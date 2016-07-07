/*  Shows how a business method is invoked on EJB Object
    Author : Team -J
    Version : 1.0
 */

package local;

import local.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.*;

public class HWorldClient {

   public static void main(String[] args) {

       try {
           Context initial = getInitialContext();
           Object obj= initial.lookup("inetsolv.remote.hworld");
           //Object obj= initial.lookup("inetsolv.local.hworld");
           HWorldHome home =(HWorldHome)obj;
           HWorldRemote h = home.create();
	     String res = h.GetMessage(" World ");
           System.out.println(res);
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
