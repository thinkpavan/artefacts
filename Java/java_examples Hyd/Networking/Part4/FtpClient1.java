/* show how to get information about http headers
Author : Team -J
Version : 1.0 */

import java.net.*;
import java.io.*;

class FtpClient1{
  static public void main(String[] args)throws Exception{
	try{
		URL url = new URL("ftp://INETSOLV/getform.htm");
		URLConnection urc = url.openConnection();
		urc.setDoOutput(true);
		urc.setDoInput(true);
		System.out.println("User Ineraction Allowed " +urc.getAllowUserInteraction());
		urc.setAllowUserInteraction(true);
		System.out.println("User Ineraction Allowed " +urc.getAllowUserInteraction());
	//	Object ftpcnt = urc.getContent(); uncomment this and see !!!
	PrintStream ps = new PrintStream(urc.getOutputStream());
	// we get the above stream to pass data to ftp server
	ps.print("user INETSOLV\\Administrator \r\n");
	ps.print("pass posani \r\n");
	ps.flush();
	Object ftpcnt = urc.getContent(); 

	}catch(Exception e){System.out.println(e);}
  }
}

