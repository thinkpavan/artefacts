/*  shows how to Use JOptionPane
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//option pane can be used to display an icon,message and a selectable 
// value and row of buttons
public class UseJOptionPane{
	public static void main(String args[]){
		OptFrame   of = new OptFrame("Option Pane Sample");
		of.show();
	}		
}

class OptFrame extends JFrame  implements ItemListener {
	JRadioButton optionpane;
	JCheckBox  opane;
	Container cp;
	JOptionPane op;
	public OptFrame( String name){
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
		if( e.getSource() instanceof JRadioButton){
			JRadioButton jrb =(JRadioButton) e.getSource();
			if ( jrb.isSelected())
				JOptionPane.showMessageDialog(optionpane,"This is an information message","info",JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(optionpane,"This is an Error message","error",JOptionPane.ERROR_MESSAGE);		
		}
		else{
			JCheckBox jcb = (JCheckBox) e.getSource();
				if ( jcb.isSelected())
				op = new JOptionPane("with yes no cancel buttons",
		JOptionPane.INFORMATION_MESSAGE,JOptionPane.YES_NO_CANCEL_OPTION);
			else
		op = new JOptionPane("with default buttons",
		JOptionPane.INFORMATION_MESSAGE,JOptionPane.DEFAULT_OPTION);
			JDialog jd = op.createDialog(opane,"some dialog");
			jd.show();
			}
		
	}
}



