/*  shows how to use Menu
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class UseMenu {
	public static void main(String args[]){
		MyFrame2 mywin = new MyFrame2("Menu Frame");
		mywin.setSize(new Dimension(200,200));
		mywin.setLayout(new FlowLayout());
		mywin.show();
	}
}


class MyFrame2 extends Frame {
	MenuBar appmenu;
	MenuItem newf,open,save,saveas,pagesetup,print,exit,hlp,about;
	CheckboxMenuItem option1,option2,option3,option4;
	Menu file,help,somemenu;
	public MyFrame2(String s){
		super(s);
		appmenu = new MenuBar();
		setMenuBar(appmenu);
		file= new Menu ("file");
		appmenu.add(file);
		newf = new MenuItem ("New");
		file.add(newf);
		open = new MenuItem ("Open");
		file.add(open);
		save = new MenuItem ("save");
		file.add(save);
		saveas = new MenuItem ("save as");
		file.add(saveas);
		file.addSeparator();
		pagesetup = new MenuItem ("Page Setup");
		file.add(pagesetup);
		print = new MenuItem ("Print");
		file.add(print);
		file.addSeparator();
		exit = new MenuItem ("Exit");
		file.add(exit);
		help = new Menu("help");
		appmenu.setHelpMenu(help); // ensure that this is the last menu
					   // on some platforms
		help.add(about =new MenuItem("About"));
		help.add( hlp =new MenuItem("help"));
		somemenu=  new Menu("Options");
		somemenu.add(option1 = new CheckboxMenuItem("Option1",true));
		somemenu.add(option2 = new CheckboxMenuItem("Option2",true));
		somemenu.add(option3 = new CheckboxMenuItem("Option3"));
		somemenu.add(option4 = new CheckboxMenuItem("Option4"));
		appmenu.add(somemenu);
	}
	

	
}

