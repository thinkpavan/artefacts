/*  shows problem how to solve the problem of fetching
bulk data or doing expensive operation in event handlers
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SwingProbSolv{
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
	// now spin off data thread and return immediately
DataThread dt = new DataThread(dlm);
	dt.start();
}
}

class DataThread extends Thread{
 DefaultListModel  dlm;
 Vector v;
	public DataThread( DefaultListModel  dlm){
		this.dlm = dlm;
            v = new Vector();
	}
	public void run(){
         try{
		System.out.println("fetching data from data base");
		sleep(10000);
	}catch(Exception e){}
		for(int i = 0; i <20;i++)
			v.addElement(i +" element added");
     ListUpdater lu = new  ListUpdater(v,dlm);
		System.out.println("Placing runnable object on event dispatch thread");
	SwingUtilities.invokeLater(lu);
 }
}

class ListUpdater extends Thread{
 DefaultListModel  dlm;
 Vector v;
  public ListUpdater(Vector v,DefaultListModel  dlm){
	this.v = v;
	this.dlm = dlm;
  }
 public void run(){
// update list from fetched data
   for(int i= 0;i <20;i++) { // we have to use methods on vectors
// here than using i <20 here
		dlm.addElement(v.elementAt(i));
   }
// this will run on event dispatch thread.
 }
}
