import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GridBag 
{
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("My Frame");
		GridBagLayout g1 = new GridBagLayout();
		frame.setLayout(g1);
		GridBagConstraints gbc = new GridBagConstraints();
		JButton b1 = new JButton("Button 1");
		JButton b2 = new JButton("Button 2");
		JButton b3 = new JButton("Button 3");
		JButton b4 = new JButton("Button 4");
		JButton b5 = new JButton("Button 5");
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER ;
		gbc.weightx = 1.0 ;
		gbc.gridwidth = 1 ;
		g1.setConstraints(b1,gbc);
		frame.add(b1);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
