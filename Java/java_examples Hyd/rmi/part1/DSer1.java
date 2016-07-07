/* shows how to write an object to a stream (serialize)
Author : Team -J
Version : 1.0 */
import java.io.*;
class DSer1{
	public static void main(String args[]) throws Exception{
		FileInputStream fis = new FileInputStream("ser1.txt");
		ObjectInputStream  os = new ObjectInputStream (fis);
		String s = (String)os.readObject();
            Byte n=(Byte)os.readObject();
		fis.close();
		System.out.println(s);
            System.out.println(n);

	}
}

