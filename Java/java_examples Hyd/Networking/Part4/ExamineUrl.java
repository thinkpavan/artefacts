/*Shows how to use url
Author : Team -J
Version : 1.0 */

import java.net.*;
import java.io.*;

class ExamineUrl{
  static public void main(String[] args)throws Exception{
	try{
		URL url = new URL("http://INETSOLV/default.htm");
		URLConnection urc = url.openConnection();
		System.out.println(urc.getClass());
		URL url1 = new URL("ftp://INETSOLV/default.htm");
		URLConnection urc1 = url1.openConnection();
		System.out.println(urc1.getClass());
		URL url2 = new URL("jar:http://INETSOLV/default.jar!/");
		URLConnection urc2 = url.openConnection();
		System.out.println(urc2.getClass());

		/*URL url2 = new URL("nntp://INETSOLV/default.htm");
		URLConnection urc2 = url.openConnection();
		System.out.println(urc2.getClass());
		URL url3 = new URL("smtp://INETSOLV/default.htm");
		URLConnection urc3 = url1.openConnection();
		System.out.println(urc3.getClass());*/
//we can use getprotocol,getport,gethost,getref,getfile this returns both file and path
		InputStream is =  url.openStream();
		byte b[] = new byte[10000];
		int nob = is.read(b,0,10000);
		String s = new String(b,0,nob);
		System.out.println(s);
//when we tested we got only half of the file so we tried to use a silly trick here
	/*	nob = is.read(b,0,10000);
		 s = new String(b,0,nob);
		System.out.println(s);*/
// when we use raw openstream we will not get the http headers to get http header details we have to
// use open connection
	}catch(Exception e){System.out.println(e);}
  }
}

