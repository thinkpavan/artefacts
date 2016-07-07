<%@ taglib uri="propertytags" prefix="propertyValue" %>
<%@ taglib uri="typetags" prefix="typeValue" %>
<%@ taglib uri="objecttags" prefix="object" %>
<%@ taglib uri="classpropertytags" prefix="classProperty" %>
<%@ taglib uri="propertytypetags" prefix="propertyType" %>

<%
/** The Object Browser
 * 
 * author Darryl Bleau (darrylbleau@submersion.com)
 * created: August 26, 2001  
*/
%>

    <%
    
    /* this if statement sets up the start of the tables to enable display of the data for this object
       it also ensures that nothing will be displayed if there is no object selected
       the matching statement to this if down lower sets up the ending of the tables,
       it also makes sure that no tags are touched if there is no object selected
    */
    if (request.getParameter("objectID") != null)
    {
    %>
      
        <% /* display object name */ %>
        <% /* display the name of this object using getName with an instance of the object with the ID we have */ %>
        <object:get id="newObject" objectID="<%= request.getParameter(\"objectID\") %>"/>
        <p><b><font size="4"><%= newObject.getName() %> (<%= newObject.getClassName() %>)</font></b></p>
        
        <% /* display header (property, property values, types, type values) with table begin */ %>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr bgcolor="00FF80"> 
                <td><b>Property</b></td>
                <td><b>Property Values</b></td>
                <td><b>Types</b></td>
                <td><b>Type Values</b></td>
            </tr>
        
        <% /* iterate properties */ %>
        <classProperty:iterate className = "<%= newObject.getClassName() %>" showInherited = "true" id="property">
        
        <% /* display property name and 'add property' box */ %>
        <tr bgcolor="00FF80">
        <form name="addvalue" method="POST" action="<%= request.getContextPath() + "/admin/objects.jsp" %>">
            <td><%= property.getName() %></td>
            <td>
                <input type="text" name="value">
                <input type="submit" name="addvalue" value="Add Value">
                <input type="hidden" name="mode" value="addPropertyValue">
                <input type="hidden" name="path" value="<%= request.getParameter("path") %>">
                <input type="hidden" name="objectID" value="<%= request.getParameter("objectID") %>">
                <input type="hidden" name="propertyID" value="<%= property.getID() %>">
            </td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </form>
        </tr>
                
            <% /* iterate property values */ %>
            <propertyValue:iterate id="propertyValue" objectID="<%= request.getParameter(\"objectID\") %>" propertyID="<%= String.valueOf(property.getID()) %>"> 
            
            <% /* if (last or only property value) */ %>
            <%
            if (!propertyValueHasNext.booleanValue())
            {
            %>
                
                <% /* display 'L' style property value line with change/remove box */ %>
                <tr bgcolor="00FF80">
                <form name="changevalue" method="POST" action="<%= request.getContextPath() + "/admin/objects.jsp" %>">
                    <td background="images/bar_s.jpg"><img src="images/bar_l.jpg" width="25" height="25"></td>
                    <td> 
                        <input type="text" name="value" value="<%= propertyValue.getValue() %>">
                        <input type="submit" name="changeValue" value="Change">
                        <input type="submit" name="removeValue" value="Remove">
                        <input type="hidden" name="mode" value="changePropertyValue">
                        <input type="hidden" name="path" value="<%= request.getParameter("path") %>">
                        <input type="hidden" name="objectID" value="<%= request.getParameter("objectID") %>">
                        <input type="hidden" name="valueID" value="<%= propertyValue.getID() %>">                    
                    </td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </form>
                </tr>
                
                <% /* iterate types */ %>
                <propertyType:iterate id="type" propertyID="<%= String.valueOf(property.getID()) %>">
                
                    <% /* if (last or only type) */ %>
                    <%
                    if (!typeHasNext.booleanValue())
                    {
                    %>
                    
                        <% /* display 'bL' style type line */ %>
                        <tr bgcolor="00FF80">
                        <form name="addtypevalue" method="POST" action="<%= request.getContextPath() + "/admin/objects.jsp" %>">
                            <td>&nbsp;</td>
                            <td background="images/bar_s.jpg"><img src="images/bar_l.jpg" width="25" height="25"></td>
                            <td><%= type.getName() %></td>
                            <td height="24">
                                <input type="text" name="value">
                                <input type="submit" name="addValue" value="Add Value">
                                <input type="hidden" name="valueID" value="<%= propertyValue.getID() %>">
                                <input type="hidden" name="typeID" value="<%= type.getTypeID() %>">
                                <input type="hidden" name="mode" value="addTypeValue">
                                <input type="hidden" name="path" value="<%= request.getParameter("path") %>">
                                <input type="hidden" name="objectID" value="<%= request.getParameter("objectID") %>">
                            </td>
                        </form>
                        </tr>
                        
                        <% /* iterate type values */ %>
                        <typeValue:iterate id="typeValue" valueID="<%= String.valueOf(propertyValue.getID()) %>" typeID="<%= String.valueOf(type.getTypeID()) %>">
                        
                            <% /* if (last or only type value) */ %>
                            <%
                            if (!typeValueHasNext.booleanValue())
                            {
                            %>
                            
                                <% /* display 'bbL' style type value line with change/remove box */ %>
                                <tr bgcolor="00FF80">
                                <form name="changetypevalue" method="POST" action="<%= request.getContextPath() + "/admin/objects.jsp" %>">
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td background="images/bar_s.jpg"><img src="images/bar_l.jpg" width="25" height="25"></td>
                                    <td> 
                                        <input type="text" name="value" value="<%= typeValue.getValue() %>">
                                        <input type="submit" name="changeValue" value="Change">
                                        <input type="submit" name="removeValue" value="Remove">
                                        <input type="hidden" name="mode" value="changeTypeValue">
                                        <input type="hidden" name="path" value="<%= request.getParameter("path") %>">
                                        <input type="hidden" name="objectID" value="<%= request.getParameter("objectID") %>">
                                        <input type="hidden" name="valueID" value="<%= typeValue.getID() %>">
                                    </td>
                                </form>
                                </tr>
                                
                            <% /* else (more type values to come) */ %>
                            <%
                            }
                            else
                            {
                            %>
                            
                                <% /* display 'bbT' style type value line with change/remove box */ %>
                                <tr bgcolor="00FF80">
                                <form name="changetypevalue" method="POST" action="<%= request.getContextPath() + "/admin/objects.jsp" %>">
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td background="images/bar_s.jpg"><img src="images/bar_t.jpg" width="25" height="25"></td>
                                    <td> 
                                        <input type="text" name="value" value="<%= typeValue.getValue() %>">
                                        <input type="submit" name="changeValue" value="Change">
                                        <input type="submit" name="removeValue" value="Remove">
                                        <input type="hidden" name="mode" value="changeTypeValue">
                                        <input type="hidden" name="path" value="<%= request.getParameter("path") %>">
                                        <input type="hidden" name="objectID" value="<%= request.getParameter("objectID") %>">
                                        <input type="hidden" name="valueID" value="<%= typeValue.getID() %>">
                                    </td>
                                </form>
                                </tr>
                                
                            <% /* end if */ %>
                            <%
                            }
                            %>
                            
                        <% /* end iterate type values */ %>
                        </typeValue:iterate>
                        
                    <% /* else (more types to come) */ %>
                    <%
                    }
                    else
                    {
                    %>
                    
                        <% /* display 'bT' style type line */ %>
                        <tr bgcolor="00FF80">
                        <form name="addtypevalue" method="POST" action="<%= request.getContextPath() + "/admin/objects.jsp" %>">
                            <td height="24">&nbsp;</td>
                            <td background="images/bar_s.jpg" height="24"><img src="images/bar_t.jpg" width="25" height="25"></td>
                            <td height="24"><%= type.getName() %></td>
                            <td height="24">
                                <input type="text" name="value">
                                <input type="submit" name="addValue" value="Add Value">
                                <input type="hidden" name="valueID" value="<%= propertyValue.getID() %>">
                                <input type="hidden" name="typeID" value="<%= type.getTypeID() %>">
                                <input type="hidden" name="mode" value="addTypeValue">
                                <input type="hidden" name="path" value="<%= request.getParameter("path") %>">
                                <input type="hidden" name="objectID" value="<%= request.getParameter("objectID") %>">                                
                            </td>
                        </form>
                        </tr>
                        
                        <% /* iterate type values */ %>
                        <typeValue:iterate id="typeValue" valueID="<%= String.valueOf(propertyValue.getID()) %>" typeID="<%= String.valueOf(type.getTypeID()) %>">
                        
                            <% /* if (last or only type value) */ %>
                            <%
                            if (!typeValueHasNext.booleanValue())
                            {
                            %>
                            
                                <% /* display 'bIL' style type value line with change/remove box */ %>
                                <tr bgcolor="00FF80">
                                <form name="changetypevalue" method="POST" action="<%= request.getContextPath() + "/admin/objects.jsp" %>">
                                    <td>&nbsp;</td>
                                    <td><img src="images/bar_i.jpg" width="25" height="25"></td>
                                    <td background="images/bar_s.jpg"><img src="images/bar_l.jpg" width="25" height="25"></td>
                                    <td> 
                                        <input type="text" name="value" value="<%= typeValue.getValue() %>">
                                        <input type="submit" name="changeValue" value="Change">
                                        <input type="submit" name="removeValue" value="Remove">
                                        <input type="hidden" name="mode" value="changeTypeValue">
                                        <input type="hidden" name="path" value="<%= request.getParameter("path") %>">
                                        <input type="hidden" name="objectID" value="<%= request.getParameter("objectID") %>">
                                        <input type="hidden" name="valueID" value="<%= typeValue.getID() %>">
                                    </td>
                                </form>
                                </tr>
                                <tr>
                                    <td>&nbsp;</td>
                                    <td><img src="images/bar_i.jpg" width="25" height="25"></td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                </tr>
                                
                            <% /* else (more type values to come) */ %>
                            <%
                            }
                            else
                            {
                            %>
                            
                                <% /* display 'bIT' style type value line with change/remove box */ %>
                                <tr bgcolor="00FF80">
                                <form name="changetypevalue" method="POST" action="<%= request.getContextPath() + "/admin/objects.jsp" %>">
                                    <td>&nbsp;</td>
                                    <td><img src="images/bar_i.jpg" width="25" height="25"></td>
                                    <td background="images/bar_s.jpg"><img src="images/bar_t.jpg" width="25" height="25"></td>
                                    <td> 
                                        <input type="text" name="value" value="<%= typeValue.getValue() %>">
                                        <input type="submit" name="changeValue" value="Change">
                                        <input type="submit" name="removeValue" value="Remove">
                                        <input type="hidden" name="mode" value="changeTypeValue">
                                        <input type="hidden" name="path" value="<%= request.getParameter("path") %>">
                                        <input type="hidden" name="objectID" value="<%= request.getParameter("objectID") %>">
                                        <input type="hidden" name="valueID" value="<%= typeValue.getID() %>">
                                    </td>
                                </form>
                                </tr>                                
                            
                            <% /* end if */ %>
                            <%
                            }
                            %>
                            
                        <% /* end iterate type value */ %>
                        </typeValue:iterate>
                            
                    <% /* end if */ %>
                    <%
                    }
                    %>
                    
                <% /* end iterate types */ %>
                </propertyType:iterate>
                
            <% /* else (more property values to come) */ %>
            <%
            }
            else
            {
            %>
                
                <% /* display 'T' style property value line with change/remove box */ %>
                <tr bgcolor="00FF80"> 
                <form name="changevalue" method="POST" action="<%= request.getContextPath() + "/admin/objects.jsp" %>">
                    <td background="images/bar_s.jpg"><img src="images/bar_t.jpg" width="25" height="25"></td>
                    <td> 
                        <input type="text" name="value" value="<%= propertyValue.getValue() %>">
                        <input type="submit" name="changeValue" value="Change">
                        <input type="submit" name="removeValue" value="Remove">
                        <input type="hidden" name="mode" value="changePropertyValue">
                        <input type="hidden" name="path" value="<%= request.getParameter("path") %>">
                        <input type="hidden" name="objectID" value="<%= request.getParameter("objectID") %>">
                        <input type="hidden" name="valueID" value="<%= propertyValue.getID() %>">
                    </td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </form>
                </tr>
                
                <% /* iterate types */ %>
                <propertyType:iterate id="type" propertyID="<%= String.valueOf(property.getID()) %>">
                
                    <% /* if (last or only type) */ %>
                    <%
                    if (!typeHasNext.booleanValue())
                    {
                    %>                    
                    
                        <% /* display 'IL' style type line */ %>
                        <tr bgcolor="00FF80"> 
                        <form name="addtypevalue" method="POST" action="<%= request.getContextPath() + "/admin/objects.jsp" %>">
                            <td><img src="images/bar_i.jpg" width="25" height="25"></td>
                            <td background="images/bar_s.jpg" height="24"><img src="images/bar_l.jpg" width="25" height="25"></td>
                            <td height="24"><%= type.getName() %></td>
                            <td height="24">
                                <input type="text" name="value">
                                <input type="submit" name="addValue" value="Add Value">
                                <input type="hidden" name="valueID" value="<%= propertyValue.getID() %>">
                                <input type="hidden" name="typeID" value="<%= type.getTypeID() %>">
                                <input type="hidden" name="mode" value="addTypeValue">
                                <input type="hidden" name="path" value="<%= request.getParameter("path") %>">
                                <input type="hidden" name="objectID" value="<%= request.getParameter("objectID") %>">
                            </td>
                        </form>    
                        </tr>
                        
                        <% /* iterate type values */ %>
                        <typeValue:iterate id="typeValue" valueID="<%= String.valueOf(propertyValue.getID()) %>" typeID="<%= String.valueOf(type.getTypeID()) %>">
                            
                            <% /* if (last or only type value) */ %>
                            <%
                            if (!typeValueHasNext.booleanValue())
                            {
                            %>
                            
                                <% /* display 'IbL' style type value line with change/remove box */ %>
                                <tr bgcolor="00FF80">
                                <form name="changetypevalue" method="POST" action="<%= request.getContextPath() + "/admin/objects.jsp" %>">
                                    <td><img src="images/bar_i.jpg" width="25" height="25"></td>
                                    <td>&nbsp;</td>
                                    <td background="images/bar_s.jpg"><img src="images/bar_l.jpg" width="25" height="25"></td>
                                    <td> 
                                        <input type="text" name="value" value="<%= typeValue.getValue() %>">
                                        <input type="submit" name="changeValue" value="Change">
                                        <input type="submit" name="removeValue" value="Remove">
                                        <input type="hidden" name="mode" value="changeTypeValue">
                                        <input type="hidden" name="path" value="<%= request.getParameter("path") %>">
                                        <input type="hidden" name="objectID" value="<%= request.getParameter("objectID") %>">
                                        <input type="hidden" name="valueID" value="<%= typeValue.getID() %>">
                                    </td>
                                </form>
                                </tr>
                                <tr>
                                    <td><img src="images/bar_i.jpg" width="25" height="25"></td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                </tr>                                
                                
                            <% /* else (more type values to come) */ %>
                            <%
                            }
                            else
                            {
                            %>
                            
                                <% /* display 'IbT' style type value line with change/remove box */ %>
                                <tr bgcolor="00FF80">
                                <form name="changetypevalue" method="POST" action="<%= request.getContextPath() + "/admin/objects.jsp" %>">
                                    <td><img src="images/bar_i.jpg" width="25" height="25"></td>
                                    <td>&nbsp;</td>
                                    <td background="images/bar_s.jpg"><img src="images/bar_t.jpg" width="25" height="25"></td>
                                    <td> 
                                        <input type="text" name="value" value="<%= typeValue.getValue() %>">
                                        <input type="submit" name="changeValue" value="Change">
                                        <input type="submit" name="removeValue" value="Remove">
                                        <input type="hidden" name="mode" value="changeTypeValue">
                                        <input type="hidden" name="path" value="<%= request.getParameter("path") %>">
                                        <input type="hidden" name="objectID" value="<%= request.getParameter("objectID") %>">
                                        <input type="hidden" name="valueID" value="<%= typeValue.getID() %>">
                                    </td>
                                </form>
                                </tr>
                                
                            <% /* end if */ %>
                            <%
                            }
                            %>
                            
                        <% /* end iterate type values */ %>
                        </typeValue:iterate>
                        
                    <% /* else (more types to come) */ %>
                    <%
                    }
                    else
                    {
                    %>
                    
                        <% /* display 'IT' style type line */ %>
                        <tr bgcolor="00FF80"> 
                        <form name="addtypevalue" method="POST" action="<%= request.getContextPath() + "/admin/objects.jsp" %>">
                            <td><img src="images/bar_i.jpg" width="25" height="25"></td>
                            <td background="images/bar_s.jpg" height="24"><img src="images/bar_t.jpg" width="25" height="25"></td>
                            <td height="24"><%= type.getName() %></td>
                            <td height="24">
                                <input type="text" name="value">
                                <input type="submit" name="addValue" value="Add Value">
                                <input type="hidden" name="valueID" value="<%= propertyValue.getID() %>">
                                <input type="hidden" name="typeID" value="<%= type.getTypeID() %>">
                                <input type="hidden" name="mode" value="addTypeValue">
                                <input type="hidden" name="path" value="<%= request.getParameter("path") %>">
                                <input type="hidden" name="objectID" value="<%= request.getParameter("objectID") %>">                                
                            </td>
                        </form>
                        </tr>

                        <% /* iterate type values */ %>
                        <typeValue:iterate id="typeValue" valueID="<%= String.valueOf(propertyValue.getID()) %>" typeID="<%= String.valueOf(type.getTypeID()) %>">
                        
                        
                            <% /* if (last or only type value) */ %>
                            <%
                            if (!typeValueHasNext.booleanValue())
                            {
                            %>
                            
                                <% /* display 'IIL' style type value line with change/remove box */ %>
                                <tr bgcolor="00FF80"> 
                                <form name="changetypevalue" method="POST" action="<%= request.getContextPath() + "/admin/objects.jsp" %>">
                                    <td><img src="images/bar_i.jpg" width="25" height="25"></td>
                                    <td><img src="images/bar_i.jpg" width="25" height="25"></td>
                                    <td background="images/bar_s.jpg"><img src="images/bar_l.jpg" width="25" height="25"></td>
                                    <td> 
                                        <input type="text" name="value" value="<%= typeValue.getValue() %>">
                                        <input type="submit" name="changeValue" value="Change">
                                        <input type="submit" name="removeValue" value="Remove">
                                        <input type="hidden" name="mode" value="changeTypeValue">
                                        <input type="hidden" name="path" value="<%= request.getParameter("path") %>">
                                        <input type="hidden" name="objectID" value="<%= request.getParameter("objectID") %>">
                                        <input type="hidden" name="valueID" value="<%= typeValue.getID() %>">
                                    </td>
                                </form>
                                </tr>  
                                <tr>
                                    <td><img src="images/bar_i.jpg" width="25" height="25"></td>
                                    <td><img src="images/bar_i.jpg" width="25" height="25"></td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                </tr>                                  
                                
                            <% /* else (more type values to come) */ %>
                            <%
                            }
                            else
                            {
                            %>

                                <% /* display 'IIT' style type value line with change/remove box */ %>
                                <tr bgcolor="00FF80">
                                <form name="changetypevalue" method="POST" action="<%= request.getContextPath() + "/admin/objects.jsp" %>">
                                    <td><img src="images/bar_i.jpg" width="25" height="25"></td>
                                    <td><img src="images/bar_i.jpg" width="25" height="25"></td>
                                    <td background="images/bar_s.jpg"><img src="images/bar_t.jpg" width="25" height="25"></td>
                                    <td> 
                                        <input type="text" name="value" value="<%= typeValue.getValue() %>">
                                        <input type="submit" name="changeValue" value="Change">
                                        <input type="submit" name="removeValue" value="Remove">
                                        <input type="hidden" name="mode" value="changeTypeValue">
                                        <input type="hidden" name="path" value="<%= request.getParameter("path") %>">
                                        <input type="hidden" name="objectID" value="<%= request.getParameter("objectID") %>">
                                        <input type="hidden" name="valueID" value="<%= typeValue.getID() %>">
                                    </td>
                                </form>
                                </tr>                                
                                
                            
                            <% /* end if */ %>
                            <%
                            }
                            %>                        
                        
                        <% /* end iterate type values */ %>
                        </typeValue:iterate>
                        
                    <% /* end if */ %>
                    <%
                    }
                    %>
                    
                <% /* end iterate property types */ %>    
                </propertyType:iterate>
                
            <% /* end if */ %>
            <%
            }
            %>
            
            <% /* end iterate property values */ %>
            </propertyValue:iterate>
        
        <% /* display one blank line */ %>
        <tr bgcolor="00FF80"> 
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>        
        
        <% /* end iterate properties */ %>
        </classProperty:iterate>
        
        <% /* display table end */ %>
        </table>
          
    <%
    }
    else
    {
    %>
    There is no object selected, please select an object from the tree view on the left. (You need to double-click an object in order to select it.)
    <%
    }
    %>
