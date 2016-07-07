<%
REM//		The below select case 
REM//		checks for input errors
REM//		from frmSite_Admin.  It
REM//		uses the variable sError_Message
REM//		to store error text.


REM//		Open db connection
Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "bugs", , ""


REM//		Check for errors

Select Case request.form("txtType")


REM//		Add User
Case "Add User"

If request.form("txtFirst_Name") = "" or request.form("txtLast_Name") = "" or request.form("txtUser_Name") = "" or _ 
request.form("txtPassword") = "" Then 
	sError_Message = "Add User Error:  All fields (excluding e-mail address) must be filled in!"
	
ElseIf InStr(request.form("txtUser_Name"), ", ") <> 0 Then
	sError_Message = "Invalid User Name!  User name cannot contain ', '"

Else


REM//		Check if a project has
REM//		been selected for the user to
REM//		be authorized to.	

sql = "SELECT * FROM [tblProjects]"
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3

loc = 0
Do While rs.eof <> True

	If request.form("chk" & rs("sProject_Name")) = "True" Then
		sError_Message = "1"
		redim preserve iProjects_a(loc)
		iProjects_a(loc) = rs("iProject_ID")
		loc = loc + 1
		rs.movenext
	Else
		rs.movenext
	End If

Loop

rs.Close
set rs.activeconnection=nothing


	If sError_Message <> "1" Then 
		sError_Message = "Add User Error:  You must select a project!"
	Else
		sError_Message = ""
	End If

End If

REM//		Check for existing user
REM//		with inputted user name
sql = "SELECT * FROM [tblUsers] WHERE tblUsers.sUser_Name = '" & LTrim(RTrim(request.form("txtUser_Name"))) & "'"
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3

if rs.eof <> True Then sError_Message = "The User Name '" & LTrim(RTrim(request.form("txtUser_Name"))) & "', already exists.  Please choose another..."

rs.Close
set rs.activeconnection=nothing


sql = "SELECT * FROM [tblUsers]"



REM//		Remove Project
Case "Remove Project"

If request.form("lstProject") = "Management" Then sError_Message = "This project cannot be removed!"

If request.form("lstProject") = "" or request.form("lstProject") = "Please make a selection..." _ 
Then sError_Message = "Select a valid project..."
iClear_Form = 1

sql = "SELECT * FROM [tblProjects] WHERE tblProjects.sProject_Name = '" & LTrim(RTrim(request.form("lstProject"))) & "'"



REM//		Remove Program
Case "Remove Program"

If request.form("lstProgram") = "" or request.form("lstProject") = "" or _ 
request.form("lstProgram") = "Select a project" or request.form("lstProgram") = "No Records!" _ 
Then sError_Message = "Select a valid program..."
iClear_Form = 1

sql = "SELECT tblProjects.iProject_ID "
sql = sql & "FROM tblProjects INNER JOIN tblPrograms ON tblProjects.iProject_ID = tblPrograms.iProject_ID "
sql = sql & "WHERE tblPrograms.sProgram='" & LTrim(RTrim(request.form("lstProgram"))) & "' "
sql = sql & "AND tblProjects.sProject_Name='" & LTrim(RTrim(request.form("lstProject"))) & "'"



REM//		Remove Area
Case "Remove Area"

If request.form("lstProgram") = "" or request.form("lstProject") = "" or _ 
request.form("lstProgram") = "Select a project" or request.form("lstProgram") = "No Records!" or _ 
request.form("lstArea") = "" or request.form("lstArea") = "Select a program" or request.form("lstArea") = "No Records!" _ 
Then sError_Message = "Select a valid area..."
iClear_Form = 1

sql = "SELECT tblPrograms.iProgram_ID "
sql = sql & "FROM (tblProjects INNER JOIN tblPrograms ON tblProjects.iProject_ID = tblPrograms.iProject_ID) "
sql = sql & "INNER JOIN tblAreas ON tblPrograms.iProgram_ID = tblAreas.iProgram_ID "
sql = sql & "WHERE tblPrograms.sProgram='" & LTrim(RTrim(request.form("lstProgram"))) & "' "
sql = sql & "AND tblAreas.sArea='" & LTrim(RTrim(request.form("lstArea"))) & "' "
sql = sql & "AND tblProjects.sProject_Name='" & LTrim(RTrim(request.form("lstProject"))) & "'"



