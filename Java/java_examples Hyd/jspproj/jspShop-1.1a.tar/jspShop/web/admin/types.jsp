<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<%
/** Types JSP
 * 
 * author Jeff Davey (jeffdavey@submersion.com)
 * created: September 15, 2001  
*/
%>

<%
    String pageURL;
    String mode = request.getParameter("mode");
    // let's figure out which mode we're in
    if (mode == null)
    {
        pageURL = "/admin/templates/type/browse.jsp";
    }
    else if (mode.equals("changeType"))
    {
        pageURL = "/admin/templates/type/changetype.jsp";
    }
    else if (mode.equals("create"))
    {
        pageURL = "/admin/templates/type/create.jsp";
    }
    else if (mode.equals("add"))
    {
        pageURL = "/admin/templates/type/add.jsp";
    }   
    else if (mode.equals("delete"))
    {
        pageURL = "/admin/templates/type/delete.jsp";
    }
    else
    {
        pageURL = "/admin/templates/type/browse.jsp";
    }
    
%>
<body bgcolor="#FFFFFF" text="#000000">
<div align="center"> 
  <table width="100%" cellspacing="0" cellpadding="0">
    <tr> 
      <td><img src="images/tlcorner.jpg" width="45" height="45"></td>
      <td><a href="objects.jsp"><img src="images/objectclosed.jpg" width="85" height="45" border="0"></a></td>
      <td><a href="classes.jsp"><img src="images/classclosed.jpg" width="83" height="45" border="0"></a></td>
      <td><img src="images/typeopen.jpg" width="90" height="45"></td>
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
                    String url = "http://" + server + request.getContextPath() + "/admin/typeBrowse.jsp";
                    String clickURL = "http://" + server + request.getContextPath() + "/admin/types.jsp";
                    
                    url = response.encodeURL(url);
                    clickURL = response.encodeURL(clickURL);
                %>              
             <OBJECT classid="clsid:CAFEEFAC-0013-0001-0000-ABCDEFFEDCBA"
				WIDTH = 250 HEIGHT = 450  codebase="http://java.sun.com/products/plugin/1.3.1/jinstall-131-win32.cab#Version=1,3,1,0">
                  <PARAM NAME = CODE VALUE = com.submersion.jspshop.adminlist.AdminList >
                  <PARAM NAME = ARCHIVE VALUE = typeBrowse.jar>
                  <PARAM NAME="type" VALUE="application/x-java-applet;jpi-version=1.3.1">
                  <PARAM NAME="scriptable" VALUE="false">
                  <PARAM NAME = "URL" VALUE ="<%=url%>">
                  <PARAM NAME = "ClickURL" VALUE = "<%=clickURL%>">
                  <PARAM NAME = "ClickParam" VALUE="typeID">
                  <PARAM NAME = "ModeParam" VALUE="mode">
                  <PARAM NAME = "AddMode" VALUE="add">
                  <PARAM NAME = "DeleteMode" VALUE="delete">
                  <COMMENT> <EMBED type="application/x-java-applet;jpi-version=1.3.1"  CODE = com.submersion.jspshop.adminlist.AdminList ARCHIVE = typeBrowse.jar WIDTH = 250 HEIGHT = 450 URL = "<%=url%>" ClickURL="<%=clickURL%>" ClickParam = "typeID"  ModeParam = "mode" AddMode = "add" DeleteMode = "delete" scriptable=false pluginspage="http://java.sun.com/products/plugin/1.3.1/plugin-install.html">
                    <NOEMBED> </NOEMBED> 
                  </EMBED> </COMMENT> 
                </OBJECT>             
              </p>
            </td>
            <td background="images/incstretch.jpg">&nbsp;</td>
            <td width="100%" bgcolor="00FF80" valign="top"> 
              <p>
                 <% /* include the URL that corresponds to the mode we're in */ %>
                <jsp:include page="<%=pageURL%>" flush="true" />
              </p>
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
