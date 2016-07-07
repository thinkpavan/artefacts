<html>
<!--
  Shows how to use custom tags from our apps.
-->
<%@ taglib uri="http://www.inet.com/taglibs/cooptags" prefix="inettags"%>

<HTML>
<HEAD>
<TITLE>Example on Co-operating tags</TITLE>
</HEAD>
<BODY BGCOLOR="#FFFFFF">

	<inettags:switch value="java">
		<inettags:case value="java">
			<P>Here are the details of java course</P>
		</inettags:case>
		<inettags:case value="C">
			<P>Here are the details of C course</P>
		</inettags:case>
		<inettags:case value="CPP">
			<P>Here are the details of C course</P>
		</inettags:case>
	</inettags:switch>
</BODY>
</HTML>
