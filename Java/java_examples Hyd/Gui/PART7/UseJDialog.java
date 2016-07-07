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
public class UseJDialog{
	public static void main(String args[]){
		DiaFrame   of = new DiaFrame("JDialog Sample");
		of.show();
	}		
}

class DiaFrame extends JFrame  implements ItemListener {
	JRadioButton optionpane;
	JCheckBox  opane;
	Container cp;
	JOptionPane op;
	public DiaFrame( String name){
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
			if ( jrb.isSelected()){
				int res =JOptionPane.showConfirmDialog(optionpane,"Do You Want to save the file");
				switch (res){
				/*same as okay 	case JOptionPane.YES_OPTION:
						System.out.println("yes choosen");
						break;*/
					case  JOptionPane.NO_OPTION:
						System.out.println("No choosen");
						break;
					case  JOptionPane.CANCEL_OPTION:
						System.out.println("Cancel choosen");
						break;
					case  JOptionPane.OK_OPTION: 
						System.out.println("Ok choosen");
						break;
				  }
				}
			else {
			  String s=JOptionPane.showInputDialog(optionpane,
				"Input","Dialog",JOptionPane.QUESTION_MESSAGE);
				System.out.println(s);
			}
		}
		else{
			JCheckBox jcb = (JCheckBox) e.getSource();
				if ( jcb.isSelected()){
				JDialog jd;
				String objs[] = {"one","two","three"};
				JOptionPane jop = new JOptionPane("message",
				JOptionPane.QUESTION_MESSAGE,
				JOptionPane.OK_OPTION,null,(Object[])objs,(Object)objs[0]);
				jd= jop.createDialog(jcb,"this is a dialog");
				jd.show();
				System.out.println(" selected value = " + jop.getSelectionValues());
				}
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








