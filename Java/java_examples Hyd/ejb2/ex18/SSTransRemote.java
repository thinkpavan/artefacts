/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package sync;
import javax.ejb.*;
import java.rmi.*;

public interface SSTransRemote extends EJBObject {
    // this method performs db operation
  public boolean operation1(int hike) throws  RemoteException;
  public boolean operation2(int hike) throws  RemoteException;
}
