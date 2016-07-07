/* shows how to use xmlbeans classes to read data from xml files
Version : 1.0
Author : Team - J
*/
import info.inetsolv.xyz.his.own.tags.*;
import java.io.File;

public class ReadData{
public static void main(String args[]) throws Exception{
	File xml_file= new File("input1.xml");
	SimplemailDocument.Simplemail sm;	
	SimplemailDocument smd=SimplemailDocument.Factory.parse(xml_file);
	sm=smd.getSimplemail();
	System.out.println("to = " + sm.getTo());
	System.out.println("from = " + sm.getFrom());
	System.out.println("subject = " + sm.getSubject());
	System.out.println("content = " + sm.getContent());
}
}