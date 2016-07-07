/* shows how to write an object to a stream (serialize)
Author : Team -J
Version : 1.0 */
import java.io.*;
class Ser3{
	public static void main(String args[]) throws Exception{
		OurObj s = new OurObj(10,20,30);
                   s.meth1(999);
		FileOutputStream fis = new FileOutputStream("ser3.ser");
		ObjectOutputStream  os = new ObjectOutputStream (fis);
		 //s.meth1(999);
		os.writeObject(s);
		s.print();
           
		fis.close();
	}
}

