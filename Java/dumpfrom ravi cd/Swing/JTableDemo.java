import javax.swing.*;
import java.awt.*;
class JTableDemo 
{
	public static void main(String[] args) 
	{
		Object[][] obj ={{"Pavan","tech",20000},
									{"Shyam","tech",20000},
									{"Shyam","tech",20000},
									{"Shyam","tech",20000},
									{"Shyam","tech",20000},
									{"Shyam","tech",20000},
									{"Shyam","tech",20000},
									{"Shyam","tech",20000},
									{"Shyam","tech",20000},
									{"Shyam","tech",20000},
									{"Shyam","tech",20000},
									{"Shyam","tech",20000},
									{"Shyam","tech",20000},
									{"Shyam","tech",20000},
									{"Shyam","tech",20000},
									{"Shyam","tech",20000},
									{"Shyam","tech",20000},
									{"Shyam","tech",20000},
									{"Venu","tech",20000} };
		String[] name ={"Name","Job","Sal"};
		JFrame frame = new JFrame();
		JTable tab = new JTable(obj,name);
		JScrollPane scrollpane  = new JScrollPane(tab);
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(scrollpane,BorderLayout.CENTER);
		//tab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 

		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
