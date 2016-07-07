/* This show how an applet can interact with it's environment
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


public class AppCont1  extends Applet{
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
		System.out.println(" I am in start method\n");
		setSize(300,300);
		setVisible(true);
	try{
		AppletContext apc = getAppletContext();
		apc.showDocument(new URL("http://inetsolv/appcont1.html"));
	//	apc.showDocument(new URL("http://inetsolv/postform.htm"),"another Window");
//we can use getApplets to get the list of applets that are embeded in current page
// we can also use getaudioclip and getimage to get au file and image files
// we are seriou programmers now, we know how to use the !!!!!
	}catch(Exception e){System.out.println(e);}
	}
	public void stop(){
		System.out.println(" I am in stop method\n");
	}
	public AppCont1(){
		try{
		setLayout(new FlowLayout());
		add(b1 = new Button("b1"));
		add(b2 = new Button("b2"));
		add(b3 = new Button("b3"));
		add(b4 = new Button("This Applet is Downloaded from"));
		}catch(Exception e ){e.printStackTrace();}
	}
}