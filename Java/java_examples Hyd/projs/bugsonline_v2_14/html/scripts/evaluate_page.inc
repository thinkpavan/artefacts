<%

REM//			Declare Variables


REM//			Defines Page
Dim iBug_Type

REM//			User and Assigned to Numbers
Dim iPosted_By
Dim iAssigned_To

REM//			Number of Details
Dim iDetails
Dim iLoc

REM//			Type of detail (1 = all, 2 = one)

Dim iDetail_Type


REM//			Error Messages
Dim sError_Message

REM//			Database Variables
Dim sql
Dim sql1
Dim sql2
Dim sql3
Dim rs
Dim rs1
Dim rs2
Dim conn
Dim conn1
Dim conn2

REM//			Title Image
Dim imgTitle

REM//			Title Message
Dim sMessage

REM//			Determines whether or not to display bug info

Dim iStop
Dim iWrite

REM//			In bug_header.inc - determines if 1st header has been shown

Dim iStart

REM//			Zeros to be placed in front of bug id

Dim sZeros

REM//			Used for same reason as listed above

Dim sBug_ID

REM//			Size of array storing different project areas

Dim iArray_Size

REM//			Array containing different project areas

Dim sAreas_a()

REM//			Array containing program names corresponding to area

Dim sPrograms_a()

REM//			Array listing number of errors per Area

Dim iBugs_a()

REM//			Array of top three bug areas

Dim iTop_Areas_a(2)

REM//			Same as above (used for counting)

Dim iTop_Areas1_a(2)

REM//			Variable used to count project areas

Dim sAreas

REM//			Variable used to count project areas

Dim sPrograms

REM//			Variabe used in site_admin_form.inc
REM//			If = 1 then clears text fields upon
REM//			loading

Dim iClear_Form

REM//			Variable used in process_site_admin.inc
REM//			to determine user authorization

Dim sUser

REM//			Variable used in parsing of 
REM//			multiple selected <SELECT>
REM//			columns

Dim iText_Loc1


REM//			Variable used in create_select.inc
REM//			to determine is an <OPTION> has
REM//			already been shown

Dim sDisplayed


REM//			Used in create_select.inc to determine 
REM//			if should reload form on_click (only if = 1)

Dim iChange

REM//			Array variable used to store
REM//			all projects to which a new
REM//			user is authorized (used in 
REM//			process_site_admin.inc)

Dim iProjects_a()

REM//			Variable used to create 
REM//			querystring for user
REM//			defined search

Dim sType

REM//			Array Variables Used in error checking bug
REM//			search form

Dim sList_a(6)		'List Box Array
Dim sText_a(3)		'Text Box Array

sList_a(0) = "Program"
sList_a(1) = "Area"
sList_a(2) = "User"
sList_a(3) = "Assigned"
sList_a(4) = "Status"
sList_a(5) = "Priority"
sList_a(6) = "Severity"

sText_a(0) = "Date_Start"
sText_a(1) = "Date_End"
sText_a(2) = "Description"
sText_a(3) = "Title"

REM//			Define Variables

iBug_Type = request.querystring("iBT")


REM//			If iBT = 9 (Bug Search Option)
REM//			and user selects a User
REM//			defined search then page is redirected
REM//			with appropriate querystring


If iBug_Type = 9 And request.form("txtType") = "ReLoad" And request.form("lstUser_Favorite") <> "No Records!" _ 
And request.form("lstUser_Favorite") <> "Please Make A Selection" Then
	
Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "bugs", , ""
sql = "SELECT * FROM [tblBug_Search] "
sql = sql & "WHERE tblBug_Search.sUser_Name='" & session("sUser_Name") & "'"
sql = sql & " AND tblBug_Search.sSearch_Name='" & request.form("lstUser_Favorite") & "'"
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3

If rs.eof <> True Then 
	session("sUser_Search") = request.form("lstUser_Favorite")
	response.redirect "view_bugs.asp?iBT=9" & "&" & rs("sQuerystring")
End If

rs.close
conn.close

End If


REM//			User selects to reset bug search form

