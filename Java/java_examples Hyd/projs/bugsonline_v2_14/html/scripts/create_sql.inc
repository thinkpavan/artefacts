<%
	

REM//		Create SQL Statement for bug search

sSearch_Sql = "SELECT tblBug_ID.sBug_ID "
sSearch_Sql = sSearch_Sql & "FROM ((tblBugs INNER JOIN tblBug_ID ON tblBugs.sBug_ID = tblBug_ID.sBug_ID) "
sSearch_Sql = sSearch_Sql & "INNER JOIN tblUsers ON tblBugs.iPosted_By = tblUsers.iID) "
sSearch_Sql = sSearch_Sql & "LEFT JOIN tblUsers AS tblUsers_1 ON tblBugs.iAssigned_To = tblUsers_1.iID "

If request("lstProject") <> "No Criteria" And request("lstProject") <> "" And request("lstProject") <> "Management" Then
	
	sSearch_Sql = sSearch_Sql & "WHERE (tblBug_ID.sProject='" & request("lstProject") & "')"
	
ElseIf session("sProject") <> "Management" Then
	
	sSearch_Sql = sSearch_Sql & "WHERE (tblBug_ID.sProject='" & session("sProject") & "')"
	
Else

	sSearch_Sql = sSearch_Sql & "WHERE (tblBug_ID.sProject<>'Management')"
End If


REM//		If user designates to show current or orignal records only

If request("chkCurrent") = "current" Then 
	sSearch_Sql = sSearch_Sql & " AND (tblBugs.dtDateEnd = #1/1/1899#)"
elseif request("chkCurrent") = "original" Then
	sSearch_Sql = sSearch_Sql & " AND (tblBugs.bOriginal = true)"
end if

REM//		Evaluate all list box search criteria
REM//		ie.  Program, Area, Posted By, Assigned To
REM//		Status, Priority, and severity.

For x = 0 To 6


REM//		Check if any criteria was specified

If request("lst" & sList_a(x)) <> "" And request("lst" & sList_a(x)) <> "No Criteria" Then


REM//		Check is search is = or <> (if not
REM//		is checked then <>)

iStart = 1
If request("chk" & sList_a(x)) = "True" then
	sFactor = "<>"
	sJoin = " AND "
Else
	sFactor = "="
	sJoin = " OR "
End If


REM//		Run through all selected criteria
			
If request("lst" & sList_a(x)).count Then
	

	For i = 1 to request("lst" & sList_a(x)).count

				
	REM//		Determine if just starting (if
	REM//		true then must start open bracket)

	If iStart = 1 Then
		iStart = 0
		sSearch_Sql = sSearch_Sql & " AND ("
	
	Else
		sSearch_Sql = sSearch_Sql & sJoin		
	End If
		


	REM//		Determine relevant table
	
	
	REM//		Program or Area

		If x < 2 Then
			sTable = "tblBug_ID" 
			
			
	REM//		Posted By
	
		ElseIf x = 2 Then
			sTable = "tblUsers"
			
			

	REM//		Assigned To
	
		ElseIf x = 3 Then
			sTable = "tblUsers_1"


	REM//		Severity
		
		Else
			sTable = "tblBugs"	
			
		
		End If
	
		
		If x <> 5 And x <> 2 And x <> 3 Then 
			sSearch_Sql = sSearch_Sql & sTable & ".s" & sList_a(x) & sFactor & "'" & request("lst" & sList_a(x)) (i) & "'"
			
			
	REM//		Posted By or Assigned To
	
		ElseIf x = 2 or x = 3 Then
			
			
			If request("chk" & sList_a(x)) = "True" Then
				sLike = " NOT LIKE "
			Else
				sLike = " LIKE "
			End If
			
			If request("lst" & sList_a(x)) (i) = "Not Assigned" Then
				
				sSearch_Sql = sSearch_Sql & "tblBugs.iAssigned_To" & sFactor & "0"
				
			ElseIf request("lst" & sList_a(x)) (i) = "Assigned" Then
							
				If request("chk" & sList_a(x)) = "True" Then
					sSearch_Sql = sSearch_Sql & "tblBugs.iAssigned_To=0"
				Else
					sSearch_Sql = sSearch_Sql & "tblBugs.iAssigned_To<>0"
				End If
				
			Else
			
				sSearch_Sql = sSearch_Sql & sTable & ".sFirst_Name & ' ' & " & sTable & ".sLast_Name" & sLike & "'" & request("lst" & sList_a(x)) (i) & "'"
			
			End If

			

	REM//		Priority
	
		Else
			
			sSearch_Sql = sSearch_Sql & sTable & ".i" & sList_a(x) & sFactor & request("lst" & sList_a(x)) (i)
		End If
		
	
	Next


End If



REM//		Close bracket

