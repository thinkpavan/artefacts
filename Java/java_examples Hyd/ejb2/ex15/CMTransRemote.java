/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package cmt;
import javax.ejb.*;
import java.rmi.*;

public interface CMTransRemote extends EJBObject {
    // this method performs db operation
  public boolean PerformSomeDBOperation(int hike)
        throws  RemoteException;
}
