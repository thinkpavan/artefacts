<html>

<head>

</head>

<body>

<script runat=server language="VBScript">

sub write()
	'On Error resume next
	set theList = createobject("Scripting.FileSystemObject")
	set NewFile = theList.OpenTextFile("c:\web stuff\bug\images\b1.jpg", , True)
	test = NewFile.ReadAll
	response.write test
	NewFile.Close
	
end sub

</script>

<%

'write()

response.write( "pixels: " & request.servervariables("http_ua_pixels")) 


for each item in request.servervariables
	for x = 1 to request.servervariables(item).count %>
		<%= item & " = " & request.servervariables(item) (x) %> <BR>
	<% Next
Next
%>
<BR>

</body>

</html>

<%session("sRedirect") = "No"%>