package com.submersion.jspshop.rae;

import java.util.*;

/**
 *  Abstract class for individual RAE object instances.
 *
 *@author        Jeff Davey (jeffdavey@submersion.com)
 *@created       August 28, 2001
 *@version       $REVISION$
 *@modified:     $Date$
 *@changedBy:    $Author$
 */
public abstract class RAECollection
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
	protected HashMap items = new HashMap();
	public static final int CONTEXT = 1;
	public static final int PROPERTY = 2;
	public static final int TYPE = 3;
	public static final int VALUE = 4;
	public static final int CLASS = 5;

    // Security rights...
    public final int READ = 1;
    public final int CREATE = 2;
    public final int MODIFY = 4;
    public final int DELETE = 8;

/*  ================================================
		PUBLIC INTERFACE
    ================================================ */

    /*  --Count---------------- */    
	/**
	 *  Gets the size of the internal hash
	 *
	 *@return    The size value
	 *@since
	 */
	public int getCount()
	{
		return items.size();
	}

    /*  --Iterator---------------- */
    /**
     *  Gets the iterator of the hash
     *
     *@return    The iterator value
     *@since
     */
    public Iterator getIterator()
	{
		return items.values().iterator();
	}

    /*  --Collection---------------- */
    /**
     *  Gets the collection of the hash
     *
     *@return    The iterator value
     *@since
     */
    public Collection getCollection()
	{
		return items.values();
	}
	    
}

