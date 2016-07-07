/* shows how to use xmlbeans classes to read data from xml files
Version : 1.0
Author : Team - J
*/
import info.inetsolv.xyz.his.own.tags.*;
import java.io.FileWriter;
public class WriteData{
public static void main(String args[]) throws Exception{
	FileWriter xml_file= new FileWriter("output1.xml");
	SimplemailDocument.Simplemail sm;	
	SimplemailDocument smd=SimplemailDocument.Factory.newInstance();
	sm=smd.addNewSimplemail();
	sm.setTo("stud@yahoo.com");
	sm.setFrom("stud@hotmail.com");
	sm.setSubject("How are you");
	sm.setContent("This is the content of my mail");
System.out.println(smd.toString());
xml_file.write(smd.toString());
xml_file.close();
}
}