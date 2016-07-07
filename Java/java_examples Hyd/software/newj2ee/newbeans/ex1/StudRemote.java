/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package part1;
import javax.ejb.*;
import java.rmi.*;

public interface StudRemote extends EJBObject {
    public void stoteStudent(String sname)
        throws  RemoteException;
    public String getStudentName(int id)
        throws  RemoteException;
}
