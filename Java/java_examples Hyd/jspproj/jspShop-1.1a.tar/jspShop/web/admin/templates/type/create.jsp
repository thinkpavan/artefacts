<%@ taglib uri="typenametags" prefix="typeName" %> 

<typeName:create id="newType" name="<%=request.getParameter(\"name\") %>" />
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
        url = "https://" + server + request.getContextPath() + "/admin/types.jsp?typeID=" + newType.getID();
    }
    else
    {
        url = "http://" + server + request.getContextPath() + "/admin/types.jsp?typeID=" + newType.getID();
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
