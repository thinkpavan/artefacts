/* shows how to implement BMP.
Version: 1.0
Author: Team-J.
*/

package oto;
import java.rmi.RemoteException;
import javax.ejb.EJBObject;

public interface AddrRemote extends EJBObject {

  public String getData()
    throws RemoteException;
 }



