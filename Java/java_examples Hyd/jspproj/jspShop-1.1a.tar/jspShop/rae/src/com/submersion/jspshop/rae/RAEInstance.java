package com.submersion.jspshop.rae;

/**
 *  Abstract class for individual RAE object instances.
 *
 *@author        Jeff Davey (jeffdavey@submersion.com)
 *@created       August 28, 2001
 *@version       $REVISION$
 *@modified:     $Date$
 *@changedBy:    $Author$
 */
public abstract class RAEInstance
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
	protected Long id;
	protected String name;
    protected int right;

    // Security rights...
    public final int READ = 1;
    public final int CREATE = 2;
    public final int MODIFY = 4;
    public final int DELETE = 8;

/*  ================================================
		CONSTRUCTORS
    ================================================ */
	/**
	 *  Constructor for the RAEInstance object
	 *
	 *@param  id  The primary ID for this instance
	 *@since
	 */
	public RAEInstance(Long id)
	{
		this.id = id;
	}

    public RAEInstance()
    {
    }
/*  ================================================
		PUBLIC INTERFACE
    ================================================ */

    /*  --ID---------------- */    
	/**
	 *  Gets the primary ID of the current instance
	 *
	 *@return    The id value
	 *@since
	 */
	public Long getID()
	{
		return id;
	}

    /*  --Name---------------- */
    /**
     *  Gets the name attribute of the current instance
     *
     *@return    The name value
     *@since
     */
    public String getName() throws SecurityException
	{
		if (name == null)
		    initialise();
            
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        } 
        
		return name;
	}

	protected abstract void initialise();
}

