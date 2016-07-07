<%@ page autoFlush="true" import="javax.servlet.jsp.*" %>


<%
  JspFactory jf = JspFactory.getDefaultFactory();
  JspEngineInfo jif = jf.getEngineInfo();
  String sver = jif.getSpecificationVersion();
%>

<h1> Engine Version  :<%= sver %> </h1>


<%
 jf.releasePageContext(pageContext);
 out.println("Hello..");
%>
