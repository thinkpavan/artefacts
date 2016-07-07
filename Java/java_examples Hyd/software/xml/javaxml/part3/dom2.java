/* Example to demonstrate how to use dom parser to manuplate
xml contenet.
Author : Team-J
Version: 1.0
*/
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import com.sun.xml.tree.XmlDocument;

public class dom2{
    public static void main (String argv [])throws Exception
    {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance ();
	DocumentBuilder db = dbf.newDocumentBuilder ();
	Document doc = db.newDocument ();
	Element root = doc.createElement ("PurchaseOrder");
	Attr a1;
	doc.appendChild (root);
	Element poline = doc.createElement("POLINE");
	root.appendChild(poline);
	Element itemno = doc.createElement("itemid");
	poline.appendChild(itemno);
	itemno.appendChild(doc.createTextNode("1000"));	
	Element qty = doc.createElement("qty");
	poline.appendChild(qty);
	qty.appendChild(doc.createTextNode("10"));		
	root.setAttribute ("pono", "10");

	// The above creates a tree structure of our xml doc.
// we can use the class XmlDocument class that is provided by sun
// to write the xml in document
System.out.println(doc.getClass());
// the below is not part of standard api , but sun has provided this
XmlDocument xmldoc = (XmlDocument) doc;
 xmldoc.write (System.out);
java.io.FileOutputStream fos = new  java.io.FileOutputStream("newpo2.xml");
xmldoc.write(fos);
fos.close();


    }
}

