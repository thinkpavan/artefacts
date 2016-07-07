/*Class that implements the logic of a bean , It should be noted
that a client never directly talks to this object
Version : 1.0
Author : Team -J
*/

package ws1;
import javax.ejb.*;

public class WS1 implements SessionBean {
    private SessionContext context;

// this method will be called when ejb is created

    public void ejbCreate() throws CreateException {
		System.out.println(" In Ejb create method");
    }
// following are the methods defined in SessionBean interface
   public void setSessionContext(SessionContext sc) {}
   public void ejbRemove() {}
   public void ejbActivate() {}
   public void ejbPassivate() {}

// Business logic provided by the bean component
   public String GetMessage(String UName){
	return "hello" + UName;
   }	
} 
