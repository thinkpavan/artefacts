/*Program to receive mails from pop3 server.
Version: 1.0
Author : Team-J.
*/

import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;


public class RecvMail1 {

    public static void main(String[] argv) {
	try{
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
	Message message[] = folder.getMessages();
	for (int i=0;i<message.length; i++) {
		System.out.println(i+1 + ": " + message[i].getFrom()[0] + "\t" + message[i].getSubject());
		message[i].setFlag(Flags.Flag.DELETED, true); 
	 }
//permanently delete all the messages marked for deletion.
//	folder.expunge(); // use true as param to close method to expunge messages.
	folder.close(true);
	store.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
