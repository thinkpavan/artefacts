/*  shows how to Use JFileChooser and set a filter to it
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;
//option pane can be used to display an icon,message and a selectable 
// value and row of buttons
public class UseFileChooser1{
	public static void main(String args[]){
		FileFrame1   of = new FileFrame1();
		of.show();
	}		
}

class FileFrame1 extends JFrame implements ActionListener{
		JFileChooser jf;
		JButton jb1;
		JButton jb2;
	public FileFrame1(){
		super("File Chooser Demo");
		Container cp = getContentPane();
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
		JButton jb =(JButton)ae.getSource();
		if(jb1 == jb){
			jf.addChoosableFileFilter(new MyFileFilter(".txt"));
			jf.addChoosableFileFilter(new MyFileFilter(".java"));
			jf.showSaveDialog(jb);
			System.out.println("selected file = " + jf.getSelectedFile());	
		}
	}	
}

class MyFileFilter extends FileFilter{
	String filter;
	public MyFileFilter( String filter){
		this.filter = filter;
	}
	public boolean accept(File fname){
		if(fname.toString().endsWith(filter))
			return (true);
		else 
			return (false);
	}
	public String getDescription(){
		return (new String ("select only files that ends with "+ filter));
	}
}






