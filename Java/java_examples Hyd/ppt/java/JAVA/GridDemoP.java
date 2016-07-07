
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridDemoP extends JFrame
{
  public GridDemoP()
  {
    super("E-Commerce Application");

	Container c = getContentPane();
	// use GridLayout: 3 rows, 2 columns
    // 10 pixel horiz. gap, 7 pixel vert. gap
	c.setLayout( new GridLayout(3, 2, 10, 7) );   

	JCheckBox jck1 = new JCheckBox("Downgrade dog to cat");
    JCheckBox jck2 = new JCheckBox("Upgrade bike to car");
    JCheckBox jck3 = new JCheckBox("Add speed package");
    c.add( jck1 );
    c.add( jck2 );
    c.add( jck3 );

    JButton jb1 = new JButton("place order");   
	c.add( jb1 );

	// use a panel to stop the cancel button growing
	JPanel p = new JPanel();
    JButton jb2 = new JButton("cancel");
	p.add(jb2);
	c.add( p );

    JLabel jl = new JLabel(new ImageIcon( "bmw.jpg"));
    c.add(jl);

    setSize(400,400);  // extra depth (200 --> 400)
    show();
  } // end of GridDemoP()

  public static void main(String[] args) 
  {
    GridDemoP app = new GridDemoP();

    app.addWindowListener( new WindowAdapter() {
      public void windowClosing(WindowEvent e) 
	  { System.exit(0); }
    } );
  } // end of main()

} // end of GridDemoP


