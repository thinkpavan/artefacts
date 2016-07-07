/*Example showing how to produce xml data.
Version:1.0
Author:Team-J.
*/




import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.swing.colorchooser.*;
import javax.swing.filechooser.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.util.*;
import java.io.*;
import java.applet.*;
import java.io.*;

public class StudData extends JFrame implements ActionListener {
	JPanel pan = new JPanel();
	JButton save = new JButton("save");
	JTextArea sn=new JTextArea("yourname");
	JTextArea rn=new JTextArea("rollno");
	JTextArea street=new JTextArea("street");
	JTextArea city=new JTextArea("city");
	JTextArea state=new JTextArea("state");

    public static void main(String[] args) {
	StudData mainf = new StudData();
	
    }


    public StudData() {
	sn.setColumns(40);
	rn.setColumns(40);
	street.setColumns(40);
	city.setColumns(40);
	state.setColumns(40);
	pan.add(sn);
	pan.add(rn);
	pan.add(street);
	pan.add(city);
	pan.add(state);
	pan.add(save);
	save.addActionListener(this);
	setContentPane(pan);
	setSize(new Dimension(500,400));
	show();
    }

    public void actionPerformed(ActionEvent al){
	try{
		String flname = sn.getText()+".xml";
		FileWriter fr = new FileWriter(flname);
		String data="<?xml version=\"1.0\"?>\r\n<student>\r\n<name>";
		data = data+sn.getText()+"</name>\r\n<rollno>" + rn.getText();
		data = data+"</rollno>\r\n<address>\r\n<street>"+street.getText();
		data = data +"</street>\r\n<city>"+city.getText()+"</city>\r\n</address>";
		data = data + "\r\n</student>";
		fr.write(data);
		fr.close();
	}catch(Exception e){};
    }
}
