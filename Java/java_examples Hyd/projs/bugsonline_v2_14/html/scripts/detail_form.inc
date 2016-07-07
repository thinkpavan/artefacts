
<% REM//		Bug Detail Information%>

<% If iSize = "" Then iSize = 65 %>

<TABLE WIDTH=<% = iSize %>% BORDER=0 CELLSPACING=0 ALIGN=CENTER>


<% If iSize > 65 Then %>

<TR>

<TD VALIGN=CENTER COLSPAN=3>

<FONT FACE="Georgia, Arial" SIZE=3 COLOR="#000000"><B>

<IMG SRC="images/projects/bugs.gif" HEIGHT=70 WIDTH=70 ALIGN=BOTTEM>

<% If sError_Message = "" Then %>

Bug # <% = sZeros & sBug_ID %> - Add Detail

<% Else %>

<% = sError_Message %>

<% End If %>


</FONT></B>

</TD>

</TR>


<% End If %>

<TR>

<TD WIDTH="100%" ALIGN=LEFT COLSPAN=2 BACKGROUND="images/card_border_top_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#0000C0">
&nbsp;&nbsp;Bug Detail Information
</FONT></B>
</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<%
REM//		Insert Name info
REM//		if Add Bug Detail

If sBug_ID <> "" Then


REM//		Posted By Information
%>


<TR>

<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_top_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Posted By:
</FONT></B>
</TD>

<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_top.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#0000C0">
<%

if (session("sFirst_Name") = "") then
	session("sFirst_Name") = request.querystring("sFirst_Name")
	session("sLast_Name") = request.querystring("sLast_Name")
	session("sProject") = request.querystring("sProject")
end if	

%>
<%=session("sFirst_Name") & " " & session("sLast_Name")%>
</FONT></B>
</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<% REM//		Date and time information%>
<TR>

<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_mid2_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Date/ Time:
</FONT></B>
</TD>

<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_mid2.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#0000C0">
<%=date & "/ " & time %>
</FONT></B>
</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<%
End If


REM//		Assigned To Info
%>

<TR>

<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_mid1_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Assigned To:
</FONT></B>
</TD>

<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_mid1.gif">

<%
'		Open database to fill array of developers

iSelect_Type = 9
iSelect_Size = 1
%>
<!-- #include file="create_select.inc" -->

</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<% REM//		Bug Status Information %>


<TR>

<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_mid2_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Bug Status:
</FONT></B>
</TD>

<%
'Open bug to load default values (previous values)
sql = "SELECT b.sStatus, b.sSeverity, b.iPriority FROM tblBugs b WHERE (b.dtDateEnd = #1/1/1899#) "
sql = sql + "AND b.sBug_ID = '" + sBug_ID + "'"
Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "bugs", , ""
Set rs1 = Server.CreateObject("ADODB.Recordset")
rs1.Open sql, conn, 3, 3
%>

<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_mid2.gif">
<SELECT NAME="lstStatus" SIZE=1>
	<OPTION>Please Make A Selection</OPTION>
	<OPTION<%If request.form("lstStatus") = "Open" Then response.write " SELECTED"%>>Open</OPTION>
	<OPTION<%If request.form("lstStatus") = "Assigned" Then response.write " SELECTED"%>>Assigned</OPTION>
	<OPTION<%If request.form("lstStatus") = "Completed" Then response.write " SELECTED"%>>Completed</OPTION>
	<OPTION<%If request.form("lstStatus") = "Postponed" Then response.write " SELECTED"%>>Postponed</OPTION>
	<OPTION<%If request.form("lstStatus") = "Program Feature" Then response.write " SELECTED"%>>Program Feature</OPTION>
	<% 
	'Determine if current user was user who originally submitted by, if so then they are given option to also close
	sql = "SELECT u.sFirst_Name, u.sLast_Name FROM tblBugs b, tblUsers u WHERE (b.bOriginal = True) AND (b.iPosted_By = u.iID) "
	sql = sql + "AND b.sBug_ID = '" + sBug_ID + "'"
	Set rs = Server.CreateObject("ADODB.Recordset")
	rs.Open sql, conn, 3, 3
	
	if ((rs("sFirst_Name") + " " + rs("sLast_Name") = session("sFirst_Name") + " " + session("sLast_Name")) OR (session("sProject") = "Management")) then	
	%>
	<OPTION<%If request.form("lstStatus") = "Closed" Then response.write " SELECTED"%>>Closed</OPTION>
	
	<%
	end if
	rs.Close
	set rs.activeconnection=nothing	
	%>
	
