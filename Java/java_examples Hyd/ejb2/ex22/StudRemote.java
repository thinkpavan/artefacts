/* shows how to implement BMP.
Version: 1.0
Author: Team-J.
*/

package select;
import java.rmi.RemoteException;
import javax.ejb.EJBObject;

public interface StudRemote extends EJBObject {

  public String getData()
    throws RemoteException;
 }


