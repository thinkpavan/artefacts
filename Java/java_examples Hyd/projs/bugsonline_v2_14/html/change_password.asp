<!-- #include file="scripts/bug.inc" -->


<%
Dim sMessage

If session("sLogin_Error") = "" Then
	sMessage = "Please enter the following information to proceed..."
	session("sLogin_Error") = ""
Else
	sMessage = session("sLogin_Error")
	session("sLogin_Error") = ""
End If	
%>


<HTML>


<HEAD>
<TITLE>Bugs Online Change Password</TITLE>
</HEAD>


<BODY TEXT="#004080" BGCOLOR="#000000">


<FORM NAME="frmChange_Password" ACTION="login_change_password.asp" METHOD=POST>

<TABLE WIDTH=100% HEIGHT=100%>


<TR>

<TD ALIGN=CENTER COLSPAN=2>
&nbsp;
</TD>

</TR>


<TR>


<TD ALIGN=CENTER COLSPAN=2 HEIGHT=70>
<IMG SRC="images/projects/bugs.gif" BORDER=0 ALT="">
<IMG SRC="images/banners/change.gif" BORDER=0 ALT="">
</TD>

</TR>


<TR>


<TD ALIGN=CENTER COLSPAN=2 HEIGHT=50>
<B><FONT FACE="Georgia, Arial" COLOR="#FFDF8C" SIZE=2>

<%
If InStr(sMessage, "Please enter the") <> 0 Then
%>

<IMG SRC="images/text/please_enter_the.gif" BORDER=0 ALT="">

<%
Else

	response.write sMessage
		
End If
%>

</FONT></B>

</TD>

</TR>


<TR>

<TD WIDTH="50%" HEIGHT=20 ALIGN=RIGHT>
<IMG SRC="images/text/original_password.gif" BORDER=0 ALT="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</TD>

<TD ALIGN=LEFT>
<INPUT TYPE="password" NAME="txtPassword" SIZE="20" MAXLENGTH="20">
</TD>

</TR>


<TR>

<TD WIDTH="50%" HEIGHT=20 ALIGN=RIGHT>
<IMG SRC="images/text/new_password.gif" BORDER=0 ALT="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</TD>

<TD ALIGN=LEFT>
<INPUT TYPE="password" NAME="txtNew_Password" SIZE="20" MAXLENGTH="20">
</TD>

</TR>


<TR>

<TD WIDTH="50%" HEIGHT=20 ALIGN=RIGHT>
<IMG SRC="images/text/confirm_password.gif" BORDER=0 ALT="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</TD>

<TD ALIGN=LEFT>
<INPUT TYPE="password" NAME="txtConfirm_Password" SIZE="20" MAXLENGTH="20">
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


<TR>

<TD COLPSAN=2>
&nbsp;
</TD>

</TR>


</TABLE>


</FORM>


</BODY>


</HTML>