<SCRIPT LANGUAGE="Javascript">


function change_project() 
{
	document.frmSite_Changes.txtType.value = "";
	document.frmSite_Changes.submit();
}
	
function submit_form(sType) 
{


<%
If InStr(request.servervariables("HTTP_USER_AGENT"), "Mozilla/3") = 0 Then
%>

	var sMessage;
	
	switch (sType) 
	{
	case 'Add User':
		sMessage = 'Are you sure you wish to add this user?';
		break;
	case 'Remove Project':
		sMessage = 'Are you sure you wish to remove this project?';
		sMessage = sMessage + ', this will permanently erase all information';
		sMessage = sMessage + ' pertaining to this project, and could affect';
		sMessage = sMessage + ' users who are currently logged in to this project.';
		break;
	case 'Remove Program':
		sMessage = 'Are you sure you wish to remove this Program?';
		sMessage = sMessage + ' This will permanently erase all information pertaining';
		sMessage = sMessage + ' to this program.';
		break;
	case 'Remove Area':
		sMessage = 'Are you sure you wish to remove this Program Area?';
		sMessage = sMessage + ' This will permanently erase all information pertaining';
		sMessage = sMessage + ' to this Area.';
		break;
	case 'Add Project':
		sMessage = 'Are you sure you wish to add this project?';
		break;
	case 'Add Program':
		sMessage = 'Are you sure you wish to add this program?';
		break;
	case 'Add Area':
		sMessage = 'Are you sure you wish to add this program area?';
		break;
	case 'Remove User':
		sMessage = 'Are you sure you wish to remove user(s)?';
		break;
	case 'Authorize User':
		sMessage = 'Are you sure you wish to authorize user(s)?';
		break;

	case 'Report':
		sMessage = 'Create report for ' + document.frmSite_Changes.txtStart.value + ' to ' + document.frmSite_Changes.txtEnd.value + '?';
		break;

	default:
		break;
	}
	
	if (confirm(sMessage) == true) 
	{
		document.frmSite_Changes.txtType.value = sType;
		document.frmSite_Changes.submit();
	}	
	
<% Else %>

	if (confirm('Are you sure you wish to continue?') == true) 
	{
		document.frmSite_Changes.txtType.value = sType;
		document.frmSite_Changes.submit();
	}

<% End If %>
}


</SCRIPT>
	

<FORM NAME="frmSite_Changes" ACTION="view_bugs.asp?iBT=11" METHOD=POST>

<CENTER>

<TABLE WIDTH="90%" BORDER=0 CELLSPACING=0 ALIGN=CENTER>


<TR>

<TD WIDTH="100%" ALIGN=CENTER COLSPAN=6 BACKGROUND="images/card_border_top_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=3 COLOR="#000000">
Add User
</FONT></B>
</TD>

<TD BACKGROUND="images/card_border_right.gif">

&nbsp;

</TD>

</TR>


<TR>

<TD WIDTH=13% ALIGN=LEFT BACKGROUND="images/card_top_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">
&nbsp;First Name:
</FONT></B>
</TD>

<TD WIDTH=21% BACKGROUND="images/card_top.gif">

<INPUT TYPE="text" NAME="txtFirst_Name" SIZE=12 MAXLENGTH=20 VALUE="<%=request.form("txtFirst_Name")%>">

</TD>


<TD WIDTH="16%" ALIGN=LEFT BACKGROUND="images/card_top.gif">
<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">
Last Name:
</FONT></B>

</TD>

<TD WIDTH=18% BACKGROUND="images/card_top.gif">

<INPUT TYPE="text" NAME="txtLast_Name" SIZE=12 MAXLENGTH=20 VALUE="<%=request.form("txtLast_Name")%>">

</TD>


<TD WIDTH="13%" ALIGN=LEFT BACKGROUND="images/card_top.gif">
<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">
User Name:
</FONT></B>

</TD>


<TD WIDTH=21% BACKGROUND="images/card_top.gif">

<INPUT TYPE="text" NAME="txtUser_Name" SIZE=12 MAXLENGTH=20 VALUE="<%=request.form("txtUser_Name")%>">

</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<TR>


<TD WIDTH="13%" ALIGN=LEFT BACKGROUND="images/card_mid2_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">
&nbsp;Password:
</FONT></B>

</TD>

