/* This is an implementation of a simple applet with two class files
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



public class SApplet extends Applet{
	myPanel mc;
	public void init(){

		System.out.println(" I am in init method\n");
	}
	public void start(){
		System.out.println(" I am in start method\n");
		show();
	}
	public void stop(){
		System.out.println(" I am in stop method\n");
	}
	public SApplet(){
		add(mc = new myPanel());

	}
}

class myPanel extends Panel{

 public myPanel(){
	super();
	add(new Button("b1"));
	add(new Button("b2"));
	add(new Button("b3"));
	add(new Button("b4"));
 }
}