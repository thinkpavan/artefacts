package oto;

import javax.ejb.*;
import java.rmi.*;
import java.util.*;
import oto.AddrLocal;


public interface AddrLocalHome  extends EJBLocalHome {

  public AddrLocal create(String studid,String addr) 
    throws CreateException;

  public AddrLocal findByPrimaryKey(String primaryKey) 
    throws FinderException;
}
