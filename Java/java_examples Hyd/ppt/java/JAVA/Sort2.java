// Sort2.java
// Based on D&D, Fig. 24.7 
// Using a Comparator object with algorithm sort
import java.util.*;

public class Sort2 
{
   public static void main( String args[] )
   {
      String suits[] = { "Hearts", "Diamonds","Clubs", "Spades" };                                        
      List theList = Arrays.asList( suits );   // get List

      System.out.println( "Unsorted array elements:\n" + theList );

      // sort in descending order
      Collections.sort( theList, Collections.reverseOrder() ); 

      System.out.println( "Sorted list elements:\n" + theList );
   }
}
