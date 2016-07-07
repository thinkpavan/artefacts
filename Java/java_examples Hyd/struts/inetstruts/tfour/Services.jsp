<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<tiles:insert page="/layout.jsp" flush="true">
  <tiles:put name="title"  value="This is first example on Tiles" />
  <tiles:put name="header" value="/header.jsp" />
  <tiles:put name="footer" value="/footer.jsp" />
  <tiles:put name="body"   value="/Servicesbody.jsp" />
</tiles:insert>
