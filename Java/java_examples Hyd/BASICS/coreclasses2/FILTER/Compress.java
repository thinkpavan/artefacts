/* This  Program show how to compress  content of file
Author : Team - J 
Version: 1.0*/
import java.io.*;
import java.util.zip.*;
class Compress{ 
	public static void  main (String args[]) throws Exception{
		// construct an input stream which holds the data that has to be compressed
		FileInputStream fis = new FileInputStream("whatisios1.bmp");
		FileOutputStream fos = new FileOutputStream ("comp.bmp");
		DeflaterOutputStream dos = new DeflaterOutputStream(fos);
		int data;
		while ( (data = fis.read()) != -1){
			dos.write(data);
		}
		dos.close();
	}
}