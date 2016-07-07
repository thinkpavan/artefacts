/* shows how to use xmlbeans classes to read data from xml files
Version : 1.0
Author : Team - J
*/
import info.inetsolv.my.tags.*;
import java.io.FileWriter;
public class WriteData{
public static void main(String args[]) throws Exception{
	FileWriter xml_file= new FileWriter("output1.xml");
	SimplestudentDocument.Simplestudent ss;	
	SimplestudentDocument ssd=SimplestudentDocument.Factory.newInstance();
	ss=ssd.addNewSimplestudent();
System.out.println(ss.getClass());
	String name="ramana",address="srnagar";
	int age=33;
	float fp=1122.22f;
	ss.setName(name);
	ss.setAge(age);
	ss.setAddress(address);
	ss.setFeePaid(fp);
System.out.println(ssd.toString());
xml_file.write(ssd.toString());
xml_file.close();
}
}