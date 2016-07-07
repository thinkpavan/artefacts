/*  Sample showing how to develop EJB Home Interface , The class
 that implements this interface will be auomatically depends on
 EJB Server on which this EJB will be deployed.
 Version : 1.0
 Author : Team - J
*/

package com.inet.course;

import java.rmi.*;
import javax.ejb.*;
import com.inet.course.CourseRemote;

public interface CourseHome extends EJBHome {

    public CourseRemote create()
        throws RemoteException, CreateException;

}
