package otm;

import javax.ejb.*;
import java.rmi.*;



public interface OLRemote extends EJBObject 
{
  public String getOrderId() throws RemoteException;
  public void setOrderId(String val) throws RemoteException;

  public String getLineId() throws RemoteException;
  public void setLineId(String val) throws RemoteException;


  public String getItemName() throws RemoteException;
  public void setItemName(String val) throws RemoteException;

  public int  getQty() throws RemoteException;
  public void setQty(int  val) throws RemoteException;

}
