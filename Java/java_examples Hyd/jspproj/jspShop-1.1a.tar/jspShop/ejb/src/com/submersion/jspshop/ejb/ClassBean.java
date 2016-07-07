package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;

/** <pre>Implementation of the Class entity bean using CMP (Container managed persistance).
 * 
 * Classes can stand alone.
 * Classes can inherit properties and types from other classes
 * Classes define Objects.
 *
 * Class Context is described like this:
 *
 *  |-Object  (Has properties of A and B)
 *  |   |-Container (Inherits properties A and B, has Properties C)
 *  |   |&nbsp;&nbsp;&nbsp;|-Container A (Inherits properties A, B, and C, has Property E)
 *  |   |-Product   (Inherits properties A and B, has Properties D)
 *  |-ObjectB (Has properties of F)
 *
 *
 *  The context each Class is this:
 *    Object      = -1 (No inheritance)
 *    Container   = .Object (Inherits Object properties)
 *    ContainerA  = .Container.Object (Inherits Container AND Object)
 *    Product     = .Object (Inherits Object properties)
 *    ObjectB     = -1 (No inheritance)</pre>
 *    
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.Class
 * @see com.submersion.jspshop.ejb.ClassHome
 * @version $Revision$
 * Date Created: August 22, 2001
 * Last changed: $Date$
 * Changed by: $Author$
 */
public class ClassBean implements EntityBean
{
/*  --Class variables-------------------- */
    transient private EntityContext ctx;

/*  --EJB field variables-------------------- */
    public String className;
    public String parentName;
    public String context;
    public String description;

/*  =====================================
              DateField Methods
    ===================================== */

/*  --ClassName-------------------- */
    /** Returns the primary key ClassName
     */
    public String getClassName()
    {
        return className;
    }

/*  --ParentName-------------------- */
    /** Returns the primary key of the parent object
     */
    public String getParentName()
    {
        return parentName;
    }

    /** Changes the parent object for this class. Would only be used during creation
     * 
     * @param parentName 
     */
    public void setParentName(String parentName)
    {
        this.parentName = parentName;
    }

/*  --Context-------------------- */
    /** Returns a sort key which contains the inheritance line for this class
     */
    public String getContext()
    {
        return context;
    }

    /** Changes the sort key containing inheritance information. Would only be used during a create.
     * 
     * @param context 
     */
    public void setContext(String context)
    {
        this.context = context;
    }

/*  --Description-------------------- */
    /** Returns the description for this Class
     */
    public String getDescription()
    {
        return description;
    }

    /** Changes the description for this class.
     * 
     * @param description 
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
/*  =====================================
              EJB Specific Calls
    ===================================== */
    public String ejbCreate(String className)
    {
        this.className = className;
        return null;
    }

    public void ejbPostCreate(String className)
    {
    }

    public void setEntityContext(EntityContext ctx)
    {
        this.ctx = ctx;
    }

    public void unsetEntityContext()
    {
        ctx = null;
    }

    public void ejbActivate()
    {
    }

    public void ejbPassivate()
    {
    }

    public void ejbLoad()
    {
    }

    public void ejbStore()
    {
    }

    public void ejbRemove()
    {
    }
}
