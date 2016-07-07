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

/**
 *  Convenience class to identify the server. Useful for debugging
 *
 *@author     Daniel Lemire
 *@created    March 12th 1999
 */
public class ServletEngineIdentification extends HttpServlet {

	String mJavaVersion;
	String mJavaVendor;
	String mUserDir;
	String mServerInfo;
	int mMajorVersion;
	int mMinorVersion;


	/**
	 *  Initialisation of the servlet
	 *
	 *@param  config                
	 *@exception  ServletException  
	 *@since 0.30
	 */
	public void init(ServletConfig config)
			 throws ServletException {
		super.init(config);
		ServletContext sc = config.getServletContext();
		/*
		 *  try {
		 *  mMajorVersion = sc.getMajorVersion();
		 *  } catch (Exception e) {}
		 *  try {
		 *  mMinorVersion = sc.getMinorVersion();
		 *  } catch (Exception e) {}
		 */
		try {
			mServerInfo = sc.getServerInfo();
		} catch (Exception e) {
		}
		mJavaVendor = System.getProperty("java.vendor");
		mJavaVersion = System.getProperty("java.version");
		mUserDir = System.getProperty("user.dir");
	}


	/**
	 *  This servlet only supports the get method for now.
	 *
	 *@param  request               
	 *@param  response              
	 *@exception  ServletException  
	 *@exception  IOException       
	 *@since  0.30
	 */
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			 throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML><BODY>");
		out.println("<PRE>");
		try {
			out.println("Server Info " + mServerInfo);
		} catch (Exception e) {
			try {
				this.getServletContext().getServerInfo();
			} catch (Exception e2) {
				out.println("Server Info 'Unknown'");
			}
		}
		try {
			out.println("Java vendor " + mJavaVendor);
			out.println("Java version " + mJavaVersion);
			out.println("User dir " + mUserDir);
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		out.println("</PRE>");
		out.println("</BODY></HTML>");
		out.flush();
	}

}

