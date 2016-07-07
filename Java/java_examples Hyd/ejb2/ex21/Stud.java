package home;

import java.io.Serializable;
import java.util.*;
import javax.ejb.*;
import javax.naming.*;
import javax.sql.DataSource;



abstract public class Stud implements EntityBean {
  private EntityContext ctx;
// need not declare fields to hold data. This will be done by code
// that is automatically generated by container specific tools.

	public Stud() {};

  public void setEntityContext(EntityContext ctx) {
    System.out.println("set entity context");
    this.ctx = ctx;
  }

  public void unsetEntityContext() {
    this.ctx = null;
    System.out.println("unset entity context");
  }

	//declare get/set abstract methods for container managed fields
	abstract public String getId();
	abstract public void setId(String val);

	abstract public String  getName();
	abstract public void setName(String val);

	abstract public String getOA();
	abstract public void setOA(String val);

  public void ejbActivate() {
	System.out.println(" ejb activate");
  }


  public void ejbPassivate() {
	System.out.println(" ejb passivate");
  }


  public void ejbLoad() {
	System.out.println(" ejb load");
  }


  public void ejbStore() {
	System.out.println(" ejb store");
  }


  public void ejbRemove()
    throws RemoveException
  {
	System.out.println(" ejb remove");
  }


  public String  ejbCreate(String id,String name,String oa) 
    throws CreateException
  {
	System.out.println("In ejb create ");
    setId(id);
    setName(name);
    setOA(oa);
    return null; 
  }


  public void ejbPostCreate(String id,String name,String oa)
  {
	System.out.println("In ejb post create ");
  }
  public String getData(){
	return getName() + getId() + getOA();
  }
// home method corresponsing to getNOS
  public int  ejbHomeGetNOS(){
	int nos;
	return 20;
  }
  // ejbSelect methods
 // public abstract Set ejbSelectGetNOS() throws javax.ejb.FinderException;
}











