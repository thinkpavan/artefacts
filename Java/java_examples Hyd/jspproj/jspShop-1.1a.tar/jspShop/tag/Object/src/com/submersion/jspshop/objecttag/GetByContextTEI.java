
package com.submersion.jspshop.objecttag;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

/** TEI Descriptor for GetByContextTag
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.objecttag.GetByContextTag
 * @version $Revision$
 * @created: October 9, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class GetByContextTEI extends	TagExtraInfo
{
/*  ================================================
		TAG SPECIFIC METHODS
    ================================================ */
	public VariableInfo[] getVariableInfo(TagData data)
	{
		// create VariableInfo Instance for ID
		VariableInfo info = new VariableInfo(data.getId(), "com.submersion.jspshop.rae.rObject", true, VariableInfo.AT_END);
		        
		// put into an array
		VariableInfo[] varInfo = { info };
		
		// return it
		return varInfo;
	}
}
