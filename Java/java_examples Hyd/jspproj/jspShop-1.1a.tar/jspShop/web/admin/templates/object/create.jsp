<%@ taglib uri="objecttags" prefix="object" %>

<object:create id="newObject" name="<%=request.getParameter(\"name\")%>" className="<%= request.getParameter(\"className\") %>" parentID="<%=request.getParameter(\"parentID\")%>"/>
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
        url = "https://" + server + request.getContextPath() + "/admin/objects.jsp?objectID=" + newObject.getID() + "&path=" + request.getParameter("path") + "," + newObject.getID();
    }
    else
    {
        url = "http://" + server + request.getContextPath() + "/admin/objects.jsp?objectID=" + newObject.getID() + "&path=" + request.getParameter("path") + "," + newObject.getID();
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
