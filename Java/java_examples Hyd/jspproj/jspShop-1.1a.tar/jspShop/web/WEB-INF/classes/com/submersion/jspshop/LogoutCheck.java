package com.submersion.jspshop;

import com.submersion.jspshop.rae.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.*;
/** Used to see if the person has logged out, or their session expired.
 *  Then updates the information needed
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @version $Revision$
 * @created: October 12, 2001
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class LogoutCheck implements	HttpSessionBindingListener
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    Long userID;
    String ip;
    Long valueID;

/*  ================================================
		CONSTRUCTORS
    ================================================ */
    public LogoutCheck()
    {
    }

    public LogoutCheck(Long userID, String ip, Long valueID)
    {
        this.userID = userID;
        this.ip = ip;
        this.valueID = valueID;
    }

/*  ================================================
		PUBLIC INTERFACE
    ================================================ */
    /* --UserID-------------- */
    public Long getUserID()
    {
        return userID;
    }    
    public void setUserID(Long userID)
    {
        this.userID = userID;
    }

    /* --IP-------------- */
    public String getIP()
    {
        return ip;
    }
    public void setIP(String ip)
    {
        this.ip = ip;
    }        

    /* --ValueID-------------- */
    public Long getValueID()
    {
        return valueID;
    }
    public void setValueID(Long valueID)
    {
        this.valueID = valueID;
    }        


    /* --Listener calls----------- */
    public void valueBound(HttpSessionBindingEvent event)
    {
        // do nothing   
    }
    
    public void valueUnbound(HttpSessionBindingEvent event)
    {
        try
        {
            // update Last Logged in, and End time for the IP
            rObject object = new rObject(userID, userID);

            // find the property we're looking for
            Properties properties = object.getProperties("Last Logged In Date", Properties.PROPERTY);

            Iterator iterator = properties.getIterator();        
            // date is already set
            if (iterator.hasNext())
            {
                // change it to this time
                Property property = (Property)iterator.next();
                property.setValue(new Long(System.currentTimeMillis()).toString());
            }
            else
            {
                // doesn't exist so create
                ClassProperty classProperty = new ClassProperty("Last Logged In Date", object.getClassName());
                properties.create(classProperty.getID(), new Long(System.currentTimeMillis()).toString());            
            }        
                        

            // find the property we're looking for
            properties = object.getProperties("Last Logged In IP", Properties.PROPERTY);

            iterator = properties.getIterator();        
            // date is already set
            if (iterator.hasNext())
            {
                // change it to this time
                Property property = (Property)iterator.next();
                property.setValue(ip);
            }
            else
            {
                // doesn't exist so create
                ClassProperty classProperty = new ClassProperty("Last Logged In IP", object.getClassName());
                properties.create(classProperty.getID(), ip);            
            }        
                        
                        
        }            
        catch (Exception e)
        {
            System.err.println("jspShop: Error occurred while unbinding session from user: " + userID + ". " + e.getMessage());
            e.printStackTrace();
        }            
    }    

/*  ================================================
		PRIVATE METHODS
    ================================================ */
	private String[] split(String str, String delim) 
	{	
        // for temporarily storing our data
		ArrayList v = new ArrayList();
		
        // initialise current pos
		int cpos = 0;

        // keep going while more delimiters
		while(str.indexOf(delim,cpos) != -1)
		{	
            // delimiter point is where
			int pnt = str.indexOf(delim,cpos);
            // get a substring of the string using current pos and that point
			v.add(str.substring(cpos,pnt));
            // move the current pos past that point
			cpos = pnt + delim.length();
		}
        // add in last element
		v.add(str.substring(cpos,str.length()));

        // create return array
		String[] ret = new String[v.size()];
		for (int i = 0; i < ret.length; i++) 
		{
			ret[i] = (String) v.get(i);
		}
		
		return ret;
	}	
}
