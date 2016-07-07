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

public class BodyTag1 extends BodyTagSupport
{
	int i=0;
	public int doStartTag() throws javax.servlet.jsp.JspTagException{
		return EVAL_BODY_INCLUDE;
	}
	public void doInitBody() throws JspTagException{
      JspWriter out = pageContext.getOut();
        try {
            out.println("From doInitBody <br><br>");
        } catch (IOException ex) {
            throw new JspTagException("IOException: "+ex.toString());
        }

	}
public int doAfterBody() throws JspTagException{
	if(i<5){
      JspWriter out = pageContext.getOut();
        try {
            out.println("From doAfterBody <br><br>");
        } catch (IOException ex) {
            throw new JspTagException("IOException: "+ex.toString());
        }
		i++;
		return EVAL_BODY_TAG;
	}
	else
		return SKIP_BODY; 
}



}

    
        
    
