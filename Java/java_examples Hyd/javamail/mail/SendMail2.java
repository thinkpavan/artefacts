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

public class SendMail2 {

    public static void main(String[] argv) {
	try{
	String  to="stud1@inetsolv",subject="Test mail",from="stud2@inetsolv",url = null;
	String mailhost = "inetsolv";
	Properties props = System.getProperties();
	String msg_text="Check the attachements\r\nThanks\r\nstudent\r\n";
	String mailer = "MyMailerProgram";
	props.put("mail.smtp.host", mailhost);
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
	FileDataSource fds= new FileDataSource("connect.jpg");
	mbp2.setDataHandler( new DataHandler(fds));
	mbp2.setFileName("connect.jpg"); 
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
