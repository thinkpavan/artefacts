<%
	

REM//		Message to be returned to user
REM//		in case of error or other

sError_Message = ""
	
	

REM//		User selects to remove selected
REM//		user defined search from db

If request.form("txtType") = "Remove" Then
	

	sql = "SELECT * FROM [tblBug_Search]"
	sql = sql & "WHERE tblBug_Search.sUser_Name='" & session("sUser_Name") & "'"
	sql = sql & " AND tblBug_Search.sSearch_Name='" & request.form("lstUser_Favorite") & "'"
	Set rs = Server.CreateObject("ADODB.Recordset")
	Set Conn = Server.CreateObject("ADODB.Connection")
	Conn.Open "bugs", , ""
	rs.Open sql, conn, 3, 3
	
	If rs.eof <> True Then
		
		rs.delete
		rs.update
		sError_Message = "User Search " & request.form("lstUser_Favorite") & " removed successfully."
		
	Else
		
		sError_Message = "Invalid User Search Selection."
		
	End If
	
	session("sUser_Search") = "Please Make A Selection"
	rs.close
	conn.close
	
	
	
REM//		User selects GO!

Else


REM//		Check for errors in search
REM//		criteria

REM//		Error #1 If User selects 'No Criteria'
REM//		and some other option in list boxes
REM//		or user selects 'No Criteria' and 'Not'

For x = 0 To 6

	If InStr(request.form("lst" & sList_a(x)), "No Criteria") <> 0 And InStr(request.form("lst" & sList_a(x)), ", ") <> 0 Then
		sError_Message = sError_Message & "<BR>" & sList_a(x) & " error: 'No Criteria' cannot be selected in conjunction with another option in that same catagory."
	End If

	If InStr(request.form("lst" & sList_a(x)), "No Criteria") <> 0 And request.form("chk" & sList_a(x)) = "True" Then
		sError_Message = sError_Message & "<BR>" & sList_a(x) & " error: 'No Criteria' cannot be selected in conjunction with the 'Not' value."
	End If
	
Next


REM//		Error #2 If User selects 'Not'
REM//		leaves text field blank

For x = 0 To 3

	If x < 2 And LTrim(RTrim(request.form("txt" & sText_a(x)))) = "" And request.form("chkDates") = "True" Then
		sError_Message = sError_Message & "<BR>" & sText_a(x) & " error: You must enter a value to use the 'Not' value"
				
	ElseIf LTrim(RTrim(request.form("txt" & sText_a(x)))) = "" And request.form("chk" & sText_a(x)) = "True" Then
		sError_Message = sError_Message & "<BR>" & sText_a(x) & " error: You must enter a value to use the 'Not' value"

	End If

Next


REM//		Error #3 User inputs invalid dates
%>

<Script Language="VBScript" RUNAT="Server">
Function Test_Dates(sStart, sEnd)

If sStart <> "" or sEnd <> "" Then

	On Error Resume Next
	sTest = DateValue(request.form("txtDate_Start")) & " : " & DateValue(request.form("txtDate_End"))
	If sTest = "" Then Test_Dates = "<BR>Date error: Invalid Date Formats!"
	
End If

End Function
</Script>

<%

sError_Message = sError_Message & Test_Dates(request.form("txtDate_Start"), request.form("txtDate_End"))



REM//		User selects to add current
REM//		search criteria to favorites

If request.form("txtType") = "Add" or request.form("txtType") = "Update" And sError_Message = "" Then


	If request.form("txtUser_Favorite") = "" And request.form("txtType") <> "Update" Then sError_Message = "Please enter a Search Name."
	
	If request.form("lstUser_Favorite") = "Please Make A Selection" And request.form("txtType") = "Update" Then sError_Message = "Cannot Update, invalid User Search!"
	
	
	If sError_Message = "" Then
	
	
	If request.form("txtType") = "Update" Then
		sType = request.form("lstUser_Favorite")
		sError_Message = "User search " & sType & " updated successfully."
	Else
		sType = request.form("txtUser_Favorite")
		sError_Message = "User search " & sType & " added successfully."
	End If
	
	
	sql = "SELECT * FROM [tblBug_Search]"
	sql = sql & "WHERE tblBug_Search.sUser_Name='" & session("sUser_Name") & "'"
	sql = sql & " AND tblBug_Search.sSearch_Name='" & sType & "'"
	Set rs = Server.CreateObject("ADODB.Recordset")
	Set Conn = Server.CreateObject("ADODB.Connection")
	Conn.Open "bugs", , ""
	rs.Open sql, conn, 3, 3
	
	If rs.eof = True Then rs.addnew
	
	rs("sUser_Name") = session("sUser_Name")
	rs("sSearch_Name") = sType
	rs("sQuerystring") = Request.Form

	rs.update
	rs.close
	conn.close
	
	session("sUser_Search") = sType
	
	End If



REM//		If no error have occurred then SQL Statement is
REM//		created for bug search

ElseIf sError_Message = "" And (InStr(request("txtType"), "Go") <> 0 or InStr(request("txtType"), "GO") <> 0) Then
%>	


<!-- #include file="create_sql.inc" -->
	

<%
End If


End If



If sError_Message <> "" Then


REM//		Include files to display
REM//		results of process

imgTitle = ""
sMessage = sError_Message
%>


<!-- #include file="header.inc" -->

<!-- #include file="bug_search_form.inc" -->



<% End If %>
