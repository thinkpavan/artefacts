/*  shows how to use boarder layout manager
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class BLayout {
	public static void main(String args[]){
		Frame mywin = new Frame("My own Frame");
		System.out.println(mywin.getLayout());
		//Border layout manager is an instance of layout manager 2, so we
		// can add constraints with object
		mywin.add(new Button("North"), BorderLayout.NORTH);
		 mywin.add(new Button("South"), BorderLayout.SOUTH);
		mywin.add(new Button("East"), BorderLayout.EAST);
	//	mywin.add(new Button("West"), BorderLayout.WEST);
		mywin. add(new Button("Center"), BorderLayout.CENTER);
	//	mywin.setSize(new Dimension(400,400));
		mywin.pack();
		mywin.show();
	}
}

