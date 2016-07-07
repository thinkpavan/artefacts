/*  shows how to show a tool tip on a componenet
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
// javax signifies that this package is an extension to java core packages
import javax.swing.*;

public class UseTimer {
	public static void main(String args[]) throws Exception{
		Timer t = new Timer(300000,new TimerHandler("repeating timer"));
		Timer ott = new Timer(2,new TimerHandler("fired only once"));
		ott.setRepeats(false);

		JFrame jframe = new JFrame(" This is a Swing Frame");
	      ImageIcon ic = new ImageIcon("ic.gif");
		JLabel jl = new JLabel("before updated by the timer");
		Container cp = jframe.getContentPane();
		JButton button1 = new JButton("Button1",new ImageIcon("ie.gif"));
            button1.setPreferredSize(new Dimension(100,100));
		JButton button2 = new JButton("Button2");
		cp.add(button1);
		cp.add(jl);
		button1.add(button2);
		cp.setLayout(new FlowLayout());
		jframe.pack();
		jframe.show();
			button1.setToolTipText(" this button contains another Button");
			jl.setToolTipText(" Label's tool tip");
	System.out.println("before timer" +Thread.activeCount());
	t.start();
	ott.start();
	System.out.println("after timer" +Thread.activeCount());
	//	jframe.setToolTipText("this is a frame");  ?? not a subclass oj JComponent
	}

}

class TimerHandler implements ActionListener{
	String dbgmsg;
	public TimerHandler(String dbgmsg){
		this.dbgmsg = dbgmsg;
	}
	public void actionPerformed(ActionEvent ae){
		System.out.println(dbgmsg + " Timer Event Fired" + ae.getSource());
	}
}




