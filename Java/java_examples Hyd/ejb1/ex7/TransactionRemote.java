/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package part7;
import javax.ejb.*;
import java.rmi.*;

public interface TransactionRemote extends EJBObject {
    public String[] listEmp()
        throws  RemoteException;
  public void updatesal()
        throws  RemoteException;
}
