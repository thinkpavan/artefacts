/* shows how to use new parser
Version: 1.0
Author : Team -J
*/

import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.util.Vector;

public class xmlapp extends DefaultHandler
{
    StringBuffer curtext;
    boolean ppoline=false;
    boolean poid=false;
    boolean pitemid=false;
    boolean pqty=false;
    String ordid;
    poline p;
    Vector polines = new Vector();
    public static void main(String argv[])
    {
        
        DefaultHandler handler = new xmlapp();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse( new File("po1.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // DocumentHandler methods

    public void startDocument()
    throws SAXException {    }

    public void endDocument()
    throws SAXException
    {
     System.out.println(" Now storing the following data in DataBase");   
     System.out.println("PO ID = "+ ordid.trim());
	for( int i=0; i<polines.size();i++){
		p = (poline)polines.get(i);
		System.out.println(p.itemid + "          "+ p.qty);
	}
// here you can add code to store data in a database using jdbc instead of
// displaying the data.
    }

    public void startElement(String namespaceURI,
                             String sName, // simple name
                             String qName, // qualified name
                             Attributes attrs) throws SAXException
    {
	if(qName.equals("ordID"))
		poid=true;
	if(qName.equals("POLINE")){
		p = new poline();// create a new poline object.
		ppoline = true;
	}
	if(qName.equals("itemid"))
		pitemid=true;
	if(qName.equals("qty"))
		pqty=true;
    }

    public void endElement(String namespaceURI,
                           String sName, // simple name
                           String qName  // qualified name
                          )
    throws SAXException
    {
	if(qName.equals("ordID")){
		poid=false;
		ordid=curtext.toString();
		curtext=null;
	}
	if(qName.equals("POLINE")){
		polines.addElement(p);
		p = null;
		ppoline = false;
	}
	if(qName.equals("itemid")){
		pitemid=false;
		p.itemid=curtext.toString();
		curtext=null;
	}
	if(qName.equals("qty")){
		pqty=false;
		p.qty=curtext.toString();
		curtext=null;
	}
    }

    public void characters(char buf[], int offset, int len)
    throws SAXException
    {
        String s = new String(buf, offset, len);
        if (curtext == null) {
           curtext = new StringBuffer(s);
        } else {
           curtext.append(s);
        }
    }
    
}
