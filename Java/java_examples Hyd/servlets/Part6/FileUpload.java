/* shows how to Upload a File 
 * version :1.0
 * Author : Team -J. 
 */


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.Enumeration;


public class FileUpload extends HttpServlet { 
  
  public void doPost (HttpServletRequest req, HttpServletResponse res)
       throws ServletException, IOException
  {
    // Store the content of the posted data in a file, We know that
    // we will get more data than the content of the file here.
	FileOutputStream fos = new FileOutputStream("fileupload.dat");
	PrintStream ps = new PrintStream(fos);
	// let us write some debugging info into the file first
	ps.print(req.getContentType()+"\r\n");
	ps.print(req.getContentLength()+"\r\n");
	ps.print("--------------------------\r\n");
	InputStream in = req.getInputStream();
	while(true){
		byte b[] = new byte[1000]; 
		int i  = in.read(b,0,1000);
		if(i==-1)// we we reach the end of stream then stop reading
			break;
		fos.write(b,0,i);
	}
	fos.close();   
    // set content type and other response header fields first
    res.setContentType("text/html");    
    // then write the data of the response
    PrintWriter out = res.getWriter();
    out.println("<HEAD><TITLE> " + "File Upload  " +
                "</TITLE></HEAD><BODY>");
    out.println("<h1> Thank U for Submitting File </h1>");
    out.close();
  }
  

}
