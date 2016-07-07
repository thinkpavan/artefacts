/* Responds to the
 client with an image*/

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class simpleimage extends HttpServlet
{
  public void service(HttpServletRequest req, HttpServletResponse res) throws IOExcepiton
  {
    res.setContentType("image/jpeg");
    File f = new File("servlets/", "viagaa07.jpg");
    int size = (int)f.length();
    res.setContentLength(size);
    byte[] buf= new byte[size];
    FileInputStream fin = new FileInputStream(f);
    in.read(buf);
    res.getOutputStream().write(buf);
    res.getOutputStream().close();
  }
}
