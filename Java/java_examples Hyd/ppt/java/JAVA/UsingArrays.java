// UsingArrays.java
// Based on D&D, Fig. 24.1

import java.util.*;

public class UsingArrays 
{
   static int intValues[] = { 1, 2, 3, 4, 5, 6 };
   static double doubleValues[] = { 8.4, 9.3, 0.2, 7.9, 3.4 };
   static int filledInt[], intValuesCopy[];

   public static void main( String args[] )
   {
      initArrays();
      printArrays();

      printEquality();

      int n = Arrays.binarySearch( intValues, 5 );
      System.out.println( ( n >= 0 ? "Found 5 at element " + n :
                          "5 not found" ) + " in intValues" );

      n = Arrays.binarySearch( intValues, 8763 );
      System.out.println( ( n >= 0 ? "Found 8763 at element "
                          + n : "8763 not found" )
                          + " in intValues" );
   } // end of main()
                                           

   public static void initArrays()
   {
      filledInt = new int[ 10 ];
      intValuesCopy = new int[ intValues.length ];
      Arrays.fill( filledInt, 7 );   // fill with 7s
      Arrays.sort( doubleValues );   // sort doubleValues
      System.arraycopy( intValues, 0, intValuesCopy,
                        0, intValues.length );
   } // end of initArrays()


   public static void printArrays()
   {     
      System.out.print( "doubleValues: " );
      for ( int k = 0; k < doubleValues.length; k++ )
         System.out.print( doubleValues[ k ] + " " );

      System.out.print("\nintValues: " );
      for ( int k = 0; k < intValues.length; k++ )
         System.out.print( intValues[ k ] + " " );

      System.out.print("\nfilledInt: " );
      for ( int k = 0; k < filledInt.length; k++ )
         System.out.print( filledInt[ k ] + " " );

      System.out.print("\nintValuesCopy: " );
      for ( int k = 0; k < intValuesCopy.length; k++ )
         System.out.print( intValuesCopy[ k ] + " " );
      System.out.println();
   } // end of printArrays()


   public static void printEquality()
   {
      boolean b = Arrays.equals( intValues, intValuesCopy );
      System.out.println( "intValues " + ( b ? "==" : "!=" )
                          + " intValuesCopy" );

      b = Arrays.equals( intValues, filledInt );
      System.out.println( "intValues " + ( b ? "==" : "!=" )
                          + " filledInt" );
   } // end of printEquality()

}
