import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    
public class  Box1
{
	public static void main(String[] args) 
	{	
		JFrame frame = new JFrame("Box LAyout");
		JPanel panel = new JPanel();
		BoxLayout box = new BoxLayout(panel,BoxLayout.LINE_AXIS); 
		JButton ok = new JButton("OK");
		JButton cancel = new JButton("CANCEL");
		frame.getContentPane().add(panel,BorderLayout.CENTER);
		panel.add(new JLabel("This is "));
		panel.add(new JLabel("BOX LAYOUT"));
		frame.setDefaultLookAndFeelDecorated(true); 
		panel.add(ok);
		panel.add(cancel);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
      