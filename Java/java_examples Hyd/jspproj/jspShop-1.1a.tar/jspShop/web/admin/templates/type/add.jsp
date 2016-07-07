  <p align="center"><font size="4"><b>Add New Type<br>
    </b></font></p>
  <form name="addClass" method="post" action="<%= request.getContextPath() + "/admin/types.jsp" %>">
  <input type="hidden" name="mode" value="create">
  <div align="center">
    <table width="45%" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td width="51%"> 
          <div align="right">TypeName:</div>
        </td>
        <td width="49%"> 
          <input type="text" name="name">
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
