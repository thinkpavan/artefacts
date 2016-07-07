/* Shows how to create our own class loader
Author : Team -J
Version : 1.0
*/
import java.io.*;
import java.security.*;
import java.net.*;

public class INSClsLdr1 extends URLClassLoader {
	static URL urllist[] = new URL[2];
	static{
		try{
		urllist[0]=new URL("http://localhost/");
		urllist[1] = new URL("http://www.inetsolv.com/java_classes/");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public INSClsLdr1(){
		super(urllist);
	}
}

