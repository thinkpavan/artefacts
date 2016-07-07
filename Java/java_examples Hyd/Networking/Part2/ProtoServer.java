/*Shows about Application Level Protocol
Author : Team -J
Version : 1.0 */
/* This Application Follows a simple Protocol as shown below
When a Client Connects to this server this server send data
saying "Iam ready u can send u'r name"
The Client has to respond by sending it's name then
the Server simply says "Hi Good morning --User--"
and closes the connection after recceving bye message from client
*/
import java.net.*;
import java.io.*;

class ProtoServer{
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
		ps.println("I am ready u can send u'r name");
		byte b [] = new byte[1000];
		int k =is.read(b,0,99);
		System.out.println("before reading name");
		String name = new String(b,0,k);
		System.out.println(k + name);
		ps.println("Good Morning " + name);
		ps.println("Good Morning " + name);
		k =is.read(b,0,99);
		String bye;
		bye = new String(b,0,k);
		System.out.println("greeting msg sent" + k);
		k =is.read(b,0,1000);
System.out.println(k+"  amount of data read");
		bye = new String(b,0,k);
		System.out.println(bye +"..."+k);
		k =is.read(b,0,1000);
System.out.println(k+"  amount of data read");
		bye = new String(b,0,k);
		System.out.println(bye +"..."+k);
		k =is.read(b,0,1000);
System.out.println(k+"  amount of data read");
		bye = new String(b,0,k);
		System.out.println(bye +"..."+k);	
		k =is.read(b,0,1000);
System.out.println(k+"  amount of data read");
		bye = new String(b,0,k);
		System.out.println(bye +"..."+k);
		s.close();
// if u'r network is slow we are sure that u will get an exception 
// connection reset by peer
		}catch(Exception e){System.out.println(e);}
	}
}