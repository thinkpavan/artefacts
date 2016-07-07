/*  shows how to Use JFileChooser
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
//option pane can be used to display an icon,message and a selectable 
// value and row of buttons
public class UseFileChooser{
	public static void main(String args[]){
		FileFrame   of = new FileFrame();
		of.show();
	}		
}

class FileFrame extends JFrame implements ActionListener{
		JFileChooser jf;
		JButton jb1;
		JButton jb2;
	public FileFrame(){
		super("File Chooser Demo");
		//setRootPaneCheckingEnabled(false);
		JButton jb = new JButton(" Button Placed on Frame Directly");
		Container cp = getContentPane();
		cp.add(jb);
		cp.setLayout(new FlowLayout());
		jb1 = new JButton(" Show File");
		cp.add(jb1);
		jb2 = new JButton(" Custom File Chooser");
		cp.add(jb2);
		jb2.addActionListener(this);
		jb1.addActionListener(this);
		pack();
	}
	public void actionPerformed(ActionEvent ae){
		jf = new JFileChooser();
		if(jb1 == ae.getSource()){
		int res = jf.showOpenDialog((Component) ae.getSource());
		res = jf.showSaveDialog((Component) ae.getSource());
		if (res == JFileChooser.CANCEL_OPTION)
			System.out.println(" file not selected by user");
		if (res == JFileChooser.APPROVE_OPTION)
			System.out.println(" file  selected by user");
		File f = jf.getSelectedFile();
			System.out.println(" selected file name = " + f);
		}
		else{
			int res = jf.showDialog((Component)ae.getSource(),"My File Chooser");	
		}
	}	
}








