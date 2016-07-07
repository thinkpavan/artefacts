<%@ taglib uri="propertytypetags" prefix="type" %>

<type:create id="newType" propertyID="<%=request.getParameter(\"propertyID\")%>" typeID="<%=request.getParameter(\"typeID\")%>" />
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
