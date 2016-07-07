/*Class that implements the logic of a bean , It should be noted
that a client never directly talks to this object
Version : 1.0
Author : Team -J
*/

package part5;
import javax.ejb.*;

public class SFSes implements SessionBean {
    //private transient SessionContext context; // we used this for weblogic4.5.1
    private  SessionContext context;
    public String FName = null; 
    public String un;

// these methods will be called when ejb is created

    public void ejbCreate() throws CreateException {
		System.out.println("*** In Ejb create method ***");
		FName ="Unknown";
    }
    public void ejbCreate(String FName) throws CreateException {
		System.out.println("*** In Ejb create method with arg ***"+ FName);
		    this.FName = FName;
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
    public String BusinessMethod1(String LName){
        un =  LName + FName;
        return ( un);
    }
    public String BusinessMethod2(){
        return (un);   
    }
} 
