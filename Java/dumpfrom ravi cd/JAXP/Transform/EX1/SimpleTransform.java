/* This Programm will take .XML File,.XSL file and converts into .html file File Data */
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.*;
public class SimpleTransform
{
	public static void main(String[] args){  
	try{
 	TransformerFactory tFactory = TransformerFactory.newInstance();
	Transformer transformer = tFactory.newTransformer(new StreamSource("empdetails.xsl"));
	transformer.transform(new StreamSource("empdetails.xml"), new StreamResult(new FileOutputStream("pra_details.html")));

	/*This line Write The HTML Data to Console Instread of this to web client by writing this code 
		in Servlet or JSP Page THis is Caleed ServerSide Transformation*/
	//transformer.transform(new StreamSource("empdetails.xml"), new StreamResult(System.out));

	System.out.println("************* The result is in empdetails.html*************");
	}catch(Exception e){System.out.println("Exception is"+e);}
  }
}