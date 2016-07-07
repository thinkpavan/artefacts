/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package sec;
import javax.ejb.*;
import java.rmi.*;

public interface SecRemote extends EJBObject {
  public void busMethod1()
        throws  RemoteException;
  public void busMethod2()
        throws  RemoteException;
}
