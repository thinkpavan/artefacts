/*Shows a technique of finding thw details of a protocol
Author : Team -J
Version : 1.0 */

import java.net.*;
import java.io.*;

class WebServer{
  static public void main(String[] args)throws Exception{
	// create a new Server Socket
	try{
		ServerSocket ss = new ServerSocket(100);	
		while(true){
			// wait for the connections
			Socket s = ss.accept();
			ServerThread st = new ServerThread(s);
			st.start();
		}
	}catch(Exception e){}
  }
}
// This server program has bugs!!!
class ServerThread extends Thread{
Socket s;
	public ServerThread(Socket s){
		this.s = s;
	}
	public void run(){
		try{
		PrintStream ps =new PrintStream( s.getOutputStream());
		InputStream is = s.getInputStream();
		byte b [] = new byte[1000];
		int k =is.read(b,0,500);
		String name = new String(b,0,k);
		System.out.println(name);
		s.close();
		}catch(Exception e){System.out.println(e);}
	}
}