/* shows how to implement BMP.
Version: 1.0
Author: Team-J.
*/

package oto;
import java.rmi.RemoteException;
import javax.ejb.EJBLocalObject;

public interface StudLocal extends EJBLocalObject{

  public String getData();
  public String getAddressDet();

 }



