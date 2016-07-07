/* Example to demonstrate how to use dom parser to manuplate
xml content.
Author : Team-J
Version: 1.0
*/


import java.io.*;
import org.xml.sax.*;
import javax.xml.parsers.*;


 class ErrorHandler extends HandlerBase
    {
	// treat validation errors as fatal
	public void error (SAXParseException e) throws SAXParseException
	{
		System.out.println(" in error");
	    throw e;
	}

	public void warning (SAXParseException err) throws SAXParseException
	{
	    System.out.println ("** Warning" + ", line " + err.getLineNumber ()
		+ ", uri " + err.getSystemId ());
	    System.out.println("   " + err.getMessage ());
	}
    }

public class sax1
{
   public static String SCHEMA_LANGUAGE ="http://java.sun.com/xml/jaxp/properties/schemaLanguage",
       XML_SCHEMA ="http://www.w3.org/2001/XMLSchema",
       SCHEMA_SOURCE ="http://java.sun.com/xml/jaxp/properties/schemaSource";

   public final static void main(String[] args)
      throws IOException, SAXException, ParserConfigurationException
   {
     
      File input = new File("book2.xml"),
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
      parser.parse(input,new ErrorHandler());
   }
}
