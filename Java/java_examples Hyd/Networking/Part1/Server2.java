/*Shows how to develop a simple network server
Author : Team -J
Version : 1.0 */

import java.net.*;
import java.io.*;

class Server2{
  static public void main(String[] args)throws Exception{
	// create a new Server Socket
	try{
		ServerSocket ss = new ServerSocket(16000,1);	
	  while(true){// set queue length to 1
		// wait for the connections
		Socket s = ss.accept();
		// get the output stream associated with socket
		// to write something to the socket
		PrintStream ps =new PrintStream( s.getOutputStream());
		InputStream is = s.getInputStream();
		ps.println("I am ready to provide xxx Service");
		byte b [] = new byte[100];
		int k =is.read(b,0,99);
		for(int i =0;i<k;i++){
			char c = (char)b[i];
			System.out.print(c);
		}
		System.out.println("local Address = " + s.getLocalAddress());
		System.out.println("local Port = " + s.getLocalPort());
		System.out.println("Server local Port = " + ss.getLocalPort());

		// close the connection
		is.close();
		s.close();
	}
	}catch(Exception e){}
  }
}

