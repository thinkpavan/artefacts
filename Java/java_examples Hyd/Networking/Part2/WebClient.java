/*Shows how to connect to a web server
Author : Team -J
Version : 1.0 */

import java.io.*;
import java.net.*;
class WebClient{
  static public void main(String[] args)throws Exception{
	//create a Socket 	
	try{
		Socket s = new Socket(InetAddress.getLocalHost(),80);
		System.out.println("Connected to Server Successfully");
		PrintStream ps =new PrintStream( s.getOutputStream());
		InputStream is = s.getInputStream();
		ps.println("get default.htm");
		byte b[] = new byte [10000];
// this is definitely a bad way of getting a web document
		while(true){
		int k = is.read(b,0,1000);
		String f = new String(b,0,k);
		System.out.println(f + k);
		}
	//	s.close();
	}catch(Exception e){ System.out.println(e);}
  }
}

