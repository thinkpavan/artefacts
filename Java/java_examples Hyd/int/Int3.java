/*  internationalization of an application
Author : Team - J
Version : 1.0
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.*;

public class Int3 {
	public static void main(String args[]){
//		Locale l = new Locale(languagecode, countrycode,variant)
		Locale l= new Locale("de","DE"); //german 
	//	Locale  l = new Locale("fr","CA"); //french,canada
		// locale acts as an identifier
		JFrame jf = new JFrame();
		Container cp = jf.getContentPane();
		ResourceBundle r = ResourceBundle.getBundle("App",l);
		/////////////////
		Object[] params = {
			new Date(), //0 th param
			r.getString("str2") // 1st argument to long message
		};
// date will be formatted according to default locale , by choosing different
//local for your os you can get german/french format date
		MessageFormat mf = new MessageFormat(r.getString("longmsg"));
		mf.setLocale(l);
		String s = mf.format(params);
		JLabel lm = new JLabel(s);

		////////////////
		cp.setLayout(new FlowLayout());

		cp.add(lm);
		jf.pack();
		jf.show();

System.out.println( Locale.getDefault());
	}
}



