// Sort1.java
// Based on D&D Fig. 24.6 : 

import java.util.*;

public class Sort1 
{
   public static void main( String args[] )
   {
      String suits[] = { "Hearts", "Diamonds",
                                     "Clubs", "Spades" };
      ArrayList theList =
            new ArrayList( Arrays.asList(suits) );

      System.out.println( "Unsorted array elements:\n" + theList );

      Collections.sort( theList );    // sort the List
      System.out.println( "Sorted array elements:\n" + theList );
   }
}
