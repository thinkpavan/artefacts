/*Shows how to get all local address
Author : Team -J
Version : 1.0 */

import java.net.*;
import java.io.*;

class Address{
  static public void main(String[] args)throws Exception{
	// create a new Server Socket
	try{// get all the address that are bound
		InetAddress ina [] = InetAddress.getAllByName("INETSOLV");
// get the address that point to inetsolv
		for(int i =0;i<ina.length;i++){
				System.out.println(ina[i]);
		}
	System.out.println(" local address " + InetAddress.getByName("INETSOLV"));
	System.out.println(" local address " + InetAddress.getByName("196.12.100.100"));
	}catch(Exception e){}
  }

}

