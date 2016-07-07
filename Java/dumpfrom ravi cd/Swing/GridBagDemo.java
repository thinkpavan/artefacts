import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GridBagDemo 
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
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		frame.add(b2);
		gbc.gridx = 1 ;

		gbc.gridwidth = GridBagConstraints.REMAINDER;
		frame.add(b3);
		
		gbc.weightx = 0.0 ;
		gbc.weighty = 1.0 ;
		gbc.gridheight = 2 ;
		gbc.gridwidth = 1;
		
		g1.setConstraints(b4,gbc);
		frame.add(b4,gbc);

		gbc.gridheight = 1 ;
		gbc.weighty = 1.0 ;
		g1.setConstraints(b5,gbc);
		frame.add(b5,gbc);

		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
