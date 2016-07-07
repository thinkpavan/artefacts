package tagpack;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.IOException;

public class ParamTagEx extends TagSupport
{
   public String Name;
   public void setName(String value)
     {
       this.Name=value;
     }
   public int doEndTag() throws JspException
     {
       try
         {
            StringBuffer sb1 = new StringBuffer(this.Name);
            sb1 = sb1.reverse();
            pageContext.getOut().print(sb1.toString());
            return EVAL_PAGE;
         }catch(Exception e)
           {
             throw new JspException(e.getMessage());
           }
     }
}
