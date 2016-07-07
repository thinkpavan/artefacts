/* shows how to write an object to a stream (serialize)
Author : Team -J
Version : 1.0 */
import java.io.*;
class DSer2{
	public static void main(String args[]) throws Exception{
		FileInputStream fis = new FileInputStream("ser2.ser");
		ObjectInputStream  os = new ObjectInputStream (fis);
		String s = (String)os.readObject();
		String s1 = (String)os.readObject();
		System.out.println(s);
		System.out.println(s1);
		fis.close();
	}
}

