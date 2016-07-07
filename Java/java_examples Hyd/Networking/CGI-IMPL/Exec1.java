/* Shows how to execute another program from a java program
This program shows how exactly a webserver runs a CGI script.
Author : Team -J
Version : 1.0
*/

import java.io.*;
import java.net.*;

public class Exec1{
	public static void main(String args[])throws Exception{
		String envvars[]= new String[3];
		envvars[0]= new String("SERVER_SOFTWARE=HWebServer1");
		envvars[1]= new String("SERVER_NAME=xyz.com");
		envvars[2]= new String("REQUEST_METHOD=unknown");
		Process p = Runtime.getRuntime().exec(new String("java RunMe"),envvars);
		InputStream pin = p.getInputStream();//stdout of created process
		OutputStream pou = p.getOutputStream();//stdin of process
		InputStream pes = p.getErrorStream();//stderr of process
		// web server carriers out the following in a seperate thread
		while(true){
// we can use the following technique to continuously monitor for in/out's of cgi program
			try{
				p.exitValue(); //throes exception if process is running
				break;
			}catch(IllegalThreadStateException its){
				System.out.println("process still alive");
			// web server passes the data it has received from web clients
				byte b[] = new byte[1000];
				int nob;
				nob = pin.read(b,0,1000);
// we are just printing on console here,
// we can pass this data on network socket
//just to get out of a problem , a ver bad technique
	Thread.currentThread().sleep(1000);
				for(int i =0;i<nob;i++)
					System.out.print((char)b[i]);

	PrintStream ps = new PrintStream(pou);
	ps.print("This is from web clientghjghghjghjghjghjghjghjghjghjghjghghjghjgjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
			pou.write(65);
			pou.write(65);
			pou.write(65);
			pou.write(65);
			pou.write(65);
			pou.write(65);
			pou.write(65);
			pou.write(65);
			pou.write(65);

			}
		}
	}	
}