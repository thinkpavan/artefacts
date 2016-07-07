/* shows how to implement BMP.
Version: 1.0
Author: Team-J.
*/

package bmp;
import java.rmi.RemoteException;
import javax.ejb.EJBObject;

public interface StudRemote extends EJBObject {

  public String getName()throws RemoteException;
  public void setName(String name)throws RemoteException;
  public String getId() throws RemoteException;
  public void setId(String id) throws RemoteException;

 }



