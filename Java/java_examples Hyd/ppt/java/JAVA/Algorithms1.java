// Fig. 24.9 : Algorithms1.java
// Using algorithms reverse, fill, copy, min and max
import java.util.*;

public class Algorithms1 
{
   public static void main( String args[] )
   {
      String letters[] = { "P", "C", "M" };
      List theList = Arrays.asList( letters );        // get List
      String lettersCopy[] = new String[ 3 ];
      List copyList = Arrays.asList( lettersCopy );

      System.out.println( "Printing initial stats: " );
      printStatistics( theList );

      Collections.reverse( theList );            // reverse order
      System.out.println( "\nPrinting stats after calling reverse: ");
      printStatistics( theList );

      Collections.copy( copyList, theList );  // copy List
      System.out.println( "\nPrinting stats after copying: ");
      printStatistics( copyList );

      System.out.println( "\nPrinting stats after calling fill: ");
      Collections.fill( theList, "R" );
      printStatistics( theList );
   }

   private static void printStatistics( List listRef )
   {
      System.out.print( "The list is: " );
      for ( int k = 0; k < listRef.size(); k++ )
         System.out.print( listRef.get( k ) + " " );

      System.out.print( "\nMax: " + Collections.max( listRef ) );
      System.out.println( "  Min: " + Collections.min( listRef ) );
   }
} // end of Algorithms1
