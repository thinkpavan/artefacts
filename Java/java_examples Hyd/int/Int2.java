/*  internationalization of an application
Author : Team - J
Version : 1.0
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.*;
public class Int2 {
	public static void main(String args[]){
//		Locale l = new Locale(languagecode, countrycode,variant)
	//	Locale l= new Locale("de","DE"); //german 
		Locale  l = new Locale("fr","CA"); //french,canada
		// locale acts as an identifier
		JFrame jf = new JFrame();
		Container cp = jf.getContentPane();
		ResourceBundle r = ResourceBundle.getBundle("App",l);
		JButton delete = new JButton(r.getString("str1"));
		JButton save = new JButton(r.getString("str2"));
		JButton stop = new JButton(r.getString("str3"));
		JButton cancel = new JButton(r.getString("str4"));
		/////////////////
		Date d = new Date();
// we can use long,short,medium,full,short dates
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG,l);
// to extract time part we can use getTimeInstance , similarly we can have
// datetime
		String s = df.format(d);
		JLabel date = new JLabel(s);

		////////////////
		cp.setLayout(new FlowLayout());
		cp.add(delete);
		cp.add(save);
		cp.add(stop);
		cp.add(cancel);
		cp.add(date);
		jf.pack();
		jf.show();
	}
}



