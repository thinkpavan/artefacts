// Addition program
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Addition extends JApplet 
				implements ActionListener 
{
   JTextField input, output;
   int sum;           // variable that stores sum of integers

   // setup the graphical user interface components
   // and initialize variables
   public void init()
   {
      JLabel prompt = new JLabel( "Enter integer and press Enter:" );

      input = new JTextField( 10 );
      // "this" applet handles action events for TextField input
      input.addActionListener( this );

      JLabel res = new JLabel( "Current sum:" );

      output = new JTextField( 15 );
	  output.setEditable(false);
	  output.setText("0");

      sum = 0;        // set sum to 0

	  // Add Components to a JPanel, using the default FlowLayout. 
	  JPanel pane = new JPanel();
      pane.add(prompt);  pane.add(input);
      pane.add(res); pane.add(output);
	
	  setContentPane(pane);
   }

   // process user's action in TextField input 
   public void actionPerformed( ActionEvent e )
   {
      // get the number and convert it to an integer
      int number = Integer.parseInt( e.getActionCommand() );

      sum = sum + number;   // add number to sum
      input.setText( "" );  // clear data entry field
      output.setText( Integer.toString( sum ) );  // display sum
   }
}




            
