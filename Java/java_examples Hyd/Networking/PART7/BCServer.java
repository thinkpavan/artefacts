/*Shows how to write an udp multicast program
Author : Team -J
Version : 1.0 */

/*A multicast group is specified by a class D IP address, those in the range
 224.0.0.1 to 239.255.255.255, inclusive, and by a standard UDP port number.
from javadoc */

import java.io.*;
import java.net.*;
class BCServer{
  static public void main(String[] args)throws Exception{
	try{
	InetAddress mcgrp = InetAddress.getByName("230.1.1.1");
 	MulticastSocket mcs = new MulticastSocket(16000);
	System.out.println("joined group");
	 mcs.joinGroup(mcgrp); 
	byte videoframe[] = new byte[1000];
	String s1 = new String("This is first video Frame");
	s1.getBytes(0,s1.length(),videoframe,0);
	DatagramPacket vf = new DatagramPacket(videoframe, s1.length(), mcgrp, 16000);
	mcs.send(vf);
	System.out.println(" vf 1 sent successfully");
	}catch(Exception e){ System.out.println(e);}
  }
}

