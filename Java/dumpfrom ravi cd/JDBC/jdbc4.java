import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class dataAc
{
          Statement st1;
          ResultSet rest;
          Connection con;
          String s[]=new String[4];
          public dataAc()
          {
              try
              {
                   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                   con=DriverManager.getConnection("jdbc:odbc:LIB","SCOTT","TIGER");
                   st1=con.createStatement();
                   System.out.println("Connected to Database!");
              }
              catch(Exception e)
              {
                    System.out.println("Error, Unable to Access Database");
                    System.out.println("Application Closed");	   
                    System.exit(0);
              }
         }
         public String[] retV(int i)
         {
           try
           {
                    if(i==0)  rest=st1.executeQuery("SELECT * FROM BOOKMASTER");
                    if(rest.next())
                    {                    
                           s[0]=rest.getString("BKNO");
                           s[1]=rest.getString("BKNM");
                           s[2]=(new Integer(rest.getInt("BKPR")).toString());   
                           s[3]=rest.getString("BKDP");   
                    }
                    else if(rest.isLast())
                    {
                           rest.close();  
                           retV(0);
                    }      
                      
            }
           catch(SQLException e)
           {
               if(e.getErrorCode()==0)
               {
                  try
                  {
                    rest.close();
                    retV(0);
                   }
                   catch(Exception ex){}
                }
                else
                {
                    System.out.println("Error Occurered "+e);
                    s[0]=" "; s[1]=" "; s[2]=" "; s[3]=" ";
                }
           }
           return s;
     }
     public void insR(String ar[]) throws SQLException
     {
          int i=st1.executeUpdate("INSERT INTO BOOKMASTER VALUES('"+ar[0]+"','"+ar[1]+"','"+ar[2]+"','"+ar[3]+"')");
          System.out.println(i + " row(s) inserted");
      }
}
public class jdbc4 extends JFrame implements ActionListener
{
     JButton b1,b2,b3,b4,b5;
     JLabel l1,l2,l3,l4,l5;
     JTextField t1,t2,t3,t4;
     int pos=0;
     String vals[]=new String[4];
     dataAc dats;
     public jdbc4()
     {
            setTitle("Graphical Data Access");
            setSize(600,500);
            dats=new dataAc();
            getContentPane().setLayout(null);
            b1=new JButton("Add");
            b1.addActionListener(this);
            b1.setMnemonic('A');
            b1.setToolTipText("To Add Record");
            b2=new JButton("Save");
            b2.addActionListener(this);
            b2.setMnemonic('S');
            b2.setToolTipText("To Save Record");
            b3=new JButton("Next");
            b3.addActionListener(this);
            b3.setMnemonic('N');
            b3.setToolTipText("To Move for Next Record");
            b4=new JButton("Refresh");
            b4.addActionListener(this);
            b4.setMnemonic('R');
            b4.setToolTipText("To Reload Data");
            b5=new JButton("Quit");
            b5.addActionListener(this);
            b5.setMnemonic('Q');
            b5.setToolTipText("To Quit");
            t1=new JTextField(10);
            t2=new JTextField(30);
            t3=new JTextField(50);
            t4=new JTextField(10);
            l1=new JLabel("Book Code"); 
            l2=new JLabel("Book Description"); 
            l3=new JLabel("Book Price"); 
            l4=new JLabel("Date of Purchase"); 
            l5=new JLabel("Publisher Master Entry Form"); 
            l1.setBounds(100,100,140,30);
            l2.setBounds(100,150,140,30);
            l3.setBounds(100,200,140,30);
            l4.setBounds(100,250,140,30);
            l5.setBounds(150,30,300,40);
            t1.setBounds(300,100,90,30);
            t2.setBounds(300,150,140,30);
            t3.setBounds(300,200,200,30);
            t4.setBounds(300,250,100,30);
            b1.setBounds(50,400,90,30);
            b2.setBounds(150,400,90,30);
            b3.setBounds(250,400,90,30);
            b4.setBounds(350,400,90,30);
            b5.setBounds(450,400,90,30);
            getContentPane().add(b1);
            getContentPane().add(b2);
            getContentPane().add(b3);
            getContentPane().add(b4);
            getContentPane().add(b5);
            getContentPane().add(l1);
            getContentPane().add(l2);
            getContentPane().add(l3);
            getContentPane().add(l4);
            getContentPane().add(t1);
            getContentPane().add(t2);
            getContentPane().add(t3);
            getContentPane().add(t4);
            setFont(new Font("Monospaced",Font.BOLD,20));
            getContentPane().add(l5);
            setVal(0);  
            setVisible(true);
      }
      private void setVal(int i)
      {
         try
         {
            switch(i)
            {
                 case 0:
                    vals=dats.retV(0);
                    break;
                 case 1:
                    dats.insR(vals);
                    break;                 
                 case 2:
                     dats.retV(1);
                     break;
            }               
            t1.setText(vals[0]);
            t2.setText(vals[1]);
            t3.setText(vals[2]);
            t4.setText(vals[3]);
          }
          catch(SQLException e)
          {
              System.out.println("Error : " +e);
          }
       }             
       public void actionPerformed(ActionEvent e)
       {  
              vals[0]=t1.getText();
              vals[1]=t2.getText();
              vals[2]=t3.getText();
              vals[3]=t4.getText();
              if(e.getActionCommand().equals("Add"))
                    clearF();
              else if(e.getActionCommand().equals("Save"))
                    setVal(1);
              else if(e.getActionCommand().equals("Next"))
                     setVal(2);
              else if(e.getActionCommand().equals("Refresh"))
                     setVal(0);
              else  if(e.getActionCommand().equals("Quit"))
                     System.exit(0);
      }
      private void clearF()
      {
               t1.setText("");
               t2.setText("");
               t3.setText("");
               t4.setText("");
       }
       public static void main(String[] args)
       {
                new jdbc4();
        }
}

