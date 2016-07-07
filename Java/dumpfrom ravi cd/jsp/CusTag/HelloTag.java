package tagdemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class HelloTag extends TagSupport
{
  private String name="JSP";
  public void setName(String name)
  {
    this.name=name;
  }
  public String getName()
  {
    return this.name;
  }
  public int doStartTag()
  {
    return Tag.SKIP_BODY;
  }
  public int doEndTag()throws JspTagException
  {
	try
	{
		JspWriter out=pageContext.getOut();
		String str="<h1>Hello"+getName()+"<h1>";
		out.println(str);
	}
	
	catch(Exception e)
	{
	
		throw new JspTagException("Error In HelloTag:"+e.getMessage());
	}
	
	return Tag.EVAL_PAGE;
   }
}