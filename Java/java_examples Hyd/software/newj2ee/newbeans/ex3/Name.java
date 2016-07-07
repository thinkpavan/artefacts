/*Class that implements the logic of a bean , It should be noted
that a client never directly talks to this object
Version : 1.0
Author : Team -J
*/

package ex3;
import javax.ejb.*;
import java.util.*;
public class Name implements SessionBean {
    private SessionContext context;
	private String last_name;
	private String first_name;

    public void ejbCreate() throws CreateException {
		System.out.println(" In ejbCreate() method");
		last_name=null;
		first_name=null;
    }
/*
    public void ejbCreate(String fname,String lname) throws CreateException {
		System.out.println(" In ejbCreate(string,string) method");
		last_name=fname;
		first_name=lname;
    }*/
// following are the methods defined in SessionBean interface
   public void setSessionContext(SessionContext sc) {
		System.out.println("setsessionctx called");
	}
   public void ejbRemove() {
		System.out.println("In remove method");
	}
   public void ejbActivate() {
		System.out.println("in ejb activate");
	}
   public void ejbPassivate() {
		System.out.println("in ejb passivate");

	}

// Business logic provided by the bean component
	
    public void  setFName(String fname){
		first_name = fname;
	}
    public void  setLName(String lname){
		last_name = lname;
	}
    public String getFullName(){
		return first_name + last_name;
	}
} 
