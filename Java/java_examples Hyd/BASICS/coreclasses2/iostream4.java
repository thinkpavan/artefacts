/* This  Program demonstrates the use of FilterInputStream
Author : Team - J 
Version: 1.0*/
import java.io.*;
class iostream4  { 
	public static void  main (String args[]) throws Exception{
		byte c1[] = {22,23,24,25,26,27,28,29,30,31,32};
		byte c2[] = {2,3,4,5,6,7,8,9,0,1,2};
		InputStream in = new ByteArrayInputStream(c1,0,10);
		//FilterInputStream f1= new FilterInputStream(in);
		// only sub classes can call the above constructor as
		// the constructor is protected
		FilterInputStream f1=new  BufferedInputStream(in);
		System.out.println(f1.read());
		// we can use all the method available on inputstreams
		// filterinput streams provides additional filtering in this
		// case Bufferedinputstream maintains internal buffer to improve
		// performance
	}
}