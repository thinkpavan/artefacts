<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- 
Example on how to use cookies , in class we will explain how to 
develop the site which can use automated login facility.
-->

<%@ page info=" This directive is used to give information about the page" %>
<%@ page language="java"%>
<%@ page errorPage="errpage.jsp"%>
<HTML>
<HEAD>
<TITLE>UseBean Example</TITLE>
</HEAD>

<BODY>
<H2>shows how to use cookies</H2>
<!-- In this example we will first find out whether the browser has
passed username and password as part of cookies or not if not we will present
a form to him to submit user name and password.
-->
<% Cookie ck[] = request.getCookies();
	for(int i=0;i<ck.length;i++)
		out.println(ck[i].getName()+"...."+ck[i].getValue());
	
%>
<%
 if( request.getParameter("submit")== null) {%>

<form method="get" action="logincookie.jsp">
<P>
<INPUT TYPE="textbox" NAME="name">
<P>
<P>
<INPUT TYPE="password" NAME="pass">
<P>
<INPUT TYPE="SUBMIT" NAME="submit">
</FORM>
<%}
else {
%>

   <% 
	Cookie c1 = new Cookie("name",request.getParameter("name"));
	Cookie c2 = new Cookie("pass",request.getParameter("pass"));
	//c1.setMaxAge(30*60) valid for 30 secs , - indicates default ie expires
	// after the vbrowser closes , 0 delete immediately.
	out.println(" Thanks for visiting us");
	response.addCookie(c1);
	response.addCookie(c2);
// we are supposed to check whether this visitor is a valid user or not
	out.println("<br> username = " +request.getParameter("name"));
	out.println("<br> password = " +request.getParameter("pass"));
      session.putValue("isloggedin", new Boolean(true));
    %>
<%
}// end of else
%>	
	<br>This file is generated by INteSolv Students. <br><br><br>
Thanks for visiting us !!!! <br><br>

<%@ include file="copyright.html" %> 

</BODY>
</HTML>