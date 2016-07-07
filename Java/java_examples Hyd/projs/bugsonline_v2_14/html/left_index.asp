<!-- #include file="scripts/bug.inc" -->


<%
REM//		Variable used to determine
REM//		if project image exists

Dim sImage


REM//		Check if not opened within proper frame

If InStr(request.servervariables("HTTP_REFERER"), "index.asp") = 0 And InStr(request.servervariables("HTTP_REFERER"), "itnet") = 0 And InStr(request.servervariables("HTTP_REFERER"), "change_password.asp") = 0 _ 
And InStr(request.servervariables("HTTP_REFERER"), "209.178.39.12") = 0 And InStr(request.servervariables("HTTP_REFERER"), "intranet") = 0 _ 
And request.querystring("iBT") < 1 And request.querystring("iBug_ID") = "" Then

	session("sLogin_Error") = "Please login first!"
	session("sRedirect") = "index.asp"
	response.redirect "destroy_frame.asp"
End If
%>


<HTML>


<HEAD>


<TITLE>Bugs Online Menu</TITLE>


<SCRIPT LANGUAGE="Javascript">


<%
REM//		Open database connection which will set-up menu

Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "bugs", , ""
sql = "SELECT * FROM [tblLeft_Index]"
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3
rs.movefirst
dim x
dim loc
rs.movelast
x = rs.recordcount
rs.movefirst

If session("sProject") <> "Management" Then x = x - 1
%>

{
  var bn=navigator.appName;
  var vn=navigator.appVersion;
  if ((bn!="Microsoft Internet Explorer") || (vn.substring(0,3)!="2.0"))
  {
  var l_button = new Array(<%=loc + 2%>);


  <%
  REM//		Setup image file locations into java array
  
  
  Dim y
  loc = 1
  for y = 1 to x%>
  l_button[<%=loc%>]= new Image ();
  l_button[<%=loc%>].src="images/reg/b<%=y%>.gif";
  <%loc = loc + 1%>
  l_button[<%=loc%>]= new Image ();
  l_button[<%=loc%>].src="images/sel/b<%=y%>.gif";
  <%loc = loc + 1%>
  l_button[<%=loc%>]= new Image ();
  l_button[<%=loc%>].src="images/b<%=y%>.gif";
  <%loc = loc + 1
  next%>
  }
}


function on_img(loc,img,loc1)
  {
  	if ((bn!="Microsoft Internet Explorer") || (vn.substring(0,3)!="2.0")) {
	var sFile_Loc = loc.src;
	var iLength = sFile_Loc.indexOf('images/b');

  	if (iLength == -1)
		loc.src=l_button[img].src;
	}
  }


function on_img1(loc,img,loc1)
  {
    if ((bn!="Microsoft Internet Explorer") || (vn.substring(0,3)!="2.0")) {
	loc.src=l_button[img].src;


	<%
	REM//		Mouse over java script
	
	
	loc = 1
	for y = 1 to x%>
	if (loc1 != <%=y%>)
	document.b<%=y%>.src=l_button[<%=loc%>].src;
	
	
	<%
	loc = loc + 3
	next
	%>

	}
  }



</SCRIPT>


</HEAD>


<BODY BACKGROUND="images/background_folder.gif">


<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0 WIDTH=100%>


<TR WIDTH=100% VALIGN=TOP BACKGROUND="images/background.gif">


<TD WIDTH=11 HEIGHT=46 ROWSPAN=2 BACKGROUND="images/background_folder.gif">


<IMG SRC="images/left_border.gif" BORDER="0" NAME="left_border" ALT="" HEIGHT=46 WIDTH=11>


</TD>

<%


loc = -2
x = 0

REM//		Create menu


do while rs.eof <> true
loc = loc + 3
x = x + 1


REM//		Button #1


If x = 1 Then 
%>


<TD WIDTH=70 HEIGHT=40><A HREF="<%=rs("sLink") & "?iBT=" & x%>" Target="frmContents" onMouseOver="on_img(b<%=x%>,<%=loc+1%>,'b<%=x%>.gif');self.status='<%=rs("sMouse_Over")%>';return true" onMouseOut="on_img(b<%=x%>,<%=loc%>,'b<%=x%>.gif');self.status='';return true" OnClick="on_img1(b<%=x%>,<%=loc+2%>,<%=x%>)"><IMG SRC="images/b<%=x%>.gif" BORDER="0" NAME="b<%=x%>" ALT="<%=rs("sAlt")%>" HEIGHT=40 WIDTH=70></A></TD>


<% Else %>


<%
REM//		Site Administration Button appears only if user authorized as administrator


If rs("sAlt") = "Site Administration" Then
%>


<%If session("sProject") = "Management" Then%>


<TD WIDTH=70 HEIGHT=40><A HREF="<%=rs("sLink") & "?iBT=" & x%>" TARGET="frmContents" onMouseOver="on_img(b<%=x%>,<%=loc+1%>,'b<%=x%>.gif');self.status='<%=rs("sMouse_Over")%>';return true" onMouseOut="on_img(b<%=x%>,<%=loc%>,'b<%=x%>.gif');self.status='';return true" OnClick="on_img1(b<%=x%>,<%=loc+2%>,<%=x%>)"><IMG SRC="images/reg/b<%=x%>.gif" BORDER="0" NAME="b<%=x%>" ALT="<%=rs("sAlt")%>" HEIGHT=40 WIDTH=70></A></TD>


<%End If%>


<%Else%>


<TD WIDTH=70 HEIGHT=40><A HREF="<%=rs("sLink") & "?iBT=" & x%>" TARGET="frmContents" onMouseOver="on_img(b<%=x%>,<%=loc+1%>,'b<%=x%>.gif');self.status='<%=rs("sMouse_Over")%>';return true" onMouseOut="on_img(b<%=x%>,<%=loc%>,'b<%=x%>.gif');self.status='';return true" OnClick="on_img1(b<%=x%>,<%=loc+2%>,<%=x%>)"><IMG SRC="images/reg/b<%=x%>.gif" BORDER="0" NAME="b<%=x%>" ALT="<%=rs("sAlt")%>" HEIGHT=40 WIDTH=70></A></TD>


<%
End If


End If


rs.movenext
loop


REM//		Close database connection


rs.Close
set rs.activeconnection=nothing
Conn.close
%>



<TD BACKGROUND="images/background.gif" WIDTH=100%>


<IMG SRC="images/space.gif" BORDER="0" NAME="space" ALT="" HEIGHT=40 WIDTH=100%>


</TD>


</TR>


<TR WIDTH=100% VALIGN=TOP BACKGROUND="images/background.gif">


<TD BACKGROUND="images/background.gif" COLSPAN=<% = x %> HEIGHT=6>

&nbsp;

</TD>


</TR>


</TABLE>


</BODY>


</HTML>