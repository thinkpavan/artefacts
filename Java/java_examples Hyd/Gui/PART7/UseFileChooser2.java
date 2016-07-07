/*  shows how to Use JFileChooser and set a previewer to it
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
//option pane can be used to display an icon,message and a selectable 
// value and row of buttons
public class UseFileChooser2{
	public static void main(String args[]){
		FileFrame2   of = new FileFrame2();
		of.show();
	}		
}

class FileFrame2 extends JFrame implements ActionListener,PropertyChangeListener{
		JFileChooser jf;
		JButton jb1;
		JButton jb2;
		JPanel previewer;
		Container cp;
	public FileFrame2(){
		super("File Chooser Demo");
		cp = getContentPane();
		cp.setLayout(new FlowLayout());
		jb1 = new JButton(" Show File");
		cp.add(jb1);
		jb2 = new JButton(" Custom File Chooser");
		cp.add(jb2);
		jb2.addActionListener(this);
		jb1.addActionListener(this);
		jf = new JFileChooser();
		jf.addPropertyChangeListener(this);
		pack();
	}
	public void actionPerformed(ActionEvent ae){

		JButton jb =(JButton)ae.getSource();
		if(jb1 == jb){
			previewer = new JPanel();
			previewer.setPreferredSize(new Dimension(200,100));

			previewer.add(new JLabel(" this is a Previewer"));
			jf.setAccessory(previewer);
			jf.showOpenDialog(jb);
		}
	}
	public void propertyChange(PropertyChangeEvent pce){
		if(pce.getPropertyName().equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)){
			Graphics g = previewer.getGraphics();
				g.setColor(Color.red);
				g.fillRect(0,0,previewer.getSize().width,previewer.getSize().height);
			//add u'r code here to show the name of the file on the panel
		}
	}
}

