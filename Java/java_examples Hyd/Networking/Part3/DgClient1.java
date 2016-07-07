/*Shows how to receive dgram sockets
Author : Team -J
Version : 1.0 */

import java.io.*;
import java.net.*;
class DgClient1{
  static public void main(String[] args)throws Exception{
	try{
		byte b[] = new byte[1000];
		DatagramSocket dg = new DatagramSocket(4444,InetAddress.getByName("INETSOLV"));	
		DatagramPacket dgp = new DatagramPacket(b,1000);
		dg.receive(dgp);
		System.out.println("This Socket is connected to " +dg.getInetAddress());
		String s = new String(dgp.getData(),0,dgp.getLength());
		System.out.println(s);

		byte buf[] = new byte[1000];
		String s1 = new String("my reply to first datagram");
		s1.getBytes(0,s1.length(),buf,0);
		int desport = dgp.getPort();
		InetAddress in = dgp.getAddress();// returns info about the host from where we
		// recieve this datagram
		System.out.println("Destination Port = "+ desport);
		System.out.println("Destination Address = "+ in);
		DatagramPacket dgp1 = new DatagramPacket(buf,s1.length(),in,desport);
		dg.send(dgp1);
		
	}catch(Exception e){ System.out.println(e);}
  }
}

