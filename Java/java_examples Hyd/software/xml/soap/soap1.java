/* Example to create a soap message with attachement and without header
Author : Team-J
Version: 1.0
*/
import java.io.*;
import javax.xml.soap .*;

public class soap1{
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
	String att="<html><head>some head </head><body>some body</body></html>";
	AttachmentPart  ap;
	FileOutputStream fos = new FileOutputStream("Soap1.txt");

	factory = MessageFactory.newInstance();
	message = factory.createMessage(); 

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

	ap = message.createAttachmentPart();
//	ap.setMimeHeader("Content-Type", "text/html");
	ap.setContent(att, "text/html");
	message.addAttachmentPart(ap); 
	message.writeTo(fos);
	
    }
}

