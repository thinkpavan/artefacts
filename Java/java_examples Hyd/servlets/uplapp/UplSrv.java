/* shows how to Upload a File 
 * version :1.0
 * Author : Team -J. 
 */


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javazoom.upload.MultipartFormDataRequest;
import java.util.Hashtable;
import java.util.Enumeration;
import javazoom.upload.UploadFile;


public class UplSrv extends HttpServlet { 
  
  public void doPost (HttpServletRequest req, HttpServletResponse res)
       throws ServletException, IOException
  {
    PrintWriter out = res.getWriter();
    out.println("<HEAD><TITLE> " + "File Upload  " +
                "</TITLE></HEAD><BODY>");
    Hashtable ht;
    UploadFile curfile;
/* create a parser for parsing form data */
    try{
	    MultipartFormDataRequest nreq = new MultipartFormDataRequest(req);
          ht = nreq.getFiles();
          Enumeration files = ht.elements();
    	    while(files.hasMoreElements()){
		curfile = (UploadFile) files.nextElement();
	      out.println(curfile.getFileName() +"<BR>");
          }
	}catch(Exception e){
	out.println(e);
    }
    out.println("<h1> Thank U for Submitting File </h1></body></html>");
    out.close();
  }
  

}
