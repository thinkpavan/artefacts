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

public class FirstTag extends TagSupport
{
	public int doStartTag() throws javax.servlet.jsp.JspTagException{
      JspWriter out = pageContext.getOut();
        try {
            out.println("<html><head><title>From tag library doStartTag</title></head>");
        } catch (IOException ex) {
            throw new JspTagException("IOException: "+ex.toString());
        }
		return SKIP_BODY; /* EVAL_BODY_INCLUDE  to eveluate body */
	}
      public int doEndTag() throws JspException {
      JspWriter out = pageContext.getOut();
        try {
            out.println("<body> Content generated from doEndTag function <br>Developed by inetsolv to demonstrate how to implement taglibs <select><option>First</option><option>second</option><option>second</option><option>second</option><option>second</option><option>second</option></select>");
        } catch (IOException ex) {
            throw new JspTagException("IOException: "+ex.toString());
        }
        return EVAL_PAGE; /* SKIP_PAGE  to skip evaluating the other part of page */
    }
}

    
        
    
