/*Class that implements the logic of a bean , It should be noted
that a client never directly talks to this object
Version : 1.0
Author : Team -J
*/

package com.inet.course;
import javax.ejb.*;
import java.util.*;
public class Course implements SessionBean {
    private SessionContext context;

// this method will be called when ejb is created

    public void ejbCreate() throws CreateException {
		System.out.println(" In Ejb create method");
    }
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
    public Vector getCourses(){
		Vector v = new Vector();
		v.addElement(new String("j2ee"));
		v.addElement(new String("xxx"));
		v.addElement(new String("yyy"));
		return v;
	}
    public String getCourseDet(int courseid){
			return "Here are the details of course xxx";
	}
	
} 
