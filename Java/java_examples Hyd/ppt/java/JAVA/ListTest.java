// ListTest.java
// Based on Fig. 24.4 
import java.util.*;

public class ListTest 
{
   public static void main( String args[] )
   {
      String colors[] = { "black", "yellow", "green",
                          "blue", "violet", "silver" };
      String colors2[] = { "gold", "white", "brown",
                           "blue", "gray", "silver" };

      LinkedList link = new LinkedList();
      LinkedList link2 = new LinkedList();

      for ( int k = 0; k < colors.length; k++ ) {
         link.add( colors[ k ] );
         link2.add( colors2[ k ] );   // same length as colors
      }

      link.addAll( link2 );           // concatenate lists
      link2 = null;                   // release resources

      printList( link );

      uppercaseStrings( link );
      printList( link );

      System.out.print( "\nDeleting elements 4 to 6..." );
      link.subList(4,7).clear();   // remove items      

      printList( link );        
   } // end of main()


   public static void printList( List listRef )
   {
      System.out.println( "\nlist: " );
      for ( int k = 0; k < listRef.size(); k++ )
         System.out.print( listRef.get( k ) + " " );
      System.out.println();
   }               
                                     

   public static void uppercaseStrings( List listRef2 )
   {
      ListIterator listIt = listRef2.listIterator();
      while (listIt.hasNext()) {
         Object obj = listIt.next();       // get item
         if (obj instanceof String)      // check for String
            listIt.set( ((String) obj).toUpperCase() ); 
      }
   }

} // end of ListTest
