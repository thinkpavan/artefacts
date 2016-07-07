/* shows how to write an object to a stream (serialize)
Author : Team -J
Version : 1.0 */
import java.io.*;
class DSer3{
	public static void main(String args[]) throws Exception{
		FileInputStream fis = new FileInputStream("ser3.ser");
		ObjectInputStream  os = new ObjectInputStream (fis);
		OurObj s = (OurObj)os.readObject();
		fis.close();
		s.print();
            s.meth1(int a);
	}
}

