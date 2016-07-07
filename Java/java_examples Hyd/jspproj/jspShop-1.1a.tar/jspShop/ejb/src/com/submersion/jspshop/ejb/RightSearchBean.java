package com.submersion.jspshop.ejb;

import java.util.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import javax.naming.*;
import javax.sql.*;
import java.sql.*;

/** Description of product here
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.Object
 * @see com.submersion.jspshop.ejb.ObjectSearch
 * @see com.submersion.jspshop.ejb.ObjectSearchHome
 * @see com.submersion.jspshop.ejb.ObjectHelper
 * @version $Revision$
 * @created: September 7, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class RightSearchBean implements SessionBean
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */

/*  --EJB variables-------------------- */
    private SessionContext ctx;
    private InitialContext jndiContext;

/*  --EJB field variables-------------------- */
    public Long objectID;
    public String context;
    public Long parentID;
    public String name;
    public String className;


/*  ================================================
		IMPLEMENTATION
    ================================================ */
    public HashMap doRightSearch(Long context, Long userID) throws RemoteException
    {
        // lighterweight than Hashtable (no need for synchronisation on user per user basis
        HashMap rval = new HashMap();
        // our connection to the database
        Connection con = null;
        // use a prepared statement
        PreparedStatement prep = null;
        // for creating our query
        StringBuffer sbuf = new StringBuffer();
        
        try
        {
            // get a connection from container
            con = this.getConnection();
            
            //!!!
            // going to build the query dynamically, so this may break some databases? Most i've used support simple joins like I'm doing though.
            // maybe someone else will have an idea on doing search queries quickly and efficiently with CMP, oh yah, and including rights
            // Best I could do is 2.7 seconds on a athlon 1200mhz for 500 records (there were just too many queries, and none of em cached)
            
            // also, using a session bean like that, table names are hardcoded now.. I'll try and figure out a better way to do this on another release
            // maybe grabbing it out of database using a cmp bean or something.
            
            // I don't pretend to know everything about this stuff, so I hope there is a better way :) (Jeff)
            // (ps. can you tell I don't like this, bleh, who needs performance anyways? :P)
            
            
            //!!! Updated, changed this so it only returns all objects and their rights from
            // a specified context, and only those that have rights.
            
            // first get the security query, this will be the same for all queries
            String securityQuery = getSecurityQuery();
            
            // start prepared statement
            prep = con.prepareStatement(securityQuery);
            
            // specify parameters
            prep.setLong(1,context.longValue());
            prep.setLong(2,userID.longValue());
            prep.setLong(3,userID.longValue());
            
            // get the values back
            ResultSet rs = prep.executeQuery();
            

            // iterate through all the returning values
            while (rs.next())
            {
                // add it to the collection
                rval.put(new Long(rs.getLong(1)), rs.getString(2));
            }                
        }
        catch (SQLException e)
        {
            System.err.println("jspShop: Error executing the RightSearch bean with the database: " + e);
            e.printStackTrace();
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up datasource, jdbc/DefaultDS, from the container: " + e);
            e.printStackTrace();
        }
        finally
        {
            // clean up database connection
            if (con != null)
            {
                try
                {
                    con.close();
                }
                catch (SQLException e)
                {
                    System.err.println("jspShop: Error closing connection to datasource in doRightSearch method: " + e);
                    e.printStackTrace();
                }
            }
        }
        return rval;
    }
/*  ================================================
		PRIVATE METHODS
    ================================================ */
    private String getSecurityQuery()
    {
        StringBuffer sbuf = new StringBuffer();
        
        // what we're returning from the query
        sbuf.append("select object.objectID, typeValue.typeValueID from");
        
        // tables that are needed
        sbuf.append(" jspshop_TypeValue typeValue");
        sbuf.append(", jspshop_Object object");
        sbuf.append(", jspshop_Value value");
        sbuf.append(", jspshop_Property property");
        sbuf.append(", jspshop_Type type");
                    
        // next for the where queries (+ super joins)
        sbuf.append(" where");
        sbuf.append(" object.parentID = ?"); // CONTEXT   
        sbuf.append(" and object.objectID = value.objectID");
        sbuf.append(" and value.propertyID = property.propertyID");
        sbuf.append(" and property.name = 'Security'"); // Hard coding this for right now too.. *sigh* (why not, already did everything else)
        sbuf.append(" and (value.value in (");
        sbuf.append(" select"); // next query is to figure out which groups the user belongs to, and get a listing of em            
        sbuf.append(" value.value");
        sbuf.append(" from");
        sbuf.append(" jspshop_Value value, jspshop_Property property, jspshop_Object object");
        sbuf.append(" where");
        sbuf.append(" object.objectID = ?"); // USERID
        sbuf.append(" and object.objectID = value.valueID");
        sbuf.append(" and value.propertyID = property.propertyID");
        sbuf.append(" and property.name = 'Membership'"); // more Hardcoding
        sbuf.append(" ) or value.value = ?)"); // USERID
        sbuf.append(" and value.valueID = typeValue.valueID");
        sbuf.append(" and typeValue.typeID = type.typeID");
        sbuf.append(" and type.name = 'Right'");
        
        // return security query
        return sbuf.toString();
    }
        
    
	private Connection getConnection() throws SQLException, NamingException
	{		
		// get the  context from the container
        InitialContext context = new InitialContext();
        // find where the reference to the datasource is (hard coded DefaultDS here)
		DataSource source = (DataSource)context.lookup("jdbc/DefaultDS");
        // return the connection
		return source.getConnection();
	}
    
/*  ================================================
		EJB SPECIFIC
    ================================================ */
    public void setSessionContext(SessionContext ctx) 
    {
        this.ctx = ctx;
    }

    public void ejbCreate() 
    {
    }

    public void ejbActivate() 
    {
    }

    public void ejbPassivate() 
    {
    }

    public void ejbRemove() 
    {
    }
}
