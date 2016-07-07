package tagpack;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.IOException;

public class  SimpleTag extends TagSupport 
{


   public int doStartTag() throws JspException
      {
	   try
	     {
		   pageContext.getOut().print("<CENTER><H2>doStartTag() Executed </h2></CENTER>");
                   pageContext.getOut().print("<img src=\"girl.jpg\">");
		   return EVAL_BODY_INCLUDE;
		 } catch(Exception e)
		   {
			  throw new JspException(e.getMessage());
		   }
      }

   public int doEndTag() throws JspException
          {
                    try
                        {
			    pageContext.getOut().print("<Center><h2>doEndTag() Executed</h2></Center>");
                            return EVAL_PAGE;
			} catch(Exception e)
			  {
			    throw new JspException(e.getMessage());
			  }
	  }
}
