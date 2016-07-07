/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package part9.Client;
import javax.ejb.*;
import java.rmi.*;

public interface BeanClientRemote extends EJBObject {
  public void callsrv()
        throws  RemoteException;
}
