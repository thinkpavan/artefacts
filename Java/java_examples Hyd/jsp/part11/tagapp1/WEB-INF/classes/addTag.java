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

public class addTag extends TagSupport
{
    int op1;
    int op2;
    public void setOp1(int o1) {
	op1=o1;
    }
    public void setOp2(int o2) {
	op2=o2;
    }
    public int doEndTag() throws JspException {
	int res=0;
      JspWriter out = pageContext.getOut();
        try {
		res = op1 + op2;
            out.println("<body> sum of = "+ op1 + " and " + op2 + " = " + res);
            out.println("</body>");
        } catch (IOException ex) {
            throw new JspTagException("IOException: "+ex.toString());
        }
        return super.doEndTag();
    }
}

    
        
    
