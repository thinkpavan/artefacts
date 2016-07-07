package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;

/**
 *  Remote interface for TypeValue entity bean
 *
 *@author        Jeff Davey (jeffdavey@submersion.com)
 *@created       August 28, 2001
 *@see           com.submersion.jspshop.ejb.TypeValueBean
 *@see           com.submersion.jspshop.ejb.TypeValueHome
 *@version       $Revision$
 *@created:      August 22, 2001
 *@changed:      $Date$
 *@changedBy:    $Author$
 */
public interface TypeValue extends EJBObject
{
	/*
	 *  =====================================
	 *  DataField Methods
	 *  =====================================
	 */
	 
	/*  --TypeValueID-------------------- */
	/**
	 *  returns the primary key for TypeValue bean
	 *
	 *@return                      The typeValueID value
	 *@exception  RemoteException
	 *@since
	 */
	public Long getTypeValueID() throws RemoteException;


	/*  --ValueID-------------------- */
	/**
	 *  Returns the key of the property value that the type belongs to
	 *
	 *@return                      The valueID value
	 *@exception  RemoteException
	 *@since
	 */
	public Long getValueID() throws RemoteException;


	/**
	 *  sets the key of the property value that the typevalue belongs to. Should
	 *  only be used on creation.
	 *
	 *@param  valueID
	 *@exception  RemoteException
	 *@since
	 */
	public void setValueID(Long valueID) throws RemoteException;


	/*  --Value--------------------	 */
	/**
	 *  returns the value of the type
	 *
	 *@return                      The value value
	 *@exception  RemoteException
	 *@since
	 */
	public String getValue() throws RemoteException;


	/**
	 *  sets the value of the type
	 *
	 *@param  value
	 *@exception  RemoteException
	 *@since
	 */
	public void setValue(String value) throws RemoteException;


	/*  --TypeID-------------------- */
	/**
	 *  Gets the typeID attribute of the TypeValue object
	 *
	 *@return                      The typeID value
	 *@exception  RemoteException  Description of Exception
	 *@since
	 */
	public Long getTypeID() throws RemoteException;


	/**
	 *  Sets the typeID attribute of the TypeValue object
	 *
	 *@param  typeID               The new typeID value
	 *@exception  RemoteException  Description of Exception
	 *@since
	 */
	public void setTypeID(Long typeID) throws RemoteException;
}

