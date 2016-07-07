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
import javazoom.upload.UploadBean;

public class UplSrv2 extends HttpServlet { 
  
  public void doPost (HttpServletRequest req, HttpServletResponse res)
       throws ServletException, IOException
  {
    PrintWriter out = res.getWriter();
    try{
   	 UploadBean upb = new UploadBean();
   	 upb.setFolderstore("c:/store");
	 upb.setOverwrite(true);
   	 out.println("<HEAD><TITLE> " + "File Upload  " +
                "</TITLE></HEAD><BODY>");
    	Hashtable ht;
    	UploadFile curfile;
/* create a parser for parsing form data */
	    MultipartFormDataRequest nreq = new MultipartFormDataRequest(req);
	    out.println(nreq.getParameter("ename")+"****<br><br>");
          ht = nreq.getFiles();
          Enumeration files = ht.elements();
    	    while(files.hasMoreElements()){
		curfile = (UploadFile) files.nextElement();
	      out.println(curfile.getFileName() +"<BR>");
		upb.store(nreq);		
          }
	}catch(Exception e){
	out.println(e);
    }
    out.println("<h1> your files are saved</h1></body></html>");
    out.close();
  }
  

}
