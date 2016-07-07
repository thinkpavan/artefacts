package tagdemo;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class colortag extends BodyTagSupport
{
	String myColor="red";
	public void setValue(String col)
	{
		myColor=col;
	}
	public String getValue()
	{
		return myColor;
	}
	public int doStartTag()throws javax.servlet.jsp.JspException
	{
		return BodyTag.EVAL_BODY_BUFFERED;
	}
	public int doAfterBody()throws javax.servlet.jsp.JspException
	{
		String body=getBodyContent().getString();
		try
		{
			String str="<font color='"+myColor+"'>"+body+"</font>";
			getPreviousOut().print(str);
		}
		catch(IOException e){}
		return SKIP_BODY;
	}
}
