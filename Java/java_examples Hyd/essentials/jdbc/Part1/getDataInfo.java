/* Demonstrates how to get drivers list that are registered
with Driver Manager
Author : Team - J
Version : 1.0
*/

import java.sql.*;
public class getDataInfo{
	public static void main(String args[])throws Exception{
	   // establish connection to database this includes loading driver
	   // and fetching data.
	// first step is to register jbbc driver with driver manager
	// class.forName loads class which in this case is jdbc
	// implementation of interface Driver
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con;
	con = DriverManager.getConnection("jdbc:odbc:acc1","","");
	// Once connected, we can  execute any sql statement
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("select * from customers");
// Meta Data gives us information about the data fetched from
// the database
	ResultSetMetaData rsmd = rs.getMetaData();
	for(int i = 1 ; i<= rsmd.getColumnCount();i++){
		System.out.print(rsmd.getColumnName(i) + "  " + rsmd.getColumnType(i));		switch(rsmd.getColumnType(i)){
			case java.sql.Types.BIGINT:
				System.out.println("     BIGINT|");
				break;
			case java.sql.Types.FLOAT:
				System.out.println("      FLOAT|");
				break;
			case java.sql.Types.REAL:
				System.out.println("      REAL|");
				break;
			case java.sql.Types.DOUBLE:
				System.out.println("      DOUBLE|");
				break;
			case java.sql.Types.NUMERIC:
				System.out.println("      NUMERIC|");
				break;
			case java.sql.Types.DECIMAL:
				System.out.println("      DECIMAL|");
				break;
			case java.sql.Types.CHAR:
				System.out.println("      CHAR|");
				break;
			case java.sql.Types.VARCHAR:
				System.out.println("      VARCHAR|");
				break;
			case java.sql.Types.LONGVARCHAR:
				System.out.println("      LONGVARCHAR|");
				break;
			case java.sql.Types.DATE:
				System.out.println("      DATE|");
				break;
			case java.sql.Types.TIME:
				System.out.println("      TIME|");
				break;
			case java.sql.Types.TIMESTAMP:
				System.out.println("      TIMESTAMP|");
				break;
			case java.sql.Types.BINARY:
				System.out.println("      BINARY|");
				break;
			case java.sql.Types.VARBINARY:
				System.out.println("      VARBINARY|");
				break;
			case java.sql.Types.LONGVARBINARY:
				System.out.println("      LONGVARBINARY|");
				break;
			case java.sql.Types.NULL:
				System.out.println("      NULL|");
				break;
			case java.sql.Types.OTHER:
				System.out.println("      OTHER|");
				break;
			case java.sql.Types.JAVA_OBJECT:
				System.out.println("      JAVA_OBJECT|");
				break;
			case java.sql.Types.DISTINCT:
				System.out.println("      DISTINCT|");
				break;
			case java.sql.Types.STRUCT:
				System.out.println("      STRUCT|");
				break;
			case java.sql.Types.ARRAY:
				System.out.println("      ARRAY|");
				break;
			case java.sql.Types.BLOB:
				System.out.println("      BLOB|");
				break;
			case java.sql.Types.CLOB:
				System.out.println("      CLOB|");
				break;
			case java.sql.Types.REF:
				System.out.println("      REF|");
				break;
		}
	}
}
}
