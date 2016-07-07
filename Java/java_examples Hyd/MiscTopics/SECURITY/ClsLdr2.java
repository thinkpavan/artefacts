/* Shows how to use classloaders
Author : Team -J
Version : 1.0
*/
import java.io.*;
public class ClsLdr2{
	public static void main(String args[])throws Exception{
		System.out.println(new File ("c:\\").toURL());
		INSClsLdr2 cl = new INSClsLdr2();
		cl.loadClass("Comman");
		Class c = cl.loadClass("ComCls");
		System.out.println(c);
		Object in = c.newInstance();
		System.out.println(in);
		System.out.println(c.getClassLoader());
		Comman i = (Comman)in;
		Class ci = i.getClass();
		System.out.println(ci.getClassLoader());
		i.dosomething();
	//	ComCls cc = (ComCls) in; //is this possible??
	}	
}

