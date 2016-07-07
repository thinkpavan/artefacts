/* Shows how to implement a session listener.
   Version : 1.0
   Author : Team -J
*/



package ourpack;


import javax.servlet.*;
import javax.servlet.http.*;

public  class MySesListener
    implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event) {
	HttpSession hs = event.getSession();
	ServletContext context =hs.getServletContext();
	context.log("Session created " + hs.getId());
    }

    public void sessionDestroyed(HttpSessionEvent event) {
	HttpSession hs = event.getSession();
	ServletContext context =hs.getServletContext();
	context.log("Session Destroyed " + hs.getId());


    }
}
