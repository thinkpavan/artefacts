<SCRIPT LANGUAGE="Javascript">

	
function submit_form(sType) 
{
	document.frmBug_Search.txtType.value = sType;
	document.frmBug_Search.submit();
}


function change_project() 
{
	document.frmBug_Search.txtType.value = "";
	document.frmBug_Search.submit();
}


</SCRIPT>


<FORM NAME="frmBug_Search" ACTION="view_bugs.asp?iBT=9" METHOD=POST>


<TABLE WIDTH="90%" BORDER=0 CELLSPACING=0 ALIGN=CENTER BACKGROUND="images/background.gif">


<TR>

<TD ALIGN=CENTER COLSPAN=5 BACKGROUND="images/card_border_top_left.gif">
<CENTER><B><FONT FACE="Georgia, Arial" SIZE=3 COLOR="#000000">
<% response.write request.form("btnSubmit") %>
Search Criteria
</FONT></B>

<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">
<% If session("sUser_Search") <> "" Then response.write "  :  User Search '" & session("sUser_Search") & "'" %>
</FONT></B>

<BR>

<B><FONT FACE="Georgia, Arial" SIZE=0 COLOR="#000000">
[Hold Ctrl or Shift + Click to select multiple]
&nbsp;&nbsp;
[Leave text fields blank for no criteria]
</FONT></B>
</CENTER>

</TD>

<TD BACKGROUND="images/card_border_right.gif" WIDTH=5>

&nbsp;

</TD>

</TR>


<TR>

<TD ALIGN=CENTER BACKGROUND="images/card_top_left.gif">
<CENTER><B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
&nbsp;&nbsp;Project
</FONT></B></CENTER>
</TD>

<TD ALIGN=CENTER BACKGROUND="images/card_top.gif">
<CENTER><B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Program
</FONT></B></CENTER>
</TD>

<TD ALIGN=CENTER BACKGROUND="images/card_top.gif">
<CENTER><B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Program Area
</FONT></B></CENTER>
</TD>

<TD ALIGN=CENTER BACKGROUND="images/card_top.gif">
<CENTER><B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Posted By
</FONT></B></CENTER>
</TD>

<TD ALIGN=CENTER BACKGROUND="images/card_top.gif">
<CENTER><B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Assigned To
</FONT></B></CENTER>
</TD>

<TD BACKGROUND="images/card_border_right.gif" WIDTH=5>

&nbsp;

</TD>

</TR>



<TR>

<% REM//		Project Info %>

<TD ALIGN=CENTER BACKGROUND="images/card_mid2_left.gif" VALIGN=TOP>

<%
If session("sProject") = "Management" Then

iSelect_Type = 14
iSelect_Size = 4
If request("lstProject") <> "Management" then sProject = request("lstProject")

%>
<!-- #include file="create_select.inc" -->

<%
Else
%>

&nbsp;&nbsp;
<SELECT NAME="lstProject" SIZE=4>

	<OPTION SELECTED><%= session("sProject") %></OPTION>
	
</SELECT>

<%
End If
%>

</TD>


<% REM//		Program Info %>

<TD ALIGN=CENTER BACKGROUND="images/card_mid2.gif" VALIGN=TOP>

<%
iSelect_Type = 12
iSelect_Size = 4
iMultiple = 1

If session("sProject") <> "Management" Then
	sProject = session("sProject")
ElseIf request("lstProject") <> "" Then
	sProject = request("lstProject")
Else
	sProject = "***none***"
End If

sProgram = request("lstProgram")
%>
<!-- #include file="create_select.inc" -->


<% REM//		Program Info Not Checkbox %>

<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">
<BR>
<INPUT NAME="chkProgram" TYPE="checkbox"<% If request("chkProgram") = "True" Then response.write " Checked"%> VALUE="True">Not

</FONT></B>
</TD>


<% REM//		Program Area Info %>

<TD ALIGN=CENTER BACKGROUND="images/card_mid2.gif" VALIGN=TOP>

<%
iSelect_Type = 11
iSelect_Size = 4
iMultiple = 1

If session("sProject") <> "Management" Then
	sProject = session("sProject")
