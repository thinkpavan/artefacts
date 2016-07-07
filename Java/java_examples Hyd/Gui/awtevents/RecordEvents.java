/* This class passively listens all awt events
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class RecordEvents  {
	public static void main(String args[]){
		MyFrame mywin = new MyFrame("My own Frame");
		Toolkit.getDefaultToolkit().addAWTEventListener( new RecordAWTEvents(),0xFFFF);
		mywin.setSize(new Dimension(600,400));
		mywin.show();
		Graphics g =mywin.getGraphics();
		System.out.println(g); //to see the name of actual graphics class
		
	}
}

class MyFrame extends Frame{
	Button b1,b2,b3;
	public MyFrame(String s){
		super(s);
		setLayout(new FlowLayout());
		add(b1=  new Button(" Button 1"));
		add(b2=  new Button(" Button 2"));
		add(b3=  new Button(" Button 3"));
	}
	public boolean handleEvent(Event evt){
		switch (evt.id){
				case Event.WINDOW_DESTROY:
				System.out.println(" Window Destroy Event ");
				System.exit(0);
		}

		return (false); // we don't know why we are returning
				// false here !!
	}
}


class RecordAWTEvents implements AWTEventListener{
	public void eventDispatched(AWTEvent event){
		System.out.println("Event :" + event);
	}
}
