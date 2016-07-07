package otm;

import java.sql.Date;
import java.util.Set;
import java.rmi.RemoteException;
import javax.ejb.*;


public interface OrderRemote extends EJBObject 
{
  public Date  getOrdDate()  throws  RemoteException;
  public String getCustName()  throws  RemoteException; 
  //public Set getOrdLines()  throws  RemoteException;
// not allowed according ejb 2.x
}
