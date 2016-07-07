/*  shows how to Use  Popup
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class UsePopup {
	public static void main(String args[]){
		MyFrame4 mywin = new MyFrame4("Menu Frame");
		mywin.setSize(new Dimension(200,200));
		mywin.setLayout(new FlowLayout());
		mywin.show();
		mywin.addWindowListener(new WListener());
	}
}


class MyFrame4 extends Frame implements ActionListener{
	PopupMenu pop;
	MenuItem newf,open,save;
	MenuShortcut ms1,ms2,ms3;
	public MyFrame4(String s){
		super(s);
		pop= new PopupMenu(" My popup Menu");
		pop.add(newf = new MenuItem("add"));
		pop.add(open = new MenuItem("open"));
		pop.add(save = new MenuItem("save"));
		ms1 = new MenuShortcut('o');
		ms2 = new MenuShortcut('a');
		ms3 = new MenuShortcut('e',true);
		newf.setShortcut(ms1);
		open.setShortcut(ms2);
		save.setShortcut(ms3);
		newf.addActionListener(this);
		addMouseListener(new MyListener());
		add(pop);
	}

	public void actionPerformed(ActionEvent a){
		System.out.println("action on " + a.getSource());
	}
	
	public PopupMenu getPopupMenu(){
		return pop;
	}
	
}

class MyListener extends MouseAdapter{
	public void mouseReleased(MouseEvent e){
		if(e.isPopupTrigger()){
			MyFrame4 f =(MyFrame4) e.getSource();
			System.out.println(f);
			PopupMenu p = f.getPopupMenu();
			p.show(f,e.getX(),e.getY());
		}
	}
}



class DListener extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		Dialog d =(Dialog) e.getSource();
		d.dispose();
	}
}