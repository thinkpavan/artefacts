/*Shows how to write an udp multicast program
Author : Team -J
Version : 1.0 */

/*A multicast group is specified by a class D IP address, those in the range
 224.0.0.1 to 239.255.255.255, inclusive, and by a standard UDP port number.
from javadoc */

import java.io.*;
import java.net.*;
class BCServer1{
  static public void main(String[] args)throws Exception{
	try{
	InetAddress mcgrp = InetAddress.getByName("230.1.1.1");
 	MulticastSocket mcs = new MulticastSocket(16000);
	System.out.println("joined group");
//we need not joing group to send message to group
	 mcs.joinGroup(mcgrp); 
	byte videoframe[] = new byte[1000];
	String s1 = new String("This is first video Frame");
	s1.getBytes(0,s1.length(),videoframe,0);
	DatagramPacket vf = new DatagramPacket(videoframe, s1.length(), mcgrp, 16000);
	mcs.send(vf);
	System.out.println(" vf 1 sent successfully");
	System.out.println("ttl = " + mcs.getTimeToLive());
//I will try to receive the same from server
	byte v[] = new byte[1000];
	DatagramPacket dgp = new DatagramPacket(v,1000);
	mcs.receive(dgp);
	System.out.println("This Socket is connected to " +mcs.getInetAddress());
	String s = new String(dgp.getData(),0,dgp.getLength());
	System.out.println(s);
	System.out.println(" vf 1 received successfully");
//leaveGroup method can be used to leave multicast group	
	}catch(Exception e){ System.out.println(e);}
  }
}

