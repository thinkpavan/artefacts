/*  Shows how to control transactions from client
    Author : Team -J
    Version : 1.0 , with this example we set transaction attribute
    to mandatory
 */

package cmt;

import cmt.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.*;

public class CMTransClient {

   public static void main(String[] args) {

       try {
           Context initial = getInitialContext();
           Object obj= initial.lookup("cmt.CMTransHome");
           CMTransHome home =(CMTransHome)obj;
           CMTransRemote h = home.create();
           javax.transaction.UserTransaction  ut = (javax.transaction.UserTransaction)initial.lookup("javax.transaction.UserTransaction");
           System.out.println("Transaction object = "+ ut.getClass());
           if (ut == null)
           System.out.println("ut is null");
           else
           System.out.println("ut is not null");
           
                ut.begin();
                h.PerformSomeDBOperation(1000);
                ut.commit();  
     //un comment below line and check !!! 
               // ut.rollback();
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
// run this example by commenting out the part that is gets the transaction
// context and check.