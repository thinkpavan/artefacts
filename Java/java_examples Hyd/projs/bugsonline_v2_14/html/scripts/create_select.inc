<%
sql = "none"

REM//		Open DB Connection

Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "bugs", , ""


REM//		Select Create Type

Select Case iSelect_Type

	REM//	Project Select Box
	Case 1, 4, 5, 14
	
	If iSelect_Type = 1 or iSelect_Type = 14 Then %>
	
	<SELECT NAME="lstProject" SIZE=
	
	<%
	response.write iSelect_Size
	
	If iChange <> 1 Then %>
	
	OnChange="change_project()"
	
	<% 
	End If
 

	If iMultiple=1 Then response.write " MULTIPLE" %>>
	
	
	<%
	If iSelect_Type = 14 Then
 	%>
 		
 	<OPTION<% If request("lstProject") = "" or request("lstProject") = "Management" or request("lstProject") = "No Criteria" Then response.write " SELECTED " %>>No Criteria</OPTION>
 	
 	<%
 	End If
	
	
	ElseIf iSelect_Type = 4 Then %>
	
	<SELECT NAME="lstProject" SIZE=<%=iSelect_Size %><% If iMultiple=1 Then response.write " MULTIPLE" %>><%
	response.write "<OPTION>Please make a selection...</OPTION>"
		
	
	Else
	
	End If

	sql = "SELECT * FROM [tblProjects]"
	sSelected = sProject
	sColumn_Name = "sProject_Name"
	
	
	REM//	Program Select Box
	Case 2, 12
	%>
	<SELECT NAME="lstProgram" SIZE=
	
	<%
	response.write iSelect_Size
	
	If iChange <> 1 Then %>
	
	OnChange="change_project()"
	
	<% 
	End If 
	
	If iMultiple=1 Then response.write " MULTIPLE" %>>
	
	<%
	If sProject = "" or sProject = "Please make a selection..." Then 
		response.write "<OPTION>Select a project...</OPTION>"
	Else

	If iSelect_Type = 12 Then 
		response.write "<OPTION"
	 	If sProgram = "" or sProgram = "No Criteria" or request("lstProject") = "" or request("lstProject") = "No Criteria" or request("lstProject") = "Management" Then response.write " SELECTED"
		response.write ">No Criteria</OPTION>"	
	End If

		sql = "SELECT tblPrograms.sProgram "
		sql = sql & "FROM tblProjects INNER JOIN tblPrograms ON tblProjects.iProject_ID = tblPrograms.iProject_ID "
		sql = sql & "WHERE tblProjects.sProject_Name='" & sProject & "'"
		sSelected = sProgram
		sColumn_Name = "sProgram"
	End If
	
	
	REM//	Area Select Box
	Case 3, 11
	%>
	<SELECT NAME="lstArea" SIZE=<%=iSelect_Size %><% If iMultiple=1 Then response.write " MULTIPLE" %>>	
	<%
	
	If iSelect_Type = 11 Then 

		response.write "<OPTION"
	 	If sArea = "" or sArea = "No Criteria" or sProgram = "No Criteria" or sProgram = "" or request("lstProject") = "" or request("lstProject") = "No Criteria" or request("lstProject") = "Management" Then response.write " SELECTED"
		response.write ">No Criteria</OPTION>"	
	
	End If
	

	If sProgram = "" And iSelect_Type <> 11 or sProgram = "Select a project..." And iSelect_Type <> 11 Then 

		response.write "<OPTION>Select a program...</OPTION>"

	Else
		
		sql = "SELECT * FROM [tblProjects] WHERE tblProjects.sProject_Name = '" & sProject & "'"
		Set rs = Server.CreateObject("ADODB.Recordset")
		rs.Open sql, conn, 3, 3
		
		If rs.eof <> True Then

			iLoc = rs("iProject_ID")
	
			rs.Close
			set rs.activeconnection=nothing
		
			sql = "SELECT tblAreas.sArea "
			sql = sql & "FROM tblPrograms INNER JOIN tblAreas ON tblPrograms.iProgram_ID = tblAreas.iProgram_ID "


	REM//		Create sql statement for all selected 
	REM//		Programs

			iStart = 5
			
			If request("lstProgram").count Then
		
				For i = 1 to request("lstProgram").count
				
					If iStart = 5 Then
						sql = sql & "WHERE tblPrograms.sProgram='" & request("lstProgram") (i) & "'"
						iStart = 0

					Else
						sql = sql & " OR tblPrograms.sProgram='" & request("lstProgram") (i) & "'"
					End If
				
				Next
			
			Else
			
				sql = "none"
			
			End If
			
			
			If sql <> "none" Then
				
				sql = sql & " And tblPrograms.iProject_ID = " & iLoc
				sSelected = sArea
				sColumn_Name = "sArea"
				
				If request("lstProject") = "Management" or request("lstProject") = "No Criteria" Then sql = "none"
			End If
		Else
			sql = "none"
		End If
	End If
	
	
	REM//	Project Users Select Box
	Case 6, 7
	%>
	<SELECT NAME="lstUser" SIZE=<%=iSelect_Size %><% If iMultiple=1 Then response.write " MULTIPLE" %>>	
	<%
	If sProject = "" or sProject = "No Records!" Then 
		response.write "<OPTION>Select a project...</OPTION>"

	ElseIf (sProgram = "" or sProgram = "Select a project..." or sProgram="No Records!") And request("chkUser") = "Developer" Then 
		response.write "<OPTION>Select a program...</OPTION>"

	Else
	
	
	If request("chkUser") = "User" Then
			
		sql = "SELECT * FROM [tblProjects] WHERE tblProjects.sProject_Name = '" & sProject & "'"
		Set rs = Server.CreateObject("ADODB.Recordset")
		rs.Open sql, conn, 3, 3
		
		If rs.eof <> True Then
			iLoc = rs("iProject_ID")
	
			rs.Close
			set rs.activeconnection=nothing
		
			sql = "SELECT tblUsers.sUser_Name "
			sql = sql & "FROM tblUsers INNER JOIN tblAuthorized ON tblUsers.sUser_Name = tblAuthorized.sUser_Name "
			sql = sql & "WHERE tblAuthorized.iAuthorized=" & iLoc			
			
			
			If iSelect_Type = 7 Then
				
				Set rs = Server.CreateObject("ADODB.Recordset")
				rs.Open sql, conn, 3, 3

				sql = "SELECT tblUsers.sUser_Name "
				sql = sql & "FROM tblUsers INNER JOIN tblAuthorized ON tblUsers.sUser_Name = tblAuthorized.sUser_Name "
				sql = sql & "WHERE tblAuthorized.iAuthorized<>" & iLoc
				sql = sql & " AND tblAuthorized.sUser_Name<>'TestCase'"
				
				do while  rs.eof <> True
					sql = sql & " AND tblAuthorized.sUser_Name<>'" & rs("sUser_Name") & "'"
					rs.movenext
				loop
		
				rs.Close
				set rs.activeconnection=nothing
				
			End If
			
			
			sql = sql & " ORDER BY tblUsers.sUser_Name"
			
			sSelected = request("lstUser")
			sColumn_Name = "sUser_Name"
		Else
			sql = "none"
		End If

	REM//		Program Developers
			
	Else

		sql = "SELECT tblUsers.sUser_Name "
		sql = sql & "FROM tblUsers INNER JOIN tblDevelopers ON tblUsers.sUser_Name = tblDevelopers.sUser_Name "
		sql = sql & "WHERE tblDevelopers.sProject='" & sProject & "' AND tblDevelopers.sProgram='" & sProgram & "'"			
			
			
		If iSelect_Type = 7 Then
				
			Set rs = Server.CreateObject("ADODB.Recordset")
			rs.Open sql, conn, 3, 3

			sql = "SELECT tblUsers.sUser_Name "
			sql = sql & "FROM tblUsers INNER JOIN tblDevelopers ON tblUsers.sUser_Name = tblDevelopers.sUser_Name "
			sql = sql & "WHERE tblDevelopers.sUser_Name<>'TestCase'"
				
			do while  rs.eof <> True
				sql = sql & " AND tblDevelopers.sUser_Name<>'" & rs("sUser_Name") & "'"
				rs.movenext
			loop
		
			rs.Close
			set rs.activeconnection=nothing
		
		End If	
	
			sql = sql & " ORDER BY tblUsers.sUser_Name"
	
			sSelected = request("lstUser")
			sColumn_Name = "sUser_Name"

	End If

	End If


	
	REM//		All Project Users
	
	Case 8
	%>
	<SELECT NAME="lstUser" SIZE=<%=iSelect_Size %><% If iMultiple=1 Then response.write " MULTIPLE" %>>
	<OPTION<% If request("lstUser") = "" or request("lstUser") = "No Criteria" Then response.write " SELECTED"%>>No Criteria</OPTION>
	<%
	
	sql = "SELECT tblUsers.sFirst_Name, tblUsers.sLast_Name "
	sql = sql & "FROM tblUsers"
	sql = sql & " ORDER BY tblUsers.sLast_Name"
			
	sSelected = request("lstUser")
	sColumn_Name = "sFirst_Name"
	sColumn_Name1 = "sLast_Name"
		
			
	REM//		All Project Developers
	
	Case 9, 10
	%>
	<SELECT NAME="lstAssigned" SIZE=<%=iSelect_Size %><% If iMultiple=1 Then response.write " MULTIPLE" %>>
	<%
	If iSelect_Type = 9 Then
	%>
	<OPTION>Please Make A Selection</OPTION>
	
	<% Else %>
	
	<OPTION<% If request("lstAssigned") = "" or request("lstAssigned") = "No Criteria" Then response.write " SELECTED"%>>No Criteria</OPTION>
	<OPTION<%If InStr(request("lstAssigned"), "Assigned") <> 0 Then response.write " SELECTED"%>>Assigned</OPTION>

	<% End If %>
	
	<OPTION<%If InStr(request("lstAssigned"), "Not Assigned") <> 0 Then response.write " SELECTED"%>>Not Assigned</OPTION>
	
	<%	
	If request("lstProject") <> "" Then lstProject = request("lstProject")
	
	
	sql = "SELECT tblUsers.sFirst_Name, tblUsers.sLast_Name "
	sql = sql & "FROM tblUsers INNER JOIN tblDevelopers ON tblUsers.sUser_Name = tblDevelopers.sUser_Name "
	sql = sql & "WHERE (tblDevelopers.sProject='" & lstProject & "')"
	
	If request("lstProgram").count And InStr(request("lstProgram"), "No Criteria") = 0 Then
	
		For i = 1 to request("lstProgram").count
	
			If i = 1 Then
				
				sql = sql & " AND (tblDevelopers.sProgram='" & request("lstProgram") (i) & "'"
				
			Else
			
				sql = sql & " OR tblDevelopers.sProgram='" & request("lstProgram") (i) & "'"
				
			End If
			
		Next
		
		sql = sql & ")"
		
	ElseIf iSelect_Type <> 9 Then
	
		sql = sql & " AND (tblDevelopers.sProgram<>'***none***')"
		
	ElseIf lstProgram <> "" And iSelect_Type = 9 Then
		
		sql = sql & " AND (tblDevelopers.sProgram='" & lstProgram & "')"
		
	Else
		sql = "none"
	
	End If

	
	If sql <> "none" Then

		sql = sql & " ORDER BY tblUsers.sLast_Name"
			
		sSelected = request("lstAssigned")
		sColumn_Name = "sFirst_Name"
		sColumn_Name1 = "sLast_Name"
	
	End If
	
	
	REM//		User Defined Searches
	
	Case 13
	%>
	<SELECT NAME="lstUser_Favorite" SIZE=<%= iSelect_Size %> OnChange="submit_form('ReLoad')"<% If iMultiple=1 Then response.write " MULTIPLE"%>>
	
	<OPTION>Please Make A Selection</OPTION>
	
	<%
	sql = "SELECT * FROM [tblBug_Search] "
	sql = sql & "WHERE tblBug_Search.sUser_Name='" & session("sUser_Name") & "'"
	If session("sUser_Search") <> "" Then 
		sSelected = session("sUser_Search")
	Else
		sSelected = request("lstUser_Favorite")	
	End If
	sColumn_Name = "sSearch_Name"
	
	
