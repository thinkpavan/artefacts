
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CombinedDemo extends JFrame
{
  public CombinedDemo()
  {
    super("E-Commerce Application");

	Container c = getContentPane();
	// use default GridLayout for frame

    // panel 1: vertical box layout
    JPanel p1 = new JPanel();
    p1.setLayout( new BoxLayout(p1, BoxLayout.Y_AXIS));
    JCheckBox jck1 = new JCheckBox("Downgrade dog to cat");
    JCheckBox jck2 = new JCheckBox("Upgrade bike to car");
    JCheckBox jck3 = new JCheckBox("Add speed package");
    p1.add( jck1 );
    p1.add( jck2 );
    p1.add( jck3 );

    // panel 2: vertical box layout
    JPanel p2 = new JPanel();
    p2.setLayout( new BoxLayout(p2, BoxLayout.Y_AXIS));
    JButton jb1 = new JButton("place order");  
	p2.add( jb1 );
    JButton jb2 = new JButton("cancel");   
	p2.add( jb2 );
        
    JLabel jl = new JLabel(new ImageIcon( "bmw.jpg"));
         
    // add panels and image to frame
    c.add(jl, "Center");
    c.add(p1, "West");
    c.add(p2, "East");

    setSize(400,400);  // extra depth (200 --> 400)
    show();
	pack();   // remove excess space
  } // end of CombinedDemo()

  public static void main(String[] args) 
  {
    CombinedDemo app = new CombinedDemo();

    app.addWindowListener( new WindowAdapter() {
      public void windowClosing(WindowEvent e) 
	  { System.exit(0); }
    } );
  } // end of main()

} // end of CombinedDemo


