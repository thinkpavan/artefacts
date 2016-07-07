/* This is an implementation of a simple applet using swing's JApplet
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



public class FJApplet extends JApplet{
	JButton b1,b2,b3,b4;
	public void init(){

		System.out.println(" I am in init method\n");
	}
	public void start(){
		System.out.println(" I am in start method\n");
		setSize(300,300);
		setVisible(true);
	}
	public void stop(){
		System.out.println(" I am in stop method\n");
	}
	public FJApplet(){
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(b1 = new JButton("b1"));
		c.add(b2 = new JButton("b2"));
		c.add(b3 = new JButton("b3"));
		c.add(b4 = new JButton("b4"));
	}
}