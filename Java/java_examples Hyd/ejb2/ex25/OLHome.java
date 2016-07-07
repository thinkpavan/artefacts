package otm;

import java.sql.Date;
import java.util.Collection;
import java.rmi.*;
import javax.ejb.*;


public interface OLHome  extends EJBHome {

  public OLRemote create(String ord_id, String line_id, String item_name,
    int  qty) 
    throws CreateException,RemoteException;

  public OLRemote findByPrimaryKey(OLPK primaryKey) 
    throws FinderException,RemoteException;
}
