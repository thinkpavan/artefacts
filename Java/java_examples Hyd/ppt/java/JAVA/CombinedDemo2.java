
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CombinedDemo2 extends JFrame
{
  public CombinedDemo2()
  {
    super("E-Commerce Application");

	Container c = getContentPane();
	// use default GridLayout for frame

    // panel 1: vertical box layout
    JPanel p1 = new JPanel();
	// 10 pixel border all around
	p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    p1.setLayout( new BoxLayout(p1, BoxLayout.Y_AXIS));

    JCheckBox jck1 = new JCheckBox("Downgrade dog to cat");
    JCheckBox jck2 = new JCheckBox("Upgrade bike to car");
    JCheckBox jck3 = new JCheckBox("Add speed package");
    p1.add( jck1 );
    p1.add( jck2 );
    p1.add( jck3 );


    // panel 2: vertical box layout
    JPanel p2 = new JPanel();
	// 14 pixel border all around
	p2.setBorder(BorderFactory.createEmptyBorder(14, 14, 14, 14));
    p2.setLayout( new BoxLayout(p2, BoxLayout.Y_AXIS));

    JButton jb1 = new JButton("place order");  
	p2.add( jb1 );

    // add 15 pixel vertical space between buttons jb1 and jb2
	p2.add(Box.createRigidArea(new Dimension(0, 15)));

    JButton jb2 = new JButton("cancel"); 
	// set the size of button jb2 to be the same as jb1
	jb2.setMaximumSize( jb1.getPreferredSize() );
	p2.add( jb2 );

        
    JLabel jl = new JLabel(new ImageIcon( "bmw.jpg"));
         
    // add panels and image to frame
    c.add(jl, "Center");
    c.add(p1, "West");
    c.add(p2, "East");

    setSize(400,400);  // extra depth (200 --> 400)
    show();
	pack();   // remove excess space
  } // end of CombinedDemo2()

  public static void main(String[] args) 
  {
    CombinedDemo2 app = new CombinedDemo2();

    app.addWindowListener( new WindowAdapter() {
      public void windowClosing(WindowEvent e) 
	  { System.exit(0); }
    } );
  } // end of main()

} // end of CombinedDemo2


