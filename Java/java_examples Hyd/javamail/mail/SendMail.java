import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;


public class SendMail {

    public static void main(String[] argv) {
	try{
	String  to="stud1@ness.com",subject="Test mail",from="stud2@ness.com",url = null;
	String mailhost = "INBLRNT11";
	String mailhost = "inetsolv";
	Properties props = System.getProperties();
	String msg_text="This is my first mail\r\nThanks student\r\n";
	String mailer = "MyMailerProgram";
	props.put("INBLRNT11", mailhost);
	Session session = Session.getDefaultInstance(props, null);
	session.setDebug(true);
	Message msg = new MimeMessage(session);
	msg.setFrom(new InternetAddress(from));
	msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to, false));
	msg.setSubject(subject);
	msg.setHeader("X-Mailer", mailer);
	msg.setSentDate(new Date());
	msg.setText(msg_text);
	Transport.send(msg);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
