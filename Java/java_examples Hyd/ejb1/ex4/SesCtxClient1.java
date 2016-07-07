/*  Shows how a business method is invoked on EJB Object
    Author : Team -J
    Version : 1.0
 */

package part4;

import part4.*;
import java.io.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.*;
import javax.ejb.*;

public class SesCtxClient1 {

   public static void main(String[] args) {

       try {
		// get the initial context of the naming services , this 
// step depends on the service provider of JNDI
           Context initial = getInitialContext();
// using naming service get reference to home interface
           Object obj= initial.lookup("inetsolv.sesctx");
           SesCtxHome home =(SesCtxHome)obj;
// we can now invoke a method on home interface to create EJB Object
        SesCtxRemote o1 = home.create();
 // create anothe ejb object
        SesCtxRemote o2 = home.create(); 
		System.in.read();
		System.in.read();
        javax.ejb.Handle h1,h2;           
        h1 = o1.getHandle();
        System.out.println(h1);
        h2 = o1.getHandle();
        System.out.println(h2);
        System.out.println(" is o1 identical to o2 " +o1.isIdentical((EJBObject)o2));
        System.out.println(o2.isIdentical(o2));
        // let us see how to use handles here.
        FileOutputStream fos = new FileOutputStream("c:\\handle1.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(h1);
        fos.close();
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
