/* Shows how to implement a session listener.
   Version : 1.0
   Author : Team -J
*/



package ourpack;


import javax.servlet.*;
import javax.servlet.http.*;

public  class MyAppListener
    implements ServletContextListener
{

    public void contextInitialized(ServletContextEvent event) {
	ServletContext context =event.getServletContext();
	context.log("+++++ Application deployed ++++++" );
    }

    public void contextDestroyed(ServletContextEvent event) {
	ServletContext context =event.getServletContext();
	context.log("+++++ Application Destroyed ++++++" );


    }
}
