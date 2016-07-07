//A Program  on JTree
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.tree.*;
class Swing10 extends JFrame
{
     JTree tree;
     JTextField jtf;
     Swing10()
     {
           setSize(500,500);
           setVisible(true);
           Container contentPane=getContentPane();
            contentPane.setLayout(new BorderLayout());
            DefaultMutableTreeNode top=new DefaultMutableTreeNode("Options"); 
           DefaultMutableTreeNode a=new DefaultMutableTreeNode("A"); 
            top.add(a);
            DefaultMutableTreeNode a1=new DefaultMutableTreeNode("A1"); 
            a.add(a1);
            DefaultMutableTreeNode a2=new DefaultMutableTreeNode("A2"); 
            a.add(a2);
            DefaultMutableTreeNode a3=new DefaultMutableTreeNode("A3"); 
            a.add(a3);
            DefaultMutableTreeNode b=new DefaultMutableTreeNode("B"); 
            top.add(b);
            DefaultMutableTreeNode b1=new DefaultMutableTreeNode("B1"); 
            b.add(b1);
            DefaultMutableTreeNode ba=new DefaultMutableTreeNode("BX"); 
            b1.add(ba);
            DefaultMutableTreeNode b2=new DefaultMutableTreeNode("B2"); 
            b.add(b2);
            DefaultMutableTreeNode b3=new DefaultMutableTreeNode("B3"); 
            b.add(b3);
            DefaultMutableTreeNode c=new DefaultMutableTreeNode("C"); 
            top.add(c);
            DefaultMutableTreeNode c1=new DefaultMutableTreeNode("C1"); 
            c.add(c1);
            DefaultMutableTreeNode c2=new DefaultMutableTreeNode("C2"); 
            c.add(c2);
            DefaultMutableTreeNode c3=new DefaultMutableTreeNode("C3"); 
            c.add(c3);
            tree=new JTree(top);
            int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;           
            int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
            JScrollPane jsp=new JScrollPane(tree,v,h);
            contentPane.add(jsp,BorderLayout.CENTER);
            jtf=new JTextField("",20);
            contentPane.add(jtf,BorderLayout.SOUTH);
            tree.addMouseListener(new MouseAdapter()
                                                      {
                                                          public void mouseClicked(MouseEvent me)
                                                          {
                                                                 domouseClicked(me);
                                                           }
                                                         });
          }
          void domouseClicked(MouseEvent me)
           {
                  TreePath tp=tree.getPathForLocation(me.getX(),me.getY());
                   if(tp!=null)
                         jtf.setText(tp.toString());
                   else
                         jtf.setText(" ");
            }
           public static void main(String []args)
           {
                    new  Swing10();
            }
}

        
 
    