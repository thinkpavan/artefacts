/*  shows about z ordering of components using light weight
components
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LZorder {
	public static void main(String args[]) throws Exception{
		JFrame jframe = new JFrame(" This is a Swing Frame");
		Container cp = jframe.getContentPane();
            cp.setLayout(new GridLayout());
		 cp.setLayout(null);

		JButton button1 = new JButton("Button1");
		JButton button2 = new JButton("Button2");
            Button b = new Button(" button 3");
		cp.add(button1);
		//jframe.add(button2);//can we use this ??
		cp.add(button2);
            cp.add(b);
            button1.setBounds (10,10,50,50);
            button2.setBounds (60,60,50,50);
            b.setBounds (50,50,50,50);
		jframe.setBounds(10,10,200,200);
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




