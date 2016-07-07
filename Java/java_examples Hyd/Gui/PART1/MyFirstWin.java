/* Demonstrates how to show window
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class MyFirstWin {
	public static void main(String args[]){
		// Top level window without  borders and  menubar
		//Window mywin = new Window();
		Frame mywin = new Frame();
		mywin.setSize(new Dimension(110,110));
		mywin.show();
		Window mywin1 = new Window(mywin);
		mywin1.setSize(new Dimension(400,400));
		mywin1.setBackground(Color.orange);
		mywin1.show();
		//forget about toolkit !!!!
		System.out.println(Toolkit.getDefaultToolkit()) ;
		//can we close this mywin now ???
	}
}
