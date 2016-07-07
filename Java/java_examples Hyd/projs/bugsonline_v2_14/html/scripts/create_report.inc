<!-- #include file="report_functions.inc" -->

<%
'Open db connection
Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "bugs", , ""


'Count variables
Dim x, y

'Base Query String used to determine report values
Dim sStartSQL
sStartSQL = "SELECT b.sBug_ID FROM tblBugs b"

'Size of date range
iDateRangeValue = INT((DATEVALUE(request.form("txtEnd")) - DATEVALUE(request.form("txtStart")) + 1))

'Array of open bugs pertaining to date range
'Array value (0) = # of bugs which were open
'on the day prior to the start date and
'Array value (iDateRangeValue + 1) = # of
'bugs on day following end date
Dim iBugCount_a ()
ReDim iBugCount_a (iDateRangeValue + 1)


'Array of bugs opened per day
'requested by report where (1) = first day
'and (iDateRangeValue) = last day
Dim iBugsOpened_a ()
ReDim iBugsOpened_a (iDateRangeValue)


'Array of bugs closed per day
'requested by report where (1) = first day
'and (iDateRangeValue) = last day
Dim iBugsClosed_a ()
ReDim iBugsClosed_a (iDateRangeValue)


'Variables containing total # of bugs
'opened and closed during dates
'specified
Dim iOpened
Dim iClosed
iOpened = 0
iClosed = 0


'These variables are used to store bug ids pertaining
'to specific days
Dim sBugList
Dim sBugList_a ()
ReDim sBugList_a (iDateRangeValue)


'The below
'are status_graph.inc variables

'Width of each day in pixels
Dim iWidth

'Max height of graphc
Dim iMax

'Variable used to assign current working date
Dim dtCurrent

'Next date interval for dates below graphc
Dim iNextDate

'Current date value
Dim iCurrent

'Used to determine current color or graph
Dim iColor, sColor

'Temp variables
Dim iTemp, iTemp1, sTemp

'Used to determine dates shown below graph
Dim sUserColor, dtUseDate

'Number of columns
Dim iCols


'The below
'are daily_report_contents.inc variables
Dim sDate_a()
ReDim sDate_a (iDateRangeValue)

'These variables are for setting summary information
Dim iStartValue
Dim iEndValue
Dim sSumSQL
sSumSQL = "SELECT s.sBug_ID, INT(e.dtDate - s.dtDate) AS Days, INT(((e.dtDate - s.dtDate) - INT(e.dtDate - s.dtDate))*24) AS Hours FROM tblBugs s, tblBugs e WHERE (s.bOriginal = True) AND (e.sBug_ID = s.sBug_ID) AND (e.iID IN (9999999"

Dim iTotalDays
Dim iTotalHours
Dim iMaxDays
Dim iMaxHours
Dim iMinDays
Dim iMinHours
Dim i24Hours
Dim i48Hours
Dim sMinBug
Dim sMaxBug


'This if clause determines search criteria and 
'establish base query to be used in creation of report

'User or Developer Report
if (request.form("lstUser") <> "") or (request.form("CustomReport") = "true") then
		
	'Submittor Report
	if (request.form("chkUser") = "User") then
		
		if (request.form("CustomReport") = "true") then
					sStartSQL = sStartSQL & ", tblUsers u WHERE (b.bOriginal = True) AND (b.iPosted_By = u.iID) AND(u.sUser_Name = '" & session("sUser_Name") & "' "			
		else			
			For i = 1 to request("lstUser").count
				if (i = 1) then
					sStartSQL = sStartSQL & ", tblUsers u WHERE (b.bOriginal = True) AND (b.iPosted_By = u.iID) AND(u.sUser_Name = '" & request("lstUser") (i) & "' "
				else 
					sStartSQL = sStartSQL & "OR u.sUser_Name = '" & request("lstUser") (i) & "' "
				end if	
			Next
			
		end if
		
	'Developer Report	
	else
	
		if (request.form("CustomReport") = "true") then	
			sStartSQL = sStartSQL & ", tblUsers u WHERE (b.iAssigned_To = u.iID) AND(u.sUser_Name = '" & session("sUser_Name") & "' "		
		else
			For i = 1 to request("lstUser").count
				if (i = 1) then
					sStartSQL = sStartSQL & ", tblUsers u WHERE (b.iAssigned_To = u.iID) AND(u.sUser_Name = '" & request("lstUser") (i) & "' "
				else 
					sStartSQL = sStartSQL & "OR u.sUser_Name = '" & request("lstUser") (i) & "' "
				end if
			Next
			
		end if
						
	end if	

'Program Report	
elseif (request.form("lstProgram") <> "") then
		
	sStartSQL = sStartSQL & ", tblBug_ID i WHERE (b.sBug_ID = i.sBug_ID) AND (i.sProject = '" & request.form("lstProject") & "' AND i.sProgram = '" & request.form("lstProgram") & "' "

'Project Report	
else
		
	sStartSQL = sStartSQL & ", tblBug_ID i WHERE (b.sBug_ID = i.sBug_ID) AND (i.sProject = '" & request.form("lstProject") & "' "

end if

sStartSQL = sStartSQL & ")"


'Determine # of bugs opened on day prior
'to start date for report
iBugCount_a (0) = iOpenBugs (sStartSQL, CDATE(DATEVALUE(request.form("txtStart")) - 1), conn, sBugList)


'Determine # of bugs opened on day following
'end date for report
iBugCount_a (iDateRangeValue + 1) = iOpenBugs (sStartSQL, CDATE(DATEVALUE(request.form("txtEnd")) + 1), conn, sBugList)
sBugList = ""


'Determine bugs opened and bugs closed
'for each day in report date range
for x = 0 to iDateRangeValue
	iBugCount_a (x + 1) = iOpenBugs (sStartSQL, CDATE(DATEVALUE(request.form("txtStart")) + x), conn, sBugList)
	sBugList_a (x + 1) = sBugList
	sBugList = ""

	if (request.form ("chkReportType") = "Daily") then
		iBugsOpened_a (x + 1) = iBugsOpened (sStartSQL, CDATE(DATEVALUE(request.form("txtStart")) + x), conn)
		iBugsClosed_a (x + 1) = iBugsClosed (sStartSQL, CDATE(DATEVALUE(request.form("txtStart")) + x), conn, sSumSQL)	
		iOpened = iOpened + iBugsOpened_a (x + 1)
		iClosed = iClosed + iBugsClosed_a (x + 1)
	end if

next

sSumSQL = sSumSQL & "))"



'Create bug status graph (or text)
%>
<!-- #include file="status_graph.inc" -->
<%


'Create daily progress graphs (or text)
if (request.form("chkReportType") = "Daily") then
%>

<!-- #include file="Cumulative_Report_Contents.inc" -->
<!-- #include file="Daily_Report_Contents.inc" -->

<%
end if


'Close database connection
Conn.close
%>