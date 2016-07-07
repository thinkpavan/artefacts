/*  shows how to Use JTabbedPane
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.beans.*;
import java.io.*;
import java.util.*;
public class UseJTB {
	public static void main(String args[])throws Exception{
		JTB jtb = new JTB();
		jtb.show();
	}		
}

class JTB extends JFrame implements ChangeListener{
	JTabbedPane jtb;
	public JTB(){
	super("Tabbed Frame Demo");
	JPanel jp = new JPanel();
	jtb = new JTabbedPane();
	jp.setLayout(new FlowLayout());
	jp.add(new JButton("Button one"));
	jp.add(new JButton("Button two"));
	jp.add(new JButton("Button three"));
	jtb.addTab("This is tab no 1",jp);
	jtb.addTab("This is second tab",new JButton("This is button"));
	jtb.addTab("This is tab no 3",new JPanel());
	jtb.addTab("This is fourth tab",new JButton("This is button"));
	jtb.addTab("This is tab no 5",new ImageIcon("lock.gif"),new JPanel());
	jtb.insertTab("This is inserted tab",new ImageIcon("lock.gif"),
	new JButton("This is on it")," This is a tip",2);
	getContentPane().add(jtb);
	getContentPane().setLayout(new FlowLayout());
	jtb.setPreferredSize(new Dimension(400,400));
	pack();
	jtb.addChangeListener(this);
	}
	public void stateChanged(ChangeEvent ce){
		System.out.println("State changed");
		//when ever new tab is selected we will be here
		JTabbedPane jt = (JTabbedPane) ce.getSource();
		System.out.println("tab count = "+ jt.getTabCount());
		int ind = jt.getSelectedIndex();
		System.out.println("Selected Tab index = " +ind);
		Component c = jt.getComponent(ind);
		jt.remove(c);
// we know we shouldn't remove the tabs here but we still do it here
	}
}

