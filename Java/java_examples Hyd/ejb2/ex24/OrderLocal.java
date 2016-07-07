package otm;

import java.sql.Date;
import java.util.Set;
import otm.*;
import javax.ejb.*;


public interface OrderLocal extends EJBLocalObject 
{
  public Date  getOrdDate();
  public String getCustName();
  public Set getOrdLines();
}
