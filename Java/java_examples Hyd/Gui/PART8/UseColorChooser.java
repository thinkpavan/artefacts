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
public class UseColorChooser{
	public static void main(String args[]){
		ColorFrame   of = new ColorFrame();
		of.show();
	}		
}

class ColorFrame extends JFrame implements ActionListener{
		JFileChooser jf;
		JButton jb1;
		JButton jb2;
		JPanel previewer;
		Container cp;
	public ColorFrame(){
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
			System.out.println("selected color = " +
				JColorChooser.showDialog(jb1,"Color Chooser",Color.red));
		}
	}

}

