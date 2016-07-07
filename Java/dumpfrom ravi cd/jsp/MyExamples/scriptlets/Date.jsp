<html>
<body>
<%@ page  import="java.util.Date" %>
<font color=red>
<%@ include file="hello.jsp" %>
<%
Date obj=new  Date();
out.println("Date "+obj+"<br>");
out.println("Date "+obj.getDate()+"<br>");
out.println("Month "+obj.getMonth()+"<br>");
out.println("Year "+obj.getYear()+"<br>");
%>
Todays Date<%=obj%>
</font>
</body>
</html>