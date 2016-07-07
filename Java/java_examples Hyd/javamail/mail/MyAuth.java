/*Program to receive mails from pop3 server.
Version: 1.0
Author : Team-J.
*/

import javax.mail.*;

public class MyAuth extends Authenticator {
	String un,pass;
public MyAuth(String un,String pass){
	this.un=un;
	this.pass=pass;
}
 public PasswordAuthentication getPasswordAuthentication() {
	  return new PasswordAuthentication( un, pass); 
}
} 
