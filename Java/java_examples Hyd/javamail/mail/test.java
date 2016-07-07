/*Program to receive mails from pop3 server. Send one multipart msg before running this
program
Version: 1.0
Author : Team-J.
*/

import java.io.*;
public class test {

    public static void main(String[] argv) throws Exception {
	FileInputStream fis1,fis2;
	fis1 = new FileInputStream("Connect.jpg");
	fis2 = new FileInputStream("newConnect.jpg");
	for(int i =0;i <34050;i++)
		{
			System.out.print(fis1.read()+"    ");
			System.out.println(fis2.read());
		}

    }
}
