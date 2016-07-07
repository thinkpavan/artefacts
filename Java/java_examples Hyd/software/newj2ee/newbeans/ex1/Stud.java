/*Class that implements the logic of a bean , It should be noted
that a client never directly talks to this object
Version : 1.0
Author : Team -J
*/

package part1;
import javax.ejb.*;

public class Stud implements SessionBean {
    private SessionContext context;

// this method will be called when ejb is created

    public void ejbCreate() throws CreateException {
		System.out.println(" In Ejb create method");
    }
// following are the methods defined in SessionBean interface
   public void setSessionContext(SessionContext sc) {
			System.out.println("using " +sc + " i can interact with weblogic");
	}
   public void ejbRemove() {
	System.out.println(" in ejb remove");
	}
   public void ejbActivate() {
	System.out.println(" in ejb activate");
	}
   public void ejbPassivate() {
	System.out.println(" in ejb passivate");

	}

// Business logic provided by the bean component
 public void stoteStudent(String sname){
	System.out.println("Connecting to oracle");
	System.out.println("Stored data in database");
}
public String getStudentName(int id){
	System.out.println("Connecting to oracle");
	System.out.println("getting student info from db");
	return "Student name";
}
	
} 
