/* Implementation of bean with code that deals with database .
Version : 1.0
Author : Team -J
*/

package bmp;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.ejb.*;
import javax.naming.*;
import javax.sql.DataSource;


public class Stud implements EntityBean {
  private EntityContext ctx;
  private String id;
  private String  name;
  private String  oa;

  public void setEntityContext(EntityContext c) {
    ctx = c;
	System.out.println(" set entity context");
  }

  public void unsetEntityContext() {
    ctx = null;
	System.out.println(" unset entity context");
  }

  public void ejbActivate() {
	System.out.println(" ejb activate");
  }


  public void ejbPassivate() {
	System.out.println(" ejb passivate");
  }


  public void ejbLoad() {
	System.out.println(" ejb load");
    Connection con = null;
    PreparedStatement ps = null;
    id = (String) ctx.getPrimaryKey();

    try {
      con = getConnection();
      ps  = con.prepareStatement("select * from students where id = ?");
      ps.setString(1, id);
      ps.executeQuery();
      ResultSet rs = ps.getResultSet();
      if (rs.next()) {
        name = rs.getString(2);
        oa = rs.getString(3);
      } else {
        throw new NoSuchEntityException (id + "Not found");
       }
    } catch (SQLException sqe) {
      throw new EJBException(sqe);
    } finally {
      cleanup(con, ps);
    }
  }

  public void ejbStore() {
	System.out.println("in ejbstore");
    Connection con = null;
    PreparedStatement ps = null;

    try {
      con = getConnection();
      ps = con.prepareStatement("update students set name = ?,oa = ? where id = ?");
      ps.setString(1, name);
      ps.setString(2, oa);
      ps.setString(3, id);
      if (!(ps.executeUpdate() > 0)) {
        throw new NoSuchEntityException (id+ "Failed to Store");
      }
    } catch(SQLException sqe) {
      throw new EJBException (sqe);
    } finally {
      cleanup(con, ps);
    }
  }


/* Home methods */
  public String ejbCreate(String id,String name,String oa)throws CreateException
  {
    System.out.println("ejb create");
    this.id = id;
    this.name = name;
    this.oa = oa;
    Connection con = null;
    PreparedStatement ps = null;

    try {
      con = getConnection();
      ps = con.prepareStatement("insert into students values (?,?,?)");
      ps.setString(1, id);
      ps.setString(2, name);
      ps.setString(3, oa);
      if (ps.executeUpdate() != 1) {
	   System.out.println("Failed to create ");
         throw new CreateException ("Failed to create");
        }
	  return id;
     } catch (SQLException sqe) {
	   System.out.println("Failed to create "+sqe);
                throw new CreateException ("Failed");
      }finally {
      cleanup(con, ps);
    }
}

  public void ejbPostCreate(String id,String name,String oa){
	System.out.println("ejb post create");
  }

  public void ejbRemove() {

    Connection con = null;
    PreparedStatement ps = null;

    try {
      con = getConnection();
      id = (String) ctx.getPrimaryKey();
      ps = con.prepareStatement("delete from students where id = ?");
      ps.setString(1, id);
      if (!(ps.executeUpdate() > 0)) {
        throw new NoSuchEntityException ("Failed to Remove");
      }
    } catch (SQLException sqe) {
      throw new EJBException (sqe);
    } finally {
      cleanup(con, ps);
    }
  }

/* Finders */

  public String ejbFindByPrimaryKey(String pk)
    throws ObjectNotFoundException
  {
    System.out.println("find by primary key");
    Connection con = null;
    PreparedStatement ps = null;
    try {
      con = getConnection();
      ps  = con.prepareStatement("select * from students where id = ?");
      ps.setString(1, pk);
      ps.executeQuery();
      ResultSet rs = ps.getResultSet();
      if (rs.next()) {
		this.id = rs.getString(1);
		this.name = rs.getString(2);
		this.oa = rs.getString(3);

      } else {
        throw new ObjectNotFoundException ("not Found");
       }
    } catch (SQLException sqe) {
      throw new EJBException (sqe);
    } finally {
      cleanup(con, ps);
    }
    return pk;
  }

  public Collection ejbFindStudents() {
    System.out.println("find students");
    Connection con = null;
    PreparedStatement ps = null;
    try {
      con = getConnection();
      ps = con.prepareStatement("select id from students ");
      ps.executeQuery();
      ResultSet rs = ps.getResultSet();
      Vector v = new Vector();
      String pk;
      while (rs.next()) {
        pk = rs.getString(1);
        v.addElement(pk);
      }
      return v;
    } catch (SQLException sqe) {
      throw new EJBException (sqe);
    } finally {
      cleanup(con, ps);
    }
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public String getId(){
	return id;
  }
  public void setId(String id){
	this.id=id;
  }


  // following method is to get the connection from the pool
  private Connection getConnection()
    throws SQLException
  {
    InitialContext initCtx = null;
    try {
      initCtx = new InitialContext();
      DataSource ds = (javax.sql.DataSource) initCtx.lookup("emcDataSource"); // look up for object in jndi tree
      return ds.getConnection();
    } catch(NamingException ne) {
	System.out.println(ne);
      throw new EJBException(ne);
    } finally {
      try {
        if(initCtx != null) initCtx.close();
      } catch(NamingException ne) {
        throw new EJBException(ne);
      }
    }
  }



  private void cleanup(Connection con, PreparedStatement ps) {
    try {
      if (ps != null) ps.close();
    } catch (Exception e) {
      throw new EJBException (e);
    }

    try {
      if (con != null) con.close();
    } catch (Exception e) {
      throw new EJBException (e);
    }
  }
}
