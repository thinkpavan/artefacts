/*  shows how to use tool bar/menu
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.beans.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class UseTBMenu {
	public static void main(String args[])throws Exception{
		LookAndFeel laf =(LookAndFeel) Class.forName("com.sun.java.swing.plaf.windows.WindowsLookAndFeel").newInstance();
		UIManager.setLookAndFeel(laf);
		TBFrame df = new TBFrame();
	//	df.show();
	}		
}

class TBFrame implements PropertyChangeListener{
	JToolBar jtb;
	public TBFrame(){
		JFrame jframe = new JFrame(" This is ToolBar Frame");
		JMenuBar jmb = new JMenuBar();
		JMenu jm = new JMenu("menu one");
		jmb.add(jm);
	//	JMenuItem jmi1,jmi2;
		OpenAction oa = new OpenAction("open");
		NewAction na = new NewAction("New");
		jm.add( oa);
		jm.add( na);
		jframe.setJMenuBar(jmb);
		Container cp = jframe.getContentPane();
		cp.add(jtb = new JToolBar(SwingConstants.VERTICAL));
		JButton open = new JButton(new ImageIcon("lock.gif"));
		JButton newb = new JButton(new ImageIcon("lock.gif"));
		JButton lock = new JButton(new ImageIcon("lock.gif"));
		JButton find = new JButton(new ImageIcon("lock.gif"));
		jtb.addPropertyChangeListener(this);
	//	jtb.add(open);
	//	jtb.add(newb);
		jtb.add(oa);
		jtb.add(na);
		jtb.add(lock);
		jtb.add(find);
		jtb.setFloatable(false);
	//	JButton jb = new JButton(oa); how to do this
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

class OpenAction extends AbstractAction{
	public OpenAction(String l){
		super(l,new ImageIcon("lock.gif"));
	}
	public void actionPerformed(ActionEvent ae){
			System.out.println("Open Action performed on" + ae.getSource());
	}
}
class NewAction extends AbstractAction{
	public NewAction(String l){
		super(l,new ImageIcon("lock.gif"));
	}

	public void actionPerformed(ActionEvent ae){
			System.out.println("NewAction performed on" + ae.getSource());
	}
}		


