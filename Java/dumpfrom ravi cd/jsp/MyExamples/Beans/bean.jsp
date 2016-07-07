<html>
<body  bgcolor=lightyellow>
<pre>
<%@ page  import="java.util.Date" %>

<jsp:useBean  id="obj"  class="java.util.Date"  />

Date<jsp:getProperty  name="obj"  property="date" />
Month<jsp:getProperty  name="obj"  property="month" />
Hours<jsp:getProperty  name="obj"  property="hours" />
Minutes<jsp:getProperty  name="obj"  property="minutes" />
Seconds<jsp:getProperty  name="obj"  property="seconds" />
<jsp:setProperty  name="obj"  property="seconds" value="123123" />
Seconds<jsp:getProperty  name="obj"  property="seconds" />
<jsp:setProperty  name="obj"  property="hours" value="6" />
Hours<jsp:getProperty  name="obj"  property="hours" />
</pre>
</body>
</html>