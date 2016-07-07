/* This shows how to configure an applet.
An application can read configuration info from local files
but an applet cannot do this due to security restrictions.
Author : Team - J
Version : 1.0
*/

// import all required classes
import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class AppParam  extends JApplet{
	JButton b1,b2,b3,b4;
	public void init(){
		String srv;
		System.out.println("before getting parameter");
		 srv = getParameter(new String("Servermsg"));
		System.out.println("after getting parameter");
		System.out.println(" I am in init method\n");
		b4.setLabel("This applet is downloaded from "+srv);
	}
	public void start(){
		System.out.println(" I am in start method\n");
		setSize(300,300);
		setVisible(true);
	}
	public void stop(){
		System.out.println(" I am in stop method\n");
	}
	public AppParam(){
		try{
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(b1 = new JButton("b1"));
		c.add(b2 = new JButton("b2"));
		c.add(b3 = new JButton("b3"));
		c.add(b4 = new JButton("This Applet is Downloaded from"));
// we can use getparameters to get parameters passed as parameters in html file*/
	//	String srv;
	//	System.out.println("before getting parameter");
	//	 srv = getParameter(new String("msg"));
	//	System.out.println("after getting parameter");
//System.out.println("srv=  ");
// donot use this here as the applet context is not available here
		}catch(Exception e ){e.printStackTrace();}
	}
}