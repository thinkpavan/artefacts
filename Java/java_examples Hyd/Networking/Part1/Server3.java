/*Shows how to develop a simple network server
Author : Team -J
Version : 1.0 */

import java.net.*;
import java.io.*;

class Server3{
  static public void main(String[] args)throws Exception{
	// create a new Server Socket
	try{
		ServerSocket ss = new ServerSocket(16000);	
		while(true){
			// wait for the connections
			Socket s = ss.accept();
			ServerThread st = new ServerThread(s);
			st.start();
		}
	}catch(Exception e){}
  }
}

class ServerThread extends Thread{
Socket s;
	public ServerThread(Socket s){
		this.s = s;
	}
	public void run(){
		try{
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
		System.out.println( "current thread = " +Thread.currentThread());

		}catch(Exception e){}
	}
}