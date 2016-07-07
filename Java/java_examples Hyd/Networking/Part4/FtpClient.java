/* show how to get file from ftp servers
Author : Team -J
Version : 1.0 */

import java.net.*;
import java.io.*;

class FtpClient{
  static public void main(String[] args)throws Exception{
	try{
		URL url = new URL("ftp://INETSOLV/getform.htm");
	//	URL url = new URL("ftp://INETSOLV/IISSide.gif");
		URLConnection urc = url.openConnection();
		System.out.println(urc.getClass());
		System.out.println(urc.getContentType());
		System.out.println(urc.getHeaderField("content-type"));
		System.out.println(urc.getLastModified());
		System.out.println(urc.getHeaderField("last-modified "));
	// assuming that there will be less than 15 headers
		for(int i =1;i <15;i++){
			String key = urc.getHeaderFieldKey(i);
			System.out.print(key);
			if(key == null)
				break;
			System.out.println("        "+urc.getHeaderField(i));
		}
	 Object ftpcontent = urc.getContent();
	System.out.println(ftpcontent.getClass());
	byte b[] = new byte[10000];//we can handle files of this size only.
	InputStream is = (InputStream) ftpcontent;
	int l = is.read(b,0,10000);
	String s = new String(b,0,l);// now write the content to file
	System.out.println(s);
	}catch(Exception e){System.out.println(e);}
  }
}

