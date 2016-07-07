
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlowDemo extends JFrame
{
  public FlowDemo()
  {
    super("E-Commerce Application");

	Container c = getContentPane();
	c.setLayout( new FlowLayout() );

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

    setSize(400,200);
    show();
  } // end of FlowDemo()

  public static void main(String[] args) 
  {
    FlowDemo app = new FlowDemo();

    app.addWindowListener( new WindowAdapter() {
      public void windowClosing(WindowEvent e) 
	  { System.exit(0); }
    } );
  } // end of main()

} // end of FlowDemo