If right(sSearch_Sql, 1) <> ")" Then sSearch_Sql = sSearch_Sql & ")"

'response.write sSearch_Sql

End If


Next	
	


	
REM//		Dates search criteria

If LTrim(RTrim(request("txtDate_Start"))) <> "" And LTrim(RTrim(request("txtDate_End"))) <> "" Then
	
	If request("chkDates") = "True" Then
		
		sSearch_Sql = sSearch_Sql & " AND (tblBugs.dtDate < #" & LTrim(RTrim(request("txtDate_Start"))) & "#"
		sSearch_Sql = sSearch_Sql & " OR tblBugs.dtDate > #" & LTrim(RTrim(request("txtDate_End"))) & "#)"
		
	Else
		
		sSearch_Sql = sSearch_Sql & " AND (tblBugs.dtDate >= #" & LTrim(RTrim(request("txtDate_Start"))) & "#"
		sSearch_Sql = sSearch_Sql & " AND tblBugs.dtDate <= #" & LTrim(RTrim(request("txtDate_End"))) & "#)"		
		
	End If
	

End If


	
REM//		Title and Description search criteria


For x = 2 To 3


If LTrim(RTrim(request("txt" & sText_a(x)))) <> "" Then


REM//		Open DB Connection to determine
REM//		which bugs contain specified strings

iStart = 1
sUsed_Bugs = ""

If x = 2 Then

	sTable = "sComments"
Else

	sTable = "sDescription"
End If

Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "bugs", , ""
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sSearch_Sql, conn, 3, 3

Do While rs.eof <> True
		
REM//		Checks if user selected 'Not' as
REM//		part of search criteria

	If request("chk" & sText_a(x)) = "True" And rs(sTable) <> "" And InStr(sUsed_Bugs, " " & rs("sBug_ID") & " ") = 0 Then
	
	
		sUsed_Bugs = sUsed_Bugs & " " & rs("sBug_ID") & " "


REM//		If user selected to search all 
REM//		records then each individual
REM//		record must be checked

		If request("chkCurrent") = "all" Then
			
			sql = sSearch_Sql & " AND (tblBug_ID.sBug_ID=" & rs("sBug_ID") & ")"
			Set Conn1 = Server.CreateObject("ADODB.Connection")
			Conn1.Open "bugs", , ""
			Set rs1 = Server.CreateObject("ADODB.Recordset")
			rs1.Open sql, conn1, 3, 3
			iStop = 0
			
			Do While rs1.eof <> True And iStop <> 1
			
			
				If InStr(LCase(rs1(sTable)), LCase(LTrim(RTrim(request("txt" & sText_a(x)))))) = 0 Then iStop = 1
				rs1.movenext
			
			Loop

			rs1.Close
			set rs1.activeconnection=nothing
			Conn1.close
			
			
			If iStop <> 1 Then
				
				If rs(sTable) <> "" Then
					
					sSearch_Sql = sSearch_Sql & " AND (tblBug_ID.sBug_ID<>" & rs("sBug_ID") & ")"
			
				End If
	
			End If


REM//		Otherwise checks each record once
REM//		Checks if record meets criteria

		
		Else

		If InStr(LCase(rs(sTable)), LCase(LTrim(RTrim(request("txt" & sText_a(x)))))) <> 0 Then
			
		
			If iStart = 1 and rs(sTable) <> "" Then
				iStart = 0
				sSearch_Sql = sSearch_Sql & " AND ( "
				sJoin = ""
	
			Else
				sJoin = " AND "
		
			End If

			sSearch_Sql = sSearch_Sql & sJoin & "tblBug_ID.sBug_ID<>" & rs("sBug_ID")
		End If
		
		
		End If

	ElseIf rs(sTable) <> "" And InStr(sUsed_Bugs, " " & rs("sBug_ID") & " ") = 0 Then
	
		
		sUsed_Bugs = sUsed_Bugs & " " & rs("sBug_ID") & " "
	
	
REM//		If user selected to search all 
REM//		records then each individual
REM//		record must be checked

		If request("chkCurrent") = "all" Then

			sql = sSearch_Sql & " AND (tblBug_ID.sBug_ID=" & rs("sBug_ID") & ")"
			Set Conn1 = Server.CreateObject("ADODB.Connection")
			Conn1.Open "bugs", , ""
			Set rs1 = Server.CreateObject("ADODB.Recordset")
			rs1.Open sql, conn1, 3, 3
			iStop = 0
			
			Do While rs1.eof <> True And iStop <> 1
			
			
				If InStr(LCase(rs1(sTable)), LCase(LTrim(RTrim(request("txt" & sText_a(x)))))) <> 0 Then iStop = 1
				rs1.movenext
			
			Loop

			rs1.Close
			set rs1.activeconnection=nothing
			Conn1.close
			
			
			If iStop <> 1 Then
				
				If rs(sTable) <> "" Then
					
					sSearch_Sql = sSearch_Sql & " AND (tblBug_ID.sBug_ID<>" & rs("sBug_ID") & ")"
			
				End If
	
			End If


