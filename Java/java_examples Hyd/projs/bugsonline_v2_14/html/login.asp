<%
REM//		Declare Variables

Dim sUser_Name
Dim sPassword
Dim sProject
Dim iChange_Password
Dim iAuthorized


REM//		Assign Variables

sUser_Name = request.form("txtUser_Name")
sPassword = request.form("txtPassword")
sProject = request.form("lstProject")
If request.form("chkChange") = "yes" Then iChange_Password = 1


REM//		Error in entry

If sUser_Name = "" or sPassword = "" Then
	session("sLogin_Error") = "Please fill in all fields!"
	response.redirect "index.asp"
ElseIf sProject = "Please make a selection..." Then
	session("sLogin_Error") = "Please select a project..."
	response.redirect "index.asp"
End If


REM//		Connect to database

Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "bugs", , ""
sql = "SELECT * FROM [tblUsers] "
sql = sql + "WHERE tblUsers.sUser_Name='" & sUser_Name & "' AND tblUsers.sPassword='" & sPassword & "'"
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3


REM//		User not found

If rs.eof = True Then 
	session("sLogin_Error") = "Invalid user name or password!"


REM//		User found  :  Store user info in session variables

Else
	session("sFirst_Name") = rs("sFirst_Name")
	session("sLast_Name") = rs("sLast_Name")
	session("dtLogin_Date") = rs("dtLogin_Date")
	session("sUser_Name") = sUser_Name
	session("sProject") = sProject
	rs("dtLogin_Date") = Date + Time
	rs.update

End If


REM//		Close database connection

rs.Close
set rs.activeconnection=nothing
Conn.close


REM//		Check for user authorization into selected project via database

Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "bugs", , ""

sql = "SELECT tblAuthorized.sUser_Name, tblAuthorized.iID, tblProjects.iProject_ID, tblProjects.sProject_Name, tblAuthorized.iAuthorized "
sql = sql & "FROM tblProjects INNER JOIN tblAuthorized ON tblProjects.iProject_ID = tblAuthorized.iAuthorized "
sql = sql & "WHERE tblAuthorized.sUser_Name='" & sUser_Name & "'"
Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3

Dim iFound
Do while rs.eof <> True And iFound <> 1

	If rs("sProject_Name") = sProject Then
		iAuthorized = rs("iAuthorized")
		session("iAuthorized") = rs("iAuthorized")
		iFound = 1
	Else
		rs.movenext
	End If
	
Loop


REM//		User not authorized

If iFound <> 1  Then session("sLogin_Error") = "User not authorized to access project!"


REM//		Close database connection

rs.Close
set rs.activeconnection=nothing
Conn.close



REM//		Error occurs in login  :  User returned to login screen

If session("sLogin_Error") <> "" Then

	session ("sUser_Name") = sUser_Name
	session ("sPassword") = sPassword
	response.redirect "index.asp"

Else


REM//		Login OK

session("authorized") = "True"


REM//		User selects to change password

If iChange_Password = 1 Then response.redirect "change_password.asp"


REM//		User forwarded to site (if login OK)


response.cookies("sUser_Name") = request.form("txtUser_Name")
response.cookies("sUser_Name").Expires = #1/1/1999 23:59:59#
response.redirect "bug_index.asp"

End If
%>