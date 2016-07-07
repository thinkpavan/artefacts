<SCRIPT LANGUAGE="VBScript" RUNAT="Server">

'This function returns the # of bugs opened
'meeting the sSQL SQL criteria and date
'criteria
function iBugsOpened (sSQL, dtDate, conn)

	'Variable used in opening database query
	Dim rs
	
	'Temp variable
	Dim iTemp
	iTemp = 0
	Dim sql
	sql = "SELECT * FROM tblBugs b"
	
	'Finish SQL statement
	sql = sql & " WHERE (b.bOriginal = true) AND (INT(dtDate) = INT(#" & dtDate & "#)) AND (sStatus <> 'Completed')"
	sql = sql & " AND (sStatus <> 'Closed') AND (sStatus <> 'Program Feature')"
	sql = sql & " AND (b.sBug_ID IN (" & sSQL & "))"
	sql = sql & " ORDER BY b.sBug_ID, b.dtDate DESC"
	
	'Run query
	Set rs = Server.CreateObject("ADODB.Recordset")
	rs.Open sql, conn, 3, 3
	
	iTemp = rs.recordcount	
	
	rs.close
	set rs.activeconnection=nothing
	
	'function return value gets # of records returned from query
	iBugsOpened = iTemp
	
	
end function



'This function returns the # of bugs closed
'meeting the sSQL SQL criteria and date
'criteria
function iBugsClosed (sSQL, dtDate, conn, SumSQL)

	'Variable used in opening database query
	Dim rs
	Set rs = Server.CreateObject("ADODB.Recordset")	
	
	'Temp variable
	Dim iTemp
	iTemp = 0
	Dim sql, sql1
	sql1 = "SELECT b.sBug_ID, Max(b.iID) AS iID1 FROM tblBugs b"
	
	'Finish SQL statement
	sql = sql1 & " WHERE (bOriginal <> true)"
	sql = sql & " AND (b.sBug_ID IN (" & sSQL & "))"	
	sql = sql & " AND (b.iID IN ("
	sql = sql & "SELECT MAX(b.iID) AS iID1 FROM tblBugs b WHERE (b.sBug_ID IN (" & sSQL & ")) AND (INT(dtDate) = INT(#" & dtDate & "#))"
	sql = sql & " AND (b.sStatus <> 'Closed') GROUP BY b.sBug_ID))"	
	sql = sql & " AND ((sStatus = 'Completed') OR (sStatus = 'Program Feature'))"
	sql = sql & " AND (b.sBug_ID NOT IN ("
	
	'Bugs which were re-opened are not counted
	sql = sql & "SELECT b.sBug_ID FROM tblBugs b WHERE (b.sBug_ID IN (" & sSQL & "))"
	sql = sql & " AND (bOriginal <> true) AND (INT(dtDate) > INT(#" & dtDate & "#))"
	sql = sql & " AND (sStatus <> 'Closed') GROUP BY b.sBug_ID))"
	sql = sql & " GROUP BY b.sBug_ID"
	
	'Run query
		
	rs.Open sql, conn, 3, 3
	iTemp = rs.recordcount
	
	do while not rs.eof
	
		SumSQL = SumSQL & "," & rs("iID1")
		rs.movenext
	loop
	
	rs.close
	
	
	'Run second query to determine bugs Closed whose previous status was not Completed or Program Feature
	sql1 = sql1 & " WHERE (bOriginal <> true) "
	sql1 = sql1 & " AND (b.iID IN ("
	sql1 = sql1 & "SELECT MAX(b.iID) AS iID1 FROM tblBugs b WHERE (b.sBug_ID IN (" & sSQL & ")) AND (INT(dtDate) = INT(#" & dtDate & "#))"
	sql1 = sql1 & " GROUP BY b.sBug_ID))"	
	sql1 = sql1 & " AND (sStatus = 'Closed') AND (b.sBug_ID NOT IN ("
	sql1 = sql1 & "SELECT b.sBug_ID FROM tblBugs b WHERE (b.sBug_ID IN (" & sSQL & "))"
	sql1 = sql1 & " AND (INT(dtDate) <= INT(#" & dtDate & "#))"
	sql1 = sql1 & " AND (b.dtDateEnd IN ("
	sql1 = sql1 & "SELECT MAX(b.dtDate) AS dtDate1 FROM tblBugs b WHERE (b.sBug_ID IN (" & sSQL & ")) AND (INT(dtDate) <= INT(#" & dtDate & "#))"
	sql1 = sql1 & " GROUP BY b.sBug_ID))"	
	sql1 = sql1 & " AND ((sStatus = 'Completed') OR (sStatus = 'Program Feature')) GROUP BY b.sBug_ID))"
	sql1 = sql1 & " GROUP BY b.sBug_ID"
			
	'Run query
	Set rs = Server.CreateObject("ADODB.Recordset")
	rs.Open sql1, conn, 3, 3
	iTemp = iTemp + rs.recordcount	

	do while not rs.eof
	
		SumSQL = SumSQL & "," & rs("iID1")
		rs.movenext
	loop
	
	rs.close
	set rs.activeconnection=nothing	

	
	'function return value gets # of records returned from query
	iBugsClosed = iTemp

	
end function



'This function returns the number of
'bugs which were in an open status
'given the sSQL SQL criteria and
'date being specified by dtDate
function iOpenBugs (sSQL, dtDate, conn, sBugList)

	'Variable used in opening database query
	Dim rs
	
	'Temp variable
	Dim iTemp
	iTemp = 0
	Dim sql
	sql = "SELECT * FROM tblBugs b"
	
	
	'Finish SQL statement
	
	'Use only most current record for that date
	sql = sql & " WHERE (b.iID IN ("
	sql = sql & "SELECT MAX(b.iID) AS iID1 FROM tblBugs b WHERE (b.sBug_ID IN (" & sSQL & ")) AND (INT(dtDate) <= INT(#" & dtDate & "#)) GROUP BY b.sBug_ID))"
	sql = sql & " AND (sStatus <> 'Closed') AND (sStatus <> 'Completed') AND (sStatus <> 'Program Feature')"
	
	'Run query
	Set rs = Server.CreateObject("ADODB.Recordset")
	rs.Open sql, conn, 3, 3
	iTemp = rs.recordcount
	
	'Load all bugs into bug list variable
	do while not (rs.eof)
		sBugList = sBugList & "&iBugID=" & rs("sBug_ID")	
		rs.movenext
	loop
	
	rs.close
	set rs.activeconnection=nothing
			

	iOpenBugs = iTemp
end function



</SCRIPT>