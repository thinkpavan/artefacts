/* shows how to implement a tag handler.
Version: 1.0
Author : Team-J
*/

package inet;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

/* TagSupport implements the Tag which has doStartTag and doEndTag methods. */

public class SecondTag extends TagSupport
{
	public int doStartTag() throws javax.servlet.jsp.JspTagException{
      JspWriter out = pageContext.getOut();
        try {
            out.println("<html><head><title>From secondtag library doStartTag</title></head>");
        } catch (IOException ex) {
            throw new JspTagException("IOException: "+ex.toString());
        }
		return SKIP_BODY; /* EVAL_BODY_INCLUDE  to eveluate body */
	}
      public int doEndTag() throws JspException {
      JspWriter out = pageContext.getOut();
        try {
            out.println("<body> Content generated from doEndTag function of second tag<br>Developed by inetsolv to demonstrate how to implement taglibs");
        } catch (IOException ex) {
            throw new JspTagException("IOException: "+ex.toString());
        }
        return SKIP_PAGE;
    }
}

    
        
    
