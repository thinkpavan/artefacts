<%@ taglib uri="classpropertytags" prefix="property" %>

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
        url = "https://" + server + request.getContextPath() + "/admin/classes.jsp?className=" + request.getParameter("className") + "&path=" + request.getParameter("path");
    }
    else
    {
        url = "http://" + server + request.getContextPath() + "/admin/classes.jsp?className=" + request.getParameter("className") + "&path=" + request.getParameter("path");
    }
    // figure out if it's a delete or change
    if (request.getParameter("Change") != null)
    {
        %>
        <property:modify id="<%=request.getParameter(\"propertyID\")%>" name="<%=request.getParameter(\"name\")%>" /> 
        <%
    }
    if (request.getParameter("Remove") != null)
    {
        %>
        <property:delete id="<%=request.getParameter(\"propertyID\")%>" />
        <%
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
