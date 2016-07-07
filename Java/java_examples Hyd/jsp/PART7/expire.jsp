<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- 
Example on how to set expiration of content ,according to HTTP we need
to pass time using GMT

Run this example as follows

1) open dbmon.
2) from browser use http://host/expire.jsp and hit return key , on the
server you should observe that the output from system.out.

3) continue the above step (u should be able to see that the browser 
sending request to webserver every time you hit return key.
-->

<%@ page info=" This directive is used to give information about the page" %>
<%@ page language="java"%>
<%@ page errorPage="errpage.jsp"%>
<% Date d = new Date();
long l = d.getTime(); //this returns no of mill seconds elapsed since midnight jan 1 ,1970
response.setDateHeader("Expires",l); //content will expire immediately %>

<HTML>
<HEAD>
<TITLE>example on setting expiration time</TITLE>
</HEAD>

<BODY>
<H2>example on setting expiration time<H2>
<!-- we will set that the content expires immediately.
-->
<%
	out.println(" u'r html content that is dynamically generated goes here"); 
//for debugging we are adding following line
System.out.println(" jsp service method is being executed");
  %>
	<br>This file is generated by INteSolv Students. <br><br><br>
Thanks for visiting us !!!! <br><br>

<%@ include file="copyright.html" %> 

</BODY>
</HTML>