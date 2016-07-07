/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package part4;
import javax.ejb.*;
import java.rmi.*;

public interface SesCtxRemote extends EJBObject {
    public String BusinessMethod1(String UName)
        throws  RemoteException;
    public Handle BusinessMethod2()
        throws  RemoteException;
}
// in this example we will try to show some points specific to stateless
// session bean.