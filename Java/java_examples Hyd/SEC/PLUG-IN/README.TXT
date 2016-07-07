This shows how to use jre1.2 features in browser
(using java plug - in)

Tools required for this.

1) java plug-in
2) html converter.

procedure

1) create html file to embed applet using applet tag.

2) run java HTMLConverter and chose the html file that has to be converted.

3) place the files on web server and run the test from I.E/Netscape.


Try using an applet that uses jfc and test it with java plug in.


To test security features please follow the following steps

1) copy u'r policy2 file to webserver or any location

2) in java plug -in add the following initilization parameters

-D java-security.policy=http://localhost:8080/policy2

place u'r appperm.html (after using html converter) on webserver
and run the applet from browser and check the results.



Thanks
Team - J
