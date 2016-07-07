/* This is an implementation of a simple applet
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



public class FApplet extends Applet{
	Button b1,b2,b3,b4;
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
	public FApplet(){
		add(b1 = new Button("b1"));
		add(b2 = new Button("b2"));
		add(b3 = new Button("b3"));
		add(b4 = new Button("b4"));
	}
}