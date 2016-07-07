/*  shows how to use tool bar
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.beans.*;
import java.awt.*;
import java.awt.event.*;
// javax signifies that this package is an extension to java core packages
import javax.swing.*;
public class UseJToolBar {
	public static void main(String args[])throws Exception{
		LookAndFeel laf =(LookAndFeel) Class.forName("com.sun.java.swing.plaf.windows.WindowsLookAndFeel").newInstance();
		UIManager.setLookAndFeel(laf);
		ToolBarFrame df = new ToolBarFrame();
	//	df.show();
	}		
}

class ToolBarFrame implements PropertyChangeListener{
	JToolBar jtb;
	public ToolBarFrame(){
		JFrame jframe = new JFrame(" This is ToolBar Frame");
		Container cp = jframe.getContentPane();
		cp.add(jtb = new JToolBar(SwingConstants.VERTICAL));
		JButton open = new JButton(new ImageIcon("lock.gif"));
		JButton newb = new JButton(new ImageIcon("lock.gif"));
		JButton lock = new JButton(new ImageIcon("lock.gif"));
		JButton find = new JButton(new ImageIcon("lock.gif"));
		jtb.addPropertyChangeListener(this);
		jtb.add(open);
		jtb.add(newb);
		jtb.add(lock);
		jtb.add(find);
		jtb.setFloatable(false);
		jframe.setBounds(20,20,400,400);
		cp.setLayout(new FlowLayout());
		jtb.putClientProperty("JToolBar.isRollover",Boolean.TRUE);
		jframe.show();

// we can add action listeners to individual buttons for taking
//actions
	}
	public void propertyChange(PropertyChangeEvent evt){
		System.out.println("Property change event fired");
		System.out.println(" Property name " + evt.getPropertyName());
		System.out.println(" Old value  " + evt.getOldValue());
		System.out.println(" New value  " + evt.getNewValue());

	}

}



