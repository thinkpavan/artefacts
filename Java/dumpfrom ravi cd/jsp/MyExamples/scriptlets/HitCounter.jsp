<html>
<body>
<h1> Hit Counter </h1>
<%! int i=0;
void increment(){
	i++;
	}
%>
<% increment(); %>
<h1>No.of Hits for This Page is<%=i%></h1>
</body>
</html>
