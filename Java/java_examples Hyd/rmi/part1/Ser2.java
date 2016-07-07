/* shows how to write an object to a stream (serialize)
Author : Team -J
Version : 1.0 */
import java.io.*;
class Ser2{
	public static void main(String args[]) throws Exception{
		String s = new String(" before serializing");
		String s1 = new String("...... before serializing.......");
		FileOutputStream fis = new FileOutputStream("ser2.ser");
		ObjectOutputStream  os = new ObjectOutputStream (fis);
		os.writeObject(s);
		os.writeObject(s1);
		fis.close();
	}
}

