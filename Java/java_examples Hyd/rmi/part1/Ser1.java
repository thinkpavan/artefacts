/* shows how to write an object to a stream (serialize)
Author : Team -J
Version : 1.0 */
import java.io.*;
class Ser1{
	public static void main(String args[]) throws Exception{
		String s = new String(" xxxxx");
		FileOutputStream fis = new FileOutputStream("ser1.txt");
		ObjectOutputStream  os = new ObjectOutputStream (fis);
		os.writeObject(s);
            Byte b=new Byte("65");
            os.writeObject(b);
		fis.close();
	}
}

