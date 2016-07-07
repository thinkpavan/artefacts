// A Program on Label in Swing.
import java.awt.*;
import javax.swing.*;
public class J_Label extends JFrame
{
   public J_Label()
   {
        Container ContentPane=getContentPane();
        setTitle("A Swing Label Prog.");
        setSize(400,500);
ContentPane.setLayout(new FlowLayout());
        ImageIcon ii=new ImageIcon("Juggler0.gif");
        JLabel ji=new JLabel("France is Great Country",ii,JLabel.LEFT);
JButton b=new JButton("OK");
        setVisible(true);
        ContentPane.add(ji);
ContentPane.add(b);
   }
   public static void main(String args[])
   {
        new J_Label();
   }
}