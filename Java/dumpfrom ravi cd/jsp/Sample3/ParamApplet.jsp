<html>
<body>
<h1> Applet In JSP Example </h1>

<jsp:plugin type="applet" code="ParamApplet"  align="center" height="200" hspace="50"  vspace="50" width="500" >

<jsp:params> 	
<jsp:param name="p" value="This is Java Applet Message"/>

<jsp:param name="x" value="50"/>

<jsp:param name="y" value="50"/>

</jsp:params>  	
</jsp:plugin>
</body>
</html>
