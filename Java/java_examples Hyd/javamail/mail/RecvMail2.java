/*Program to receive mails from pop3 server. Send one multipart msg before running this
program
Version: 1.0
Author : Team-J.
*/

import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import javax.activation.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;

public class RecvMail2 {

    public static void main(String[] argv) {
	try{
	MimeMessage mm;
	MyAuth a = new  MyAuth("stud1","pass1"); 
	String mailhost = "inetsolv";
	Properties props = System.getProperties();
	props.put("mail.pop3.host", mailhost);
	Session session = Session.getDefaultInstance(props,a);
//	session.setDebug(true);
	Store store = session.getStore("pop3");
	store.connect(); 
	Folder folder = store.getFolder("INBOX"); 
	folder.open(Folder.READ_WRITE);
	Message msg = folder.getMessage(1);
	System.out.println(msg.getFrom());
	System.out.println(msg.getSubject());
	mm = (MimeMessage)msg;
	System.out.println(mm.getContentType());
// always check before type casting.
	MimeMultipart mmp = (MimeMultipart) mm.getContent();
	int i,nop=mmp.getCount();
	System.out.println("no of parts in message = "+nop);
	for(i=0;i<nop;i++){
		BodyPart bp = mmp.getBodyPart(i);
		MimeBodyPart mbp=(MimeBodyPart) bp;
		System.out.println(mbp.getContentType());
		System.out.println(mbp.getFileName());
		if(mbp.getFileName() == null){
			// display the content
			mbp.writeTo(System.out);
		}else{ // save the content in file.
			java.io.InputStream is = mbp.getInputStream();
			java.io.FileOutputStream fos = new java.io.FileOutputStream
					("new"+mbp.getFileName());
			System.out.println("Data written to file");
			//read multiple bytes instead of 1 byte at a time.
			while(is.available() >0){
				int j= is.read();
				fos.write(j);
			}
			fos.close();
		}
	}
	store.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
