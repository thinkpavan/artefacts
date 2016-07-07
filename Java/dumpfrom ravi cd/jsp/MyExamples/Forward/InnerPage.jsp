<html>
<h1> Inner Page</h1>
<%@page session="true"%>
<% String uname=request.getParameter("uname");
String passwd=request.getParameter("passwd");
%>
<% if (uname.equals(passwd)){
	out.println("COngrats");
	session.putValue("islogin",new Boolean(true));
%>
	<jsp:forward page="Inner2.jsp"/>
<% }
else{ %>
	session.putValue("islogin",new Boolean(false));
	<jsp:forward page="ErrorPage1.jsp"/>
<%}%>

<h2>Welcome to Inner Page </h2>
</html>