End Select


If sql <> "none" Then

REM//		Open db to populate array

Set rs = Server.CreateObject("ADODB.Recordset")
rs.Open sql, conn, 3, 3

If rs.eof = True Then
	
	If iSelect_Type <> 5 And iSelect_Type <> 8 And iSelect_Type <> 10 And iSelect_Type <> 11 And iSelect_Type <> 12 And iSelect_Type <> 13 And iSelect_Type <> 9 Then
	
	response.write "<OPTION>No Records!</OPTION>"
	iSelect_Type = 10
	
	End If

Else

Do While rs.eof <> True


REM//		Determine if item has already been listed

If iSelect_Type <> 5 And InStr(sDisplayed, rs(sColumn_Name)) = 0 Then 
	sDisplayed = sDisplayed & rs(sColumn_Name)


REM//		Only list one rs column

If sColumn_Name1 = "" Then
%>

<OPTION<% If InStr(sSelected, rs(sColumn_Name)) <> 0 And iSelect_Size > 1 Then response.write " SELECTED"%> _ 
<% If sSelected = rs(sColumn_Name) And iSelect_Size = 1 Then response.write " SELECTED"%>><%=rs(sColumn_Name)%></OPTION>


<%
REM//		Shows two columns

Else 
%>

<OPTION<% If InStr(sSelected, rs(sColumn_Name) & " " & rs(sColumn_Name1)) <> 0 Then response.write " SELECTED"%>><%=rs(sColumn_Name) & " " & rs(sColumn_Name1)%></OPTION>

<% 
End If


REM//		Create Checkboxes (when iSelect_Type = 5

ElseIf iSelect_Type = 5 Then %>

<INPUT NAME="chk<%=rs(sColumn_Name)%>" TYPE="checkbox"<% If request("chk" & rs(sColumn_Name)) = "True" Then response.write " Checked"%> VALUE="True"><%=rs(sColumn_Name) & "  "%>


<% End If

rs.movenext
loop

End If

rs.Close
set rs.activeconnection=nothing
Conn.close

End If

iMultiple = 0
iChange = 0
sDisplayed = ""
sColumn_Name1 = ""
%>


</SELECT>