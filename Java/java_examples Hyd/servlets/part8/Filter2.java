/* Shows how to write a filter.
   Version : 1.0
   Author : Team -J
*/

import java.io.*;
import java.util.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.Enumeration ;

public final class Filter2 implements Filter 
{ 
	private FilterConfig fcon = null;
	PrintWriter out;
	public void init(FilterConfig filterConfig) throws ServletException 
	{
	 fcon = filterConfig; 
	} 
	public void destroy() 
	{
	 fcon = null; 
	} 
	public void doFilter(ServletRequest request, ServletResponse response,
	 	FilterChain chain) throws IOException, ServletException
	{
	HttpServletResponse httpres;
  	if (fcon == null) 
		return;
	httpres = (HttpServletResponse ) response;
	out = response.getWriter();
	out.println(" Web site is temporarily closed for maintainance");
	out.println("Thanks for visiting");
	return;
	}
}   
