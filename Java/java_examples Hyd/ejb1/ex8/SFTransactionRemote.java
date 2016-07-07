/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package part8;
import javax.ejb.*;
import java.rmi.*;

public interface SFTransactionRemote extends EJBObject {
    public String[] listEmp()
        throws  RemoteException;
  public void updatesal()
        throws  RemoteException;
}
