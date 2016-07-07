/*  shows how to plug in a new look and feel 
using pluggable look and feel arch provided by jfc
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
// javax signifies that this package is an extension to java core packages
import javax.swing.*;

public class UseUIManager{
	public static void main(String args[]) throws Exception{
		JFrame jframe = new JFrame(" This is a Swing Frame");
		Container cp = jframe.getContentPane();
		JButton button1 = new JButton("Button1");
		JButton button2 = new JButton("Button2");
		cp.add(button1);
		JTextArea jt = new JTextArea(" Ugly text area");
            JCheckBox jc = new JCheckBox("checked",true);
		cp.add(jt);
		cp.add(jc);
		cp.setLayout(new FlowLayout());
		jframe.pack();
		jframe.show();
		UIManager.LookAndFeelInfo lfi[];
		lfi = UIManager.getInstalledLookAndFeels();
		//get the installed look and feels
		for(int i=0;i<lfi.length;i++)
			System.out.println(lfi[i].getClassName());
		System.out.println("----------------------------");
		UIManager.installLookAndFeel("INetSolv's L&f","INetSolvLAF");
		lfi = UIManager.getInstalledLookAndFeels();
		//get the installed look and feels
		for(int i=0;i<lfi.length;i++)
			System.out.println(lfi[i].getClassName());
//	LookAndFeel laf =(LookAndFeel) Class.forName("INetSolvLAF").newInstance();
LookAndFeel laf =(LookAndFeel) Class.forName(lfi[3].getClassName()).newInstance();

System.out.println(laf);
	UIManager.setLookAndFeel(laf);

		SwingUtilities.updateComponentTreeUI(cp);
	}
}




