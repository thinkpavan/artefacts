<html>
<!--
we can use jndi resource name or different params like driver,jdbcurl,uname,pwd
to set up data source.
 -->
<%@ taglib uri="http://java.sun.com/jstl/sql" prefix="sql" %> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 

<sql:setDataSource var="ds" driver="oracle.jdbc.driver.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:orcl" user="scott" password="tiger" />

<HTML>
<HEAD>
<TITLE>Train Table application</TITLE>
</HEAD>
<c:set var="tno" value="${param.trainno}"/>
<c:set var="arr_time" value="${param.arr_time}"/>
<c:out value="${tno}"/><Br>
<c:out value="${arr_time}"/>

<BODY BGCOLOR="#FFFFFF">
<sql:transaction dataSource="${ds}">
 <sql:update> 
	update cur_train_table SET ARR_TIME=? WHERE TRAINNO=?
       <sql:param value="${arr_time}"/>
       <sql:param value="${tno}"/>


 </sql:update> 
</sql:transaction> 
Record updated.

</BODY>
</HTML>
