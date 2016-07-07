/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package part5;
import javax.ejb.*;
import java.rmi.*;

public interface SFSesRemote extends EJBObject {
    public String BusinessMethod1(String LName)   throws  RemoteException;
    public String BusinessMethod2()     throws  RemoteException;
}
// in this example we will try to show some points specific to stateless
// session bean.