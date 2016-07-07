/*Shows how to develop a simple network Client
Author : Team -J
Version : 1.0 */

import java.io.*;
import java.net.*;
class Client2{
  static public void main(String[] args)throws Exception{
	//create a Socket 	
	try{
		Socket s = new Socket(InetAddress.getLocalHost(),16000);
		System.out.println("Connected to Server Successfully");
		PrintStream ps =new PrintStream( s.getOutputStream());
		InputStream is = s.getInputStream();
		Thread.currentThread().sleep(60000);
		byte b [] = new byte[100];
		int k =is.read(b,0,99);
		for(int i =0;i<k;i++){
			char c = (char)b[i];
			System.out.print(c);
		}
		ps.println("Thank u ,Bye..");
	System.out.println(" Local Port = "+ s.getLocalPort());
	}catch(Exception e){ System.out.println(e);}
  }
}

