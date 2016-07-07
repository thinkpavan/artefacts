/*  shows about the zorder of the components
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
// javax signifies that this package is an extension to java core packages
import javax.swing.*;

public class Zorder {
	public static void main(String args[]) throws Exception{
		Frame frame = new Frame(" This is a Swing Frame");
		Button button1 = new Button("Button1");
		Button button2 = new Button("Button2");
            button1.setBounds(10,10,100,100);
		button2.setBounds(80,30,100,100);
		frame.add(button1);
		frame.add(button2);

		frame.setBounds(100,100,200,200);
		frame.setLayout(null);
	
		frame.pack();
		frame.show();
		
	}
}




