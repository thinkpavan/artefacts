/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package part3;
import javax.ejb.*;
import java.rmi.*;

public interface SesRemote extends EJBObject {
    public String BusinessMethod1(String UName)
        throws  RemoteException;
    public String BusinessMethod2()
        throws  RemoteException;
}
// in this example we will try to show some points specific to stateless
// session bean.