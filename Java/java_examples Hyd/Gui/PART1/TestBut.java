/*  shows how to respond to  button events
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class TestBut{
	public static void main(String args[]) throws Exception{
		Frame mywin = new Frame("My own Frame");
		MyBut m = new MyBut("old");
		mywin.add(m);

		mywin.setSize(new Dimension(400,400));
		mywin.show();
Thread.currentThread().sleep(1000*10);
			m.setLabel(" label");

	}
}



class MyBut extends Button{
	MyBut(String lab){
		super(lab);
	}
	public void paint(Graphics g){
		System.out.println("in paint");
		g.drawString(" gra",5,5);
	}
}
