
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BorderDemo extends JFrame
{
  public BorderDemo()
  {
    super("E-Commerce Application");

	Container c = getContentPane();
	// use BorderLayout:
    // 10 pixel horiz. gap, 7 pixel vert. gap
	c.setLayout( new BorderLayout(10, 7) );   

	// JCheckBox jck1 = new JCheckBox("Downgrade dog to cat");
    JCheckBox jck2 = new JCheckBox("Upgrade bike to car");
    JCheckBox jck3 = new JCheckBox("Add speed package");
    // c.add( jck1 );
    c.add( jck2, "East" );
    c.add( jck3, "South" );

    JButton jb1 = new JButton("place order");   
	c.add( jb1, "North" );
    JButton jb2 = new JButton("cancel");    
	c.add( jb2, "West" );

    JLabel jl = new JLabel(new ImageIcon( "bmw.jpg"));
    c.add(jl, "Center");

    setSize(400,400);  // extra depth (200 --> 400)
    show();
	pack();  // get rid of excess space
  } // end of BorderDemo()

  public static void main(String[] args) 
  {
    BorderDemo app = new BorderDemo();

    app.addWindowListener( new WindowAdapter() {
      public void windowClosing(WindowEvent e) 
	  { System.exit(0); }
    } );
  } // end of main()

} // end of BorderDemo


