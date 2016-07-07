<html>
<!--
  Shows how to use custom tags from our apps.
-->
<%@ taglib uri="http://www.inet.com/taglibs/one" prefix="tl"%>

<%@ taglib uri="http://www.inet.com/taglibs/two" prefix="arth"%>
<arth:add op1="1000" op2="2000" />
<tl:tag1 attrib1="value of attrib1" >
</tl:tag1 >
</html>