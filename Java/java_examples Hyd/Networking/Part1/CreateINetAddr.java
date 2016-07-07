/*Shows how to create inetaddress instances
Author : Team -J
Version : 1.0 */

import java.net.*;
import java.io.*;

class CreateINetAddr{
  static public void main(String[] args)throws Exception{
	// create a new Server Socket
	try{// get all the address that are bound
		InetAddress ina [] = InetAddress.getAllByName("INETSOLV");
		InetAddress in1 = InetAddress.getByName("INETSOLV");
		InetAddress in2 = InetAddress.getByName("196.12.100.100");
		InetAddress  in3 = InetAddress.getLocalHost();
		System.out.println(in1);
		System.out.println(in2);
		System.out.println(in2);
		System.out.println("host name = " +in1.getHostName());
		System.out.println("host address = " +in1.getHostAddress());
		System.out.println("host address = " +ina[1].getHostAddress());


	}catch(Exception e){}
  }

}

