/*Class that implements the logic of a bean , It should be noted
that a client never directly talks to this object
Version : 1.0
Author : Team -J
*/

package part4;
import javax.ejb.*;

public class SesCtx implements SessionBean {
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
        EJBHome ejbhome = context.getEJBHome();
            System.out.println("**********************");
            System.out.println("ejb home ="+ ejbhome);
        return ( "in business method 1 ");
    }
    // this methods is to pass back the reference of this bean to the caller
    // it should be noted that we have to pass handle returened by the container since
    // the container interposes all the calls to bean from client.
    public Handle BusinessMethod2(){
        System.out.println(" ** in second business method ***");
        System.out.println("context object =="+ context);
        EJBObject ejo = context.getEJBObject();
        System.out.println("ejb object =="+ ejo);
        Handle h = null;
        try{
            h= ejo.getHandle();
                    System.out.println("ejb handle =="+h);
        }catch(Exception e){ System.out.println(e);}
        System.out.println("Handle  " + h);
        return (h);   
    }
} 
