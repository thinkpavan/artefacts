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
	MimeMultipart mmp = (MimeMultipart) mm.getContent());
	DataHandler dh=mm.getDataHandler();
	System.out.println(dh);
	CommandInfo ci[] = dh.getAllCommands();
	for(int i=0;i<ci.length;i++){
		System.out.println(ci[i]);
		System.out.println(ci[i].getCommandName());
		System.out.println(ci[i].getCommandClass());
		System.out.println(ci[i].getCommandObject(dh,null));
	}
	store.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
