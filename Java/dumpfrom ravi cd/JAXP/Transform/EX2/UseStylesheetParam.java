import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import java.io.*;
 /* Use command-line input as a stylesheet parameter. */
public class UseStylesheetParam
{
  public static void main(String[] args){
    if(args.length != 1)
    {
      System.err.println("Please pass one string to this program");
      return;
    }
		try{
	    	String paramValue = args[0];
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer = tFactory.newTransformer(new StreamSource("foo.xsl"));
		transformer.setParameter("param1",paramValue);
    		transformer.transform(new StreamSource("foo.xml"), new StreamResult(System.out));
		}catch(Exception e){System.out.println("Exception"+e);}
  }   
}