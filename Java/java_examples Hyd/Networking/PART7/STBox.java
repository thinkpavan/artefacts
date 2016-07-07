/*Shows how video frames can be received by a set top box
Author : Team -J
Version : 1.0 */

/*A multicast group is specified by a class D IP address, those in the range
 224.0.0.1 to 239.255.255.255, inclusive, and by a standard UDP port number.
from javadoc */

import java.io.*;
import java.net.*;
class STBox{
  static public void main(String[] args)throws Exception{
	try{
	InetAddress mcgrp = InetAddress.getByName("230.1.1.1");
 	MulticastSocket mcs = new MulticastSocket(16000);
	System.out.println("after first socket");
 	MulticastSocket mcs1 = new MulticastSocket(16000);
	System.out.println("after second socket");
	 mcs1.joinGroup(mcgrp); 	
	System.out.println("joined group");
	 mcs.joinGroup(mcgrp); 
	byte vf[] = new byte[1000];
	DatagramPacket dgp = new DatagramPacket(vf,1000);
	mcs.receive(dgp);
	System.out.println("This Socket is connected to " +mcs.getInetAddress());
	String s = new String(dgp.getData(),0,dgp.getLength());
	System.out.println(s);
	System.out.println(" vf 1 received successfully");

// second multicast socket
	/*byte vf1[] = new byte[1000];
	DatagramPacket dgp1 = new DatagramPacket(vf,1000);
	mcs1.receive(dgp);
	System.out.println("This Socket is connected to " +mcs1.getInetAddress());
	String s1 = new String(dgp1.getData(),0,dgp1.getLength());
	System.out.println(s1);*/
	}catch(Exception e){ System.out.println(e);}
  }
}