REM//		Add Project
Case "Add Project"

If LTrim(RTrim(request.form("txtProject"))) = "" Then sError_Message = "Please enter a valid project name!"


REM//		Check for existing project
REM//		with inputted project name

If sError_Message = "" Then

sql = "SELECT * FROM [tblProjects] WHERE tblProjects.sProject_Name = '" & LTrim(RTrim(request.form("txtProject"))) & "'"
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3
if rs.eof <> True Then sError_Message = "The project name '" & LTrim(RTrim(request.form("txtProject"))) & "', already exists.  Please choose another..."

rs.Close
set rs.activeconnection=nothing
iClear_Form = 1

sql = "SELECT * FROM [tblProjects]"

End If



REM//		Add Program
Case "Add Program"

If request.form("lstProject") = "Management" Then sError_Message = "You cannot add Programs or Areas to this project"

If request.form("lstProject") = "" or request.form("lstProject") = "Please make a selection..." _ 
Then sError_Message = "Select a valid project..."

If LTrim(RTrim(request.form("txtProgram"))) = "" Then sError_Message = "Please enter a valid program name!"


REM//		Check for existing program
REM//		with inputted program name

If sError_Message = "" Then

sql = "SELECT tblPrograms.sProgram "
sql = sql & "FROM tblProjects INNER JOIN tblPrograms ON tblProjects.iProject_ID = tblPrograms.iProject_ID "
sql = sql & "WHERE tblPrograms.sProgram='" & LTrim(RTrim(request.form("txtProgram"))) & "' "
sql = sql & "AND tblProjects.sProject_Name='" & LTrim(RTrim(request.form("lstProject"))) & "'"
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3

if rs.eof <> True Then sError_Message = "The program name '" & LTrim(RTrim(request.form("txtProgram"))) & "', already exists.  Please choose another..."

rs.Close
set rs.activeconnection=nothing
iClear_Form = 1

sql = "SELECT * FROM [tblProjects] WHERE tblProjects.sProject_Name = '" & request.form("lstProject") & "'"
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3

If rs.eof <> True Then
	iLoc = rs("iProject_ID")
Else
	sError_Message = "Unable to add program '" & LTrim(RTrim(request.form("txtProgram"))) & "!"
End If

rs.Close
set rs.activeconnection=nothing

sql = "SELECT * FROM [tblPrograms]"

End If


REM//		Add Area
Case "Add Area"

If request.form("lstProject") = "Management" Then sError_Message = "You cannot add Programs or Areas to this project"

If request.form("lstProgram") = "" or request.form("lstProject") = "" or _ 
request.form("lstProgram") = "Select a project" or request.form("lstProgram") = "No Records!" _ 
Then sError_Message = "Select a valid program..."

If LTrim(RTrim(request.form("txtArea"))) = "" Then sError_Message = "Please enter a valid program area name!"


REM//		Check for existing area
REM//		with inputted area name

If sError_Message = "" Then
	
sql = "SELECT tblPrograms.sProgram, tblAreas.sArea "
sql = sql & "FROM (tblProjects INNER JOIN tblPrograms ON tblProjects.iProject_ID = tblPrograms.iProject_ID) "
sql = sql & "INNER JOIN tblAreas ON tblPrograms.iProgram_ID = tblAreas.iProgram_ID "
sql = sql & "WHERE tblPrograms.sProgram='" & LTrim(RTrim(request.form("lstProgram"))) & "' "
sql = sql & "AND tblAreas.sArea='" & LTrim(RTrim(request.form("txtArea"))) & "' "
sql = sql & "AND tblProjects.sProject_Name='" & LTrim(RTrim(request.form("lstProject"))) & "'"
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3

if rs.eof <> True Then sError_Message = "The program area name '" & LTrim(RTrim(request.form("txtArea"))) & "', already exists.  Please choose another..."

rs.Close
set rs.activeconnection=nothing
iClear_Form = 1


