/* Example to create a soap message with fault to represent an error
Author : Team-J
Version: 1.0
*/
import java.io.*;
import javax.xml.soap .*;
import javax.swing.*;
import java.awt.*;

public class soap3{
    public static void main (String argv [])throws Exception
    {
	MessageFactory factory;
	SOAPMessage message;
	SOAPPart soapPart;
	SOAPEnvelope envelope;
	SOAPHeader header;
	SOAPBody body ;
	Name name;
	SOAPElement topelem,subelem1,subelem2;
	AttachmentPart  ap;
	SOAPFault fault;
	factory = MessageFactory.newInstance();
	message = factory.createMessage(); 
	FileOutputStream fos = new FileOutputStream("soap3.txt");
/* the soap message created in the above statement contains
 A SOAPPart object that contains 
	A SOAPEnvelope object that contains 
		An empty SOAPHeader object 
		An empty SOAPBody object 
Note: No attachements will be created.*/
	soapPart = message.getSOAPPart(); 
	envelope = soapPart.getEnvelope(); 
	header = envelope.getHeader();
	body = envelope.getBody(); 
	header.detachNode(); 
	name = envelope.createName("product", "inet", "http://www.inet.com/contents"); 
	topelem=body.addBodyElement(name);
	name = envelope.createName("ProdName");
	subelem1=topelem.addChildElement(name);
	subelem1.addTextNode("Pen");
	name = envelope.createName("Price");
	subelem2=topelem.addChildElement(name);
	subelem2.addTextNode("10");
	fault = body.addFault(); 
	fault.setFaultCode("FC-400");
	fault.setFaultActor("http://www.inet.com/res");
	fault.setFaultString("problem with the server, try later"); 


	message.writeTo(fos);
	
    }
}

