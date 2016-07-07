These files are meant to be sample files to help you use the
Java2 applet with your forum. Please make sure that your forum
is already working, then these sample files should provide
you with enough info to get your applet working. The applet
is not needed to make the forum work.

Only the forumapplet.txt need to be edited and possibly
renamed myfile.html, leave the jar in the same directory
as the forumapplet.html file. The file is only meant as 
example of how you could setup your HTML, the content is
irrelevant (it might in French, it doesn't matter), you only
need to check for the relevant HTML codes and it should
help you get started. Of course, you'll need to modify the
HTML file to even get started:

*) You need to change the ForumFile parameter in two places (wherever
it appears in the html).

*) You also need to change the ServletURL parameter to tell the applet
what servlet to call...  It should be something like
 http://mydomain/servlet/com.ondelette.servlet.webforum.WebForumGenericServlet

Daniel Lemire, Ph.D.
http://www.ondelette.com
December 29th,2000

