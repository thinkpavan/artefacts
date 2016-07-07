/* shows how to implement a body tag handler.
Version: 1.0
Author : Team-J
*/

package inet;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

/* BodyTagSupport implements the BodyTag which has doStartTag and doEndTag methods. */

public class BodyTag3 extends BodyTagSupport
{
	private int iter=0;
	public void setIter(int i){
		iter=i;
	}
	public int getIter(){
		return iter;
	}
	public int doStartTag() throws javax.servlet.jsp.JspTagException{
	if(iter>0)
		return EVAL_BODY_INCLUDE;
	else
		return SKIP_BODY;
	}
	public void doInitBody() throws JspTagException{
		
	}
	public int doAfterBody() throws JspTagException{
		if(iter>1){
			iter--;
			return EVAL_BODY_TAG;
		}else
			return SKIP_BODY;
	}


	public int doEndTag() throws JspTagException
	{
	BodyContent bodyContent = getBodyContent();
	try{
		if(bodyContent != null)
			bodyContent.writeOut(bodyContent.getEnclosingWriter());
		}catch(java.io.IOException e){
			throw new JspTagException("IO Error: " + e.getMessage());
		}
	return EVAL_PAGE;
	}


}

    
        
    
