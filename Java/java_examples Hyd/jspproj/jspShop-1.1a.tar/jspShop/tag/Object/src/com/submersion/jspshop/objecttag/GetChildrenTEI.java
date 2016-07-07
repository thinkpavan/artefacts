
package com.submersion.jspshop.objecttag;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

/** TEI Descriptor for GetChildrenTag
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.objecttag.GetChildrenTag
 * @version $Revision$
 * @created: September 4, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class GetChildrenTEI extends	TagExtraInfo
{
/*  ================================================
		TAG SPECIFIC METHODS
    ================================================ */
	public VariableInfo[] getVariableInfo(TagData data)
	{
		// create VariableInfo Instance for ID
		VariableInfo info = new VariableInfo("objectID", "java.lang.Long", true, VariableInfo.NESTED);
		
        // create a VaraibleInfo instance for name
        VariableInfo info2 = new VariableInfo("name", "java.lang.String", true, VariableInfo.NESTED);

        // create a VaraibleInfo instance for name
        VariableInfo info3 = new VariableInfo("hasChildren", "java.lang.Boolean", true, VariableInfo.NESTED);
        
		// put into an array
		VariableInfo[] varInfo = { info, info2, info3 };
		
		// return it
		return varInfo;
	}
}
