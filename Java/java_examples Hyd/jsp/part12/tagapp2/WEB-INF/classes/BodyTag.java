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

public class BodyTag extends BodyTagSupport
{
	public int doStartTag() throws javax.servlet.jsp.JspTagException{
      JspWriter out = pageContext.getOut();
        try {
            out.println("From doStartTag<br><br>");
        } catch (IOException ex) {
            throw new JspTagException("IOException: "+ex.toString());
        }
		return EVAL_BODY_INCLUDE;
	}
      public int doEndTag() throws JspException {
      JspWriter out = pageContext.getOut();
        try {
            out.println("From doEndTag <br><br>");
        } catch (IOException ex) {
            throw new JspTagException("IOException: "+ex.toString());
        }
        return EVAL_PAGE; /* SKIP_PAGE  to skip evaluating the other part of page */
    }
	public void doInitBody() throws JspTagException{
		/* called before the first evaluation of boday */
      JspWriter out = pageContext.getOut();
        try {
            out.println("From doInitBody <br><br>");
        } catch (IOException ex) {
            throw new JspTagException("IOException: "+ex.toString());
        }

	}
public int doAfterBody() throws JspTagException{

      JspWriter out = pageContext.getOut();
        try {
            out.println("From doAfterBody <br><br>");
        } catch (IOException ex) {
            throw new JspTagException("IOException: "+ex.toString());
        }

	return SKIP_BODY; /* to skip the body after this evaluation */
  /*EVAL_BODY_TAG to evaluate the body once again */

}



}

    
        
    
