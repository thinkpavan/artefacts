/*  shows how to use Grid layout manager
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class GLayout {
	public static void main(String args[])throws Exception{
		Frame mywin = new Frame("My own Frame");
		mywin.setLayout(new GridLayout(5,3));
		mywin.setLayout(new GridLayout(5,3,30,30));

		for(int i=0;i<10;i++)
			mywin.add(new Button("Button "+i),"but"+i);
	//	mywin.setSize(new Dimension(400,400));
		mywin.pack();
		mywin.show();
	}
}

