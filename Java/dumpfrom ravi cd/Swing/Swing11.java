//A Program on JTable
    import java.awt.*;
    import javax.swing.*;
    class Swing11 extends JFrame
    {
     Swing11()
      {
             Container contentPane=getContentPane();
             contentPane.setLayout(new BorderLayout());
             final String[] colHeads={"Name","Phone","Fax"};
             final Object[][] data={ {"Vamsi Krishna","9865327 ","12116543"},
			{"Vinay Babu","2342342 ","6526743"},
			{"Mahesh Varma","2236472 ","1654537"},
			{"Guna Sekhar","2312342 ","6544143"},
			{"George Bush","2272342 ","6534243"},
			{"Lalith Kishore","2322342 ","6543743"}};
              JTable table=new JTable(data,colHeads);
              int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
              int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
              JScrollPane jsp=new JScrollPane(table,v,h);
              contentPane.add(jsp,BorderLayout.CENTER);
              setSize(400,500);
              setVisible(true);
        }
        public static void main(String [] args)
        {
                new Swing11();
         }
}
     