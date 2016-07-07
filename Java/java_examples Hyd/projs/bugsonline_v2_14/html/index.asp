<% 
session("authorized") = "false"

REM//		Check if opened within a frame

If session("sRedirect") <> "Yes" Then
	If request.servervariables("HTTP_REFERER") <> "" Then
		session("sRedirect") = "index.asp"
		response.redirect "destroy_frame.asp?iSame_Page=1"
	End If
Else
	session("sRedirect") = "No"
End If
%>


<%
Dim sMessage

If session("sLogin_Error") = "" Then
	sMessage = "Please enter your user name and password to proceed..."
	session("sLogin_Error") = ""
Else
	sMessage = session("sLogin_Error")
	session("sLogin_Error") = ""
End If


If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE 3") <> 0 Then 
	sMessage = "We're sorry... you're browser does not support the technologies used by this site.  Please upgrade to IE 4.* + or Netscape 3.* + and try again..."
End If
%>


<HTML>


<HEAD>
<TITLE>Welcome to Bugs Online</TITLE>


<% 
REM//		Refreshes if showing title image
REM//		

If session("iStart") <> 1 Then 
%>


<META http-equiv="refresh" content="6; URL=index.asp">


<% End If %>


</HEAD>


<BODY TEXT="#004080" BGCOLOR="#000000">


<FORM NAME="frmIndex" ACTION="login.asp" METHOD=POST>


<TABLE WIDTH=100% HEIGHT=100% BORDER=0>


<TR>

<TD ALIGN=CENTER COLSPAN=2>
&nbsp;
</TD>

</TR>


<% 
REM//		If opening screen has already been shown then 
REM//		login is requested

If session("iStart") = 1 Then 
%>
<TR>

<TD ALIGN=CENTER HEIGHT=100 COLSPAN=2>
<IMG SRC="images/projects/bugs.gif" BORDER=0 ALT="">
<IMG SRC="images/banners/welcome.gif" BORDER=0 ALT="">
</TD>

</TR>


<TR>

<TD ALIGN=CENTER COLSPAN=2 HEIGHT=50>
<B><FONT FACE="Verdana, Arial" COLOR="#FFDF8C" SIZE=2>
<%
If InStr(sMessage, "Please enter your") <> 0 Then
%>

<IMG SRC="images/text/please_enter.gif" BORDER=0 ALT="">

<%
Else

	response.write sMessage
		
End If
%>

</FONT></B>

</TD>

</TR>

<%
REM//		Login screen only shown if 
REM//		Browser supports site
REM//		Must be either IE 4.*+ or
REM//		Netscape 3.*+ to use site.

If InStr(sMessage, "browser does not") = 0 Then
%>



<TR>

<TD ALIGN=RIGHT WIDTH=50% HEIGHT=26>
<IMG SRC="images/text/user_name.gif" BORDER=0 ALT="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</TD>

<TD ALIGN=LEFT>
<INPUT TYPE="text" NAME="txtUser_Name" SIZE="20" MAXLENGTH="20" VALUE="<% = session ("sUser_Name") %>">

<SCRIPT LANGUAGE="Javascript">
	document.frmIndex.txtUser_Name.focus();
</SCRIPT>

</TD>

</TR>


<TR>

<TD ALIGN=RIGHT WIDTH=50% HEIGHT=26>
<IMG SRC="images/text/password.gif" BORDER=0 ALT="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</TD>

<TD ALIGN=LEFT>
<INPUT TYPE="password" NAME="txtPassword" SIZE="20" MAXLENGTH="20" VALUE="<% = session ("sPassword") %>">
</TD>

</TR>


<TR>

<TD ALIGN=RIGHT WIDTH=50% HEIGHT=26>
<IMG SRC="images/text/project.gif" BORDER=0 ALT="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</TD>

<TD ALIGN=LEFT>

<%
iSelect_Type = 4
iSelect_Size = 1
%>
<!-- #include file="scripts/create_select.inc" -->

</TD>

</TR>


<TR>

<TD>
&nbsp;
</TD>

<TD ALIGN=LEFT HEIGHT=15>
<INPUT TYPE="checkbox" NAME="chkChange" VALUE="yes">
<IMG SRC="images/text/change_password.gif" BORDER=0 ALT="">
</TD>

</TR>


<TR>

<TD>
&nbsp;
</TD>

<TD ALIGN=LEFT HEIGHT=20>
<INPUT TYPE="Image" SRC="images/buttons/enter.gif" BORDER=0 ALT="Click here to enter Bug's Online!">
</TD>

</TR>


<% 
REM//		End Browser not supported if

End If 


REM//		Into screen shown

 
Else

session("iStart") = 1
%>


<TR>

<TD ALIGN=CENTER COLSPAN=2>
<A HREF="index.asp"><IMG SRC="images/opening.gif" BORDER=0 HEIGHT="111" WIDTH="300" ALT="Welcome to Bugs Online!"></A>
</TD>

</TR>


<% End If %>


<TR>

<TD ALIGN=CENTER COLSPAN=2>
&nbsp;
</TD>

</TR>


</TABLE>


</FORM>


</BODY>


</HTML>