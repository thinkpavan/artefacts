/* shows how to implement co-operating tag handlers
Version: 1.0
Author : Team-J
*/

package inet;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class SwitchTag extends TagSupport{
	String value;
	public void setValue(String value){
		this.value=value;
	}

	public String getValue(){
		return value;
	}
	public int doStartTag() throws JspTagException{
		return EVAL_BODY_INCLUDE;
	}
}