REM//		Otherwise checks each record once
REM//		Checks if record meets criteria

		
		Else
		
		If InStr(LCase(rs(sTable)), LCase(LTrim(RTrim(request("txt" & sText_a(x)))))) = 0 Then 
			
			If iStart = 1 and rs(sTable) <> "" Then
				iStart = 0
				sSearch_Sql = sSearch_Sql & " AND ( "
				sJoin = ""
	
			Else
				sJoin = " AND "
		
			End If 
		
			sSearch_Sql = sSearch_Sql & sJoin & "tblBug_ID.sBug_ID<>" & rs("sBug_ID")
			
		End If
		
		
		End If
		
	End If	
	
	rs.movenext
	
Loop

	rs.Close
	set rs.activeconnection=nothing
	Conn.close
	If request("chkCurrent") <> "all" And right(sSearch_Sql, 1) <> ")" Then sSearch_Sql = sSearch_Sql & ")"	

End If


Next


sUsed_Bugs = ""
iStop = 0
iStart = 0

sSearch_Sql = "SELECT * FROM tblBugs, tblBug_ID WHERE (tblBugs.sBug_ID = tblBug_ID.sBug_ID) AND (tblBugs.dtDateEnd = #1/1/1899#) AND tblBug_ID.sBug_ID IN (" & sSearch_Sql & ")"
sql = sSearch_Sql & " ORDER BY tblBugs.dtDate DESC "
sMessage = ""

imgTitle = "banner_9_1"
%>



<!-- #include file="header.inc" -->



<%


REM//		User selected no details

If request("rdDetails") = "None" Then
	
%>

<!-- #include file="show_bugs.inc" -->


<%
REM//		User selects to view details

Else


REM//		Opens db and counts number of records


sql5 = sql
session("sSearch_Sql") = sql


Set Conn5 = Server.CreateObject("ADODB.Connection")
Conn5.Open "bugs", , ""
Set rs5 = Server.CreateObject("ADODB.Recordset")
rs5.Open sql5, conn5, 3, 3


If rs5.eof <> True Then

Do While rs5.eof <> True

	If InStr(sUsed_Bugs, " " & rs5("sBug_ID") & " ") = 0 Then
		sUsed_Bugs = sUsed_Bugs & " " & rs5("sBug_ID") & " "
		iTotal_Results = iTotal_Results + 1
	End If

	rs5.movenext

Loop


rs5.movefirst
	
End If


REM//		Determine starting, stopping location
REM//		and # bugs to show.

iStart_Display = request("iStart") (1)
If iStart_Display = "" Then iStart_Display = 0

iShow_Display = request("lstResults")

iStart_Display = iStart_Display + 1 - 1
iShow_Display = iShow_Display + 1 - 1
iLoc_Display = 0
iCurrent_Loc_Display = 0


REM//		Moves to appriate starting
REM//		record

Do While rs5.eof <> True And iLoc_Display <> iStart_Display
	
	rs5.movenext
	iLoc_Display = iLoc_Display + 1

Loop



sUsed_Bugs = ""
iStart = 1


Do While rs5.eof <> True And iCurrent_Loc_Display < iShow_Display


REM//		Shows bugs and details as requested by
REM//		User

	If InStr(sUsed_Bugs, " " & rs5("sBug_ID") & " ") = 0 Then
		sUsed_Bugs = sUsed_Bugs & " " & rs5("sBug_ID") & " "
		sBug_ID = rs5("sBug_ID")


REM//		Determine number of details to show
REM//		according to user input
		
		If request("rdDetails") = "One" Then
			iDetail_Type = 2
		Else
			iDetail_Type = 0
		End If
		
		
REM//		Displays bug header and appropriate 
REM//		details.
		%>

		
<!-- #include file="show_bug_header.inc" -->
<!-- #include file="show_bug_detail.inc" -->

		
		
		<%		
		
	iLoc_Display = iLoc_Display + 1
	iCurrent_Loc_Display = iCurrent_Loc_Display + 1
		
	End If

	rs5.movenext


Loop



REM//		Close db

rs5.Close
set rs5.activeconnection=nothing
Conn5.close

'response.write "Start: " & iStart_Display & " Show: " & iShow_Display & " Loc: " & iLoc_Display & " Total: " & iTotal_Results


REM//		Add appropriate
REM//		links to other records


If iStart <> 1 Then
%>


<!-- #include file="create_links.inc" -->


<%
Else



REM//		No records to display
%>


<BR><CENTER><B><FONT FACE="Arial" SIZE=4>
No records were found in this catagory
</FONT></B></CENTER>


<%
End If


End If
%>


<% sError_Message = ""%>