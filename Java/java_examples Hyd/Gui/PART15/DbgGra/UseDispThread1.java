/*  shows how to  use another thread to run 
long operation in event handling
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
// javax signifies that this package is an extension to java core packages
import javax.swing.*;

public class UseDispThread1    {
	public static void main(String args[]) throws Exception{
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
		button1.addActionListener(new actlist());
		cp.setLayout(new FlowLayout());
		jframe.pack();
		jframe.show();
		Thread.currentThread().sleep(2000);
/*	for(int i =0;i<4;i++){
System.out.println(" thread name  = "+Thread.currentThread());
		SwingUtilities.invokeLater(new LongOperation());
	}*/
	}

}

class LongOperation implements Runnable{
	public void run(){
System.out.println(" Thread Name  = "+Thread.currentThread());
		try{
		System.out.println(" We are simulating long operation by sitting idle here");
		Thread.currentThread().sleep(10000);
		}catch(Exception e){}
	}
}


class actlist implements ActionListener{
public void actionPerformed(ActionEvent ae){
	System.out.println(" Thread Name  = "+Thread.currentThread());
		SwingUtilities.invokeLater(new LongOperation());

}
}

