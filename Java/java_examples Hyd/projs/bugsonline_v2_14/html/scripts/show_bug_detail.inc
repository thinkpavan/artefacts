<% REM//		Open DB Connections %>

<!-- #include file="open_bug_db.inc" -->


<%
REM//		If DB is able to locate bug id then
REM//		Bug information is displayed

If iStop <> 5 Then
%>



<%
REM//		Create All Bug Details

rs1.movefirst
Do While rs1.eof <> True


If iDetail_Type <> 5 Then


REM//		Open database connection for
REM//		assigned to name

sql3 = sql2 & "WHERE tblUsers.iID=" & rs1("iAssigned_To")
Set Conn2 = Server.CreateObject("ADODB.Connection")
Conn2.Open "bugs", , ""
Set rs2 = Server.CreateObject("ADODB.Recordset")
rs2.Open sql3, conn2, 3, 3
%>


<% REM//		Bug Detail Table%>


<TABLE WIDTH=50% BORDER=0 CELLSPACING=0 ALIGN=CENTER>


<TR>

<TD WIDTH=49% ALIGN=LEFT BACKGROUND="images/card_border_top_left.gif">
<B><FONT FACE="Arial" SIZE=2 COLOR="#0000C0">
&nbsp;&nbsp;Detail <%=iLoc%> of <%=iDetails%>
<% If iLoc = 1 Then response.write " (current)"%>
</FONT></B>
</TD>

<TD WIDTH=49% ALIGN=RIGHT BACKGROUND="images/card_border_top.gif">


<% If (iLoc = 1 And iDetail_Type <> 3 AND rs1("sStatus") <> "Closed") Then %>

<A HREF="Javascript:open_help('view_bugs.asp?iBT=10&iBug_ID=<%=rs("sBug_ID") %>&sFirst_Name=<% = session("sFirst_Name")%>&sLast_Name=<% = session("sLast_Name")%>&sProject=<% = session("sProject")%>', 410, 625)">
<IMG SRC="images/buttons/add.gif" BORDER=0 ALT="Click here to enter a new detail...">
</A>

<% End If %>


&nbsp;&nbsp;
</TD>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>
 
</TR>


<TR>

<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_top_left.gif">
<B><EM><FONT FACE="Arial" SIZE=2 COLOR="#000000">
Posted By:&nbsp;&nbsp;
</FONT></EM></B>
</TD>

<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_top.gif">
<B><FONT FACE="Arial" SIZE=2 COLOR="#0000C0">
<%=rs1("sFirst_Name") & " " & rs1("sLast_Name")%>
</FONT></B>
</TD>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<TR>

<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_mid2_left.gif">
<B><EM><FONT FACE="Arial" SIZE=2 COLOR="#000000">
Date/ Time:&nbsp;&nbsp;
</FONT></EM></B>
</TD>

<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_mid2.gif">
<B><FONT FACE="Arial" SIZE=2 COLOR="#0000C0">
<%=rs1("dtDate")%>
</FONT></B>
</TD>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<TR>

<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_mid1_left.gif">
<B><EM><FONT FACE="Arial" SIZE=2 COLOR="#000000">
Assigned To:&nbsp;&nbsp;
</FONT></EM></B>
</TD>

<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_mid1.gif">
<B><FONT FACE="Arial" SIZE=2 COLOR="#0000C0">


<%
If rs2.eof = True Then
	response.write "Not Assigned"
Else
	response.write rs2("sFirst_Name") & " " & rs2("sLast_Name")
End If
%>


</FONT></B>
</TD>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<TR>


<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_mid2_left.gif">
<B><EM><FONT FACE="Arial" SIZE=2 COLOR="#000000">
Bug Status:&nbsp;&nbsp;
</FONT></EM></B>
</TD>

<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_mid2.gif">
<B><FONT FACE="Arial" SIZE=2 COLOR="#0000C0">
<% = rs1("sStatus")%>
</FONT></B>
</TD>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<TR>

<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_mid1_left.gif">
<B><EM><FONT FACE="Arial" SIZE=2 COLOR="#000000">
Priority:&nbsp;&nbsp;
</FONT></EM></B>
</TD>

<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_mid1.gif">
<B><FONT FACE="Arial" SIZE=2 COLOR="#0000C0">
<%=rs1("iPriority")%>
</FONT></B>
</TD>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<TR>

<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_mid2_left.gif">
<B><EM><FONT FACE="Arial" SIZE=2 COLOR="#000000">
Severity:&nbsp;&nbsp;
</FONT></EM></B>
</TD>

<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_mid2.gif">
<B><FONT FACE="Arial" SIZE=2 COLOR="#0000C0">
<%=rs1("sSeverity")%>
</FONT></B>
</TD>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<TR>

<TD WIDTH="49%" ALIGN=RIGHT BACKGROUND="images/card_mid1_left.gif">
<B><EM><FONT FACE="Arial" SIZE=2 COLOR="#000000">
Description:&nbsp;&nbsp;
</FONT></EM></B>
</TD>

<TD WIDTH="49%" ALIGN=LEFT BACKGROUND="images/card_mid1.gif">
<B><FONT FACE="Arial" SIZE=2 COLOR="#0000C0">
<%=rs1("sComments")%>
</FONT></B>
</TD>

<TD BACKGROUND="images/card_border_right.gif">&nbsp;</TD>

</TR>


<TR>

<TD COLSPAN=2 BACKGROUND="images/card_border_bottem.gif">&nbsp;</TD>

<TD BACKGROUND="images/corner.gif">&nbsp;</TD>

</TR>


</TABLE>


<%
If iDetail_Type = 2 or iDetail_Type = 3 then iDetail_Type = 5


REM//		Close database connection

rs2.Close
set rs2.activeconnection=nothing
Conn2.close

End If

iLoc = iLoc + 1
rs1.movenext
Loop




End If


REM//		Close Database Connections %>

<!-- #include file="close_bug_db.inc" -->