If iBug_Type = 9 And request.form("txtType") = "Reset" Then response.redirect "view_bugs.asp?iBT=9&txtProject=" & request.form("txtProject")



REM//			Evaluate Page Type

Select Case iBug_Type


	REM//		New Bugs
	Case 15, 1			

		sMessage = sMessage & session("dtLogin_Date") & "."
		imgTitle = "banner_1"
		sql = "SELECT * FROM [tblBugs] INNER JOIN [tblBug_ID] ON tblBugs.sBug_ID = tblBug_ID.sBug_ID "
		
		If session("sProject") <> "Management" Then
		
		sql = sql & "WHERE (tblBugs.dtDate>#" & session("dtLogin_Date") & "#) AND (tblBug_ID.sProject='"
		sql = sql & session("sProject") & "') AND (tblBugs.dtDateEnd = #01/01/1899#)"
		
		Else

		sql = sql & "WHERE (tblBugs.dtDate>#" & session("dtLogin_Date") & "#)"
		sql = sql & " AND tblBugs.dtDateEnd = #01/01/1899#"
	
		End If
		
		sql = sql & " ORDER BY tblBugs.dtDate DESC"
		
	
	REM//		Top Bugs
	Case 2
	
		sMessage = session("sProject") & "."
		imgTitle = "banner_2"
		sql = "SELECT * FROM [tblBugs] INNER JOIN [tblBug_ID] ON tblBugs.sBug_ID = tblBug_ID.sBug_ID "
		
		If session("sProject") <> "Management" Then
		
		sql = sql & "WHERE tblBug_ID.sProject='" & session("sProject") & "'"
		sql = sql & " AND tblBugs.sStatus<>'Completed' AND tblBugs.sStatus<>'Closed' AND "
		sql = sql & "tblBugs.sStatus<>'Program Feature' AND tblBugs.dtDateEnd = #01/01/1899#"
		
		Else
		
		sql = sql & "WHERE tblBugs.sStatus<>'Completed' AND tblBugs.sStatus<>'Closed' AND "
		sql = sql & "tblBugs.sStatus<>'Program Feature' AND tblBugs.dtDateEnd = #01/01/1899#"
		
		End If
		
		sql = sql & " ORDER BY tblBugs.dtDate DESC"
		
	
	
	REM//		Open Bugs
	Case 3
	
		sMessage = ""
		imgTitle = "banner_3"
		sql = "SELECT * FROM [tblBugs] INNER JOIN [tblBug_ID] ON tblBugs.sBug_ID = tblBug_ID.sBug_ID "
		
		If session("sProject") <> "Management" Then
		sql = sql & "WHERE tblBug_ID.sProject='" & session("sProject")
		sql = sql & "' AND tblBugs.sStatus<>'Completed' AND "
		sql = sql & "tblBugs.sStatus<>'Program Feature' AND tblBugs.sStatus<>'Closed' AND tblBugs.dtDateEnd = #01/01/1899#"
		
		Else
		sql = sql & "WHERE tblBugs.sStatus<>'Completed' AND "
		sql = sql & "tblBugs.sStatus<>'Program Feature' AND tblBugs.sStatus<>'Closed' AND tblBugs.dtDateEnd = #01/01/1899#"
		
		End If
		
		sql = sql & " ORDER BY tblBugs.dtDate DESC"
		
	
	
	REM//		Assigned Bugs
	Case 4
	
		sMessage = ""
		imgTitle = "banner_4"
		sql = "SELECT * FROM [tblBugs] INNER JOIN [tblBug_ID] ON tblBugs.sBug_ID = tblBug_ID.sBug_ID "
		
		If session("sProject") <> "Management" Then
		sql = sql & "WHERE tblBug_ID.sProject='" & session("sProject") & "' AND tblBugs.sStatus='Assigned' AND tblBugs.dtDateEnd = #01/01/1899#"
		
		Else

		sql = sql & "WHERE tblBugs.sStatus='Assigned' AND tblBugs.dtDateEnd = #01/01/1899#"
		
		End If
		
		sql = sql & " ORDER BY tblBugs.dtDate DESC"
	
	
	REM//		Unassigned Bugs
	Case 5
	
		sPage_Type = "Unassigned Bugs"
		sMessage = ""
		imgTitle = "banner_5"
		sql = "SELECT * FROM [tblBugs] INNER JOIN [tblBug_ID] ON tblBugs.sBug_ID = tblBug_ID.sBug_ID "
		
		If session("sProject") <> "Management" Then
		sql = sql & "WHERE tblBug_ID.sProject='" & session("sProject") & "' AND tblBugs.iAssigned_To=0 AND tblBugs.dtDateEnd = #01/01/1899#"
		
		Else
		
		sql = sql & "WHERE tblBugs.iAssigned_To=0 AND tblBugs.dtDateEnd = #01/01/1899#"
		
		End If
		
		sql = sql & " AND tblBugs.sStatus='Open' "
		sql = sql & "ORDER BY tblBugs.dtDate DESC"
	
	
	
	REM//		Resolved Bugs
	Case 6
	
		sMessage = ""
		imgTitle = "banner_6"
		sql = "SELECT * FROM [tblBugs] INNER JOIN [tblBug_ID] ON tblBugs.sBug_ID = tblBug_ID.sBug_ID "
		
		If session("sProject") <> "Management" Then
		
		sql = sql & "WHERE tblBug_ID.sProject='" & session("sProject") & "' AND tblBugs.dtDateEnd = #01/01/1899# AND tblBugs.sStatus='Completed'"
		
		Else

		sql = sql & "WHERE tblBugs.dtDateEnd = #01/01/1899# AND tblBugs.sStatus='Completed'"
		
		End If
		
		sql = sql & " ORDER BY tblBugs.dtDate DESC"
		
	
	
	REM//		My Bugs
	Case 7
	
		sMessage = "<BR><BR><FONT COLOR='#000080'>Create custom user report:<FONT COLOR='#000000'> "
		imgTitle = "banner_7"


		sql = "SELECT * FROM tblBugs b, tblBug_ID i, tblUsers u WHERE (b.sBug_ID = i.sBug_ID) "
		sql = sql + " AND b.iPosted_By = u.iID "
		sql = sql + "AND b.bOriginal=True "
		sql = sql + "AND u.sUser_Name = '" + session ("sUser_Name") + "' "
		
		If session("sProject") <> "Management" Then
		
			sql = sql & "AND i.sProject='" & session("sProject") & "'"	
		
		End If
	
		sql = sql & "AND (b.sBug_ID NOT IN (SELECT sBug_ID FROM tblBugs WHERE dtDateEnd = #1/1/1899# AND sStatus='Closed'))"
		
		sql = sql & " ORDER BY b.sBug_ID, b.dtDate DESC"
	
	
	
	REM//		Bug Detail
	Case 8

		
		sMessage = ""
		imgTitle = "banner_8_1"
	
	
	
	REM//		Bug Search
	Case 9
	
		sMessage = ""
		imgTitle = "banner_9"
	
	
	
	REM//		Submit Bug
	Case 10
	
		sMessage = ""
		imgTitle = "banner_10"
	
	
	
	REM//		Site Admin
	Case 11
	
		sMessage = ""
		imgTitle = "banner_11"
		
	REM//		Report Bugs
	Case 16
		sMessage =  request("sMessage") & "<BR><BR>" & request("dtDate") & "-" & request("iBugsOpen") & " bugs open"
		imgTitle = ""
		
		sql = "SELECT * FROM tblBugs b, tblBug_ID i WHERE (b.dtDateEnd = #1/1/1899#) AND (i.sBug_ID = b.sBug_ID) AND (b.sBug_ID='99999999' "
		For i = 1 to request("iBugID").count
				sql = sql & "OR i.sBug_ID = '" & request("iBugID") (i) & "' "
		Next
		sql = sql & ")"
		sql = sql & " ORDER BY b.dtDate DESC"
	
	REM//		Case Else
	Case Else
	
		session("sLogin_Error") = "An error has occured in this session, please log in again..."
		session("sRedirect") = "index.asp"
		response.redirect "destroy_frame.asp"
	
		
	
End Select
%>