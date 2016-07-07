/* This  Program demonstrates the use of CharArrayReader
how to create a simple class
Author : Team - J 
Version: 1.0*/
import java.io.*;
class iocstream1  { 
	public static void  main (String args[]) throws Exception{
		char c[] = {'a','b','c','d','e','f','g','h','i','j','k','l'};
		Reader cr = new CharArrayReader(c);
		System.out.println(" Is mark supported by this stream "+cr.markSupported());
		System.out.println(" Next available char = " +(char) cr.read());
		// read multiple chars 
		char tempc[] = new char[c.length];
		//public int read(char[] b,int off,int len)throws IOException
		cr.read(c,0,5);
		//public long skip(long n)throws IOException
		cr.skip(2);
		System.out.println(" Next available char = " + (char)cr.read());
	}
}