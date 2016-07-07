/*  shows how to use flaw layout manager
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class FLayout {
	public static void main(String args[]){
		Frame mywin = new Frame("My own Frame");
		mywin.setLayout(new FlowLayout());
		for(int i=0;i<=10;i++)
			mywin.add(new Button("                           "+i));
	//	mywin.setSize(new Dimension(400,400));
		mywin.pack();
		mywin.show();
	}
}