</SELECT>
</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<% REM//		Bug Priority Information %>


<TR>

<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_mid1_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Priority:
</FONT></B>
</TD>

<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_mid1.gif">
<SELECT NAME="lstPriority" SIZE=1>
	<OPTION>Please Make A Selection</OPTION>
	<OPTION<%If request.form("lstPriority") = "1" or rs1("iPriority") = 1  Then response.write " SELECTED"%>>1</OPTION>
	<OPTION<%If request.form("lstPriority") = "2" or rs1("iPriority") = 2 Then response.write " SELECTED"%>>2</OPTION>
	<OPTION<%If request.form("lstPriority") = "3" or rs1("iPriority") = 3 Then response.write " SELECTED"%>>3</OPTION>
</SELECT>
<B><FONT FACE="Georgia, Arial" SIZE=2>
<A HREF="#" onClick="open_help('help.asp?sType=Priority','400','400')">[Help]</A>
</FONT></B>
</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<% REM//		Bug Severity Information %>


<TR>

<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_mid2_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Severity:
</FONT></B>
</TD>


<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_mid2.gif">
<SELECT NAME="lstSeverity" SIZE=1>
	<OPTION>Please Make A Selection</OPTION>
	<OPTION<%If request.form("lstSeverity") = "Hi" or rs1("sSeverity") = "Hi" Then response.write " SELECTED"%>>Hi</OPTION>
	<OPTION<%If request.form("lstSeverity") = "Med" or rs1("sSeverity") = "Med" Then response.write " SELECTED"%>>Med</OPTION>
	<OPTION<%If request.form("lstSeverity") = "Low" or rs1("sSeverity") = "Low" Then response.write " SELECTED"%>>Low</OPTION>
</SELECT>
<B><FONT FACE="Georgia, Arial" SIZE=2>
<A HREF="#" onClick="open_help('help.asp?sType=Severity','400','400')">[Help]</A>
</FONT></B>
</TD>

<%
rs1.Close
set rs1.activeconnection=nothing
conn.close
%>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<% REM//		Bug Comments%>


<TR>

<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_mid1_left.gif">
<B><FONT FACE="Georgia, Arial" SIZE=2 COLOR="#000000">
Description:
</FONT></B>
<FONT FACE="Georgia, Arial" SIZE=0 COLOR="#000000">
<BR>(must be atleast 15 characters)
</FONT>
</TD>

<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_mid1.gif">
<TEXTAREA NAME="txtComments" COLS=20 ROWS=4 WRAP>
<%=request.form("txtComments")%>
</TEXTAREA>
</TD>


<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<TR>

<TD ALIGN=CENTER COLSPAN=2 BACKGROUND="images/card_mid2_left.gif">

<% 
REM//		Check Browser Version 
REM//		IE will not support A HREF
REM//		method but netscape will.

If InStr(request.servervariables("HTTP_USER_AGENT"), "MSIE") = 0 Then
%>

<A HREF="#" onClick="submit_form()">
<IMG SRC="images/buttons/add.gif" BORDER=0 ALT="Click here to add or update this bug...">
</A>

<% Else %>

<IMG SRC="images/buttons/add.gif" onClick="submit_form()" ALT="Click here to add or update this bug...">

<% End If %>

</TD>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<TR>

<TD COLSPAN=2 BACKGROUND="images/card_border_bottem.gif">&nbsp;</TD>

<TD BACKGROUND="images/corner.gif">&nbsp;</TD>

</TR>


</TABLE>