/* some class
Author : Team -J
Version : 1.0 */
import java.io.*;
import java.net.*;
class OurObj implements Serializable{
//class OurObj  {

	int i;
	int k;
        int a;
	transient int z;
	transient Socket s;
	OurObj(int a,int b,int c)throws Exception{
		System.out.println("in 3 arg constructor");
		i=a;
		k=b;
		z=c;
		s = new Socket();
	}
	OurObj(){
		System.out.println("in 0 arg constructor");
	}
	public void print(){
		System.out.println(i);
		System.out.println(k);
		System.out.println(z);
		System.out.println(s);
	}
	public void meth1(int a){
                System.out.println("in meth1"+a);
	}
}

