/* This show some of the restrictions placed on u'r
applet code
Author : Team - J
Version : 1.0
*/
import java.util.*;
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

public class AppTest  extends Applet{
	Button b1,b2,b3,b4;
	FileWriter fis ;
	public void init(){
		String srv;
		try{
			fis	= new FileWriter("c:\\xyz.txt");
		fis.write("in init " + new Date()+"\n");
		fis.flush();
		}catch(Exception e){}
		System.out.println("before getting parameter");
		 srv = getParameter(new String("Servermsg"));
		System.out.println("after getting parameter");
		System.out.println(" I am in init method\n");
		b4.setLabel("This applet is downloaded from "+srv);
	}
	public void start() {
		// let us try to open some file
		AppletContext ac = getAppletContext();
		try{
		fis.write("in start " + new Date()+"\n");
		fis.flush();
		b4.setLabel("Successfully opened file");
		// let us try to open network connection to other host
		InetAddress ia = InetAddress.getByName("196.12.100.101");
		Socket s = new Socket(ia,80);
	b4.setLabel("Successfully opened connection with host");
		}catch(Exception e){b4.setLabel(e.getMessage());}

	}
	public void stop(){
		try{
		fis.write("in stop " + new Date()+"\n");
		fis.flush();
		}catch(Exception e){}

		System.out.println(" I am in stop method\n");
	}
	public AppTest(){
		try{
		setLayout(new FlowLayout());
		add(b1 = new Button("b1"));
		add(b2 = new Button("b2"));
		add(b3 = new Button("b3"));
		add(b4 = new Button("b4"));
		}catch(Exception e ){e.printStackTrace();}
	}
	public void destroy() {
		try{
			fis.write("in destroy "+new Date()+"\n");
			fis.close();
		}catch(Exception e){}
	}
}