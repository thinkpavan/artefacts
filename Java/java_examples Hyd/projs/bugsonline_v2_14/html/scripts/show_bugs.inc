<%
REM//			Open Database Connection

Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "bugs", , ""
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3

If rs.eof <> True Then
	iLine = 0



REM//			Title Row %>

<TABLE WIDTH=100% CELLSPACING=0 CELLPADDING=1 BORDER=0>

<TR><TD ALIGN=CENTER>

<TABLE CELLSPACING=0 CELLPADDING=1 BORDER=0 ALIGN=CENTER BGCOLOR="#000000">

<TR><TD>

<TABLE WIDTH=100% CELLSPACING=0 CELLPADDING=1 BORDER=0 ALIGN=CENTER BGCOLOR="#3939FF">

<TR>

<TD>

<TABLE WIDTH=100% CELLSPACING=0 CELLPADDING=0 BORDER=0 ALIGN=CENTER BGCOLOR="#C6FFFF">

<TR>
<TD ALIGN=LEFT WIDTH=65>

<IMG SRC="images/text/bug.gif" BORDER=0 ALT="" WIDTH=53 HEIGHT=30 HSPACE=5>

</TD>


<TD ALIGN=LEFT WIDTH=185>

<IMG SRC="images/text/title.gif" BORDER=0 ALT="" WIDTH=40 HEIGHT=29>

</TD>


<TD ALIGN=LEFT WIDTH=130>

<IMG SRC="images/text/last_update.gif" BORDER=0 ALT="" WIDTH=100 HEIGHT=30>

</TD>


<%
If session("sProject") <> "Management" Then
%>


<TD ALIGN=LEFT WIDTH=140>

<IMG SRC="images/text/program.gif" BORDER=0 ALT="" WIDTH=75 HEIGHT=30>

</TD>


<%
Else
%>


<TD ALIGN=LEFT WIDTH=140>

<IMG SRC="images/text/project_program.gif" BORDER=0 ALT="" WIDTH=139 HEIGHT=30>

</TD>


<%
End If
%>


<TD ALIGN=LEFT WIDTH=125>

<IMG SRC="images/text/area.gif" BORDER=0 ALT="" WIDTH=44 HEIGHT=30>

</TD>


<%
'As per request status is always shown

If request("iBT") <> 4 AND request("iBT") <> 5 AND request("iBT") <> 6 Then
%>


<TD ALIGN=LEFT WIDTH=100>

<IMG SRC="images/text/status.gif" BORDER=0 ALT="" WIDTH=55 HEIGHT=30>

</TD>


<% 
Else
%>


<TD ALIGN=LEFT WIDTH=115>

<IMG SRC="images/text/priority_severity.gif" BORDER=0 ALT="" WIDTH=115 HEIGHT=30>

</TD>


<%
End If 
%>

</TR></TABLE>

</TD>
</TR>


<%
If rs.eof <> True Then


REM//			Display all records corresponding to type

Do While rs.eof <> True


REM//			Choose background

If iLine = 0 Then 
	sBackground="#FFFFFF"
ElseIf iLine mod 2 <> 0 Then
	sBackground="#C6FFFFFF"
Else
	sBackground="#FFFFFF"
End If


REM//			Check to verify that bug has not already been
REM//			displayed

If (InStr(sUsed_Bugs, " " & rs("sBug_ID") & " ") = 0) Then
	
sUsed_Bugs = sUsed_Bugs & " " & rs("sBug_ID") & " "



REM//			Establish # of zeros to be placed in
REM//			front of Bug ID so ID = 5 digits

sBug_ID = rs("sBug_ID")

Select Case Len(sBug_ID)
	Case 1
		sZeros = "0000"
	Case 2
		sZeros = "000"
	Case 3
		sZeros = "00"
	Case 4
		sZeros = "0"
	Case Else
		sZeros = ""
End Select
%>


<TR><TD>

<TABLE WIDTH=100% CELLSPACING=0 CELLPADDING=0 BORDER=0 ALIGN=CENTER BGCOLOR="<%=sBackground%>">

<TR>

<%
REM//			Bug ID
%>

<TD ALIGN=LEFT WIDTH=65>
<FONT FACE="Georgia, Arial" SIZE=2>
&nbsp;&nbsp;<A HREF="view_bugs.asp?iBT=8&iBug_ID=<%=rs("sBug_ID")%>"><%=sZeros & rs("sBug_ID")%></A>
</FONT>
</TD>


<%
REM//			Description/ Title
%>

<TD ALIGN=LEFT WIDTH=185>
<FONT FACE="Georgia, Arial" SIZE=2>
<%=rs("sDescription")%>
</FONT>
</TD>


<%
REM//			Date and Time of last update
%>

<TD ALIGN=LEFT WIDTH=130>
<FONT FACE="Georgia, Arial" SIZE=2>
<%=rs("dtDate")%>
</FONT>
</TD>


<%
REM//			Program
%>

<TD ALIGN=LEFT WIDTH=140>
<FONT FACE="Georgia, Arial" SIZE=2>


<%
If session("sProject") <> "Management" Then
	response.write rs("sProgram")
Else
	response.write "<B>" & rs("sProject") & "</B> : " & rs("sProgram")
End If
%>


</FONT>
</TD>


<%
REM//			Area
%>

<TD ALIGN=LEFT WIDTH=125>
<FONT FACE="Georgia, Arial" SIZE=2>
<%=rs("sArea")%>
</FONT>
</TD>


<%
REM//			Status or Priority/ Severity

If request("iBT") <> 4 AND request("iBT") <> 5 AND request("iBT") <> 6 Then
%>


<TD ALIGN=LEFT WIDTH=100>
<FONT FACE="Georgia, Arial" SIZE=2>
<%=rs("sStatus")%>
</FONT>
</TD>


<% 
Else
%>

<TD ALIGN=LEFT WIDTH=115>
<FONT FACE="Georgia, Arial" SIZE=2>
<%=rs("iPriority") & "/ " & rs("sSeverity")%>
</FONT>
</TD>

<%
End If 
%>


</TR>

</TABLE>

</TD></TR>


<%


End If

rs.movenext

iLine = iLine + 1

loop

rs.movefirst

End If
%>

</TD></TR>

</TABLE>

</TD></TR>

</TABLE>

</TD></TR>

</TABLE>

<P>

<%
REM//			No records found in catagory
Else
%>


<TABLE WIDTH="100%">

<TR>

<TD ALIGN=CENTER>

<BR><BR><BR>

<IMG SRC="images/text/no_records.gif" BORDER=0 ALT="">

</TD>

</TR>


<%
End If


REM//			Close database connection

rs.Close
set rs.activeconnection=nothing
Conn.close
%>

</TABLE>
