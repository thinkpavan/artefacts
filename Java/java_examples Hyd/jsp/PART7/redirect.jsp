<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- 
Example on how to set a header to redirect the browser to request for 
another resource (it may be on same or different server)
-->

<%@ page info=" This directive is used to give information about the page" %>

<% 
response.setStatus(301); // response code 301 indicates that the resource is moved
response.setHeader("Location","http://localhost/plainhtml.jsp");
%>

<HTML>
<HEAD>
<TITLE>Please wait for a moment </TITLE>
</HEAD>

<BODY>
<H2> Please wait for a moment your browser will redirect You to 
appropriate place now !!!
<H2>


	<br>This file is generated by INteSolv Students. <br><br><br>
Thanks for visiting us !!!! <br><br>

<%@ include file="copyright.html" %> 

</BODY>
</HTML>