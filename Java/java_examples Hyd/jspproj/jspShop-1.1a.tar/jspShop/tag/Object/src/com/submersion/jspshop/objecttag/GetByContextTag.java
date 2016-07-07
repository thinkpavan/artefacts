package com.submersion.jspshop.objecttag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;
import com.submersion.jspshop.ejb.*;

/** Returns information from an Object
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.objecttag.GetByContextTEI
 * @version $Revision$
 * @created: October 9, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class GetByContextTag extends TagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */    
    String context;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
    public void setContext(String context)
    {
        this.context = context;
    }
	
/*  ================================================
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspTagException
	{

        // get the ID of the current person logged in
        HttpSession session = pageContext.getSession();
        
        if (context == null || context.equals(""))
        {
            throw new JspTagException("Invalid context");
        }

        
        String[] names = split(context, "~!");
        Long previousContext = new Long(-1);

        rObject object = null;
        for (int i = names.length - 1; i > 0; i--)
        {
            object = new rObject(previousContext, names[i]);            
            previousContext = object.getID();
            if (object.getID().longValue() == -1)
            {
                object = null;
                break;
            }
        }
        pageContext.setAttribute(getId(), object);        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
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
