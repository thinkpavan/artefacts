/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package ex3;
import javax.ejb.*;
import java.rmi.*;

public interface NameRemote extends EJBObject {
    public void  setFName(String fname)
        throws  RemoteException;
    public void  setLName(String lname)
        throws  RemoteException;
    public String getFullName()
        throws  RemoteException;
}



