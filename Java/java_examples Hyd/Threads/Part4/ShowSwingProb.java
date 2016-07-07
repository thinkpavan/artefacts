/*  shows problem using multiple threads to update
swing componenet
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShowSwingProb {
	public static void main(String args[]) throws Exception{
		SwingProb jprob = new SwingProb("this shows problem with swing");
		jprob.show();			
      }
}

class SwingProb extends JFrame implements ActionListener{
 JButton jb;
 JList jl;
 Container cp;
 DefaultListModel  dlm;
 public SwingProb(String s){
	super(s);
	dlm = new DefaultListModel();
	cp = getContentPane();
	jb = new JButton("Fecth Data");
	cp.add(jb);
	dlm.addElement("one");
	dlm.addElement("two");

	jl = new JList(dlm);
	jl.setPreferredSize(new Dimension(200,200));
	JScrollPane scrollPane = new JScrollPane(jl);
	cp.add(scrollPane);
	cp.setLayout(new FlowLayout());
	jb.addActionListener(this);
	pack();
 }
public void actionPerformed(ActionEvent ae){
		// let us get data from a network server or from heavily loaded
		// database
		try{
			Thread.currentThread().sleep(90000);
		}catch(Exception e){}
	for(int i = 10;i <40;i ++){
		dlm.addElement(i +" from server");
	}
// we should not update list box from another thread as all the swing and
// awt componenets are not thread safe 
}
}



