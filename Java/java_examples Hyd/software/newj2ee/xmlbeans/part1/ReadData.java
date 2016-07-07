/* shows how to use xmlbeans classes to read data from xml files
Version : 1.0
Author : Team - J
*/
import info.inetsolv.my.tags.*;
import java.io.File;

public class ReadData{
public static void main(String args[]) throws Exception{
	File xml_file= new File("input1.xml");
	SimplestudentDocument.Simplestudent ss;	
	SimplestudentDocument ssd=SimplestudentDocument.Factory.parse(xml_file);
	ss=ssd.getSimplestudent();
	String name,address;
	int age;
	float fp;
	name=ss.getName();
	address=ss.getAddress();
	age=ss.getAge();
	fp=ss.getFeePaid();
	System.out.println("Name = " + name);
	System.out.println("address = " + address);
	System.out.println("age = " + age);
	System.out.println("fee paid = " + fp);
}
}