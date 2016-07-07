/*Shows about Application Level Protocol
Author : Team -J
Version : 1.0 */

import java.io.*;
import java.net.*;
class ProtoClient{
  static public void main(String[] args)throws Exception{
	//create a Socket 	
	try{
		Socket s = new Socket(InetAddress.getLocalHost(),16000);
		System.out.println("Connected to Server Successfully");
		s.setSoLinger(true,0); 
System.out.println(s.getSoLinger()+"so option");
		PrintStream ps =new PrintStream( s.getOutputStream());
		InputStream is = s.getInputStream();
		byte b [] = new byte[100];
		int k =is.read(b,0,99);
		for(int i =0;i<k;i++){
			char c = (char)b[i];
			System.out.print(c);
		}
		ps.println("Suresh");
            k= is.read(b,0,99);
		System.out.println("k = "+ k +"...."+ (int)b[0]+(int)b[1]);
		System.out.println("waiting for greeting message");
// run this program multiple times ,u may find that this program
// gets the message some times and some times this may not get
// this message. We can write n/w programs only if we know why
// this program behaves like this.
            //k= is.read(b,0,99);
		String msg = new String(b,0,k);
		System.out.println(msg+ "....."+ k);
//setSoTimeout(60); //blocks read call for 60 sec's if there is no data
// then an interruptedioexception will be raised
	//	ps.println("Bye");
// send the following message to check the effect og solinger
ps.println("we know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message which I have typed here in a single shotthis may not be received by other endthis may not be received by other endthis may not be received by other endthis may not be received by other endthis may not be received by other end.....................");
ps.println("we know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message which I have typed here in a single shotthis may not be received by other endthis may not be received by other endthis may not be received by other endthis may not be received by other endthis may not be received by other end.....................");
ps.println("we know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message which I have typed here in a single shotthis may not be received by other endthis may not be received by other endthis may not be received by other endthis may not be received by other endthis may not be received by other end.....................");
ps.println("we know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message whichwe know that tcp may not send the whole message which I have typed here in a single shotthis may not be received by other endthis may not be received by other endthis may not be received by other endthis may not be received by other endthis may not be received by other end.....................");

		System.out.println(" before closing");
		s.close();	
		System.out.println(" after closing");
	}catch(Exception e){ System.out.println(e);}
  }
}

