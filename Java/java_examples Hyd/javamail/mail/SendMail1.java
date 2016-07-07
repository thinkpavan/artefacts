/*Program to send mails.
Version: 1.0
Author : Team-J.
*/

import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;
import javax.activation.*; // for FileDataSource,DataHandler

public class SendMail1 {

    public static void main(String[] argv) {
	try{
	String  to="stud1@ness.com",subject="Test mail",from="stud2@ness.com",url = null;
	String mailhost = "INBLRNT11";
	Properties props = System.getProperties();
	String msg_text="Check the attachements\r\nThanks\r\nstudent\r\n";
	String mailer = "MyMailerProgram";
	props.put("INBLRNT11", mailhost);
	Session session = Session.getDefaultInstance(props, null);
	session.setDebug(true);
	Message msg = new MimeMessage(session);
	msg.setFrom(new InternetAddress(from));
	msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to, false));
	msg.setSubject(subject);
	msg.setHeader("X-Mailer", mailer);
	msg.setSentDate(new Date());
//This code deals with setting multipart message.
	MimeBodyPart mbp1 = new MimeBodyPart();
	mbp1.setText(msg_text);
	MimeBodyPart mbp2 = new MimeBodyPart();
	FileDataSource fds= new FileDataSource("sendmail.class");
	mbp2.setDataHandler( new DataHandler(fds));
	mbp2.setFileName("sendmail.class"); 
	MimeMultipart mp;
	mp = new MimeMultipart();
	mp.addBodyPart(mbp1);
	mp.addBodyPart(mbp2);
	msg.setContent(mp);

	Transport.send(msg);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
