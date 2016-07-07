import javax.xml.parsers.*;
import org.xml.sax.*;
public class FirstSax{
public static void main(String args[]){
	try{
	SAXParserFactory spf=SAXParserFactory.newInstance();
	SAXParser sp=spf.newSAXParser();
	MySax s=new MySax();
	sp.parse("empdetails.xml",s);
	}catch(Exception e){System.out.println("Exception"+e);}
	}
}
class MySax extends HandlerBase{
	public void startDocument(){
		System.out.println("Document is Started");
		}
	public void endDocument(){
		System.out.println("Document is Ended");
		}
	public void startElement(String tagname,AttributeList list){
		System.out.println("opening tagName="+tagname);
		for(int i=0;i<list.getLength();i++){
	              System.out.println("the attribute name is"+list.getName(i));
        	      System.out.println("the attribute value is"+list.getValue(list.getName(i)));
            		}
		}

	public void endElement(String tagname){
		System.out.println("Ending tagName="+tagname);
		}
	public void characters(char ch[],int start,int len){
		System.out.println("The Value of tag");
                for(int i=start;i<start+len;i++)
                System.out.print(ch[i]);
                System.out.println();
        }


	public void fatalError(SAXParseException se){
		System.out.println("fatalError In Parsing......"+se);
		}
	public void error(SAXParseException se){
		System.out.println("Error In Parsing......"+se);
		}
	public void warning(SAXParseException se){
		System.out.println("warning In Parsing......"+se);
		}

}


