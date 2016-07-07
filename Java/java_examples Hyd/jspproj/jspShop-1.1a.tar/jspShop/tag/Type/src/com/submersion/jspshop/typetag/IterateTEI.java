
package com.submersion.jspshop.typetag;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

/** TEI Descriptor for IterateTag
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.typetag.IterateTag
 * @version $Revision$
 * @created: September 24, 2001  
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
		VariableInfo info = new VariableInfo(data.getId(), "com.submersion.jspshop.rae.Type", true, VariableInfo.NESTED);
		
        // for checking if the iterator has more
        VariableInfo info2 = new VariableInfo(data.getId() + "HasNext", "java.lang.Boolean", true, VariableInfo.NESTED);
        
		// put into an array
		VariableInfo[] varInfo = { info, info2 };
		
		// return it
		return varInfo;
	}
}
