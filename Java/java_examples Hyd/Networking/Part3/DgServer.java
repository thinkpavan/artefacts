/*Shows how to receive dgram sockets
Author : Team -J
Version : 1.0 */

import java.io.*;
import java.net.*;
class DgServer{
  static public void main(String[] args)throws Exception{
	try{
		DatagramSocket dg = new DatagramSocket(3333, InetAddress.getByName("INETSOLV"));	
		byte buf[] = new byte[1000];
		String s = new String("my first datagram");
		s.getBytes(0,s.length(),buf,0);
		// in this case s.length may be used but if we transfer some
		// other char sets the value may be different
		DatagramPacket dgp = new DatagramPacket(buf,s.length(),InetAddress.getByName("INETSOLV"),4444);
		dg.send(dgp);
		// now let u wait for a datagram packet from other side
		byte b [] = new byte[1000];
		DatagramPacket dgp1= new DatagramPacket(b,1000);
		dg.receive(dgp1);
		System.out.println("after receiving data");
		String s1 = new String(dgp1.getData(),0,dgp1.getLength());
		System.out.println(s1);
	}catch(Exception e){ System.out.println(e);}
  }
}

