/*Class that implements the logic of a bean , It should be noted
that a client never directly talks to this object
Version : 1.0
Author : Team -J
*/

package part3;
import javax.ejb.*;

public class Ses implements SessionBean {
    private SessionContext context;
    private String un = null; // we know that we should not do this in stateless
    //session bean, to highlight the difference b/w stateful and state less
    // session bean we did this.

// this method will be called when ejb is created

    public void ejbCreate() throws CreateException {
		System.out.println("*** In Ejb create method ***");
    }
// following are the methods defined in SessionBean interface
   public void setSessionContext(SessionContext sc) {
        context =sc;
        System.out.println("*** in set session context ***");
   }
   public void ejbRemove() {
        System.out.println("*** in EJB Remove  ***");
    
   }
   public void ejbActivate() {
        System.out.println("*** in EJB Activate  ***");
   }
   public void ejbPassivate() {
        System.out.println("*** in EJB Passivate  ***");
        
   }

// Business logic provided by the bean component
    public String BusinessMethod1(String UName){
        un = new String(UName);
        return ( "Uname Set");
    }
    public String BusinessMethod2(){
        return (un);   
    }
} 
