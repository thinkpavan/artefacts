/*  shows how to use card layout manager
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class CLayout {
	public static void main(String args[])throws Exception{
		Frame mywin = new Frame("My own Frame");
		mywin.setLayout(new CardLayout());
		for(int i=0;i<=10;i++)
			mywin.add(new Button("Button "+i),"but"+i);
	//	mywin.setSize(new Dimension(400,400));
		mywin.pack();
		mywin.show();
		System.in.read();
		CardLayout cl = (CardLayout) mywin.getLayout();
		for(int i=0;i<=10;i++){
			cl.show(mywin,"but"+i);
			System.in.read();
			System.in.read();
		}
	}
}

