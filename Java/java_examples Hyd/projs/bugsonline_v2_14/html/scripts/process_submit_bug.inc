<%
REM//		Define Variables
sBug_ID = request.querystring("iBug_ID")			'//Number representing specific bug (if any)
sBug_ID = LTrim(RTrim(sBug_ID))

If sBug_ID = "" Then


REM//		Check Form for Input Errors

If request.form("lstProgram") = "No Records!" Or request.form("lstProgram") = "" Then
	sError_Message = "Please select a valid program..."

ElseIf request.form("lstArea") = "Please select a program..." Or request.form("lstArea") = "No Records!" Or request.form("lstArea") = "" Then
	sError_Message = "Please select a valid program area..."

ElseIf LTrim(RTrim(request.form("txtDescription"))) = "" Then
	sError_Message = "Please enter a Bug Title"
	
End If

End If


If (request.form("lstAssigned") = "Please Make A Selection" Or request.form("lstAssigned") = "") And (request.form("lstStatus") <> "Closed") AND (request.form("lstStatus") <> "Completed")   Then
	sError_Message = "Please make a valid selection in the Assigned Field..."
	
ElseIf request.form("lstStatus") = "Please Make A Selection" Or request.form("lstStatus") = "" Then
	sError_Message = "Please make a valid selection in the Status Field..."
	
ElseIf request.form("lstPriority") = "Please Make A Selection" Or request.form("lstPriority") = "" Then
	sError_Message = "Please make a valid selection in the Priority Field..."
	
ElseIf request.form("lstSeverity") = "Please Make A Selection" Or request.form("lstSeverity") = "" Then
	sError_Message = "Please make a valid selection in the Severity Field..."
		
ElseIf Len(LTrim(RTrim(request.form("txtComments")))) < 15 And request.form("lstStatus") <> "Closed" And request.form("lstStatus") <> "Completed" Then
	sError_Message = "You must add a Detail Description..." & request.form("txtComments1")
	
ElseIf request.form("lstAssigned") = "Not Assigned" And request.form("lstStatus") = "Assigned" Then
	sError_Message = "You cannot place a bug on assigned status without specifying who it is to be assigned to."
	
ElseIf request.form("lstAssigned") <> "Not Assigned" And request.form("lstStatus") = "Open" Then
	sError_Message = "You cannot assign a bug with an open status."
	
End If


REM//		Displays Error Message if
REM//		Error has occurred

If sError_Message <> "" Then
	
	
imgTitle = ""
sMessage = sError_Message



	REM//	Add New Bug Info
	
	If sBug_ID = "" Then

%>


<!-- #include file="submit_new_bug.inc" -->


<%
	REM//	Add Bug Detail Info

	Else
%>


<!-- #include file="add_bug_detail.inc" -->


<%
	End If



REM//		No Errors have occurred

Else

bIsNew = False

REM//		If Bug is a New Bug then Bug Header information is
REM//		inputted to database here

Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "bugs", , ""

If sBug_ID = "" Then
	
bIsNew = True	

REM//		Get bug ID
Set rs = Server.CreateObject("ADODB.Recordset")
sql = "SELECT MAX(iBugID) AS iMax FROM tblID"
rs.Open sql, conn, 3, 3 
sBug_ID = rs("iMax") + 1
rs.close

' Increment bug id
sql = "UPDATE tblID SET iBugID = iBugID + 1"
conn.execute(sql)

sql = "SELECT * FROM [tblBug_ID]" 
rs.Open sql, conn, 3, 3 
                              
rs.addnew
rs("sProject") = request.form("lstProject")
rs("sProgram") = request.form("lstProgram")
rs("sArea") = request.form("lstArea")
rs("sDescription") = request.form("txtDescription")
rs("sBug_ID") = sBug_ID
rs.update

rs.close


Else

REM//		Variable used to determine
REM//		if window should be close
REM//		ie. when adding a bug detail

iStop = 1

End If


REM//		Add Bug Detail Information to Database
sql = "UPDATE tblBugs b SET b.dtDateEnd = #" & Date + Time & "# "
sql = sql & "WHERE (b.dtDateEnd = #01/01/1899#) "
sql = sql & "AND (b.sBug_ID='" & sBug_ID & "')"
Set rs = Server.CreateObject("ADODB.Recordset")
conn.execute (sql)

sql = "SELECT * FROM [tblUsers]"
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3

iPosted_By = 0
iAssigned_To = 0
sEmail = ""

do while rs.eof <> True
	If rs("sFirst_Name") & " " & rs("sLast_Name") = request.form("lstAssigned") Then
		iAssigned_To = rs("iID")
		sEmail = rs("sEmail")
	End If
	
	If rs("sFirst_Name") = session("sFirst_Name") And rs("sLast_Name") = session("sLast_Name") Then
		iPosted_By = rs("iID")
	End If
	rs.movenext
loop
rs.close


sql = "SELECT * FROM [tblBugs]"
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3

rs.addnew
rs("sBug_ID")	= sBug_ID
rs("iPosted_By") = iPosted_By
rs("dtDate") = Date + Time
rs("iAssigned_To") = iAssigned_To
rs("iPriority") = request.form("lstPriority")
rs("sSeverity") = request.form("lstSeverity")
rs("sComments") = request.form("txtComments")
rs("sStatus") = request.form("lstStatus")
rs("bOriginal") = bIsNew

rs.update
rs.close

set rs.activeconnection=nothing
Conn.close


REM// Send e-mail if assigned
if (sEmail <> "") AND (sEmail <> "None") AND (useSMTP <> false) then

			Set Mailer = Server.CreateObject("SMTPsvg.Mailer")
			Mailer.FromName = "Bugs Online"
			Mailer.FromAddress = returnEmail  
			Mailer.RemoteHost = smtpServer
			Mailer.AddRecipient request.form("lstAssigned"), sEmail
			Mailer.Subject = "Bug #" & sBug_ID & ": Assigned to " & request.form("lstAssigned")
			Mailer.BodyText = "Bug #" & sBug_ID & " has been assigned to you by " & session("sFirst_Name") & " " & session("sLast_Name") & "." & Chr(13) & Chr(13) & "Please visit http://bugs.imalt.net to view and respond to this bug."
			If Mailer.SendMail Then
			
			Else
				Response.Write "Mail Failed"
			End If

end if


REM//		Confirm Successful
REM//		Completion of request


imgTitle = ""
sMessage = "<SCRIPT LANGUAGE='javascript'>" & NL

If iStop = 1 Then
	sMessage = sMessage & "window.opener.document.location.replace('./view_bugs.asp?iBT=8&iBug_ID=" & sBug_ID & "');" & NL & "window.close();" & NL & "</SCRIPT>" & NL
Else
	sMessage = sMessage & "document.location.replace('./view_bugs.asp?iBT=8&iBug_ID=" & sBug_ID & "');" & NL & "</SCRIPT>" & NL
End If

%>


<!-- #include file="header.inc" -->


<%
End If
%>