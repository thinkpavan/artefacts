<SCRIPT LANGUAGE="Javascript">


function submit_form(sType) 
{


<%
If InStr(request.servervariables("HTTP_USER_AGENT"), "Mozilla/3") = 0 Then
%>

	var sMessage;
	
	switch (sType) 
	{
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


<TABLE WIDTH=80% HEIGHT=10% ALIGN=CENTER BORDER=1 BGCOLOR='#C0C0C0'>


<TR WIDTH=100%>


<TD WIDTH=35% ALIGN=LEFT VALIGN=TOP>

<B><FONT FACE="Georgia, Arial" SIZE=0 COLOR="#000000">
<FONT SIZE=2>Create report with myself as a:<FONT SIZE=0><BR>

<INPUT NAME="chkUser" TYPE="radio" VALUE="User" <% If request.form("chkUser") <> "Developer" Then response.write " CHECKED" %>> Submittor
<BR>
<INPUT NAME="chkUser" TYPE="radio" VALUE="Developer" <% If request.form("chkUser") = "Developer" Then response.write " CHECKED" %>> Developer
</FONT></B>

</TD>


<TD WIDTH=35% ALIGN=LEFT VALIGN=TOP>

<B><FONT FACE="Georgia, Arial" SIZE=0 COLOR="#000000">
<FONT SIZE=2>Dates:<FONT SIZE=0><BR>


Start Date:&nbsp;&nbsp;</FONT>
<INPUT NAME="txtStart" TYPE=TEXT SIZE=11 VALUE="
<%
if (LTrim(RTrim(request.form("txtStart"))) = "") then

	response.write Date-10

else

	response.write request.form("txtStart")

end if
%>
">

<FONT SIZE=0><BR>
End Date:&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
<INPUT NAME="txtEnd" TYPE=TEXT SIZE=11 VALUE="
<%
if (LTrim(RTrim(request.form("txtEnd"))) = "") then

	response.write Date

else

	response.write request.form("txtEnd")

end if
%>
">

</B></FONT>

</TD>



<TD WIDTH=35% ALIGN=LEFT VALIGN=TOP>

<B><FONT FACE="Georgia, Arial" SIZE=0 COLOR="#000000">
<FONT SIZE=2>Report Type:<FONT SIZE=0><BR>
<INPUT NAME="chkReportType" TYPE="radio" VALUE="Daily" <% if request.form("chkReportType") = "Daily" or request.form("chkReportType") = "" then response.write "Checked"%>>[Daily]
<BR>
<INPUT NAME="chkReportType" TYPE="radio" VALUE="Cumulative" <%if request.form("chkReportType") = "Cumulative" then response.write "Checked"%>>[Cumulative]
</FONT></B>

</TD>


<TD WIDTH=50 ALIGN=LEFT VALIGN=MIDDLE>


<% If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE") = 0 Then %>

<A HREF="#" onClick="submit_form('Report')">
<IMG SRC="images/buttons/go.gif" BORDER=0>
</A>

<% Else %>

<IMG SRC="images/buttons/go.gif" BORDER=0 onClick="submit_form('Report')">

<% End If %>

</TD>

</TR>


</TABLE>


<INPUT TYPE=HIDDEN NAME='CustomReport' VALUE='true'>
<INPUT TYPE=HIDDEN NAME='txtType'>

</FORM>