package com.submersion.jspshop.classpropertytag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import com.submersion.jspshop.rae.*;

/** Iterates through all ClassProperty children of a given className 
 *  Can also get inherited properties and their parents 
 *
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.classpropertytag.IterateTEI
 * @version $Revision$
 * @created: September 4, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class IterateTag extends	BodyTagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    private Iterator iterator;
    private String showInherited;
    private String className;
    private String showOnlyInherited = null;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
    /*--ClassName-----------*/	
    public void setClassName(String className)
    {
        this.className = className;
    }
    
    /*--ShouldInherit-----------*/
    public void setShowInherited(String showInherited)
    {
        this.showInherited = showInherited;
    }
    
    /*--ShowOnlyInherited-----------*/
    public void setShowOnlyInherited(String showOnlyInherited)
    {
        this.showOnlyInherited = showOnlyInherited;
    }
    
/*  ================================================v
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspException
	{
        // get the ID of the current person logged in
        HttpSession session = pageContext.getSession();
        Long userID = (Long)session.getAttribute("jspShop.userID");
    
        // use this userID more often after we figure out how we're going to restrict classes
    
        // find all classProperties that belong to the class
        
        ClassProperties classProperties = null;
        
        if (showOnlyInherited == null)
        {
            showOnlyInherited = "false";
        }
        if (this.className == null)
        {
            return EVAL_PAGE;
        }
        if (showInherited.toLowerCase().equals("false") || showInherited.toLowerCase().equals("no"))
        {
            // get properties back
            classProperties = new ClassProperties(this.className,false);
            // get iterator
            iterator = classProperties.getIterator();   
        }
        else if (showOnlyInherited.toLowerCase().equals("true") || showOnlyInherited.toLowerCase().equals("yes"))
        {
            // we're gonna sort this by parent and other property name
            HashMap parents = new HashMap();
            
            //get properties back
            classProperties = new ClassProperties(this.className,true);
            // get iterator
            iterator = classProperties.getIterator();   
            
            while (iterator.hasNext())
            {
                ClassProperty classProperty = (ClassProperty)iterator.next();

                // get the parent this was inherited from
                String inheritedFrom = classProperty.getClassName();

                if (!inheritedFrom.equals(this.className))
                {
                    ArrayList list = null;
                    // does the hashMap contain this parent already?
                    if (parents.containsKey(inheritedFrom))
                    {
                        // get the list of properties for this parent
                        list = (ArrayList)parents.get(inheritedFrom);
                    }
                    else
                    {
                        // hasn't so create new list
                        list = new ArrayList();
                    }                    
                    // add the property to the list
                    list.add(classProperty);
                    // add the list to the hashMap
                    parents.put(inheritedFrom, list);                    
                }
            }
            
            // ok, time to write the list out
            
            ArrayList newList = new ArrayList();
            Iterator parentIterator = parents.keySet().iterator();
            while (parentIterator.hasNext())
            {
                String key = (String)parentIterator.next();
                // get all properties from parent list
                ArrayList parentList = (ArrayList)parents.get(key);
                // get iterator from this parent
                Iterator listIterator = parentList.iterator();
                
                while (listIterator.hasNext())
                {
                    newList.add(listIterator.next());
                }
            }
            
            iterator = newList.iterator();            
        }
        else
        {
            // get properties back
            classProperties = new ClassProperties(this.className,true);
            // get iterator
            iterator = classProperties.getIterator();   
        }                

        
        // start iteration
		return doAfterBody();			
	}
	
	public int doEndTag()
	{		
		// continue evaluating the page.
		return EVAL_PAGE;
	}
	
	public int doAfterBody() throws JspException
	{
		
		// keep returning EVAL_BODY_TAG until iterator is expired
		// then return SKIP_BODY
	
		if (iterator.hasNext())
		{

            // get the current object from the iterator
	        ClassProperty classProperty = (ClassProperty)iterator.next();                        
            
            // add the object to the pageContext             
            pageContext.setAttribute(getId(),classProperty);
            
            // add the hasnext stuff
            pageContext.setAttribute(getId() + "HasNext", new Boolean(iterator.hasNext()));
            
            // re-evaluate body to continue iteration
			return BodyTag.EVAL_BODY_TAG;
		}
		else
		{
			try
			{
				// write out any remaining body content
				if (bodyContent != null) 
					bodyContent.writeOut(bodyContent.getEnclosingWriter());
			}
			catch (Exception e)
			{
				throw new JspException("Error occurred writing bodyContent: " + e);
			}
			// all done iteration.
			return BodyTag.SKIP_BODY;
		}
	}	
}
