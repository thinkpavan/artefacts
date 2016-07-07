/*Class that implements the logic of a bean , It should be noted
that a client never directly talks to this object
Version : 1.0
Author : Team -J
*/

package ws2;
import javax.ejb.*;
import java.rmi.*;

public class WS2 implements SessionBean {
    private SessionContext context;
    public void ejbCreate() throws CreateException {
    }
   public void setSessionContext(SessionContext sc) {}
   public void ejbRemove() {}
   public void ejbActivate() {}
   public void ejbPassivate() {}

// Business logic provided by the bean component
    public String method1(String UName) throws  RemoteException {
		return "your name is registered by method1";
    }
    public String method2(String FName,String LName) throws  RemoteException {
		return FName +"  "+LName;
    }
} 
