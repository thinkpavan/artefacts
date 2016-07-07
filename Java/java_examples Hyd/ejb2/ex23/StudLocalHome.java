package oto;

import javax.ejb.*;
import java.rmi.*;
import java.util.*;
import oto.StudLocal;


public interface StudLocalHome extends EJBLocalHome {

  public StudLocal create(String id,String name,String oa) 
    throws CreateException;

  public StudLocal findByPrimaryKey(String primaryKey) 
    throws FinderException;
}
