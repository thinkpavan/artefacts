/* Example to demonstrate how our business apps can take the data
from xml doc and store it in a database.
Author : Team-J
Version: 1.0
*/
import java.io.*;
import java.util.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.*;

class DocHandler implements DocumentHandler{
	Locator l;
	Vector itemid = new Vector();
	Vector qty = new Vector();
	boolean isitemid=false,isqty=false;
    // methods of DocumentHandler
    public void setDocumentLocator (Locator l)
    {
	this.l=l;
	System.out.println(" set locator called");
    }

    public void startDocument ()  throws SAXException
    {
    }

    public void endDocument ()     throws SAXException
    {
		System.out.println(" in end doc***");
		Enumeration e1 = itemid.elements();
		Enumeration e2 = qty.elements();
		System.out.println(" here are the details of the PO");
		while(e1.hasMoreElements()){
			System.out.println( "itemid   "+e1.nextElement()+"     qty   "+ e2.nextElement());
		}
    }

    public void startElement (String tag, AttributeList attrs)
    throws SAXException
    {
	if(tag.equals("itemid"))
		isitemid=true;
	if(tag.equals("qty"))
		isqty=true;
    }

    public void endElement (String name)  throws SAXException
    {
	if(name.equals("itemid"))
		isitemid=false;
	if(name.equals("qty"))
		isqty=false;

    }

    public void characters (char buf [], int offset, int len)
    throws SAXException
    {
	String s = new String(buf,offset,len);
	System.out.println(s);

	if(isitemid)
		itemid.addElement(s);
	
	if(isqty)
		qty.addElement(s);		
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





public class storedata{
   
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
		org.xml.sax.InputSource is = new org.xml.sax.InputSource("file:/f:/xmlcourse/javaxml/part1/po1.xml");
		parser.parse(is);
	} catch (Exception e) {
	    System.out.println("   " + e.getMessage ());
	    
	} 
    }

}