sql = "SELECT tblPrograms.iProgram_ID "
sql = sql & "FROM tblProjects INNER JOIN tblPrograms ON tblProjects.iProject_ID = tblPrograms.iProject_ID "
sql = sql & "WHERE tblPrograms.sProgram='" & request.form("lstProgram") & "' "
sql = sql & "AND tblProjects.sProject_Name='" & request.form("lstProject") & "'"
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3

If rs.eof <> True Then
	iLoc = rs("iProgram_ID")
Else
	sError_Message = "Unable to add program area '" & LTrim(RTrim(request.form("txtArea"))) & "'!"
End If
rs.Close
set rs.activeconnection=nothing

sql = "SELECT * FROM [tblAreas]"

End If


REM//		Remove/ Authorize User Option
Case "Remove User", "Authorize User"

If request.form("lstUser") = "" or request.form("lstUser") = "Select a project..." or _ 
request.form("lstUser") = "No Records!" or request.form("lstProject") = "" OR request.form("lstProject") = "Select a program..." Then 
	sError_Message = "Unable to remove user!  Invalid user..."

ElseIf request.form("lstUser") = "readj" And request.form("txtType") <> "Authorize User" Then 
	sError_Message = "This user cannot be removed!"
	
Else
	sql = "SELECT * FROM [tblProjects] WHERE tblProjects.sProject_Name = '" & request.form("lstProject") & "'"
	Set rs = Server.CreateObject("ADODB.Recordset")
	rs.Open sql, conn, 3, 3
	If rs.eof <> True Then
		iLoc = rs("iProject_ID")
		sql = "SELECT * FROM [tblAuthorized]"
	
	Else
		sError_Message = "Unable to " & request.form("txtType") & ".  Project selection error!"
	End If
	
	rs.Close
	set rs.activeconnection=nothing
	
End If


If request.form("chkUser") = "Developer" And sError_Message = "" Then sql = "SELECT * FROM [tblDevelopers]"


REM//		Report
Case "Report"
%>

<Script Language="VBScript" RUNAT="Server">
Function Test_Dates(sStart, sEnd)

If sStart <> "" or sEnd <> "" Then

	On Error Resume Next
	sTest = DateValue(sStart) & " : " & DateValue(sEnd)
	If sTest = "" Then Test_Dates = "<BR>Date error: Invalid Date Formats!"
	
End If

End Function
</Script>

<%
	'Check for a valid date format
	sError_Message = sError_Message & Test_Dates(request.form("txtStart"), request.form("txtEnd"))
	
	'If dates are not valid then no other tests are performed
	if sError_Message = "" then

	if ((request.form("lstProject") = "" or request.form("lstProject") = "Management")) AND (request.form("CustomReport") <> "true") then
		sError_Message = "Please select a project."

	elseif (request.form("chkReportType") = "") then
		sError_Message = "Please select a report type."

	elseif (LTrim(RTrim(request.form("txtStart"))) = "") then
		sError_Message = "Please enter a start date."

	elseif (LTrim(RTrim(request.form("txtEnd"))) = "") then
		sError_Message = "Please enter an end date."

	elseif (DateValue(request.form("txtStart")) > DateValue(request.form("txtEnd"))) then
		sError_Message = "Start date must be less then End date!"
	
	elseif (DateValue(request.form("txtEnd")) > DateValue(Date)) then
		sError_Message = "End date cannot be after current date!"
	
	elseif ((DateValue(request.form("txtEnd")) - DateValue(request.form("txtStart")) > 62) AND (request.form("chkReportType") = "Daily")) then
		sError_Message = "Maximum of 2 months can be requested for Daily Reports."
	elseif ((DateValue(request.form("txtEnd")) - DateValue(request.form("txtStart")) > 365) AND (request.form("chkReportType") <> "Daily")) then		
		sError_Message = "Maximum of 1 year can be requested for a cumulative report."
	end if

	end if

Case Else

sError_Message = "An error has occurred in this application.  Please login and try again.  If the problem persists, please contact the system administrator"


End Select


REM//		No Errors have occurred

If sError_Message = "" Then


if (request.form("txtType") <> "Report") then

	REM//		Open db connections using
	REM//		pre determined sql statement

	Set rs = Server.CreateObject("ADODB.Recordset")
	rs.Open sql, conn, 3, 3

