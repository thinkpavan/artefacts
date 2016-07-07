/*  shows how to Use JDialog/JOptionPane
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//option pane can be used to display an icon,message and a selectable 
// value and row of buttons
public class UseJDialog1{
	public static void main(String args[]){
		DiaFrame1   of = new DiaFrame1("JDialog Sample");
		of.show();
	}		
}

class DiaFrame1 extends JFrame  implements ItemListener {
	JRadioButton optionpane;
	JCheckBox  opane;
	Container cp;
	JOptionPane op;
	public DiaFrame1( String name){
		super(name);
		cp=this.getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(optionpane = new JRadioButton("OptionPane 1"));
		cp.add(opane = new JCheckBox("Another type of Option Pane"));
		opane.addItemListener(this);
		optionpane.addItemListener(this);
	}
	public void itemStateChanged(ItemEvent e){
		// show dialog
		if( e.getSource() instanceof JCheckBox){
			JCheckBox jcb = (JCheckBox) e.getSource();
				if ( jcb.isSelected()){
				JDialog jd;
				String objs[] = {"one","two","three","four","five",
				"one","two","three","four","five",
				"one","two","three","four","five",
				"one","two","three","four","five"};
				 String sval = (String)JOptionPane.showInputDialog(jcb,"message",
				"title",JOptionPane.QUESTION_MESSAGE,
				null,(Object[])objs,(Object)objs[0]);
				System.out.println(sval);				}
			 else{
				JDialog jd;
				Object objs[] = new Object[4];
				objs[0] = new JTextField("tf one");
				objs[1] = new JTextField("tf two");
				objs[2] = new JTextField("tf three");
				objs[3] = new String("Ok");

				JOptionPane jop = new JOptionPane("message",
				JOptionPane.QUESTION_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION,null,(Object[])objs,(Object)objs[0]);
				jd= jop.createDialog(jcb,"this is a dialog");
				jd.show();
				Object o[] = jop.getOptions();
				System.out.println(" no of options = " + o.length);
			  }
		}		
	}
}








