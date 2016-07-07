<%@page session="true"%>
<html>
<body >
<%String str=(String)request.getParameter("uname");%>
Ur Name is<%= str %>
<%session.setAttribute("uname",str);%>
<form action="http://localhost:8080/Third.jsp">
<br>
Send The Request to Next Page
<input type=submit>
</body>
</html>
