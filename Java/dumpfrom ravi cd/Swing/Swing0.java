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
        ImageIcon ii=new ImageIcon("ACE.gif");
        JLabel ji=new JLabel("France is Great Country",ii,JLabel.LEFT);
        setVisible(true);
        ContentPane.add(ji);
   }
   public static void main(String args[])
   {
        new J_Label();
   }
}