<TD WIDTH=21% BACKGROUND="images/card_mid2.gif">
<INPUT TYPE="text" NAME="txtPassword" SIZE=12 MAXLENGTH=48 VALUE="
<% If request.form("txtPassword") = "" Then
	response.write "password"
   Else
   	response.write request.form("txtPassword")
   End If 
%>
">

</TD>


<TD WIDTH="16%" ALIGN=LEFT BACKGROUND="images/card_mid2.gif">
<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">
Email Address:
</FONT></B>

</TD>

<TD WIDTH=18% BACKGROUND="images/card_mid2.gif">

<INPUT TYPE="text" NAME="txtEmail" SIZE=12 MAXLENGTH=48 VALUE="<%=request.form("txtEmail")%>">

</TD>


<TD WIDTH="34%" COLSPAN=2 ALIGN=LEFT BACKGROUND="images/card_mid2.gif">&nbsp;</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<TR>

<TH ALIGN=CENTER COLSPAN=6 BACKGROUND="images/card_mid1_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Authorization
</FONT>

<FONT FACE="Georgia, Arial" SIZE=0 COLOR="#000000">
[Check all that apply]
</FONT></B>
</TH>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<TR>

<TD ALIGN=LEFT COLSPAN=6 BACKGROUND="images/card_mid2_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">


<%
iSelect_Type = 5
iSelect_Size = 4
sProject = request.form("lstProject")
%>
<!-- #include file="create_select.inc" -->


</FONT></B>
</TD>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<TR HEIGHT=25>


<% REM//		Add User Button %>

<TD ALIGN=CENTER COLSPAN=6 BACKGROUND="images/card_mid1_left.gif">

<% 
REM//		Check Browser Version 
REM//		IE will not support A HREF
REM//		method but netscape will.

If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE") = 0 Then
%>

<A HREF="#" onClick="submit_form('Add User')">
<IMG SRC="images/buttons/add.gif" BORDER=0>
</A>

<% Else %>

<IMG SRC="images/buttons/add.gif" onClick="submit_form('Add User')">

<% End If %>

<INPUT TYPE="Hidden" NAME="txtType" Value="">

</TD>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<TR>

<TD COLSPAN=6 BACKGROUND="images/card_border_bottem.gif">&nbsp;</TD>


<TD BACKGROUND="images/corner.gif">&nbsp;</TD>

</TR>


</TABLE>

</CENTER>




<TABLE WIDTH=90% BORDER=0 CELLSPACING=0 ALIGN=CENTER>


<TR>

<TD WIDTH="100%" ALIGN=CENTER COLSPAN=5 BACKGROUND="images/card_border_top_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=3 COLOR="#000000">
Site Modifications
</FONT></B>
</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>


</TR>


<TR>

<TH WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_top_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Site Projects
</FONT></B>
</TH>


<TH WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_top.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Project Programs
</FONT></B>
</TH>


<TH WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_top.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Program Areas
</FONT></B>
</TH>


<TH WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_top.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">

<% 
If request.form("chkUser_Type") <> "Unauthorized" Then 
	

If request.form("chkUser") <> "Developer" Then	
%>

Project Users

<% Else %>

Program Developers

<% 
End If

Else

If request.form("chkUser") <> "Developer" Then	
%>

Unauth Users

<% Else %>

Unauth Developers

<% 
End If


End If 
%>

</FONT></B>

<B><FONT FACE="Georgia, Arial" SIZE=0 COLOR="#000000">
<BR>[ctrl + click for multiple]

</FONT></B>

</TH>


<TH WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_top.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Project Reports
</FONT></B>
</TH>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>


</TR>


<TR>

<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid2_left.gif">

<%
iSelect_Type = 1
iSelect_Size = 4
sProject = request.form("lstProject")
%>
<!-- #include file="create_select.inc" -->

</TD>


<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid2.gif">

<%
iSelect_Type = 2
iSelect_Size = 4
sProject = request.form("lstProject")
sProgram = request.form("lstProgram")
%>
<!-- #include file="create_select.inc" -->

</TD>


<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid2.gif">

<%
If iSelect_Type <> 10 Then

	iSelect_Type = 3
	iSelect_Size = 4
	sProject = request.form("lstProject")
	sProgram = request.form("lstProgram")
	sArea = request.form("lstArea")
%>
	<!-- #include file="create_select.inc" -->


<%
Else
%>


<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">
Invalid Selection
</FONT></B>


<%	
End If
%>

</TD>


<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid2.gif">

<%
If request.form("chkUser_Type") <> "Unauthorized" Then
	iSelect_Type = 6
