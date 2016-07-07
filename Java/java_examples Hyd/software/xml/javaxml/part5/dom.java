/* Example to demonstrate how to use dom parser to manuplate
xml content.
Author : Team-J
Version: 1.0
*/

import java.io.*;
import org.xml.sax.*;
import javax.xml.parsers.*;


 class ErrHandler extends HandlerBase
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


public class dom
{
   public static String SCHEMA_LANGUAGE =
      "http://java.sun.com/xml/jaxp/properties/schemaLanguage",
                        XML_SCHEMA =
      "http://www.w3.org/2001/XMLSchema",
                        SCHEMA_SOURCE =
      "http://java.sun.com/xml/jaxp/properties/schemaSource";
   public final static void main(String[] args)
      throws IOException, SAXException, ParserConfigurationException
   {
      
      File input = new File("book3.xml"),
           schema = new File("myschema.xsd");
      DocumentBuilderFactory factory =
         DocumentBuilderFactory.newInstance();
      factory.setNamespaceAware(true);
      factory.setValidating(true);
      try
      {
         factory.setAttribute(SCHEMA_LANGUAGE,XML_SCHEMA);
        // factory.setAttribute(SCHEMA_SOURCE,schema);
      }
      catch(IllegalArgumentException x)
      {
         System.err.println("Your DOM parser is not JAXP 1.2 compliant.");
      }
      DocumentBuilder parser = factory.newDocumentBuilder();
      parser.setErrorHandler(new ErrHandler());
      parser.parse(input);
	System.out.println("Parsing over");
   }
}




