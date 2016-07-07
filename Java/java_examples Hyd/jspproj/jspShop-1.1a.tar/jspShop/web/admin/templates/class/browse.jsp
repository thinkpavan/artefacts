<%@ taglib uri="classpropertytags" prefix="classProperty" %>
<%@ taglib uri="propertytypetags" prefix="propertyType" %>
<%@ taglib uri="typenametags" prefix="typeName" %>
<%@ taglib uri="classtags" prefix="class" %>

    <%
    
    /* this if statement sets up the start of the tables to enable display of the property data for this class
       it also ensures that nothing will be displayed if there is no class selected
       there is a matching statement to this if down lower that sets up the ending of the tables
       it also makes sure that the classProperty tag is not touched if there is no class selected
    */
    if (request.getParameter("className") != null)
    {
    %>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td colspan="2"><b><font size="+1"><%= request.getParameter("className") %></font></b></td>
        </tr>
        <tr>
          <td colspan="2">
          <class:get id="newClass" className="<%= request.getParameter(\"className\") %>"/>
          <%= newClass.getDescription() %>
          </td>
        </tr>
        <tr> 
          <td width="5%">&nbsp;</td>
          <td><br>
            <table class="innerTable" width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td colspan="3"><b>Local</b></td>
              </tr>
           

          <%
          boolean displayPropertyHeader = true;
          %>
          <classProperty:iterate className = "<%= request.getParameter(\"className\") %>" showInherited = "false" id="property">
            <%
            boolean typeBeside = true;
            if (propertyHasNext.booleanValue())
            {
                //if we haven't displayed the headers yet let's do that
                if (displayPropertyHeader)
                {
                %>
                  <tr> 
                    <td width="5%">&nbsp;</td>
                    <td width="45%"><b>Properties</b></td>
                    <td width="45%"><b>Types</b></td>
                  </tr>                             
                <%
                }
                displayPropertyHeader = false;
                /* this is a property of this class, and there are more after it
                   display the name of this property
                */
            %>
                <tr> 
                  <form name="changeProperty<%=property.getID()%>" method="post" action="<%= request.getContextPath() + "/admin/classes.jsp" %>">                         
                    <td width="5%">&nbsp;</td>
                    <td width="45%">
                        <input type="text" name="name" value="<%= property.getName() %>">
                        <input type="hidden" name="propertyID" value="<%= property.getID() %>">
                        <input type="hidden" name="mode" value="propertyChange">
                        <input type="hidden" name="className" value="<%=request.getParameter("className")%>">
                        <input type="hidden" name="path" value="<%=request.getParameter("path")%>">
                        <input type="submit" name="Change" value="Change">
                        <input type="submit" name="Remove" value="Remove">
                    </td>
                    <td width="45%">&nbsp;</td>
                  </form>
                </tr>
                
                <% /*iterate through all the types for this property */ %>
                <propertyType:iterate id="type" propertyID="<%=String.valueOf(property.getID())%>">
                    <%
                    typeBeside = false;
                    if (typeHasNext.booleanValue())
                    {
                    
                        /* this is a type of this property, and there are more after it
                           display this as a 'T' because there are more to come
                        */
                    %>
                        <tr> 
                          <form name="type<%=type.getName()%>" method="post" action="<%= request.getContextPath() + "/admin/classes.jsp" %>">
                            <td width="5%">&nbsp;</td>
                            <td width="45%" background="images/bar_s.jpg"><img src="images/bar_t.jpg" width="25" height="25"></td>
                            <td width="45%">
                                <select name="typeID">
                                <option value="<%=type.getTypeID() %>" selected><%= type.getName() %></option>
                                <typeName:iterate id="name">
                                    <%
                                    if (!(type.getName() == name.getName()))
                                    {
                                    %>
                                        <option value="<%=name.getID() %>"><%= name.getName() %></option>
                                    <%
                                    }
                                    %>
                                </typeName:iterate>
                                </select>
                                <input type="submit" name="Change" value="Change">
                                <input type="submit" name="Remove" value="Remove">
                                <input type="hidden" name="propertyTypeID" value="<%=type.getID()%>">
                                <input type="hidden" name="mode" value="typeChange">
                                <input type="hidden" name="className" value="<%=request.getParameter("className")%>">
                                <input type="hidden" name="path" value="<%=request.getParameter("path")%>">                                 
                            </td>
                          </form>
                        </tr>                                    
                    <%
                    }
                    else
                    {
                        /* this is the last (or only) type of this property
                           display this as a 'L' as it's the last one
                        */
                    %>
                        <tr> 
                          <form name="type<%=type.getName()%>" method="post" action="<%= request.getContextPath() + "/admin/classes.jsp" %>">
                            <td width="5%">&nbsp;</td>
                            <td width="45%" background="images/bar_s.jpg"><img src="images/bar_l.jpg" width="25" height="25"></td>
                            <td width="45%"> 
                                <select name="typeID">
                                <option value="<%= type.getTypeID() %>" selected><%= type.getName() %></option>
                                <typeName:iterate id="name">
                                    <%
                                    if (!(type.getName() == name.getName()))
                                    {
                                    %>
                                        <option value="<%=name.getID()%>"><%= name.getName() %></option>
                                    <%
                                    }
                                    %>
                                </typeName:iterate>
                                </select>
                                <input type="submit" name="Change" value="Change">                                    
                                <input type="submit" name="Remove" value="Remove">
                                <input type="hidden" name="propertyTypeID" value="<%=type.getID()%>">                                
                                <input type="hidden" name="mode" value="typeChange">
                                <input type="hidden" name="className" value="<%=request.getParameter("className")%>">
                                <input type="hidden" name="path" value="<%=request.getParameter("path")%>">
                            </td>
                          </form>
                        </tr>                                    
                        <% /* display the add type line as this is the last (possibly only) type of this property */ %>
                        <tr> 
                          <form name="addType" method="post" action="<%= request.getContextPath() + "/admin/classes.jsp" %>">
                            <td width="5%">&nbsp;</td>
                            <td width="45%">&nbsp;</td>
                            <td width="45%"> 
                                <select name="typeID">
                                <option value="-1" selected>select type</option>
                                <typeName:iterate id="name">
                                    <%
                                    if (!(type.getName() == name.getName()))
                                    {
                                    %>
                                        <option value="<%=name.getID()%>"><%= name.getName() %></option>
                                    <%
                                    }
                                    %>
                                </typeName:iterate>
                                </select>
                                <input type="submit" name="addType" value="Add Type">
                                <input type="hidden" name="mode" value="addType">
                                <input type="hidden" name="propertyID" value="<%=property.getID()%>">
                                <input type="hidden" name="className" value="<%=request.getParameter("className")%>">
                                <input type="hidden" name="path" value="<%=request.getParameter("path")%>">
                            </td>
                          </form> 
                        </tr>                                    
                    <%
                    }
                    %>
                </propertyType:iterate>
                
            <%
            }
            else
            {
                // if we haven't displayed the headers yet let's do that
                if (displayPropertyHeader)
                {
                %>
                  <tr> 
                    <td width="5%">&nbsp;</td>
                    <td width="45%"><b>Properties</b></td>
                    <td width="45%"><b>Types</b></td>
                  </tr>                             
                <%
                }
                displayPropertyHeader = false;
                
                /* this is the last (or only) property of this class
                   display the name of this property 
                */
                %>
                <tr> 
                  <form name="changeProperty<%=property.getID()%>" method="post" action="<%= request.getContextPath() + "/admin/classes.jsp" %>">                         
                    <td width="5%">&nbsp;</td>
                    <td width="45%"> 
                        <input type="text" name="name" value="<%= property.getName() %>">
                        <input type="hidden" name="propertyID" value="<%= property.getID() %>">
                        <input type="hidden" name="mode" value="propertyChange">
                        <input type="hidden" name="className" value="<%=request.getParameter("className")%>">
                        <input type="hidden" name="path" value="<%=request.getParameter("path")%>">
                        <input type="submit" name="Change" value="Change">
                        <input type="submit" name="Remove" value="Remove">
                    </td>
                    <td width="45%">&nbsp;</td>
                  </form>
                </tr>
                              
                <% /*iterate through all the types for this property */ %>
                <propertyType:iterate id="type" propertyID="<%=String.valueOf(property.getID())%>">
                    <%
                    typeBeside = false;
                    if (typeHasNext.booleanValue())
                    {
                        /* this is a type of this property, and there are more after it
                           display this as a 'T' because there are more to come
                        */
                    %>
                        <tr>
                          <form name="type<%=type.getName()%>" method="post" action="<%= request.getContextPath() + "/admin/classes.jsp" %>">
                            <td width="5%">&nbsp;</td>
                            <td width="45%" background="images/bar_s.jpg"><img src="images/bar_t.jpg" width="25" height="25"></td>
                            <td width="45%"> 
                                <select name="typeID">
                                <option value=<%= type.getTypeID() %>" selected><%= type.getName() %></option>
                                <typeName:iterate id="name">
                                    <%
                                    if (!(type.getName() == name.getName()))
                                    {
                                    %>
                                        <option value="<%=name.getID()%>"><%= name.getName() %></option>
                                    <%
                                    }
                                    %>
                                </typeName:iterate>
                                </select>
                                <input type="submit" name="Change" value="Change">                                    
                                <input type="submit" name="Remove" value="Remove">
                                <input type="hidden" name="propertyTypeID" value="<%=type.getID()%>">
                                <input type="hidden" name="mode" value="typeChange">
                                <input type="hidden" name="className" value="<%=request.getParameter("className")%>">
                                <input type="hidden" name="path" value="<%=request.getParameter("path")%>">
                            </td>
                          </form>
                        </tr>
                    <%
                    }
                    else
                    {
                        /* this is the last (or only) type of this property
                           display this as a 'L' as it's the last one
                        */
                    %>
                        <tr> 
                          <form name="type<%=type.getName()%>" method="post" action="<%= request.getContextPath() + "/admin/classes.jsp" %>">
                            <td width="5%">&nbsp;</td>
                            <td width="45%" background="images/bar_s.jpg"><img src="images/bar_l.jpg" width="25" height="25"></td>
                            <td width="45%"> 
                                <select name="typeID">
                                <option value="<%=type.getTypeID() %>" selected><%= type.getName() %></option>
                                <typeName:iterate id="name">
                                    <%
                                    if (!(type.getName() == name.getName()))
                                    {
                                    %>
                                        <option value="<%=name.getID()%>"><%= name.getName() %></option>
                                    <%
                                    }
                                    %>
                                </typeName:iterate>
                                </select>
                                <input type="submit" name="Change" value="Change">                                    
                                <input type="submit" name="Remove" value="Remove">
                                <input type="hidden" name="propertyTypeID" value="<%=type.getID()%>">
                                <input type="hidden" name="mode" value="typeChange">
                                <input type="hidden" name="className" value="<%=request.getParameter("className")%>">
                                <input type="hidden" name="path" value="<%=request.getParameter("path")%>">
                            </td>
                          </form>
                        </tr>                                    
                        <% /* display the add type line as this is the last (possibly only) type of this property */ %>
                        <tr> 
                          <form name="addType" method="post" action="<%= request.getContextPath() + "/admin/classes.jsp" %>">
                            <td width="5%">&nbsp;</td>
                            <td width="45%">&nbsp;</td>
                            <td width="45%"> 
                                <select name="typeID">
                                <option value="-1" selected>select type</option>
                                <typeName:iterate id="name">
                                    <option value="<%=name.getID()%>"><%= name.getName() %></option>
                                </typeName:iterate>
                                </select>
                                <input type="submit" name="addType" value="Add Type">
                                <input type="hidden" name="propertyID" value="<%=property.getID()%>">
                                <input type="hidden" name="mode" value="addType">
                                <input type="hidden" name="className" value="<%=request.getParameter("className")%>">
                                <input type="hidden" name="path" value="<%=request.getParameter("path")%>">
                            </td>
                          </form>
                        </tr>                                    
                    <%
                    }
                    %>
                </propertyType:iterate>    
            <%
            }
            if (typeBeside)
            {
            %>
                <tr> 
                 <form name="addType" method="post" action="<%= request.getContextPath() + "/admin/classes.jsp" %>">
                   <td width="5%">&nbsp;</td>
                   <td width="45%">&nbsp;</td>
                   <td width="45%"> 
                       <select name="typeID">
                       <option value="-1" selected>select type</option>
                       <typeName:iterate id="name">
                           <option value="<%=name.getID()%>"><%= name.getName() %></option>
                       </typeName:iterate>
                       </select>
                       <input type="submit" name="addType" value="Add Type">
                       <input type="hidden" name="propertyID" value="<%=property.getID()%>">
                       <input type="hidden" name="mode" value="addType">
                       <input type="hidden" name="className" value="<%=request.getParameter("className")%>">
                       <input type="hidden" name="path" value="<%=request.getParameter("path")%>">
                   </td>
                 </form>
               </tr>             
            <%
            }
            %>
          </classProperty:iterate>
            
    <% /* this matches the if statement up top, it sets up the end of the tables */ %>
              <tr> 
                <td width="5%">&nbsp;</td>
                <td width="45%">&nbsp;</td>
                <td width="45%">&nbsp;</td>
              </tr>
              <tr>
                <form method="post" name="addProperty" action="<%= request.getContextPath() + "/admin/classes.jsp" %>">
                <td colspan="3"> 
                  <table class="innerTable" width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr class="innerTable"> 
                      <td width="5%">&nbsp;</td>
                      <td width="45%"> Property: 
                        <input type="text" name="name">
                        Type: 
                        <select name="typeID">
                          <option value="-1" selected>No Type (none)</option>
                          <typeName:iterate id="name">
                            <option value=<%=name.getID()%>><%= name.getName() %></option>
                          </typeName:iterate>
                        </select>
                      </td>
                      <td width="45%"> 
                        <input type="submit" name="Add" value="Add Property">
                      </td>
                    </tr>
                  </table>
                </td>
                <input type="hidden" name="mode" value="addProperty">
                <input type="hidden" name="className" value="<%=request.getParameter("className")%>">
                <input type="hidden" name="path" value="<%=request.getParameter("path")%>">
                </form>
              </tr>
            </table>
            <form name = "inherit" method="get" action="<%= request.getContextPath() + "/admin/classes.jsp" %>">
                <%                
                String passed = (String)session.getAttribute("jspShop.showInherit");
                if (passed == null)
                {
                    passed = "true";
                    session.setAttribute("jspShop.showInherit", passed);
                %>
                    <input type="checkbox" name="shouldInherit" value="true" checked onClick="javascript:inherit.submit();">Show Inherited Properties<br>
                <%
                }                
                else if (passed.equals("true"))
                {
                    if (request.getParameter("showDiffInherit") != null)
                    {
                        session.setAttribute("jspShop.showInherit",new String("false"));
                        passed = "false";
                        %>
                        <input type="checkbox" name="shouldInherit" value="false" onClick="javascript:inherit.submit();">Show Inherited Properties<br>
                        <%
                    }
                    else
                    {
                        %>
                        <input type="checkbox" name="shouldInherit" value="false" checked onClick="javascript:inherit.submit();">Show Inherited Properties<br>                    
                        <%
                    }
                }
                else
                {
                    if (request.getParameter("showDiffInherit") != null)
                    {
                        session.setAttribute("jspShop.showInherit",new String("true"));
                        passed = "true";
                        %>
                        <input type="checkbox" name="shouldInherit" value="true" checked onClick="javascript:inherit.submit();">Show Inherited Properties<br>
                        <%                    
                    }
                    else
                    {
                        %>
                        <input type="checkbox" name="shouldInherit" value="true" onClick="javascript:inherit.submit();">Show Inherited Properties<br>
                        <%                                        
                    }
                }
                %>
                <input type="hidden" name="className" value="<%=request.getParameter("className")%>">
                <input type="hidden" name="path" value="<%=request.getParameter("path")%>">
                <input type="hidden" name="showDiffInherit" value="true">
            </form>            
            <%
            String currentClassName = null;
            String lastClassName = null;
            // display the beginnings of the inherited table before we iterate
            if (passed != null && passed.equals("true"))
            {
            %>
            <table class="innerTable" width="100%" border="0" cellspacing="0" cellpadding="0">
              <% /* display the header for the inherited table */ %>
              <tr> 
                <td colspan="4"><b>Inherited</b></td>
              </tr>
              
            <classProperty:iterate className = "<%= request.getParameter(\"className\") %>" showInherited = "true" showOnlyInherited = "true" id="property">
                <%
                currentClassName = property.getClassName();
                
                if (currentClassName.equals(lastClassName))
                {
                    /* this is another inherited property of the same class as last time
                       display this inherited property name
                    */
                %>
                    <tr> 
                        <td width="5%">&nbsp;</td>
                        <td width="5%">&nbsp;</td>
                        <td width="50%"><%= property.getName() %></td>
                        <td width="50%">&nbsp;</td>
                    </tr>                                  
                    <% /* iterate through the types for this inherited property */ %>
                    <propertyType:iterate id="type" propertyID="<%=String.valueOf(property.getID())%>">
                        <%
                        if (typeHasNext.booleanValue())
                        {
                            /* there are more types for this inherited property after this one
                               so this type is displayed as a 'T' line -->
                            */
                        %>
                            <tr> 
                                <td width="5%">&nbsp;</td>
                                <td width="5%">&nbsp;</td>
                                <td width="50%" background="images/bar_s.jpg"><img src="images/bar_t.jpg" width="25" height="25"></td>
                                <td width="50%"><%= type.getName() %></td>
                            </tr>
                        <%                                          
                        }
                        else
                        {
                            /* this is the last (or only) type for this inherited property
                               so this type is displayed as an 'L' line
                            */
                        %>
                            <tr> 
                                <td width="5%">&nbsp;</td>
                                <td width="5%">&nbsp;</td>
                                <td width="50%" background="images/bar_s.jpg"><img src="images/bar_l.jpg" width="25" height="25"></td>
                                <td width="50%"><%= type.getName() %></td>
                            </tr>
                        <%
                        }
                        %>
                    </propertyType:iterate>
                    <!-- this put a space after each inherited property. Didn't know if I liked it so it's still here but commented out
                    <tr>
                        <td width="5%">&nbsp;</td>
                        <td width="5%">&nbsp;</td>
                        <td width="50%">&nbsp;</td>
                        <td width="50%">&nbsp;</td>
                    </tr>
                    -->
                <%
                }
                else
                {
                    /* this is the first inherited property of a new class
                       display spacer
                    */
                %>
                    <tr> 
                        <td width="5%">&nbsp;</td>
                        <td width="5%">&nbsp;</td>
                        <td width="50%">&nbsp;</td>
                        <td width="50%">&nbsp;</td>
                    </tr>                                
                    <% /* display class name */ %>
                    <%                    
                        String server = "";
                        if (!String.valueOf(request.getServerPort()).equals("80"))
                        {
                            server = request.getServerName() + ":" + request.getServerPort();
                        }
                        else
                        {
                            server = request.getServerName();
                        }

                        String classUrl = "http://" + server + request.getContextPath() + "/admin/classes.jsp?className=" + property.getClassName() + "&path=" + request.getParameter("path");
                    %>
                    <tr> 
                        <td width="5%"><b></b></td>
                        <td colspan="3"><b>From <a href="<%= response.encodeURL(classUrl) %>"><%= property.getClassName() %></a></b></td>
                    </tr>                                
                    <% /* display property/type headers */ %>
                    <tr> 
                        <td width="5%"><b></b></td>
                        <td width="5%"><b></b></td>
                        <td width="50%"><b>Properties</b></td>
                        <td width="50%"><b>Types</b></td>
                    </tr>                                
                    <% /* display this inherited property name */ %>
                    <tr> 
                        <td width="5%">&nbsp;</td>
                        <td width="5%">&nbsp;</td>
                        <td width="50%"><%= property.getName() %></td>
                        <td width="50%">&nbsp;</td>
                    </tr>                                
                    <% /* iterate through the types for this inherited property */ %>
                    <propertyType:iterate id="type" propertyID="<%= String.valueOf(property.getID()) %>">
                        <%
                        if (typeHasNext.booleanValue())
                        {
                            /* there are more types for this inherited property after this one
                               so this type is displayed as a 'T' line
                            */
                        %>
                            <tr> 
                                <td width="5%">&nbsp;</td>
                                <td width="5%">&nbsp;</td>
                                <td width="50%" background="images/bar_s.jpg"><img src="images/bar_t.jpg" width="25" height="25"></td>
                                <td width="50%"><%= type.getName() %></td>
                            </tr>                                        
                        <%
                        }
                        else
                        {
                            /* this is the last (or only) type for this inherited property
                               so this type is displayed as an 'L' line
                            */
                        %>
                            <tr> 
                                <td width="5%">&nbsp;</td>
                                <td width="5%">&nbsp;</td>
                                <td width="50%" background="images/bar_s.jpg"><img src="images/bar_l.jpg" width="25" height="25"></td>
                                <td width="50%"><%= type.getName() %></td>
                            </tr>                                        
                        <%
                        }
                        %>
                    </propertyType:iterate>
                    <!-- this put a space after each inherited property. Didn't know if I liked it so it's still here but commented out
                    <tr>
                        <td width="5%">&nbsp;</td>
                        <td width="5%">&nbsp;</td>
                        <td width="50%">&nbsp;</td>
                        <td width="50%">&nbsp;</td>
                    </tr>
                    -->
                <%                                
                }
                //save the current class name
                lastClassName = currentClassName;
                %>
            
            </classProperty:iterate>
            
            <% /* display the end of the inherited table */ %>
            </table>
            <%
            }
            %>
          </td>
        </tr>
      </table>
    <%
    }
    else
    {
    %>
    There is no class selected, please select a class from the tree view on the left. (You need to double-click a class in order to select it.)
    <%
    }
    %>

