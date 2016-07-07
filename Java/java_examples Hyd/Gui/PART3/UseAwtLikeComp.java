/*  shows a simple example of developing a gui program
    using swing components which are provided as replacement
    to AWT components.
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
// javax signifies that this package is an extension to java core packages
import javax.swing.*;

public class UseAwtLikeComp {
	public static void main(String args[]) throws Exception{
		JFrame jframe = new JFrame(" This is a Swing Frame");
		Container cp = jframe.getContentPane();
		JButton button1 = new JButton("Button1");
		JButton button2 = new JButton("Button2");
		cp.add(button1);
		//jframe.add(button2);//can we use this ??
		button1.add(button2);
		cp.setLayout(new FlowLayout());
		//jframe.setLayout(new FlowLayout());//can we use this ??
		jframe.pack();
		jframe.show();
		UIManager.LookAndFeelInfo lfi[];
		lfi = UIManager.getInstalledLookAndFeels();
		for(int i=0;i<lfi.length;i++)
			System.out.println(lfi[i].getClassName());
		
		UIManager.setLookAndFeel(lfi[0].getClassName());
		//UIManager.setLookAndFeel(lfi[1].getClassName());
		//UIManager.setLookAndFeel(lfi[2].getClassName());
		SwingUtilities.updateComponentTreeUI(cp);
	}
}




