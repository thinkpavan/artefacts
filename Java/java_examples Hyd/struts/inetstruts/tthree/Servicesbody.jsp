<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<tiles:insert page="/menulayout.jsp" flush="true">
  <tiles:put name="menu" value="/smenu.jsp" />
  <tiles:put name="content" value="/smenuc1.jsp" />
</tiles:insert>

