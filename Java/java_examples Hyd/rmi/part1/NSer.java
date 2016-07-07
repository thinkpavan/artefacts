/* shows how to write an object to a stream (serialize)
Author : Team -J
Version : 1.0 */
import java.io.*;
import java.net.*;

class NSer{
	public static void main(String args[]) throws Exception{
		String s = new String(" before serializing");
		Socket so = new Socket("127.0.0.1",5000);
		OutputStream fis = so.getOutputStream();
		ObjectOutputStream  os = new ObjectOutputStream (fis);
		OurObj o = new OurObj(100,200,300);
		o.print();
		os.writeObject(s);
		os.writeObject(o);
		so.close();
	}
}

