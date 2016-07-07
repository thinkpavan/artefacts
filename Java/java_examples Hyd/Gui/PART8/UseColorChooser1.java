/*  shows how to Use JColorChooser and set a previewer to it
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.beans.*;
import java.io.*;
public class UseColorChooser1{
	public static void main(String args[]){
		ColorFrame1   of = new ColorFrame1();
		of.show();
	}		
}

class ColorFrame1 extends JFrame implements ActionListener{
		JColorChooser jf;
		JButton jb1;
		JButton jb2;
		Container cp;
		JDialog jd;
	public ColorFrame1(){
		super("Color Chooser Demo");
		cp = getContentPane();
		cp.setLayout(new FlowLayout());
		jb1 = new JButton(" Show Color Chooser");
		cp.add(jb1);
		jb1.addActionListener(this);
	//	jf = new JColorChooser();
	//	jf.addPropertyChangeListener(this);
		pack();
	}
	public void actionPerformed(ActionEvent ae){

		JButton jb =(JButton)ae.getSource();
		if(jb1 == jb){
				jf = new JColorChooser();
			/*createDialog(Component c, String title,
				boolean modal, JColorChooser chooserPane,
				ActionListener okListener, ActionListener
				 cancelListener) */
//find the bug here
			jd = JColorChooser.createDialog(jb,"This is in Dialog",false,
				jf,this,this);
			jd.show();
		
			System.out.println("selected color = " +
				jf.getColor());
		}
		else{
			System.out.println(jb.getActionCommand());
		}
	}

}

