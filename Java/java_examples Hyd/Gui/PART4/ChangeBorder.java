/*  shows how to change boarder
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
// javax signifies that this package is an extension to java core packages
import javax.swing.*;
import javax.swing.border.*;

public class ChangeBorder {
	public static void main(String args[]) throws Exception{
		JFrame jframe = new JFrame(" This is a Swing Frame");
		Container cp = jframe.getContentPane();
		JButton button1 = new JButton("What is this component ???");
			UIManager.put("Label.foreground",Color.black);
		button1.setBorder(null);
		button1.setEnabled(false);
			JButton button2 = new JButton("Button with boarder");
			button2.setBorder(new BevelBorder(BevelBorder.RAISED));

		JLabel jl = new JLabel(" this is a label");
		JLabel jl1 = new JLabel("What is this component ???");

		cp.add(button1);
		cp.add(button2);
		cp.add(jl);
		cp.add(jl1);
		cp.setLayout(new FlowLayout());
		//jframe.setLayout(new FlowLayout());//can we use this ??
		jframe.pack();
		jframe.show();
			//	jl1.setBorder(new BevelBorder(BevelBorder.RAISED));
			jl1.setBorder(new BevelBorder(BevelBorder.RAISED));
			System.out.println("border = "+button2.getBorder());
		UIManager.LookAndFeelInfo lfi[];
	}
}




