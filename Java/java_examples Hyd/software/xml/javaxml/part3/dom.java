/* Example to demonstrate how to use dom parser to manuplate
xml contenet.
Author : Team-J
Version: 1.0
*/
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class dom{
    public static void main (String argv [])throws Exception
    {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance ();
	dbf.setValidating(true);
	DocumentBuilder db = dbf.newDocumentBuilder ();
	Document doc = db.parse (new File("po1.xml"));
System.out.println(db.isValidating());
System.out.println("...---------------------------------...");

// from the document object we can parse the xml in a very easy way
// but this takes lot of memory if the document to be pased is  very big
	Element root = doc.getDocumentElement();
	System.out.println(root.getTagName());
	NodeList nl = root.getChildNodes();
	System.out.println(" no of nodes for root =  "+ nl.getLength());
	for(int i =0 ;i<nl.getLength();i++){
		Node n = nl.item(i);
		System.out.println("..."+n.getNodeValue());
		System.out.println("..."+ n.getNodeName());	
		System.out.println("..."+n.getNodeType());
	}
    }
}

