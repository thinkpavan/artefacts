/*Shows how to develop a simple network server
Author : Team -J
Version : 1.0 */

import java.net.*;
import java.io.*;

class Server1{
  static public void main(String[] args)throws Exception{
	// create a new Server Socket
	try{
		ServerSocket ss = new ServerSocket(16000);	
		// wait for the connections
		Socket s = ss.accept();
	}catch(Exception e){System.out.print(e);}
  }
}

