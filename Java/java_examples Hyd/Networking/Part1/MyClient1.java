import java.io.*;
import java.net.*;

public class MyClient1
{
	public static void main(String[] args) throws IOException
	{
		Socket ss = new Socket(InetAddress.getLocalHost(),16000);
		System.out.println("Connected to server");
	}
}
