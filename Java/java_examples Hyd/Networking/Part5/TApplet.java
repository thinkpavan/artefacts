/* This is an implementation of a simple applet with two class files
Author : Team - J
Version : 1.0
Here we would like to show students how class files are pulled from
server by showing the log's generated by web servers
we are sure that a student can develop any kind of applet if he understands
how browsers pulls class files from the server.
*/

// import all required classes
import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import com.inetsolv.myPanel1;



public class TApplet extends Applet{
	myPanel1 mc;
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
	public TApplet(){
		add(mc = new myPanel1());

	}
}

