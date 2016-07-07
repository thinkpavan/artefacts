/* This  Program demonstrates the use of ByteInputStream
how to create a simple class
Author : Team - J 
Version: 1.0*/
import java.io.*;
class iostream1  { 
	public static void  main (String args[]) throws Exception{
		// input stream is an abstract super class for all classes
		// that represent input stream.
		byte c[] = {22,23,24,25,26,27,28,29,30,31,32};
		// create a ByteArrayInputStream and store the reference in
		// it's abstract super class InputStream
		InputStream in = new ByteArrayInputStream(c);
		System.out.println(" Is mark supported by this stream "+in.markSupported());
		// we don't need to use mark method here (Initial mark supporting
		// stream marks the first byte as marked
		in.mark(10);
		//read returns -1 to indicate that there is nothing to read.
		System.out.println(" Next available byte = " + in.read());
		// read bytes can be used to read multiple bytes
		byte b[]= new byte[20];
		in.read(b,0,3);
		int i;
		for(i=0;i<3;i++)
			System.out.print(b[i]+"  ");
		System.out.println();
		in.reset(); // move back to previously marked position
		System.out.println(" bytes read =" + in.read(b,0,13));
		// all the bytes were read, let us try to read one more byte
		System.out.println(" in.available() " + in.available());
		System.out.println(in.read());
		System.out.println("---------------------------");
	
	}
}