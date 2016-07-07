/*  This is a sesssion bean to show how the transaction can be mainitained by
a client.
Version : 1.0
Author : Team -J
*/

package sec;
import javax.ejb.*;
import java.sql.*;
import javax.naming.*;
import java.util.*;
import javax.sql.*;

public class Sec implements SessionBean{
    private  SessionContext context;
// these methods will be called when ejb is created

    public void ejbCreate() throws CreateException {
    }

// following are the methods defined in SessionBean interface
   public void setSessionContext(SessionContext sc) {
        context =sc;
   }
   public void ejbRemove() {
   }
   public void ejbActivate() {
   }
   public void ejbPassivate() {
   }
  public void busMethod1(){
	System.out.println("Bus Method 1 called");
	System.out.println(" No code in methods1 to take care of security");
   }
  public void busMethod2(){
	System.out.println("Bus Method 2 called");
	System.out.println(" No code in methods2 to take care of security");
	java.security.Principal p=context.getCallerPrincipal();
	System.out.println(p.getName());
	System.out.println("iscaller in role  " +context.isCallerInRole("role1"));

   }   
} 

