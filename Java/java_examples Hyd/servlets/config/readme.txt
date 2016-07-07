

According servlet 2.2 spec a web application can contain servlets,jsp
and other resources like html,image and other class files.

Once an application is developed we can configure the application
by packing up all the related files in a war file and we can deploy it
in any product that is 2.2 complaint.


We need to follow the steps given below in order to pack the resources
related to a web application.

1) create a top level directory , say inetsolv ( this is the name of
of our web application). This directory is the document root of the 
application.

2) Copy the html files or related stuff under this directory according to the requirement by creating appropriate directory structure under inetsolv.

3) create a Directory WEB-INF  under inetsolv directory.

4) create a file web.xml and store it under WEB-INF diretory.

5) copy your servlet classes and other classes used by the applcation under
WEB-INF/classes 

6) If the application uses additional jar files copy them under WEB-INF/lib
directory.


7) create a war file by using jar utility using the total content of 
inetsolv directory.

8) add the following line to weblogic.properties directory.

weblogic.httpd.webApp.inetapp=c:/abc/inetapp.war

now we can use the application by using 
http://localhost:7001/inetapp/resourcename.xxx.

