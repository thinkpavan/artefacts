/*  shows how to respond to  button events
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JButEvt {
	public static void main(String args[]){
		JFrame mywin = new JFrame("Example on event handling");
		Container cp = mywin.getContentPane();
		JButton jb = new JButton(" this buuton handles events");
		cp.add(jb);
		// register event handler
		jb.addActionListener(new AListener());
		mywin.show();
	}
}

class AListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		System.out.println("Action performed on :\n\n"+ ae.getSource());
	}
}

