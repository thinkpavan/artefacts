/* shows how to use new parser
Version: 1.0
Author : Team -J
*/

import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;

public class newparser extends DefaultHandler
{
    StringBuffer textBuffer;
    
    public static void main(String argv[])
    {
        
        DefaultHandler handler = new newparser();
        SAXParserFactory factory = SAXParserFactory.newInstance();
	  factory.setNamespaceAware(true);// set the parser to be aware of  namespace. 
        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse( new File("nspo.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // DocumentHandler methods

    public void startDocument()
    throws SAXException
    {
     System.out.println(" Started parsing the document");   
    }

    public void endDocument()
    throws SAXException
    {
     System.out.println(" parsed sucessfully");   

    }

    public void startElement(String namespaceURI,
                             String sName, // simple name
                             String qName, // qualified name
                             Attributes attrs) throws SAXException
    {
	 System.out.println(" qname = " + qName);
	 System.out.println(" sname = " + sName);
	 System.out.println(" namespace = " + namespaceURI);


    }

    public void endElement(String namespaceURI,
                           String sName, // simple name
                           String qName  // qualified name
                          )
    throws SAXException
    {
    }

    public void characters(char buf[], int offset, int len)
    throws SAXException
    {
        String s = new String(buf, offset, len);
	  //System.out.println(" Character Data = " +s);
    }
    
}
