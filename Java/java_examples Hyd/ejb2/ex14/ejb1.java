/*Class that implements the logic of a bean , It should be noted
that a client never directly talks to this object.
Version : 1.0
Author : Team -J
*/

package ref;
import javax.ejb.*;
import java.sql.*;
import ref.*;
import javax.naming.*;
import java.util.*;

public class ejb1 implements SessionBean{
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

  public void ejb1Method(){
    try{
        // we need not use credentials to get ic.
      	Context ic    = new InitialContext();
// using naming service get reference to home interface
           Object obj= ic.lookup("ref.ejb2LocalHome");
// to improve performance we are using local home and local object here.
           ejb2LocalHome home =(ejb2LocalHome)obj;
           ejb2Local h = home.create();
           System.out.println(" Before calling method on other ejb object");
	     h.ejb2Method();
           System.out.println(" After getting EJBObject ");
        }catch(Exception e){
                System.out.println(e);
       }
    }

} 