end if



REM//		Based on submit type
REM//		Perform different 
REM//		operations

Select Case request.form("txtType")

REM//		Add User
Case "Add User"

REM//		Add user name info


rs.addnew

rs("sUser_Name") = LTrim(RTrim(request.form("txtUser_Name")))
rs("sFirst_Name") = LTrim(RTrim(request.form("txtFirst_Name")))
rs("sLast_Name") = LTrim(RTrim(request.form("txtLast_Name")))
rs("sPassword") = LTrim(RTrim(request.form("txtPassword")))
If LTrim(RTrim(request.form("txtEmail"))) <> "" Then rs("sEmail") = LTrim(RTrim(request.form("txtEmail")))
rs("dtLogin_Date") = "1/1/98 1:00:00 AM"
If request.form("chkDeveloper") = "True" Then rs("iDeveloper") = 1

rs.update

sUser = rs("sUser_Name")

rs.Close
set rs.activeconnection=nothing

REM//		Add user authorizations

sql = "SELECT * FROM [tblAuthorized]"
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3

For x = 0 To loc - 1

	rs.addnew
	rs("sUser_Name") = sUser
	rs("iAuthorized") = iProjects_a(x)
	rs.update
	
Next

rs.Close
set rs.activeconnection=nothing


REM//		Ad user developer authorization

sql = "SELECT * FROM [tblDevelopers]"
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3

rs.addnew
rs("sUser_Name") = sUser
rs("sProject") = "***None***"
rs("sProgram") = "***None***"
rs.update

sError_Message = "New user '" & sUser & "', has been added successfully"
iClear_Form = 1
		


REM//		Remove Project
Case "Remove Project"

If rs.eof <> True Then
	rs.delete
	rs.update
	sError_Message = "Project '" & request.form("lstProject") & "' has been removed successfully."
Else
	sError_Message = "Unable to remove project '" & request.form("lstProject") & "'."
End If



REM//		Remove Program
Case "Remove Program"

If rs.eof = True Then
	
	sError_Message = "Unable to remove program '" & request.form("lstProgram") & "'."

Else

	iLoc = rs("iProject_ID")
	rs.Close
	set rs.activeconnection=nothing
	sql = "SELECT * FROM [tblPrograms] WHERE tblPrograms.sProgram = '" & request.form("lstProgram") & "' AND "
	sql = sql & "tblPrograms.iProject_ID = " & iLoc
	Set rs = Server.CreateObject("ADODB.Recordset")
	rs.Open sql, conn, 3, 3
	
	If rs.eof = True Then
		sError_Message = "Unable to remove program '" & request.form("lstProgram") & "'."
	Else
		rs.delete
		rs.update
		sError_Message = "Program '" & request.form("lstProgram") & "' has been removed successfully."
	End If
	
End If


REM//		Remove Area
Case "Remove Area"

If rs.eof = True Then
	
	sError_Message = "Unable to remove program area '" & request.form("lstArea") & "'."

Else

	iLoc = rs("iProgram_ID")
	rs.Close
	set rs.activeconnection=nothing
	sql = "SELECT * FROM [tblAreas] WHERE tblAreas.sArea = '" & request.form("lstArea") & "' AND "
	sql = sql & "tblAreas.iProgram_ID = " & iLoc
	Set rs = Server.CreateObject("ADODB.Recordset")
	rs.Open sql, conn, 3, 3
	
	If rs.eof = True Then
		sError_Message = "Unable to remove program area '" & request.form("lstArea") & "'."
	Else
		rs.delete
		rs.update
		sError_Message = "Program Area '" & request.form("lstArea") & "' has been removed successfully."
	End If
	
End If


REM//		Add Project
Case "Add Project"

	rs.addnew
	rs("sProject_Name") = LTrim(RTrim(request.form("txtProject")))
	rs.update
	sError_Message = "Project '" & LTrim(RTrim(request.form("txtProject"))) & "' has been added successfully."



