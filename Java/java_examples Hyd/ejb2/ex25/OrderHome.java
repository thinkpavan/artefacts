package otm;

import java.sql.Date;
import java.util.Collection;
import javax.ejb.*;
import java.rmi.RemoteException;



public interface OrderHome extends EJBHome 
{

  public OrderRemote create(String ord_id, String cust_name, Date ord_date) 
    throws CreateException,RemoteException;

  public OrderRemote  findByPrimaryKey(otm.OrderPK pk) 
    throws FinderException,RemoteException;

}
