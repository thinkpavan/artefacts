/* show how to get information about http headers
Author : Team -J
Version : 1.0 */

import java.net.*;
import java.io.*;

class HttpHead{
  static public void main(String[] args)throws Exception{
	try{
		URL url = new URL("http://INETSOLV/default.htm");
	//	URL url = new URL("http://INETSOLV/IISSide.gif");
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
	 Object httpcontent = urc.getContent();
	System.out.println(httpcontent.getClass());
	System.out.println(httpcontent);
	}catch(Exception e){System.out.println(e);}
  }
}

