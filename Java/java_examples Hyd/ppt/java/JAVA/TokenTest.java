// TokenTest.java
// Testing the StringTokenizer class of the java.util package

import java.util.*;
import javax.swing.JOptionPane;

public class TokenTest {

   public static void main(String args[])
   {
     String str = JOptionPane.showInputDialog("Enter a string:");
	 String output;

     StringTokenizer tokens = new StringTokenizer( str );

     output = "Number of elements: " + tokens.countTokens() +
              "\nThe tokens are:\n" ;

     while ( tokens.hasMoreTokens() )
       output += tokens.nextToken() + "\n" ;
    
	 JOptionPane.showMessageDialog(null, output, 
			"Token Test Results",
			JOptionPane.INFORMATION_MESSAGE );
     
	 System.exit(0);
   }
}
