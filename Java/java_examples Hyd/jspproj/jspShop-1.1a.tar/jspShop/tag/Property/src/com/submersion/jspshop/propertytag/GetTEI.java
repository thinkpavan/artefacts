
package com.submersion.jspshop.propertytag;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

/** TEI Descriptor for GetTag
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.propertytag.GetTag
 * @version $Revision$
 * @created: October 9, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class GetTEI extends	TagExtraInfo
{
/*  ================================================
		TAG SPECIFIC METHODS
    ================================================ */
	public VariableInfo[] getVariableInfo(TagData data)
	{
		// create VariableInfo Instance for ID
		VariableInfo info = new VariableInfo(data.getId(), "com.submersion.jspshop.rae.Property", true, VariableInfo.AT_END);
		        
		// put into an array
		VariableInfo[] varInfo = { info };
		
		// return it
		return varInfo;
	}
}
