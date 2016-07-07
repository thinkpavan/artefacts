/* This class file runs other java program
Author : Team -J
Version : 1.0
invoke this program as java RunJava anotherjavafile
*/
import java.lang.reflect.*;
public class RunJava{
	public static void main(String args[])throws Exception{
		INSClsLdr cl = new INSClsLdr();
		Class prog = cl.loadClass(args[0]);
		System.out.println("Class Loaded ...");
    Class arg[] = new Class[] {String[].class};
    String a[] = new String[0];
    Object o[] = new Object[1];
    o[0]= a;
    Method  mm =  prog.getMethod("main",arg);
    mm.invoke(null,o);     // this may throw an exception if prog class doesn't have main method.
	}
}