Else
	sProject = request("lstProject")
End If

sProgram = request("lstProgram")
sArea = request("lstArea")
%>
<!-- #include file="create_select.inc" -->


<% REM//		Program Area Info Not Checkbox %>

<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">
<BR>
<INPUT NAME="chkArea" TYPE="checkbox"<% If request("chkArea") = "True" Then response.write " Checked"%> VALUE="True">Not

</FONT></B>
</TD>


<% REM//		Posted By %>

<TD ALIGN=CENTER BACKGROUND="images/card_mid2.gif" VALIGN=TOP>

<%
'		Open database to fill array of developers

iSelect_Type = 8
iSelect_Size = 4
iMultiple = 1
%>
<!-- #include file="create_select.inc" -->


<% REM//		Posted By Not Checkbox %>

<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">
<BR>
<INPUT NAME="chkUser" TYPE="checkbox"<% If request("chkUser") = "True" Then response.write " Checked"%> VALUE="True">Not

</FONT></B>
</TD>


<% REM//		Assigned To %>

<TD ALIGN=CENTER BACKGROUND="images/card_mid2.gif" VALIGN=TOP>

<%
'		Open database to fill array of developers

iSelect_Type = 10
iSelect_Size = 4
iMultiple = 1
%>
<!-- #include file="create_select.inc" -->


<% REM//		Assigned To Not Checkbox %>

<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">
<BR>
<INPUT NAME="chkAssigned" TYPE="checkbox"<% If request("chkAssigned") = "True" Then response.write " Checked"%> VALUE="True">Not

</FONT></B>
</TD>

<TD BACKGROUND="images/card_border_right.gif" WIDTH=5>

&nbsp;

</TD>

</TR>


<TR>


<% REM//		Date Title %>

<TD ALIGN=CENTER COLSPAN=2 BACKGROUND="images/card_mid1_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Dates
</FONT></B>
</TD>


<% REM//		Bug Status %>

<TD ALIGN=CENTER BACKGROUND="images/card_mid1.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Bug Status
</FONT></B>
</TD>


<% REM//		Bug Priority %>

<TD ALIGN=CENTER BACKGROUND="images/card_mid1.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Bug Priority
</FONT></B>
</TD>


<% REM//		Bug Severity %>

<TD ALIGN=CENTER BACKGROUND="images/card_mid1.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Bug Severity
</FONT></B>
</TD>

<TD BACKGROUND="images/card_border_right.gif" WIDTH=5>

<B><FONT FACE="Georgia, Arial" COLOR="#000000" SIZE=0>
&nbsp;
</FONT></B>

</TD>

</TR>


<TR>


<% REM//		Data Start %>

<TD ALIGN=CENTER COLSPAN=2 BACKGROUND="images/card_mid2_left.gif" VALIGN=TOP>
<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">&nbsp;&nbsp;From:  </FONT></B>

<INPUT TYPE="Text" NAME="txtDate_Start" VALUE="<% = request("txtDate_Start") %>" MAXLENGTH=8 SIZE=8>

<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000"><BR>&nbsp;&nbsp;To:  &nbsp;&nbsp;&nbsp;&nbsp;</FONT></B>

<INPUT TYPE="Text" NAME="txtDate_End" VALUE="<% = request("txtDate_End") %>" MAXLENGTH=8 SIZE=8>


<% REM//		Dates Not Checkbox %>

<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000"><BR>
<INPUT NAME="chkDates" TYPE="checkbox"<% If request("chkDates") = "True" Then response.write " Checked"%> VALUE="True">Not
</FONT></B>
</TD>


<% REM//		Bug Staus %>

<TD ALIGN=CENTER BACKGROUND="images/card_mid2.gif" VALIGN=TOP>

