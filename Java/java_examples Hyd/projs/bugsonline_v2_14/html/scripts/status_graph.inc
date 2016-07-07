<BR>
<CENTER>
<FONT FACE="Verdana, Arial" SIZE=2 COLOR=BLACK><B>
Overall Bug Status Graph
<B></FONT>
</CENTER>
<BR>
<TABLE WIDTH=100% CELLSPACING=1 CELLPADDING=1 BORDER=0>

<TR VALIGN=BOTTOM WIDTH=100%>

<%
'Set column widths (min 2 max 100)
if (x > 14) then
	iWidth = 13
else
	iWidth = 15/x * 13

end if
if iWidth < 2 then iWidth = 2
if iWidth > 150 then iWidth = 100

iWidth = Int(700 / (iDateRangeValue + 1)) - 1

'Find max value of graph
iMax = 1
for y = 0 to iDateRangeValue + 1
	iTemp = iBugCount_a (y)
	if iTemp > iMax then iMax = iTemp
next

y = 0
dtCurrent = DATEVALUE(request.form("txtStart"))

'Set # of dates to appear
iNextDate = 1

if x > 10 then 
	iNextDate = x/10
	x = 10
	iCols = x
else
	iCols = x
end if

iCurrent = iBugCount_a (0)
iStartValue = iCurrent

%>

<TD ALIGN=RIGHT WIDTH=40%>
<FONT FACE="Verdana, Arial" SIZE=1 COLOR=RED>

<% = iCurrent %> <BR>
<IMG SRC='./images/reports/space.gif' HEIGHT=<%=INT((iCurrent/iMax) * 125) + 7%> WIDTH=5 ALIGN=BOTTOM BORDER=0><BR>

</TD>

<TD ALIGN=RIGHT WIDTH=5%>
<FONT FACE="Verdana, Arial" SIZE=1 COLOR=BLACK>

<%
if iMax > 2 then 
%>

	<% = iMax %><BR>
	<IMG SRC='./images/reports/space.gif' HEIGHT=32 WIDTH=5 ALIGN=BOTTOM BORDER=0><BR>
	<% = INT(iMax*.6666666666667) %><BR>
	<IMG SRC='./images/reports/space.gif' HEIGHT=32 WIDTH=5 ALIGN=BOTTOM BORDER=0><BR>
	<% = INT(iMax*.3333333333334) %><BR>
	<IMG SRC='./images/reports/space.gif' HEIGHT=32 WIDTH=5 ALIGN=BOTTOM BORDER=0><BR>

<% elseif iMax = 2 then %>

	<% = iMax %><BR>
	<IMG SRC='./images/reports/space.gif' HEIGHT=55 WIDTH=5 ALIGN=BOTTOM BORDER=0><BR>
	<% = INT(iMax*.5) %><BR>
	<IMG SRC='./images/reports/space.gif' HEIGHT=55 WIDTH=5 ALIGN=BOTTOM BORDER=0><BR>

<% else %>

	<% = iMax %><BR>
	<IMG SRC='./images/reports/space.gif' HEIGHT=115 WIDTH=5 ALIGN=BOTTOM BORDER=0><BR>

<% end if %>
0
</FONT>
</TD>

<TD ALIGN=LEFT COLSPAN=<%=iCols%>>
<FONT FACE="Verdana, Arial" SIZE=1 COLOR=BLUE>
<%

response.write("<IMG SRC='./images/reports/black.gif' HEIGHT=125 WIDTH=5 ALIGN=BOTTOM BORDER=0>")
iColor = 1
iTemp1 = 5

