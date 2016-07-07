/* This is to show how to use java security features
Author : Team -J
Version : 1.0
 run this prog using java -Djava.security.policy==mypolicy1 -Djava.security.manager 
 TestSec
or directly use the script testsec2 TestSec
*/
import java.net.*;
import java.io.*;

class TestSec{
  static public void main(String[] args)throws Exception{
	System.out.println(System.getSecurityManager());
	try{
		ServerSocket ss = new ServerSocket(10090);	
		// wait for the connections
		Socket s = ss.accept();
	}catch(Exception e){System.out.print(e);}
  }
}

