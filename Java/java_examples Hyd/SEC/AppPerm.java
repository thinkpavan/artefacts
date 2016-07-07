/* This show some of the restrictions placed on u'r
applet code
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
import java.net.*;
import java.io.*;

public class AppPerm  extends Applet{
	Button b1,b2,b3,b4;
	public void init(){
		String srv;
		System.out.println("before getting parameter");
		 srv = getParameter(new String("Servermsg"));
		System.out.println("after getting parameter");
		System.out.println(" I am in init method\n");
		b4.setLabel("This applet is downloaded from "+srv);
	}
	public void start(){
		// let us try to open some file
		AppletContext ac = getAppletContext();
		try{
		FileInputStream fis = new FileInputStream("c:\\xyz.txt");
		b4.setLabel("Successfully opened file");
		// let us try to open network connection to other host
		InetAddress ia = InetAddress.getByName("127.0.0.1");
		Socket s = new Socket(ia,8080);
	b4.setLabel("Successfully opened connection with host");
		}catch(Exception e){b4.setLabel(e.getMessage());}

	}
	public void stop(){
		System.out.println(" I am in stop method\n");
	}
	public AppPerm(){
		try{
		setLayout(new FlowLayout());
		add(b1 = new Button("b1"));
		add(b2 = new Button("b2"));
		add(b3 = new Button("b3"));
		add(b4 = new Button("b4"));
		}catch(Exception e ){e.printStackTrace();}
	}
}