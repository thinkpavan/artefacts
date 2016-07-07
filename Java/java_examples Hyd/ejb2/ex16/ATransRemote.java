/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package atrans;
import javax.ejb.*;
import java.rmi.*;

public interface ATransRemote extends EJBObject {
    // this method performs db operation
  public boolean PerformSomeDBOperation(int hike)
        throws  RemoteException;
}
