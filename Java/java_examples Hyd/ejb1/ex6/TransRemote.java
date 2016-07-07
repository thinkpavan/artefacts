/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package part6;
import javax.ejb.*;
import java.rmi.*;

public interface TransRemote extends EJBObject 
{
    public String[] listEmp()throws  RemoteException;
    public void updatesal(int hike, int empno)throws  RemoteException;
}