<SELECT NAME="lstStatus" SIZE=3 MULTIPLE>
	<OPTION<% If request("lstStatus") = "" or request("lstStatus") = "No Criteria" Then response.write " SELECTED" %>>No Criteria</OPTION>
	<OPTION<%If InStr(request("lstStatus"), "Open") <> 0 Then response.write " SELECTED"%>>Open</OPTION>
	<OPTION<%If InStr(request("lstStatus"), "Assigned") <> 0 Then response.write " SELECTED"%>>Assigned</OPTION>
	<OPTION<%If InStr(request("lstStatus"), "Completed") <> 0 Then response.write " SELECTED"%>>Completed</OPTION>
	<OPTION<%If InStr(request("lstStatus"), "Postponed") <> 0 Then response.write " SELECTED"%>>Postponed</OPTION>
	<OPTION<%If InStr(request("lstStatus"), "Program Feature") <> 0 Then response.write " SELECTED"%>>Program Feature</OPTION>
	<OPTION<%If InStr(request("lstStatus"), "Closed") <> 0 Then response.write " SELECTED"%>>Closed</OPTION>
</SELECT>


<% REM//		Bug Status Not Checkbox %>

<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000"><BR>
<INPUT NAME="chkStatus" TYPE="checkbox"<% If request("chkStatus") = "True" Then response.write " Checked"%> VALUE="True">Not
</FONT></B>
</TD>


<% REM//		Bug Priority %>

<TD ALIGN=CENTER BACKGROUND="images/card_mid2.gif" VALIGN=TOP>

<SELECT NAME="lstPriority" SIZE=3 MULTIPLE>
	<OPTION<% If request("lstPriority") = "" or request("lstPriority") = "No Criteria" <> 0 Then response.write " SELECTED" %>>No Criteria</OPTION>
	<OPTION<%If InStr(request("lstPriority"), "1") <> 0 Then response.write " SELECTED"%>>1</OPTION>
	<OPTION<%If InStr(request("lstPriority"), "2") <> 0 Then response.write " SELECTED"%>>2</OPTION>
	<OPTION<%If InStr(request("lstPriority"), "3") <> 0 Then response.write " SELECTED"%>>3</OPTION>
</SELECT>


<% REM//		Bug Priority Not Checkbox %>

<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000"><BR>
<INPUT NAME="chkPriority" TYPE="checkbox"<% If request("chkPriority") = "True" Then response.write " Checked"%> VALUE="True">Not
</FONT></B>
</TD>


<% REM//		Bug Severity %>

<TD ALIGN=CENTER BACKGROUND="images/card_mid2.gif" VALIGN=TOP>

<SELECT NAME="lstSeverity" SIZE=3 MULTIPLE>
	<OPTION<% If request("lstSeverity") = "" or request("lstSeverity") = "No Criteria" Then response.write " SELECTED" %>>No Criteria</OPTION>
	<OPTION<%If InStr(request("lstSeverity"), "Hi") <> 0 Then response.write " SELECTED"%>>Hi</OPTION>
	<OPTION<%If InStr(request("lstSeverity"), "Med") <> 0 Then response.write " SELECTED"%>>Med</OPTION>
	<OPTION<%If InStr(request("lstSeverity"), "Low") <> 0 Then response.write " SELECTED"%>>Low</OPTION>
</SELECT>


<% REM//		Bug Severity Not Checkbox %>

<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000"><BR>
<INPUT NAME="chkSeverity" TYPE="checkbox"<% If request("chkSeverity") = "True" Then response.write " Checked"%> VALUE="True">Not
</FONT></B>
</TD>

<TD BACKGROUND="images/card_border_right.gif" WIDTH=5>

&nbsp;

</TD>

</TR>


<% REM//		Keywords Title %>

<TR>

<TD ALIGN=CENTER COLSPAN=5 BACKGROUND="images/card_mid1_left.gif">
<CENTER><B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Keywords
</FONT></B>
</CENTER>
</TD>

<TD BACKGROUND="images/card_border_right.gif" WIDTH=5>

&nbsp;

</TD>

</TR>


<TR>


<% REM//		Title Keywords %>

<TD ALIGN=CENTER COLSPAN=3 BACKGROUND="images/card_mid2_left.gif">
<CENTER><B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">Title:  </FONT></B>

<INPUT TYPE="Text" NAME="txtTitle" VALUE="<% = request("txtTitle") %>" MAXLENGTH=50 SIZE=15>

