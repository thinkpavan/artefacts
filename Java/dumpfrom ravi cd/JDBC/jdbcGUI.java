//Program for JDBC-GUI

import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class jdbcGUI extends Frame implements ActionListener
{
      Connection con;
      ResultSet rs;
      Statement st;
      Button b1,b2,b3,b4,b5,b6;
      Label l1,l2,l3;
      TextField t1,t2,t3;
      int cnt[]=new int[15];
      int i=0,no=0;

      jdbcGUI()
      {
             l1=new Label("Empno");
             l2=new Label("Ename");
             l3=new Label("Salary");

             t1=new TextField(10);
             t2=new TextField(10);
             t3=new TextField(10);

             b1=new Button("Insert");
             b2=new Button("Update");
             b3=new Button("Delete");

             Panel p=new Panel (new GridLayout(3,2));
             p.add(l1);p.add(t1);
             p.add(l2);p.add(t2);
             p.add(l3);p.add(t3);
             add("North",p);

             Panel p1=new Panel(new GridLayout(2,3));
             p1.add(b1);p1.add(b2);p1.add(b3);
             p1.add(b4);p1.add(b5); p1.add(b6);
             add("South",p1);

             b1.addActionListener(this);
             b2.addActionListener(this);
             b3.addActionListener(this);
            try
            {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con=DriverManager.getConnection("jdbc:odbc:deep","scott","tiger");

                 st=con.createStatement();
                 int eno=0,sal=0;
                 String ename=""; 
                 rs=st.executeQuery("select empno from emp");
                 while(rs.next())
                 {
                        cnt[i]=rs.getInt(1);
                        i++;
                 }
                 rs.close();
            }//end of try
            catch(Exception e){e.printStackTrace();}
       }//end of constructor
       public static void main(String[] args)
       {
            Frame f=new Emprecord();
            f.setSize(300,300);
            f.setVisible(true);
       }
       public void actionPerformed(ActionEvent e1)
       {
             try
             {
               if(e1.getSource().equals(b1))
               { 
                   PreparedStatement pst=con.prepareStatement("insert into emp(empno,ename,sal) values(?,?,?)");

                   int eno=Integer.parseInt(t1.getText());
                   String ename=t2.getText();
                   int sal=Integer.parseInt(t3.getText());
                   pst.setInt(1,eno);
                   pst.setString(2,ename.trim());
                   pst.setInt(3,sal);
                   int no=pst.executeUpdate();
                   System.out.println(no+ "rows inserted");
                }
                if(e1.getSource().equals(b2))
                {
                     st=con.createStatement();
                     int eno1=Integer.parseInt(t1.getText());
                     String ename1=t2.getText();
                     int sal1=Integer.parseInt(t3.getText());
                     int no= st.executeUpdate("update emp  set ename='"+ename1+"',sal="+sal1+" where empno="+eno1);
                     System.out.println(no+ "rows updated");
                }
                if(e1.getSource().equals(b3))
                {
                   PreparedStatement pst=con.prepareStatement("delete from emp where empno=?");

                   int eno=Integer.parseInt(t1.getText());
                   pst.setInt(1,eno);
                   int no=pst.executeUpdate();
                   System.out.println(no+ "rows deleted");
                }

        }catch (Exception e)
        {
                e.printStackTrace();
        }
   }
}

