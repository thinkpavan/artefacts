/**
 *  WebForum (c) 2000 Daniel Lemire , This program is free software; you can
 *  redistribute it and/or modify it under the terms of the GNU General Public
 *  License as published by the Free Software Foundation (version 2). This
 *  program is distributed in the hope that it will be useful, but WITHOUT ANY
 *  WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 *  FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 *  details. You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software Foundation,
 *  Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.text.*;
import java.util.*;

/**
 *  Use this to determine if you have proper write privileges to user.dir.
 * If this fails, webforum will fail (likely). You might want to start
 * you server container from a different directory.
 *
 *@author     Daniel Lemire
 *@created    March 12th 1999
 */
public class ServletWriteTest extends HttpServlet {
	String mServerInfo;
	String mJavaVersion;
	String mJavaVendor;


	/**
	 *  Initialization of the servlet
	 *
	 *@param  config                
	 *@exception  ServletException  
	 *@since 0.30
	 */
	public void init(ServletConfig config)
			 throws ServletException {
		super.init(config);
		try {
			ServletContext sc = config.getServletContext();
			//mMajorVersion = sc.getMajorVersion();
			//mMinorVersion = sc.getMinorVersion();
			mServerInfo = sc.getServerInfo();
			mJavaVendor = System.getProperty("java.vendor");
			mJavaVersion = System.getProperty("java.version");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 *  
	 *
	 *@param  request               
	 *@param  response              
	 *@exception  ServletException  
	 *@exception  IOException       
	 *@since 0.30
	 */
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			 throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML><BODY>");
		out.println("<PRE>");
		out.println("New version");
		out.println(" server = " + mServerInfo);
		out.println(" java.version = " + mJavaVersion);
		out.println(" java.vendor = " + mJavaVendor);
		out.println("writing to disk...");
		File file = new File("deleteme.txt");
		out.println(file.getAbsolutePath());
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("deleteme.txt")));
			pw.println("hello");
			pw.println((new Date()).toString());
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		out.println("writing to disk...done");
		out.println("</PRE>");
		out.println("</BODY></HTML>");
		out.flush();
	}

}