REM//		Add Program
Case "Add Program"

	rs.addnew
	rs("iProject_ID") = iLoc
	rs("sProgram") = LTrim(RTrim(request.form("txtProgram")))
	rs.update
	sError_Message = "Program '" & LTrim(RTrim(request.form("txtProgram"))) & "' has been added successfully."



REM//		Add Area
Case "Add Area"

	rs.addnew
	rs("iProgram_ID") = iLoc
	rs("sArea") = LTrim(RTrim(request.form("txtArea")))
	rs.update
	sError_Message = "Program Area '" & LTrim(RTrim(request.form("txtArea"))) & "' has been added successfully."
	

REM//		Remove User
Case "Remove User"

	
	rs.Close
	set rs.activeconnection=nothing	
	
	If request("lstUser").count Then
		
		For i = 1 to request("lstUser").count

		sResults = request("lstUser") (i)
		
		If request.form("chkUser") = "User" Then
			
			sql = "SELECT * FROM [tblAuthorized] WHERE tblAuthorized.sUser_Name='" & sResults & "'"
			sql = sql & " AND tblAuthorized.iAuthorized=" & iLoc

		REM//		Remove developer		
		Else

			sql = "SELECT * FROM [tblDevelopers] WHERE tblDevelopers.sUser_Name='" & sResults & "'"
			sql = sql & " AND tblDevelopers.sProject='" & request.form("lstProject") & "' And tblDevelopers.sProgram='" & request.form("lstProgram") & "'"		
		
		End If
		
		Set rs = Server.CreateObject("ADODB.Recordset")
		rs.Open sql, conn, 3, 3
		
		if rs.eof <> True And InStr(LCase(sResults), "readj") = 0 Then
		
		do while rs.eof <> True
			rs.delete
			rs.update
			rs.movenext
		loop
		
		
		If request.form("chkUser") = "User" Then
		
			rs.Close
			set rs.activeconnection=nothing		
			
		End If
		
		If request.form("chkUser") = "User" Then
			
			sql = "SELECT * FROM [tblAuthorized] WHERE tblAuthorized.sUser_Name='" & sResults & "'"
		
		Set rs = Server.CreateObject("ADODB.Recordset")
		rs.Open sql, conn, 3, 3
		
		If rs.eof = True Then
			
			rs.Close
			set rs.activeconnection=nothing
			sql = "SELECT * FROM [tblUsers] WHERE tblUsers.sUser_Name='" & sResults & "'"
			Set rs = Server.CreateObject("ADODB.Recordset")
			rs.Open sql, conn, 3, 3
			
			do while rs.eof <> True
				rs.delete
				rs.update
				rs.movenext
			loop
		
		End If
	
		End If
		
	
		If i <> request("lstUser").count Then
			
			rs.Close
			set rs.activeconnection=nothing
		
		End If
	
		
		sError_Message = sError_Message & "User '" & sResults & "' has been removed successfully.<BR>"
		
		Else
		
		sError_Message = sError_Message & "Unable to remove user " & sResults & "!<BR>"
		
		End If

		
		Next
	
	End If
	
	
REM//		Authorize User

Case "Authorize User"

	If request("lstUser").count Then
		
		For i = 1 to request("lstUser").count

		sResults = request("lstUser") (i)
		rs.addnew
		rs("sUser_Name") = sResults
		
		If request.form("chkUser") = "User" Then
			
			rs("iAuthorized") = iLoc
			
		REM//		Add Developer
		Else
			rs("sProject") = request.form("lstProject")
			rs("sProgram") = request.form("lstProgram")
			
		End If
		
		rs.update
	
		sError_Message = sError_Message & "User(s) '" & sResults & "' has been added successfully.<BR>"
	
		Next
	
	End If


