<html>
<head>
<title>Classes</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<%!
// return current time to proxy server request
public long getLastModified(HttpServletRequest request) 
{
	return System.currentTimeMillis();
}
%>

<%
/** Class JSP
 * 
 * author Darryl Bleau (darrylbleau@submersion.com)
 * created: September 10, 2001  
*/
%>

<%
    // figure out which mode we should display
    String mode = request.getParameter("mode");
    String pageURL = null;
    
    if (mode == null)
    {
        pageURL = "/admin/templates/class/browse.jsp";
    }
    else if (mode.equals("add"))
    {
        pageURL = "/admin/templates/class/add.jsp";
    }
    else if (mode.equals("delete"))
    {
        pageURL = "/admin/templates/class/delete.jsp";
    }
    else if (mode.equals("create"))
    {
        pageURL = "/admin/templates/class/create.jsp";
    }
    else if (mode.equals("propertyChange"))
    {
        pageURL = "/admin/templates/class/propertychange.jsp";
    }
    else if (mode.equals("typeChange"))
    {
        pageURL = "/admin/templates/class/typechange.jsp";
    }
    else if (mode.equals("addType"))
    {
        pageURL = "/admin/templates/class/addtype.jsp";
    }
    else if (mode.equals("addProperty"))
    {
        pageURL = "/admin/templates/class/addproperty.jsp";
    }
    else
    {
        pageURL = "/admin/templates/class/browse.jsp";
    }
%>

<link rel="stylesheet" href="tables.css">
<link rel="stylesheet" href="main.css">
<body bgcolor="#FFFFFF" text="#000000">
<div align="center"> 
  <table width="100%" cellspacing="0" cellpadding="0">
    <tr> 
      <td><img src="images/tlcorner.jpg" width="45" height="45"></td>
      <td><a href="objects.jsp"><img src="images/objectclosed.jpg" width="85" height="45" border="0"></a></td>
      <td><img src="images/classopen.jpg" width="83" height="45"></td>
      <td><a href="types.jsp"><img src="images/typeclosed.jpg" width="90" height="45" border="0"></a></td>
      <td background="images/tstretchbar.jpg" width="100%">&nbsp;</td>
      <td><img src="images/trcorner.jpg"></td>
    </tr>
    <tr> 
      <td background="images/lstretch.jpg">&nbsp;</td>
      <td colspan="4" bgcolor="0080FF"> 
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td><img src="images/intlcorner.jpg"></td>
            <td background="images/intlstretch.jpg"></td>
            <td><img src="images/intcenter.jpg"></td>
            <td background="images/intrstretch.jpg" width="100%"></td>
            <td><img src="images/intrcorner.jpg"></td>
          </tr>
          <tr> 
            <td background="images/inlstretch.jpg">&nbsp;</td>
            <td bgcolor="FFFFFF" valign="top"> 
              <p> 
                <!--"CONVERTED_APPLET"-->
                <!-- HTML CONVERTER -->
                <% 
                    /* encode the URLs for the applet below
                       so people that don't have cookies enabled
                       will still be able to keep their session id
                    */
                    
                    String server = "";
                    if (!String.valueOf(request.getServerPort()).equals("80"))
                    {
                        server = request.getServerName() + ":" + request.getServerPort();
                    }
                    else
                    {
                        server = request.getServerName();
                    }
                    
                    String url = "http://" + server + request.getContextPath() + "/admin/classBrowse.jsp";
                    String clickURL = "http://" + server + request.getContextPath() + "/admin/classes.jsp";
                    
                    url = response.encodeURL(url);
                    clickURL = response.encodeURL(clickURL);
                %>
                <OBJECT classid="clsid:CAFEEFAC-0013-0001-0000-ABCDEFFEDCBA"
				WIDTH = 250 HEIGHT = 450  codebase="http://java.sun.com/products/plugin/1.3.1/jinstall-131-win32.cab#Version=1,3,1,0">
                  <PARAM NAME = CODE VALUE = com.submersion.jspshop.adminbrowse.AdminBrowse >
                  <PARAM NAME = ARCHIVE VALUE = objectBrowse.jar>
                  <PARAM NAME="type" VALUE="application/x-java-applet;jpi-version=1.3.1">
                  <PARAM NAME="scriptable" VALUE="false">
                  <PARAM NAME = "URL" VALUE ="<%=url%>">
                  <PARAM NAME = "URLParam" VALUE ="context">
                  <PARAM NAME = "ClickURL" VALUE = "<%=clickURL%>">
                  <PARAM NAME = "ClickParam" VALUE="className">
                  <PARAM NAME = "Path" VALUE="<%= request.getParameter("path") %>">
                  <PARAM NAME = "ModeParam" VALUE="mode">
                  <PARAM NAME = "AddMode" VALUE="add">
                  <PARAM NAME = "DeleteMode" VALUE="delete">
                  <COMMENT> <EMBED type="application/x-java-applet;jpi-version=1.3.1"  CODE = com.submersion.jspshop.adminbrowse.AdminBrowse ARCHIVE = objectBrowse.jar WIDTH = 250 HEIGHT = 450 URL = "<%=url%>" URLParam = "context"  ClickURL="<%=clickURL%>" ClickParam = "className" Path="<%=request.getParameter("path") %>" ModeParam = "mode" AddMode = "add" DeleteMode = "delete" scriptable=false pluginspage="http://java.sun.com/products/plugin/1.3.1/plugin-install.html">
                    <NOEMBED> </NOEMBED> 
                  </EMBED> </COMMENT> 
                </OBJECT> 
              </p>
            </td>
            <td background="images/incstretch.jpg">&nbsp;</td>
            <td width="100%" bgcolor="00FF80" valign="top">
            
            <% /* include the URL that corresponds to the mode we're in */ %>
            <jsp:include page="<%=pageURL%>" flush="true" />
            
            </td>
            <td background="images/inrstretch.jpg">&nbsp;</td>
          </tr>
          <tr> 
            <td><img src="images/inblcorner.jpg"></td>
            <td background="images/inblstretch.jpg"></td>
            <td><img src="images/inbcenter.jpg"></td>
            <td background="images/inbrstretch.jpg" width="100%"></td>
            <td><img src="images/inbrcorner.jpg"></td>
          </tr>
        </table>
      </td>
      <td background="images/rstretch.jpg">&nbsp;</td>
    </tr>
    <tr> 
      <td><img src="images/blcorner.jpg" width="45" height="45"></td>
      <td colspan="4" background="images/bstretch.jpg">&nbsp;</td>
      <td><img src="images/brcorner.jpg" width="45" height="45"></td>
    </tr>
  </table>
</div>
</body>
</html>

