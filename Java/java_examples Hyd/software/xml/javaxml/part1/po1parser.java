/* Example to demonstrate how we can parse the xml document using jaxp
Author : Team-J
Version: 1.0
*/
import java.io.*;

import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.*;

class DocHandler implements DocumentHandler{
	Locator l;
    // methods of DocumentHandler
    public void setDocumentLocator (Locator l)
    {
	this.l=l;
	System.out.println(" set locator called");
    }

    public void startDocument ()  throws SAXException
    {
	System.out.println(" document parsing started");

    }

    public void endDocument ()     throws SAXException
    {
	System.out.println(" end of document reached");

    }

    public void startElement (String tag, AttributeList attrs)
    throws SAXException
    {
	System.out.println(" emelent " + tag);
	if (attrs != null) {
	    for (int i = 0; i < attrs.getLength (); i++) {
		System.out.println(attrs.getValue (i));
	    }
	}
    }

    public void endElement (String name)  throws SAXException
    {
	System.out.println(" end of emelent " + name);

    }

    public void characters (char buf [], int offset, int len)
    throws SAXException
    {
	System.out.println(" characters called  "+len+"  "+offset+"  "+buf.length);
	for(int i = offset;i<offset+len;i++)
		System.out.print(buf[i]);
	System.out.println();
    }

    public void ignorableWhitespace (char buf [], int offset, int len)
    throws SAXException
    {
// we are not bothered about white spaces
    }

    public void processingInstruction (String target, String data)
    throws SAXException
    {
	System.out.println(" PI" +target +"   "+data);
    }
}

//////////////////////////////
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
////////////////////////////////////





public class po1parser{
   
    public static void main (String argv [])
    throws IOException
    {

	try {
	    Parser	parser;
	    SAXParserFactory pf = SAXParserFactory.newInstance ();
          pf.setValidating (true);

	    SAXParser sp = pf.newSAXParser ();
	    parser = sp.getParser ();

	    parser.setDocumentHandler( new DocHandler());// dochandle methods
// will be called by the parser.
	    parser.setErrorHandler (new ErrHandler ());
		org.xml.sax.InputSource is = new org.xml.sax.InputSource("file:/f:/javaxml/part1/extpo1.xml");
		parser.parse(is);
	} catch (Exception e) {
	    System.out.println("   " + e.getMessage ());
	    
	} 
    }

}
/* run this example by passing po1.xml and po2.xml 
and find the difference. Also run this example by 
passing po2 after changing the line   
pf.setValidating (true); to           pf.setValidating (false);
*/
