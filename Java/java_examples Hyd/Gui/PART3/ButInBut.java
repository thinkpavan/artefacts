/*  shows how a button can hold another button
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
// javax signifies that this package is an extension to java core packages
import javax.swing.*;

public class ButInBut {
	public static void main(String args[]) throws Exception{
		JFrame jframe = new JFrame(" This is a Swing Frame");
            ImageIcon ic = new ImageIcon("ic.gif");
		JLabel jl = new JLabel(" j label",ic,SwingConstants.LEFT);
		System.out.println("icon height  ="+ ic.getIconHeight());
		Container cp = jframe.getContentPane();
		JButton button1 = new JButton("Button1",new ImageIcon("ie.gif"));
	//	JButton button1 = new JButton("Button1");
           // button1.setPreferredSize(new Dimension(100,100));
		JButton button2 = new JButton("Button2");
		cp.add(button1);
		cp.add(jl);
		//jframe.add(button2);//can we use this ??
	//	button1.add(button2);
		cp.setLayout(new FlowLayout());
		//jframe.setLayout(new FlowLayout());//can we use this ??
		jframe.pack();
		jframe.show();
		UIManager.LookAndFeelInfo lfi[];
		lfi = UIManager.getInstalledLookAndFeels();
		for(int i=0;i<lfi.length;i++)
			System.out.println(lfi[i].getClassName());
	
	
	//	UIManager.setLookAndFeel(lfi[0].getClassName());
	//	UIManager.setLookAndFeel(lfi[1].getClassName());
	//	UIManager.setLookAndFeel(lfi[2].getClassName());
		SwingUtilities.updateComponentTreeUI(cp);
            jframe.setDefaultCloseOperation(WindowConstants .DO_NOTHING_ON_CLOSE );
            //frame.setDefaultCloseOperation(WindowConstants .DISPOSE_ON_CLOSE );
            //frame.setDefaultCloseOperation(WindowConstants .HIDE_ON_CLOSE  ); //default



	}
}




