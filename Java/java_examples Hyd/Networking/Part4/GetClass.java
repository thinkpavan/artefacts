/* show how to get a class file from web server
Author : Team -J
Version : 1.0 */

import java.net.*;
import java.io.*;

class GetClass{
  static public void main(String[] args)throws Exception{
	try{
		URL url = new URL("http://INETSOLV/ExamineUrl.class");
	//	URL url = new URL("http://INETSOLV/IISSide.gif");
		URLConnection urc = url.openConnection();
		System.out.println(urc.getClass());
	// assuming that there will be less than 15 headers
		for(int i =1;i <15;i++){
			String key = urc.getHeaderFieldKey(i);
			System.out.print(key);
			if(key == null)
				break;
			System.out.println("        "+urc.getHeaderField(i));
		}
	Object httpcontent = urc.getContent();
	byte b[] = new byte[10000];//we can handle files of this size only.
	InputStream is = (InputStream) httpcontent;
	int l = is.read(b,0,10000);
	String s = new String(b,0,l);// now write the content to file
	System.out.println(s);
	}catch(Exception e){System.out.println(e);}
  }
}

