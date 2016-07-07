/* Demonstrates how to show window
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class PaintTest {
	
	public static void main(String args[]) throws Exception{
		
		MyFrame mywin = new MyFrame("My own Frame");
		mywin.setSize(new Dimension(200,200));
		System.out.println(" no of threads ="+ Thread.activeCount());
		mywin.show();
		
		Thread.currentThread().sleep(10000);
		
		for( MyFrame.i=0;MyFrame.i <100;MyFrame.i++){
			Thread.currentThread().sleep(1);
			//System.out.println("... before repaint...");
			mywin.repaint();
		}
	}
		
}

class MyFrame extends Frame{
	public static int i=0;
	Event e;
	public MyFrame(String s){
		super(s);
	}
	
	public void paint(Graphics g){
            System.out.println("in paint event ");
		g.drawString("in paint event",100,100);
	}
	public void update(Graphics g){
            System.out.println(i + "****in update event ");
	    super.update(g); //calls pint event
		//paint(g);
	}


}
