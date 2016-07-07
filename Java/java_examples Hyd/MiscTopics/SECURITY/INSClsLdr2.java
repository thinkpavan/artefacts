/* Shows how to create our own class loader
Author : Team -J
Version : 1.0
*/
import java.io.*;
import java.security.*;
import java.net.*;

public class INSClsLdr2 extends URLClassLoader {
	static URL urllist[] = new URL[3];
	static{
		try{
		urllist[0]=new URL("http://localhost/");
		urllist[1] = new URL("http://www.inetsolv.com/java_classes/");
		urllist[2]=new URL("file:/c:/");

		}catch(Exception e){
			System.out.println(e);
		}
	}
	public INSClsLdr2(){
		super(urllist);
	}
}

