
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoxDemo extends JFrame
{
  public BoxDemo()
  {
    super("E-Commerce Application");

	Container c = getContentPane();
	// use BoxLayout: align components vertically
	c.setLayout( new BoxLayout(c, BoxLayout.Y_AXIS) );   

	JCheckBox jck1 = new JCheckBox("Downgrade dog to cat");
    JCheckBox jck2 = new JCheckBox("Upgrade bike to car");
    JCheckBox jck3 = new JCheckBox("Add speed package");
    c.add( jck1 );
    c.add( jck2 );
    c.add( jck3 );

    JButton jb1 = new JButton("place order");   
	c.add( jb1 );
    JButton jb2 = new JButton("cancel");    
	c.add( jb2 );

    JLabel jl = new JLabel(new ImageIcon( "bmw.jpg"));
    c.add(jl);

    setSize(400,400);  // extra depth (200 --> 400)
    show();
	pack();   // get rid of excess space
  } // end of BoxDemo()

  public static void main(String[] args) 
  {
    BoxDemo app = new BoxDemo();

    app.addWindowListener( new WindowAdapter() {
      public void windowClosing(WindowEvent e) 
	  { System.exit(0); }
    } );
  } // end of main()

} // end of BoxDemo


