<%
	Boolean islogin=(Boolean)session.getValue("islogin");
	 boolean bool=islogin.booleanValue(); %>
	<%= bool %>
	<%if(islogin.booleanValue()!=true){
	throw (new Exception("My Security Exception"));
	}%>

		