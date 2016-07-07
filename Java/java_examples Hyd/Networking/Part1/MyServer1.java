import java.io.*;
import java.net.*;

public class MyServer1 
{
	public static void main(String[] args)  throws Exception
	{
		ServerSocket serverSocket = new ServerSocket(16000);
		System.out.println("Server started ... \n waiting for connection... ");
		Socket mySocket = serverSocket.accept();
		//mySocket.accept();
		System.out.println("\n Connection established...\n");
		PrintStream ps = new PrintStream(mySocket.getOutputStream());
		InputStream is = ps.getInputStream();
		System.out.println("Read to take input");
		System.out.println("IP Address "+mySocket.getLocalAddress());
		System.out.println("IP Address "+mySocket.getLocalPort());
		System.out.println("IP Address "+socketSocket.getLocalPort());

	}
}
