<%
If (session("authorized") = "" or session("authorized") = "false") Then
	if (request.querystring("sFirst_Name") <> "" and session("authorized") <> "false") then
		session("sFirst_Name") = request.querystring("sFirst_Name")
		session("sLast_Name") = request.querystring("sLast_Name")
		session("sProject") = request.querystring("sProject")
		session("authorized") = "True"
	else
		session("sLogin_Error") = "Please login first!"
		session("sRedirect") = "index.asp"
		response.redirect "destroy_frame.asp"
	end if
End If
%>