DO WHILE (dtCurrent <= DATEVALUE(request.form("txtEnd")))

	if (iBugCount_a (y) < iBugCount_a (y + 1)) then
		sColor = "red"
	else
		sColor = "blue"
	end if	
	
	iSize = (iCurrent/iMax * 125)
	
	if (iCurrent = iBugCount_a (y + 1)) then
		iTemp = 0
	else
		iTemp = ((((iBugCount_a (y + 1) / iMax) * 125) - iSize) / iWidth)
	
	end if

	if (iBugCount_a (y + 1) = 1) then
		sTemp = CDATE(dtCurrent) & " - " & iBugCount_a (y + 1) & " bug"
	else
		sTemp = CDATE(dtCurrent) & " - " & iBugCount_a (y + 1) & " bugs"
	end if
	
	
	if iBugCount_a (y + 1) <> 0 then response.write ("<A HREF='view_bugs.asp?iBT=16&iBugsOpen=" & iBugCount_a (y + 1) & "&dtDate=" & CDATE(dtCurrent) & "&sMessage=" & server.urlencode (sMessage1) & sBugList_a (y + 1) & "'>")
	for x = 0 to iWidth 
		iColor = iColor + 1
		if iColor = 4 then iColor = 1
		if iColor = 2 then iColor = 3
		sUseColor = sColor & iColor
		response.write ("<IMG SRC='./images/reports/" & sUseColor & ".gif' HEIGHT=" & Int(iSize) & " WIDTH=1 ALIGN=BOTTOM BORDER=0 ALT='" & sTemp & "'>")
		iSize = iSize + iTemp
		iTemp1 = iTemp1 + 1

	next
	
	'Separate days with black line only if less than 100 are being shown
	iSize = iSize - iTemp
	if (iDateRangeValue < 150) then
		response.write ("<IMG SRC='./images/reports/black.gif' HEIGHT=" & Int(iSize) & " WIDTH=1 ALIGN=BOTTOM BORDER=0 ALT='" & sTemp & "'>")
	else
		iColor = iColor + 1
		if iColor = 4 then iColor = 1
		if iColor = 2 then iColor = 3
		sUseColor = sColor & iColor	
		response.write ("<IMG SRC='./images/reports/" & sUseColor & ".gif' HEIGHT=" & Int(iSize) & " WIDTH=1 ALIGN=BOTTOM BORDER=0 ALT='" & sTemp & "'>")
	end if
	if iBugCount_a (y + 1) <> 0 then response.write ("</A>")	
		
	iTemp1 = iTemp1 + 1		
	dtCurrent = dtCurrent + 1
	y = y + 1
	iCurrent = iBugCount_a (y)
	
LOOP

response.write("<BR><IMG SRC='./images/reports/black.gif' HEIGHT=5 WIDTH=" & iTemp1 & " ALIGN=TOP BORDER=0>")

%>

</FONT>
</TD>

<TD ALIGN=LEFT WIDTH=45%>
<FONT FACE="Verdana, Arial" SIZE=1 COLOR=RED>
<% = iCurrent %> <BR>
<IMG SRC='./images/reports/space.gif' HEIGHT=<%=Int(iSize) + 7%> WIDTH=5 ALIGN=BOTTOM BORDER=0>
</FONT>
</TD>


</TR>


<TR VALIGN=TOP WIDTH=100%>

<TD ALIGN=RIGHT WIDTH=40%>
&nbsp;
</TD>

<TD ALIGN=LEFT WIDTH=5%>
&nbsp;
</TD>

<%
iEndValue = iCurrent

dtCurrent = DATEVALUE(request.form("txtStart"))
dtUseDate = dtCurrent

FOR x = 1 to iCols

%>

<TD ALIGN=LEFT VALIGN=TOP WIDTH=<%=1/iCols%>%>
<FONT FACE="Verdana, Arial" SIZE=1 COLOR=BLACK>
<%= dtUseDate %>
</FONT>
</TD>

<%
dtCurrent = dtCurrent + iNextDate
dtUseDate = CDATE(INT(dtCurrent))


Next
%>

<TD ALIGN=LEFT VALIGN=TOP WIDTH=45%>
<FONT FACE="Verdana, Arial" SIZE=1 COLOR=BLACK>
&nbsp;
</FONT>
</TD>

</TR>

</TABLE>