<INPUT NAME="chkTitle" TYPE="checkbox"<% If request("chkTitle") = "True" Then response.write " Checked"%> VALUE="True">

<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">Not</FONT></B>
</CENTER>
</TD>


<% REM//		Description Keywords %>

<TD ALIGN=CENTER COLSPAN=2 BACKGROUND="images/card_mid2.gif">
<CENTER><B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">Description:  </FONT></B>

<INPUT TYPE="Text" NAME="txtDescription" VALUE="<% = request("txtDescription") %>" MAXLENGTH=50 SIZE=15>

<INPUT NAME="chkDescription" TYPE="checkbox"<% If request("chkDescription") = "True" Then response.write " Checked"%> VALUE="True">

<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">Not</FONT></B>
</CENTER>
</TD>

<TD BACKGROUND="images/card_border_right.gif" WIDTH=5>

&nbsp;

</TD>

</TR>


<TR>


<% REM//		# details options %>

<TD ALIGN=CENTER COLSPAN=2 BACKGROUND="images/card_mid1_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">
Show Details:

<INPUT TYPE="Radio" VALUE="None" NAME="rdDetails"<% If request("rdDetails") = "" or request("rdDetails") = "None" Then response.write " CHECKED" %>>None
<INPUT TYPE="Radio" VALUE="One" NAME="rdDetails"<% If request("rdDetails") = "One" Then response.write " CHECKED" %>>One
<INPUT TYPE="Radio" VALUE="All" NAME="rdDetails"<% If request("rdDetails") = "All" Then response.write " CHECKED" %>>All


<% REM//		Show current details only %>

<BR>Search Details: &nbsp;&nbsp;
<INPUT NAME="chkCurrent" VALUE="current" TYPE="radio"<% If request("chkCurrent") = "current" or request("chkCurrent") = "" Then response.write " Checked"%> VALUE="True">Current
<INPUT NAME="chkCurrent" VALUE="original" TYPE="radio"<% If request("chkCurrent") = "original" Then response.write " Checked"%> VALUE="True">Original
<INPUT NAME="chkCurrent" VALUE="all" TYPE="radio"<% If request("chkCurrent") = "all" Then response.write " Checked"%> VALUE="True">All


</FONT></B>
</TD>


<% REM//		Go Button %>

<TD ALIGN=LEFT COLSPAN=2 BACKGROUND="images/card_mid1.gif">

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<% 
REM//		Check Browser Version 
REM//		IE will not support A HREF
REM//		method but netscape will.

If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE") = 0 Then
%>

<A HREF="#" onClick="submit_form('Go')">
<IMG SRC="images/buttons/go.gif" BORDER=0 ALT="Click here to begin search!">
</A>

<A HREF="#" onClick="submit_form('Reset')">
<IMG SRC="images/buttons/reset.gif" BORDER=0 ALT="Click here to reset form.">
</A>

<% Else %>

<IMG SRC="images/buttons/go.gif" BORDER=0 onClick="submit_form('Go')" ALT="Click here to begin search!">
<IMG SRC="images/buttons/reset.gif" BORDER=0 onClick="submit_form('Reset')" ALT="Click here to reset form.">

<% End If %>

</TD>


<% REM//		Number of results to return %>

<TD ALIGN=RIGHT BACKGROUND="images/card_mid1.gif">
<B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">
Max Per Page Results
</FONT></B>

<SELECT NAME="lstResults" SIZE=0>
	<OPTION<% If request("lstResults") = 1 Then response.write " SELECTED"%>>1</OPTION>
	<OPTION<% If request("lstResults") = 5 Then response.write " SELECTED"%>>5</OPTION>
	<OPTION<% If request("lstResults") = "" or request("lstResults") = 10 Then response.write " SELECTED"%>>10</OPTION>
	<OPTION<% If request("lstResults") = 15 Then response.write " SELECTED" %>>15</OPTION>
	<OPTION<% If request("lstResults") = 20 Then response.write " SELECTED"%>>20</OPTION>
	<OPTION<% If request("lstResults") = 25 Then response.write " SELECTED"%>>25</OPTION>
	<OPTION<% If request("lstResults") = 30 Then response.write " SELECTED"%>>30</OPTION>
	<OPTION<% If request("lstResults") = 35 Then response.write " SELECTED"%>>35</OPTION>
	<OPTION<% If request("lstResults") = 40 Then response.write " SELECTED"%>>40</OPTION>
	<OPTION<% If request("lstResults") = 45 Then response.write " SELECTED"%>>45</OPTION>
	<OPTION<% If request("lstResults") = 50 Then response.write " SELECTED"%>>50</OPTION>
