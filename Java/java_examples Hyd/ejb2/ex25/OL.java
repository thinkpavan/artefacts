package otm;

import java.io.Serializable;
import java.sql.Date;
import java.util.*;

import javax.ejb.*;
import javax.naming.*;
import javax.sql.DataSource;


abstract public class OL  implements EntityBean 
{
  private EntityContext ctx;

  public void setEntityContext(EntityContext c) {
    ctx = c;
  }

  public void unsetEntityContext() {
    ctx = null;
  }

  /**
   * container managed fields
   */
  abstract public String getOrderId();
  abstract public void setOrderId(String val);

  abstract public String getLineId();
  abstract public void setLineId(String val);

  abstract public String getItemName();
  abstract public void setItemName(String val);

  abstract public int  getQty();
  abstract public void setQty(int  val);

  abstract public OrderLocal getOrder();
  abstract public void setOrder(OrderLocal or);



  public void ejbActivate() {}
  public void ejbPassivate() {}
  public void ejbLoad() {}
  public void ejbStore() {}

  public void ejbRemove() {}

  public OLPK ejbCreate(String ord_id, String line_id, String item_name,
    int  qty) 

  {
    setOrderId(ord_id);
    setLineId(line_id);
    setItemName(item_name);
    setQty(qty);
    return null;
  }

  public void ejbPostCreate(String ord_id, String line_id, String item_name,
    int  qty) 
  {}

}
































