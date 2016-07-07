/*Class that implements the logic of a bean , It should be noted
that a client never directly talks to this object.
Version : 1.0
Author : Team -J
*/

package ref;
import javax.ejb.*;
import java.sql.*;
import ref.*;

public class ejb2 implements SessionBean{
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
  // implementation of business methods
  public void ejb2Method(){
	System.out.println(" ******* As part of ejb2Method*****");
  }


} 

// by running this example we can find out why ejb specification about
// sessionsynchronization with stateful session bean