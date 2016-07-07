package otm;

import java.sql.Date;
import java.util.*;
import javax.ejb.*;
import javax.naming.*;

abstract public class Order implements EntityBean 
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
  abstract public String getOrdId();
  abstract public void setOrdId(String val);

  abstract public String getCustName();
  abstract public void setCustName(String val);

  abstract public java.sql.Date getOrdDate();
  abstract public void setOrdDate(java.sql.Date val);


  abstract public Set getOrdLines();
  abstract public void setOrdLines(Set val);



  public void ejbActivate() {}

  public void ejbPassivate() {}

  public void ejbLoad() {}

  public void ejbStore() {}

  public void ejbRemove() {}

  public OrderPK  ejbCreate(String ord_id, String cust_name, Date ord_date) 
    throws CreateException
  {
	setOrdId(ord_id);
	setCustName(cust_name);
	setOrdDate(ord_date);

    return null;  
  }

public void ejbPostCreate(String ord_id, String cust_name, Date ord_date){
	System.out.println(" Order: In ejb post create");
	
}

}
