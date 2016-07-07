<%@ taglib uri="objecttags" prefix="object" %>
<%@ taglib uri="classtags" prefix="class" %>

<p align="center"><font size="4"><b>Add New Object<br>
  </b></font></p>
<form name="addObject" method="post" action="<%= request.getContextPath() + "/admin/objects.jsp" %>">
  <input type="hidden" name="mode" value="create">
  <input type="hidden" name="path" value="<%=request.getParameter("path")%>">
  <input type="hidden" name="parentID" value="<%=request.getParameter("objectID")%>">
  <div align="center"> 
    <table width="45%" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td width="51%"> 
          <div align="right">Parent:</div>
        </td>
        <object:get id="newObject" objectID="<%= request.getParameter(\"objectID\") %>"/>
        <td width="49%"><%= newObject.getName() %></td>
      </tr>
      <tr> 
        <td width="51%"> 
          <div align="right">Class:</div>
        </td>
        <td width="49%"> 
          <select name="className">
            <option value="-1" selected>Select Class</option>
            <class:iterate id="newClass">
                <option value="<%= newClass.getID() %>"><%= newClass.getID() %></option>            
            </class:iterate>
          </select>
        </td>
      </tr>
      <tr> 
        <td width="51%"> 
          <div align="right">Name:</div>
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
