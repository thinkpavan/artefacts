<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- 
forward.jsp will forward the request to this jsp
-->

<%@ page info=" This directive is used to give information about the page" %>



<HTML>
<HEAD>
<TITLE>Out put of recv.jsp </TITLE>
</HEAD>
name:::<%=request.getParameter("name")%>
father name  :::<%=request.getParameter("Fname")%>

<BODY>
<H2> 
	some html here ....
<H2>


	<br>This file is generated by INteSolv Students. <br><br><br>
Thanks for visiting us !!!! <br><br>

<%@ include file="copyright.html" %> 

</BODY>
</HTML>