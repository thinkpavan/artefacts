/* shows how to write an object to a stream (serialize)
Author : Team -J
Version : 1.0 */
import java.io.*;
import java.net.*;
class NDSer{
	public static void main(String args[]) throws Exception{
		ServerSocket ss = new ServerSocket(5000);	
		// wait for the connections
		Socket s = ss.accept();
		ObjectReader or = new ObjectReader(s);
		or.start();
	}
}

class ObjectReader extends Thread{
	Socket so;
	public ObjectReader(Socket s){
		so = s;
	}
	public void run(){
		try{
		ObjectInputStream ois = new ObjectInputStream(so.getInputStream());
		String s = (String)ois.readObject();
		OurObj o = (OurObj)ois.readObject();
		System.out.println("Object = " + s);
		o.print();
		}catch(Exception e){System.out.println(e);}
	}
}