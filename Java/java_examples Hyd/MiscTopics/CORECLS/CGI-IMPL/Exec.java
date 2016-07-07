/* Shows how to execute another program from a java program
This program shows how exactly a webserver runs a CGI script.
Author : Team -J
Version : 1.0
*/

import java.io.*;
import java.net.*;

public class Exec{
	public static void main(String args[])throws Exception{
		String envvars[]= new String[3];
		envvars[0]= new String("SERVER_SOFTWARE=HWebServer1");
		envvars[1]= new String("SERVER_NAME=xyz.com");
		envvars[2]= new String("REQUEST_METHOD=unknown");
		Process p = Runtime.getRuntime().exec(new String("postmethod"),envvars);
		InputStream pin = p.getInputStream();//stdout of created process
		OutputStream pou = p.getOutputStream();//stdin of process
		InputStream pes = p.getErrorStream();//stderr of process
		OutputThread ot = new OutputThread(pou);
		ot.start();
		while(true){
			try{
				p.exitValue(); //throws exception if process is running
				ot.stop();//even though it is deprecated we have no problem using this method here
				break;
			}catch(IllegalThreadStateException its){
				System.out.println("process still alive");
			// web server passes the data it has received from web clients
				byte b[] = new byte[1000];
				int nob=0;
				System.out.println("Before Read");
				nob = pin.read(b,0,1000);
				System.out.println("After Read");
				for(int i =0;i<nob;i++)
					System.out.print((char)b[i]);
			}
		}
	}	
}

// this class pumps data required for the other process,
// in webserver implementation we need to implement a class similar to this
// which pumps data recieved from network client
class OutputThread extends Thread{
OutputStream os;
	public OutputThread( OutputStream os){
		this.os = os;
	}
	public void run(){
		while(true){
			try{
				os.write(65);
			}catch(Exception e ){}
		}
	}
}