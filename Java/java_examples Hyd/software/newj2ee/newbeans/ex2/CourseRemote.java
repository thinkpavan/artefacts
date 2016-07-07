/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package com.inet.course;
import javax.ejb.*;
import java.rmi.*;
import java.util.Vector;

public interface CourseRemote extends EJBObject {
    public Vector getCourses()
        throws  RemoteException;
    public String getCourseDet(int courseid)
        throws  RemoteException;
}



