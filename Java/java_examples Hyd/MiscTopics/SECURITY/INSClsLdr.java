/* Shows how to create our own class loader
Author : Team -J
Version : 1.0
*/
import java.io.*;
import java.security.*;

public class INSClsLdr extends SecureClassLoader {
	// secure class loader cannot be instantiated as it's 
	// constructors and other methods are protected, so we are
	// creating a sub class of this class here.
	public INSClsLdr(){
		super();
	}
	public INSClsLdr(ClassLoader parent){
		super(parent);
	}
	// code source can be used to store the urls and other info
	// we will now use it as null
	public  Class defineClass(String name){
		// we will check for files only in c directory
		byte b[];
		int len ;
		try{
			FileInputStream fis = new FileInputStream("c:\\"+name+".class");
			len = fis.available();
			b = new byte[len];// use some other method to read the entire file
			fis.read(b,0,len);
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
		return super.defineClass(name,b,0,len,(CodeSource)null);
	}
}

