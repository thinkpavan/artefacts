package otm;

import java.sql.Date;
import java.util.Collection;
import javax.ejb.*;
import otm.*;


public interface OrderLocalHome extends EJBLocalHome 
{

  public OrderLocal create(String ord_id, String cust_name, Date ord_date) 
    throws CreateException;

  public OrderLocal findByPrimaryKey(otm.OrderPK pk) 
    throws FinderException;

}
