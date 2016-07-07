  <p align="center"><font size="4"><b>Add New Class<br>
    </b></font></p>
  <form name="addClass" method="post" action="<%= request.getContextPath() + "/admin/classes.jsp" %>">
  <input type="hidden" name="mode" value="create">
  <input type="hidden" name="path" value="<%=request.getParameter("path")%>">
  <input type="hidden" name="inheritedFrom" value="<%=request.getParameter("className")%>">
  <div align="center">
    <table width="45%" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td width="51%"> 
          <div align="right">Inheriting from:</div>
        </td>
        <td width="49%"><%=request.getParameter("className") %></td>
      </tr>
      <tr> 
        <td width="51%"> 
          <div align="right">ClassName:</div>
        </td>
        <td width="49%"> 
          <input type="text" name="className">
        </td>
      </tr>
      <tr> 
        <td width="51%"> 
          <div align="right">Description:</div>
        </td>
        <td width="49%"> 
          <input type="text" name="description">
        </td>
      </tr>
      <tr>
        <td width="51%">&nbsp;</td>
        <td width="49%"> 
          <input type="submit" name="Submit" value="Submit">
        </td>
      </tr>
    </table>
  </div>
  </form>
  <p align="center"><font size="4"><b> </b></font></p>
