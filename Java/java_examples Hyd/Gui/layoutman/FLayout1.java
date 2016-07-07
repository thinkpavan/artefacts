/*  shows how to use flaw layout manager
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class FLayout1 {
	public static void main(String args[]){
		Frame mywin = new Frame("My own Frame");
		mywin.setLayout(new FlowLayout());
		for(int i=0;i<=10;i++)
			mywin.add(new MyBut("                           "+i));
	//	mywin.setSize(new Dimension(400,400));
		mywin.pack();
		mywin.show();
	}
}

class MyBut extends Button{
	public MyBut(String s){
		super(s);
	}
	public Dimension getMinimumSize(){
		System.out.println("in min size");
		return (new Dimension(50,50));
	}
      public Dimension getPreferredSize(){
		System.out.println("in preferred  size");
		return (new Dimension(50,50));
	}
	public Dimension getMaximumSize(){
		System.out.println("in preferred  size");
		return (new Dimension(50,50));
	}


}