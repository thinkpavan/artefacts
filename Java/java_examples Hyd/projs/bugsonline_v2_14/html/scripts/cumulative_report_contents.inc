<BR>

<CENTER>
<FONT FACE="Verdana, Arial" SIZE=2 COLOR=BLACK><B>
Cumulative Bug Status Graph
<B></FONT>
</CENTER>

<BR>
<TABLE WIDTH=100% CELLSPACING=0 CELLPADDING=0 BORDER=0>

<B><FONT FACE="Verdana, Arial" SIZE=0 COLOR="#000000">


<%
iWidth = 150

iMaxClosed = 0
iMaxOpened = 0
iOpened = 0
iClosed = 0

for x = 1 to iDateRangeValue
	iOpened = iOpened + iBugsOpened_a (x)
	iClosed = iClosed + iBugsClosed_a (x)
		
next

if (iOpened > iClosed) then
	iMax = iOpened
else
	iMax = iClosed
end if


%>
<TR VALIGN=BOTTOM WIDTH=100%>
		
<!-- #include file="report_graph.inc" -->		

<%
		

response.write ("</TR>")


%>	
<TR ALIGN=CENTER VALIGN=TOP WIDTH=100%>

<TD ALIGN=CENTER COLSPAN=2>
<FONT COLOR=BLACK FACE='Verdana, Arial' SIZE=1>
<%
if (iOpened > iClosed) then
	sColor = "Red"
else
	sColor = "Blue"
end if

response.write "Total Bugs Opened: " & "<FONT COLOR=" & sColor & ">" & iOpened & "&nbsp;" & "<FONT COLOR=BLACK><BR>"
response.write "Total Bugs Completed: " & "<FONT COLOR=" & sColor & ">" & iClosed & "&nbsp;" & "<FONT COLOR=BLACK><BR><BR>"

if (iStartValue < iEndValue) then
	response.write ("<FONT COLOR=RED FACE='Verdana, Arial' SIZE=1>")
else
	response.write ("<FONT COLOR=BLACK FACE='Verdana, Arial' SIZE=1>")
end if

response.write ("Starting Bug Count: " & iStartValue & "<BR>")
response.write ("Ending Bug Count: " & iEndValue & "<BR><BR>")
response.write ("<FONT COLOR=BLACK FACE='Verdana, Arial' SIZE=1>")

'Open query to determine average times for closing bugs
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sSumSQL, conn, 3, 3

iTotalDays = 0
iTotalHours = 0
iMaxDays = 0
iMaxHours = 0
iMinDays = 1000
iMinHours = 1000
i24Hours = 0
i48Hours = 0
sMinBug = "none"
sMaxBug = "none"

do while not rs.eof

	'Add time to totals
	iTotalDays = iTotalDays + rs("Days")
	iTotalHours = iTotalHours + rs("Hours")
		
	'Determine if qualifies as max
	if ((rs("Days") > iMaxDays) OR (rs("Days") = iMaxDays AND rs("Hours") > iMaxHours)) then
		iMaxDays = rs("Days")
		iMaxHours = rs("Hours")
		sMaxBug = rs("sBug_ID")
	end if
	
	'Determine if qualifies as min
	if ((rs("Days") < iMinDays) OR (rs("Days") = iMinDays AND rs("Hours") < iMinHours)) then
		iMinDays = rs("Days")
		iMinHours = rs("Hours")
		sMinBug = rs("sBug_ID")
	end if
	
	'Determine if qualifies as completed within 24 hours
	if ((rs("Days") < 1) OR (rs("Days") = 1 AND rs("Hours") = 0)) then i24Hours = i24Hours + 1
	
	'Determine if qualifies as completed within 48 hours
	if ((rs("Days") < 2) OR (rs("Days") = 2 AND rs("Hours") = 0)) then i48Hours = i48Hours + 1
	
	rs.movenext
loop

if iMaxDays = 1000 then iMaxDays = 0
if iMaxHours = 1000 then iMaxHours = 0

rs.close
set rs.activeconnection=nothing

iTotalDays = iTotalDays + INT(iTotalHours/24)
iTotalHours = iTotalHours - (INT(iTotalHours/24) * 24)
%>

<B><U>
Bug Completion Statistics (<%=iClosed%> Bugs Completed)
</B></U>

</TD>

</TR>


<TR ALIGN=CENTER VALIGN=TOP WIDTH=100%>

<TD ALIGN=RIGHT WIDTH=50%>
<FONT COLOR=BLACK FACE='Verdana, Arial' SIZE=1>
Average Time:&nbsp;&nbsp;<BR>
Maximum Time:&nbsp;&nbsp;<BR>
Minimum Time:&nbsp;&nbsp;<BR>
Completed within 24 hours:&nbsp;&nbsp;<BR>
Completed within 48 hours:&nbsp;&nbsp;<BR>
</FONT>
</TD>


<TD ALIGN=LEFT WIDTH=50%>
<FONT COLOR=BLACK FACE='Verdana, Arial' SIZE=1><B>
<%
'Only fill in values if bugs were completed
if (iClosed <> 0) then
	
	response.write (INT(iTotalDays/iClosed) & " days, " & INT(iTotalHours/iClosed) & " hours<BR>")

	'Bug which took the maximum # of days to complete
	if sMaxBug <> "none" then
		response.write ("<A HREF='view_bugs.asp?iBT=8&iBug_ID=" & sMaxBug & "'>" & iMaxDays & " days, " & iMaxHours & " hours</A><BR>")
	else
		response.write (iMaxDays & " days, " & iMaxHours & " hours<BR>")
	end if

	'Bug which took the mimimum # of days to complete
	if sMinBug <> "none" then
		response.write ("<A HREF='view_bugs.asp?iBT=8&iBug_ID=" & sMinBug & "'>" & iMinDays & " days, " & iMinHours & " hours</A><BR>")
	else
		response.write (iMinDays & " days, " & iMinHours & " hours<BR>")
	end if


	response.write (i24Hours & " (" & INT((i24Hours/iClosed) * 100) & "%)<BR>")
	response.write (i48Hours & " (" & INT((i48Hours/iClosed) * 100) & "%)<BR>")


else
	response.write ("NA<BR>NA<BR>NA<BR>NA<BR>NA<BR>")

end if
%>

</B>
</FONT>
</TD>

</TR>


</TABLE>

<BR>