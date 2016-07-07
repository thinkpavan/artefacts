<BR>

<CENTER>
<FONT FACE="Verdana, Arial" SIZE=2 COLOR=BLACK><B>
Daily Bug Status Graphs
<B></FONT>
</CENTER>

<BR>
<TABLE WIDTH=100% CELLSPACING=1 CELLPADDING=1 BORDER=0>

<B><FONT FACE="Verdana, Arial" SIZE=0 COLOR="#000000">


<%
	iCols = 15
	
	if iDateRangeValue > 15 then
		iWidth = 20
	else
		iWidth = INT(300/iDateRangeValue)
	end if
	
	if iWidth > 200 then iWidth = 200

	iMaxClosed = 0
	iMaxOpened = 0
	for x = 1 to iDateRangeValue
		if iBugsOpened_a (x) > iMaxOpened then iMaxOpened = iBugsOpened_a (x)	
		if iBugsClosed_a (x) > iMaxClosed then iMaxClosed = iBugsClosed_a (x)
		
	next

	if (iMaxClosed > iMaxOpened) then
		iMax = iMaxClosed
	else
		iMax = iMaxOpened
	end if


	'Create table columns with graphs
	dtCurrent = DATEVALUE(request.form("txtStart"))
	dtCurrent1 = DATEVALUE(request.form("txtStart"))
	y = 0

	DO WHILE (dtCurrent <= DATEVALUE(request.form("txtEnd")))

	%>
	<TR VALIGN=BOTTOM WIDTH=100%>
	<%
	
	FOR X = 1 TO iCols

		CurrentDate = CDATE(request.form("txtStart")) + y		

		'Find Bugs Closed and opened
		iClosed = iBugsClosed_a (y + 1)
		iOpened = iBugsOpened_a (y + 1)
		%>
		
		<!-- #include file="report_graph.inc" -->		

		<%
		dtCurrent = dtCurrent + 1
		y = y + 1
		
		if dtCurrent > DATEVALUE(request.form("txtEnd")) then x = 16

	NEXT
		

	response.write ("</TR>")


	'Create table columns with dates
	%>	
	<TR ALIGN=CENTER VALIGN=TOP WIDTH=100%>
	<%

	FOR X = 1 TO iCols
		sText = sDate_a(x)
		%>
		
		<!-- #include file="report_dates.inc" -->

		<%
		dtCurrent1 = dtCurrent1 + 1
		if dtCurrent1 > DATEVALUE(request.form("txtEnd")) then x = 16
		
	NEXT
	response.write ("</TR>")


	LOOP
	
%>

</TABLE>

<BR><BR><BR>