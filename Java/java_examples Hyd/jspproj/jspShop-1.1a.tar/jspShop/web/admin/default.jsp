<%@ taglib uri="logintags" prefix="login" %>

<%
    Long userID = (Long)session.getAttribute("jspShop.userID");
    String url = "/admin/objects.jsp";
    
    if (request.getParameter("Submit") != null)
    {
        %>
            <login:login email="<%= request.getParameter(\"username\") %>" password="<%=request.getParameter(\"password\") %>" />
        <%
        if (validLogin.booleanValue())
        {
            %>
            <jsp:forward page="<%= response.encodeURL(url) %>" />
            <%
        }
        else
        {
            out.println("Invalid Login.<BR>");
        }
    }
%>

<html>
    <head>
        <title>
            Administrative Login
        </title>
    </head>
    <body>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <div align="center">        
            <form method="post" action="" name="login">
                Username: <input type="text" name="username" value=""><br>
                Password: <input type="password" name="password" value=""><br>
                <input type="submit" name="Submit" value="Submit">            
            </form>
        </div>
    </body>
</html>
