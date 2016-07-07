<%@ taglib uri="typenametags" prefix="typeName" %>  
  <%
  if (request.getParameter("typeID") != null)
  {
  %>
      <form name="addClass" method="post" action="<%= request.getContextPath() + "/admin/types.jsp" %>">
      <input type="hidden" name="mode" value="changeType">
      <div align="center">
      <p>&nbsp;</p>
      <p>&nbsp;</p>
        <table width="80%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td width="38%"> 
              <div align="right">TypeName:</div>
            </td>
            <td width="62%" align="left"> 
              <typeName:get id="type" typeID="<%=request.getParameter(\"typeID\") %>" />
              <input type="text" name="name" value="<%= type.getName() %>">
              <input type="hidden" name="typeID" value="<%= type.getID() %>">
              <input type="submit" name="Submit" value="Modify">
              
            </td>        
          </tr>
        </table>
      </div>
      </form>
  <%
  }
  else
  {
  %>
  There is no type selected, please select a type from the list on the left. (You need to double-click a type in order to select it.)
  <%
  }
  %>
