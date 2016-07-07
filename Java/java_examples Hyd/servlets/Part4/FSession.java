/* shows how to use sessions
 * version :1.0
 * author Adapted from the JSDK2.0 by Team -J. 
 */


import java.io.*;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.http.*;




public class FSession extends HttpServlet { 
  
  public void doGet (HttpServletRequest req, HttpServletResponse res)
       throws ServletException, IOException
  {
    //Get the session object
// true to indicate if session is not existing already
    HttpSession session = req.getSession(true);
    
    // set content type and other response header fields first
    res.setContentType("text/html");
    
    // then write the data of the response
    PrintWriter out = res.getWriter();
    
    out.println("<HEAD><TITLE> " + "FSession  " +
                "</TITLE></HEAD><BODY>");
    out.println("<h1> FSession Output </h1>");
    
    // Retrieve the  value from the session
    String sval = (String) session.getValue("Someval");
    
    if (sval==null) 
      sval = new String("Object stored in user session");
    
    session.putValue("Someval", sval);
    
    out.println("Value stored in session object<b>" + sval );
  
    out.println("<h3>Request and Session Data:</h3>");
    out.println("Session ID in Request: " +
                req.getRequestedSessionId());
    out.println("<br>Session ID in Request from Cookie: " +
                req.isRequestedSessionIdFromCookie());
    out.println("<br>Session ID in Request from URL: " +
                req.isRequestedSessionIdFromUrl());
    out.println("<br>Valid Session ID: " +
                req.isRequestedSessionIdValid());
    out.println("<h3>Session Data:</h3>");
    out.println("New Session: " + session.isNew());
    out.println("<br>Session ID: " + session.getId());
    out.println("<br>Creation Time: " + session.getCreationTime());
    out.println("<br>Last Accessed Time: " +
                session.getLastAccessedTime());
    out.println("<h3>Session Context Data:</h3>");
// we can get info on all sessions
    HttpSessionContext context = session.getSessionContext();
    
    for (Enumeration e = context.getIds(); e.hasMoreElements() ;) {
      out.println("Valid Session: " +
                  (String)e.nextElement()+ "<br>");
    }
    
    out.println("</BODY>");
    out.close();
  }
  

}
