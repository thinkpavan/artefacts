<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/" >
<html>
<head>
<title>Trendz Information Technologies</title>
</head>
<body bgcolor="yellow">
<font color="red" size="5">
<h1> Trendz Employees Are </h1>
	<xsl:for-each select="empdetails/emp">
		<h2>Ename::<xsl:value-of select="ename"/></h2>
		<h2>Empno::<xsl:value-of select="empid"/></h2>
	</xsl:for-each>

	<xsl:for-each select="empdetails/dept">
		<h2>Ename::<xsl:value-of select="deptno"/></h2>
		<h2>Empno::<xsl:value-of select="dname"/></h2>
	</xsl:for-each>

</font>
</body>
</html>
</xsl:template>
</xsl:stylesheet>