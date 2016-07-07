/* shows how to implement co-operating tag handlers
Version: 1.0
Author : Team-J
*/

package inet;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class CaseTag extends TagSupport{
	String value;
	public void setValue(String value){
		this.value=value;
	}
	public String getValue(){
		return value;
	}
	public int doStartTag() throws JspTagException{
		inet.SwitchTag parent=(inet.SwitchTag)findAncestorWithClass(this,inet.SwitchTag.class);
		if(parent==null){
			throw new JspTagException("You cannot use case without switch");
		}
		try{
			if(parent.getValue().equals(getValue())){
				return EVAL_BODY_INCLUDE;
			}else{
				return SKIP_BODY;
			}
		}catch(NullPointerException e){
			if(parent.getValue()==null && getValue()==null){
				return EVAL_BODY_INCLUDE;
			}else{
				return SKIP_BODY;
			}
		}
	}
}

