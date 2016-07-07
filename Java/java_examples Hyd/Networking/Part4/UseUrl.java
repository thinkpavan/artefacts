/*Shows how to use url
Author : Team -J
Version : 1.0 */

import java.net.*;
import java.io.*;

class UseUrl{
  static public void main(String[] args)throws Exception{
	try{
		URL url = new URL("http://INETSOLV/default.htm");
		System.out.println("after consructing first url");
		URL url1 = new URL("http://INETSOLV:8080/contents.txt");	
		System.out.println("after consructing second url");
		URL url2 = new URL("ftp://INETSOLV:8080/contents.txt");	
		System.out.println("after consructing third url");
		URL url4 = new URL("jar:http://INETSOLV:8080/contents.jar!/");	
		System.out.println("after consructing fourth url");
		URL url3 = new URL("xxx://INETSOLV:888/contents.txt");	
		System.out.println("after consructing fifth url");
	}catch(Exception e){System.out.println(e);}
  }
}

