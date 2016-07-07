
package com.submersion.jspshop.classtag;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

/** TEI Descriptor for GetTag
 * 
 * @author Darryl Bleau (darrylbleau@submersion.com)
 * @see com.submersion.jspshop.classtag.GetTag
 * @version $Revision$
 * @created: September 24, 2001  
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
		VariableInfo info = new VariableInfo(data.getId(), "com.submersion.jspshop.rae.Class", true, VariableInfo.AT_END);
		        
		// put into an array
		VariableInfo[] varInfo = { info };
		
		// return it
		return varInfo;
	}
}
