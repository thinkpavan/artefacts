
package com.submersion.jspshop.propertytypetag;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

/** TEI Descriptor for IterateTag
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.propertytypetag.IterateTag
 * @version $Revision$
 * @created: September 8, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class IterateTEI extends	TagExtraInfo
{
/*  ================================================
		TAG SPECIFIC METHODS
    ================================================ */
	public VariableInfo[] getVariableInfo(TagData data)
	{
		// create VariableInfo Instance for the rae.ClassProperty object
		VariableInfo info = new VariableInfo(data.getId(), "com.submersion.jspshop.rae.PropertyType", true, VariableInfo.NESTED);
		
        //to see if we're at end of iterator
        VariableInfo info2 = new VariableInfo(data.getId() + "HasNext", "java.lang.Boolean", true, VariableInfo.NESTED);
        
		// put into an array
		VariableInfo[] varInfo = { info, info2 };
		
		// return it
		return varInfo;
	}
}
