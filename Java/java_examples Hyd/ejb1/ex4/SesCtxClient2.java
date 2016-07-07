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

public class SesCtxClient2 {

   public static void main(String[] args) {

       try {
            EJBObject ejo;
            Handle h1;
            FileInputStream fis= new FileInputStream("c:\\handle1.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        h1 = (Handle) ois.readObject();
        ejo = h1.getEJBObject();
        SesCtxRemote sch = (SesCtxRemote) ejo;
        System.out.println(" ejb object reference obtained from handle ="+ejo);
        System.out.println(" now we can call methods on ="+sch);
        System.out.println(sch.BusinessMethod1("some param"));
        fis.close();
       }catch(Exception e){ System.out.println(e);}
   } 
} 
// run this example after restarting server and check !!

// perform the same test on state ful session bean also