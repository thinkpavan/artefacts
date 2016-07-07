<%@ taglib uri="propertytags" prefix="property" %>
<%
    if (request.getParameter("removeValue") != null)
    {
    %>
        <property:delete id="<%= request.getParameter(\"valueID\") %>"/>        
    <%
    }
    else if (request.getParameter("changeValue") != null)
    {
    %>
        <property:modify id="<%= request.getParameter(\"valueID\") %>" value="<%= request.getParameter(\"value\") %>"/>
    <%
    }
    %>
<%
    String url = "";
    String server = "";
    if (!String.valueOf(request.getServerPort()).equals("80"))
    {
        server = request.getServerName() + ":" + request.getServerPort();
    }
    else
    {
        server = request.getServerName();
    }
    if (request.isSecure())
    {
        url = "https://" + server + request.getContextPath() + "/admin/objects.jsp?objectID=" + request.getParameter("objectID") + "&path=" + request.getParameter("path");
    }
    else
    {
        url = "http://" + server + request.getContextPath() + "/admin/objects.jsp?objectID=" + request.getParameter("objectID") + "&path=" + request.getParameter("path");
    }
%>

<HTML>
<BODY>
<SCRIPT LANGUAGE="JavaScript">
<!--
    window.location.href = "<%=response.encodeURL(url) %>";
//-->
</SCRIPT>

      <div align="center"> <br><br>
	     <a href="<%=response.encodeURL(url) %>">Click here</a> if you are not redirected.
      </div>
</BODY>
</HTML>
