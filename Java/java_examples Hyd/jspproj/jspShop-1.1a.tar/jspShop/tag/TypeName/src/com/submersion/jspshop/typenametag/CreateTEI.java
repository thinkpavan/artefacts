
package com.submersion.jspshop.typenametag;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

/** TEI Descriptor for CreateTag
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.typenametag.CreateTag
 * @version $Revision$
 * @created: September 25, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class CreateTEI extends	TagExtraInfo
{
/*  ================================================
		TAG SPECIFIC METHODS
    ================================================ */
	public VariableInfo[] getVariableInfo(TagData data)
	{
		// create VariableInfo Instance for ID
		VariableInfo info = new VariableInfo(data.getId(), "com.submersion.jspshop.rae.TypeName", true, VariableInfo.AT_END);
		        
		// put into an array
		VariableInfo[] varInfo = { info };
		
		// return it
		return varInfo;
	}
}