Else
	iSelect_Type = 7
End If
iSelect_Size = 4
iMultiple = 1
sProject = request.form("lstProject")
%>
<!-- #include file="create_select.inc" -->

</TD>


<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid2.gif">

<FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">Start Date:<BR></FONT>
<INPUT NAME="txtStart" TYPE=TEXT SIZE=11 VALUE="
<%
if (LTrim(RTrim(request.form("txtStart"))) = "") then

	response.write Date-10

else

	response.write request.form("txtStart")

end if
%>
">

<BR>

<FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">End Date:<BR></FONT>
<INPUT NAME="txtEnd" TYPE=TEXT SIZE=11 VALUE="
<%
if (LTrim(RTrim(request.form("txtEnd"))) = "") then

	response.write Date

else

	response.write request.form("txtEnd")

end if
%>
">

</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>


</TR>


<TR>


<% REM//		Remove Project Button %>

<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid1_left.gif">


<% 
REM//		Check Browser Version 
REM//		IE will not support A HREF
REM//		method but netscape will.

If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE") = 0 Then
%>

<A HREF="#" onClick="submit_form('Remove Project')">
<IMG SRC="images/buttons/remove.gif" BORDER=0>
</A>

<% Else %>

<IMG SRC="images/buttons/remove.gif" onClick="submit_form('Remove Project')">

<% End If %>


</TD>


<% REM//		Remove Program Button %>

<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid1.gif">


<% 
REM//		Check Browser Version 
REM//		IE will not support A HREF
REM//		method but netscape will.

If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE") = 0 Then
%>

<A HREF="#" onClick="submit_form('Remove Program')">
<IMG SRC="images/buttons/remove.gif" BORDER=0>
</A>

<% Else %>

<IMG SRC="images/buttons/remove.gif" onClick="submit_form('Remove Program')">

<% End If %>


</TD>


<% REM//		Remove Program Area Button %>

<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid1.gif">


<% 
REM//		Check Browser Version 
REM//		IE will not support A HREF
REM//		method but netscape will.

If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE") = 0 Then
%>

<A HREF="#" onClick="submit_form('Remove Area')">
<IMG SRC="images/buttons/remove.gif" BORDER=0>
</A>

<% Else %>

<IMG SRC="images/buttons/remove.gif" onClick="submit_form('Remove Area')">

<% End If %>


</TD>


<TD WIDTH="20%" ALIGN=CENTER VALIGN=TOP BACKGROUND="images/card_mid1.gif">

<B><FONT FACE="Georgia, Arial" SIZE=0 COLOR="#000000">
<INPUT NAME="chkUser" TYPE="radio" VALUE="User" OnClick="change_project()"<% If request.form("chkUser") <> "Developer" Then response.write " CHECKED" %>> [Users]

<INPUT NAME="chkUser" TYPE="radio" VALUE="Developer" OnClick="change_project()"<% If request.form("chkUser") = "Developer" Then response.write " CHECKED" %>> [Developers]
</FONT></B>

</TD>


<TD WIDTH="20%" ALIGN=CENTER VALIGN=BOTTOM BACKGROUND="images/card_mid1.gif">

<B><FONT FACE="Georgia, Arial" SIZE=0 COLOR="#000000">
<FONT SIZE=2>Report Type:<FONT SIZE=0><BR>
<INPUT NAME="chkReportType" TYPE="radio" VALUE="Daily" <% if request.form("chkReportType") = "Daily" or request.form("chkReportType") = "" then response.write "Checked"%>>[Daily]
<INPUT NAME="chkReportType" TYPE="radio" VALUE="Cumulative" <%if request.form("chkReportType") = "Cumulative" then response.write "Checked"%>>[Cumulative]
</FONT></B>

</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>


</TR>


<TR>


<% REM//	Project TextBox %>

<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid2_left.gif">
<INPUT TYPE="text" NAME="txtProject" SIZE=12 MAXLENGTH=20 VALUE="<%=request.form("txtProject")%>">
</TD>


<% REM//	Program Text Box %>

<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid2.gif">
<INPUT TYPE="text" NAME="txtProgram" SIZE=12 MAXLENGTH=20 VALUE="<%=request.form("txtProgram")%>">
</TD>


<% REM//	Area TextBox %>

<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid2.gif">
<INPUT TYPE="text" NAME="txtArea" SIZE=12 MAXLENGTH=20 VALUE="<%=request.form("txtArea")%>">
</TD>


