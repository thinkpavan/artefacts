package otm;

import javax.ejb.*;
import java.rmi.*;



public interface OLLocal  extends EJBLocalObject 
{
  public String getOrderId();
  public void setOrderId(String val);

  public String getLineId();
  public void setLineId(String val);

  public String getItemName();
  public void setItemName(String val);

  public int  getQty();
  public void setQty(int  val);

  public OrderLocal getOrder();
  public void setOrder(OrderLocal or);
}