</SELECT>

</TD>

<TD BACKGROUND="images/card_border_right.gif" WIDTH=5>

&nbsp;

</TD>

</TR>


<TR>


<% REM//		User Defaults %>

<TD ALIGN=CENTER COLSPAN=5 BACKGROUND="images/card_mid2_left.gif">
<CENTER><B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
User Defined Searches
</FONT></B>
</CENTER>
</TD>

<TD BACKGROUND="images/card_border_right.gif" WIDTH=5>

&nbsp;

</TD>

</TR>


<TR>


<% REM//		Selection of Default searches %>

<TD ALIGN=CENTER COLSPAN=3 BACKGROUND="images/card_mid1_left.gif">
<CENTER>

<%
iSelect_Type = 13
iSelect_Size = 1
%>
<!-- #include file="create_select.inc" -->


<% 
REM//		Check Browser Version 
REM//		IE will not support A HREF
REM//		method but netscape will.

If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE") = 0 Then
%>

<A HREF="#" onClick="submit_form('Remove')">
<IMG SRC="images/buttons/remove.gif" BORDER=0 ALT="Click here to remove user search...">
</A>

<A HREF="#" onClick="submit_form('Update')">
<IMG SRC="images/buttons/update.gif" BORDER=0 ALT="Click here to update user search...">
</A>

<A HREF="#" onClick="submit_form('ReLoad')">
<IMG SRC="images/buttons/reload.gif" BORDER=0 ALT="Click here to reload user search...">
</A>

<% Else %>

<IMG SRC="images/buttons/remove.gif" BORDER=0 onClick="submit_form('Remove')" ALT="Click here to remove user search...">
<IMG SRC="images/buttons/update.gif" BORDER=0 onClick="submit_form('Update')" ALT="Click here to update user search...">
<IMG SRC="images/buttons/reload.gif" BORDER=0 onClick="submit_form('ReLoad')" ALT="Click here to reload user search...">

<% End If %>


</CENTER>
</TD>


<% REM//		Add User Defined Search Text Box %>

<TD ALIGN=CENTER COLSPAN=2 BACKGROUND="images/card_mid1.gif">
<CENTER><B><FONT FACE="Georgia, Arial" SIZE=1 COLOR="#000000">Name:</FONT></B>  

<INPUT TYPE="Text" NAME="txtUser_Favorite" VALUE="

<% 
If session("sUser_Search") <> "" Then
	session("sUser_Search") = ""
Else
	response.write request("txtUser_Favorite")
End If
%>
" MAXLENGTH=20 SIZE=15>

<% 
REM//		Check Browser Version 
REM//		IE will not support A HREF
REM//		method but netscape will.

If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE") = 0 Then
%>

<A HREF="#" onClick="submit_form('Add')">
<IMG SRC="images/buttons/add.gif" BORDER=0 ALT="Click here to add this search to your user defined searches.">
</A>

<% Else %>

<IMG SRC="images/buttons/add.gif" BORDER=0 onClick="submit_form('Add')" ALT="Click here to add this search to your user defined searches.">

<% End If %>

</CENTER>
</TD>

<TD BACKGROUND="images/card_border_right.gif" WIDTH=5>

&nbsp;

</TD>

</TR>


<TR>

<TD COLSPAN=5 BACKGROUND="images/card_border_bottem.gif">&nbsp;</TD>


<TD BACKGROUND="images/corner.gif" WIDTH=5>&nbsp;</TD>

</TR>


</TABLE>


<% REM//		Submit Type %>

<INPUT TYPE="Hidden" NAME="txtType">
<INPUT TYPE="Hidden" NAME="iStart" VALUE="0">


</FORM>