<% REM//	Authorized/ Unauthorized Users Radio Buttons %>

<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid2.gif">
<B><FONT FACE="Georgia, Arial" SIZE=0 COLOR="#000000">
<INPUT NAME="chkUser_Type" TYPE="radio" VALUE="Authorized" OnClick="change_project()"<% If request.form("chkUser_Type") <> "Unauthorized" Then response.write " CHECKED" %>> [Auth.]

<INPUT NAME="chkUser_Type" TYPE="radio" VALUE="Unauthorized" OnClick="change_project()"<% If request.form("chkUser_Type") = "Unauthorized" Then response.write " CHECKED" %>> [Unauth.]
</FONT></B>
</TD>


<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid2.gif">

&nbsp;

</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>


</TR>


<TR>


<% REM//		Add Project Button %>

<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid1_left.gif">


<% 
REM//		Check Browser Version 
REM//		IE will not support A HREF
REM//		method but netscape will.

If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE") = 0 Then
%>

<A HREF="#" onClick="submit_form('Add Project')">
<IMG SRC="images/buttons/add.gif" BORDER=0>
</A>

<% Else %>

<IMG SRC="images/buttons/add.gif" onClick="submit_form('Add Project')">

<% End If %>


</TD>


<% REM//		Add Program Button %>

<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid1.gif">


<% 
REM//		Check Browser Version 
REM//		IE will not support A HREF
REM//		method but netscape will.

If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE") = 0 Then
%>

<A HREF="#" onClick="submit_form('Add Program')">
<IMG SRC="images/buttons/add.gif" BORDER=0>
</A>

<% Else %>

<IMG SRC="images/buttons/add.gif" onClick="submit_form('Add Program')">

<% End If %>


</TD>


<% REM//		Add Program Area Button %>

<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid1.gif">


<% 
REM//		Check Browser Version 
REM//		IE will not support A HREF
REM//		method but netscape will.

If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE") = 0 Then
%>

<A HREF="#" onClick="submit_form('Add Area')">
<IMG SRC="images/buttons/add.gif" BORDER=0>
</A>

<% Else %>

<IMG SRC="images/buttons/add.gif" onClick="submit_form('Add Area')">

<% End If %>


</TD>


<% REM//		Remove/ Add User Button %>

<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid1.gif">


<%
If request.form("chkUser_Type") = "Unauthorized" Then
	
REM//		Check Browser Version 
REM//		IE will not support A HREF
REM//		method but netscape will.

If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE") = 0 Then
%>

<A HREF="#" onClick="submit_form('Authorize User')">
<IMG SRC="images/buttons/add.gif" BORDER=0>
</A>

<% Else %>

<IMG SRC="images/buttons/add.gif" onClick="submit_form('Authorize User')">

<% 
End If


Else

 
REM//		Check Browser Version 
REM//		IE will not support A HREF
REM//		method but netscape will.

If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE") = 0 Then
%>

<A HREF="#" onClick="submit_form('Remove User')">
<IMG SRC="images/buttons/remove.gif" BORDER=0>
</A>

<% Else %>

<IMG SRC="images/buttons/remove.gif" onClick="submit_form('Remove User')">

<% 
End If

End If
%>


</TD>


<TD WIDTH="20%" ALIGN=CENTER BACKGROUND="images/card_mid1.gif">

<% If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE") = 0 Then %>

<A HREF="#" onClick="submit_form('Report')">
<IMG SRC="images/buttons/go.gif" BORDER=0>
</A>

<% Else %>

<IMG SRC="images/buttons/go.gif" BORDER=0 onClick="submit_form('Report')">

<% End If %>

</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>


</TR>


<TR>

<TD COLSPAN=5 BACKGROUND="images/card_border_bottem.gif">&nbsp;</TD>


<TD BACKGROUND="images/corner.gif">&nbsp;</TD>

</TR>


</TABLE>


</FORM>


<SCRIPT LANGUAGE="Javascript">


<% If iClear_Form = 1 Then %>
{
document.frmSite_Changes.txtFirst_Name.value = "";
document.frmSite_Changes.txtLast_Name.value = "";
document.frmSite_Changes.txtUser_Name.value = "";
document.frmSite_Changes.txtPassword.value = "Password";
document.frmSite_Changes.txtEmail.value = "";
document.frmSite_Changes.txtProject.value = "";
document.frmSite_Changes.txtProgram.value = "";
document.frmSite_Changes.txtArea.value = "";
}
<% End If %>


</SCRIPT>