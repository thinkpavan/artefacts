<@page import="mypack.CheckBean" %>
<jsp:useBean id="check"	scope="session" class="CheckBean" />
<jsp:setProperty name="check" property="*" />
<%= check.validate()%>