Case "Report"
	sMessage = "Bug Status Report: " + request.form ("txtStart") + " to " + request.form ("txtEnd") + "<BR><FONT COLOR=GREEN>"
	
	if (request.form("lstUser") <> "") then
		
		'Submittor Report
		if (request.form("chkUser") = "User") then
			sMessage = sMessage & " Bugs Posted By-<BR><FONT COLOR='#000080'>"
			
			For i = 1 to request("lstUser").count
				sql = "SELECT * FROM tblUsers WHERE sUser_Name='" & request("lstUser") (i) & "'"
				Set rs = Server.CreateObject("ADODB.Recordset")
				rs.Open sql, conn, 3, 3
				sMessage = sMessage &  rs("sFirst_Name") & " " & rs("sLast_Name") & "<BR>"
				rs.Close
			Next
				set rs.activeconnection=nothing
				
		'Developer Report	
		else
			sMessage = sMessage & " Bugs Assigned To-<BR><FONT COLOR='#000080'>"
			
			For i = 1 to request("lstUser").count
				sql = "SELECT * FROM tblUsers WHERE sUser_Name='" & request("lstUser") (i) & "'"
				Set rs = Server.CreateObject("ADODB.Recordset")
				rs.Open sql, conn, 3, 3
				sMessage = sMessage &  rs("sFirst_Name") & " " & rs("sLast_Name") & "<BR>"
				rs.Close
			Next
				set rs.activeconnection=nothing
						
		end if	

	'Program Report	
	elseif (request.form("lstProgram") <> "") then
		sMessage = sMessage & request.form("lstProject") & " Project/ " & request.form("lstProgram") & " Program"

	
	'Custom user report
	elseif (request.form("CustomReport") = "true") then
		if (request.form("chkUser") = "User") then
			sMessage = sMessage & " Bugs Posted By-" & session("sFirst_Name") & " " & session("sLast_Name") & "<BR><FONT COLOR='#000080'>"
		else
			sMessage = sMessage & " Bugs Assigned To-" & session("sFirst_Name") & " " & session("sLast_Name") & "<BR><FONT COLOR='#000080'>"
		end if


	'Project Report			
	else
		sMessage = sMessage & request.form("lstProject") & " Project"
	
	end if


	Dim sMessage1
	sMessage1 = sMessage & "<FONT COLOR=BLACK>"
	
	if (request("chkReportType") = "Daily") then sMessage = sMessage + "<BR><FONT COLOR=BLACK><IMG SRC='./images/reports/red.gif' HEIGHT=10 WIDTH=10 BORDER=1> <IMG SRC='./images/reports/green.gif' HEIGHT=10 WIDTH=10 BORDER=1> &nbsp;Bugs Submitted&nbsp;&nbsp;&nbsp;" + _
		              "<IMG SRC='./images/reports/yellow.gif' HEIGHT=10 WIDTH=10 BORDER=1> <IMG SRC='./images/reports/blue.gif' HEIGHT=10 WIDTH=10 BORDER=1> &nbsp;Bugs Completed<BR><BR>"


REM//		Unsupported type

Case Else


	sError_Message = "Unable to complete operation.  If problem persists please contact administrator"


End Select


if (request.form("txtType") <> "Report") then

	rs.Close
	set rs.activeconnection=nothing

end if

End If


Conn.close

REM//		Include files to display
REM//		results of process


imgTitle = ""

if sMessage = "" then sMessage = "<FONT COLOR='#C00000'>" + sError_Message + "</FONT>"
%>



<!-- #include file="header.inc" -->

<%if (request.form("txtType") <> "Report" or sError_Message <> "") then

if (request.form("CustomReport") <> "true") then	
%>

<!-- #include file="site_admin_form.inc" -->

<% else 


sql = "SELECT * FROM tblBugs b, tblBug_ID i, tblUsers u WHERE (b.sBug_ID = i.sBug_ID) "
sql = sql + " AND b.iPosted_By = u.iID "
sql = sql + "AND b.bOriginal=True "
sql = sql + "AND u.sUser_Name = '" + session ("sUser_Name") + "' "
		
If session("sProject") <> "Management" Then
		
	sql = sql & "AND i.sProject='" & session("sProject") & "'"	
		
End If
	
sql = sql & "AND (b.sBug_ID NOT IN (SELECT sBug_ID FROM tblBugs WHERE dtDateEnd = #1/1/1899# AND sStatus='Closed'))"
		
sql = sql & " ORDER BY b.sBug_ID, b.dtDate DESC"

%>
<!-- #include file='user_report_form.inc' -->

<!-- #include file="show_bugs.inc" -->

<%
end if


'Create report

else
%>

<!-- #include file="create_report.inc" -->

<%
end if
%>
