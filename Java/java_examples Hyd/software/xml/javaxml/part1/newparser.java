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
      File input = new File("book1.xml"),
           schema = new File("myschema.xsd");
      SAXParserFactory factory = SAXParserFactory.newInstance();
      factory.setNamespaceAware(true);
      factory.setValidating(true);
      SAXParser parser = factory.newSAXParser();
      try
      {
         parser.setProperty(SCHEMA_LANGUAGE,XML_SCHEMA);
         parser.setProperty(SCHEMA_SOURCE,schema);
      }
      catch(SAXNotRecognizedException x)
      {
         System.err.println("Your SAX parser is not JAXP 1.2 compliant.");
      }
      parser.parse(input,handler);

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
	 int noa = attrs.getLength(); 
	 String aName;
	 System.out.println(" qname = " + qName);
System.out.println("noa  =  "+noa);
            for (int i = 0; i < noa ; i++)
                System.out.println("Attribute name =  "+ attrs.getQName(i));
    }

    public void endElement(String namespaceURI,
                           String sName, // simple name
                           String qName  // qualified name
                          )
    throws SAXException
    {
       System.out.println("End of Element " + qName);        
    }

    public void characters(char buf[], int offset, int len)
    throws SAXException
    {
        String s = new String(buf, offset, len);
	  System.out.println(" Character Data = " +s);
    }
    
}
