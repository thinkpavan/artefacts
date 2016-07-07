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

public final class Filter1 implements Filter 
{ 
	private FilterConfig fcon = null;
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
	HttpServletRequest httpreq;
  	if (fcon == null) 
		return;
	StringWriter buf = new StringWriter();
	PrintWriter logger = new PrintWriter(buf);
	logger.println("*******************request detials***************");
	logger.println("          protocol=" + request.getProtocol());
	logger.println("        remoteAddr=" + request.getRemoteAddr());
	logger.println("        serverName=" + request.getServerName());
	logger.println("        serverPort=" + request.getServerPort());
	httpreq = (HttpServletRequest) request;
	logger.println("          pathInfo=" + httpreq .getPathInfo());
	logger.println("        requestURI=" + httpreq .getRequestURI());
	logger.println("       servletPath=" + httpreq .getServletPath());

	
	logger.flush();
	fcon.getServletContext().log(buf.getBuffer().toString());

	// Pass control on to the next filter
        chain.doFilter(request, response);
	}
}   
/* check the log file to find out the details logged by this servlet. */
