package otm;

import java.sql.Date;
import java.util.Collection;

import javax.ejb.*;


public interface OLLocalHome  extends EJBLocalHome {

  public OLLocal create(String ord_id, String line_id, String item_name,
    int  qty) 
    throws CreateException;

  public OLLocal  findByPrimaryKey(OLPK primaryKey) 
    throws FinderException;
}
