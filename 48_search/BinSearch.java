// Team Four {Fang, Kaitlin, Jing}
// APCS pd06
// HW48 -- implementing linear and binary search on an ArrayList of Comparables
// 2021-12-16

/**
   class BinSearch
   Binary search on array of Comparables
**/

/**
  Disco
  * The built-in object Comparable allow the usage of compareTo() and is used in the Integer Wrapper class
  * Since a is a Comparable[], each element of a is a Comparable, and thus a[m].compareTo(target) compiles and runs
  QCC
  * Is there any difference in efficiency between a recursive and iterative version of binary search?
  * What are the advantages of being returned an index of an occurrence of the target that doesn't necessarily have to the the first or last occurrence of the target?
**/

public class BinSearch
{

  /**
     int binSearch(Comparable[],Comparable) -- searches an array of 
     Comparables for target Comparable
     pre:  input array is sorted in ascending order
     post: returns index of target, or returns -1 if target not found
  **/
  public static int binSearch ( Comparable[] a, Comparable target )
  {
    //uncomment exactly 1 of the 2 stmts below:

    return binSearchIter( a, target, 0, a.length-1 ); // passed tests
    // return binSearchRec( a, target, 0, a.length-1 ); // passed tests
  }


  public static int binSearchRec( Comparable[] a,
                                  Comparable target,
                                  int lo, int hi )
  {

    int tPos = -1; //init return var to flag value -1
    int m = (lo + hi) / 2; //init mid pos var

    if (hi < lo) {
      return tPos;
    }

    if (a[m].compareTo(target) == 0) {
      tPos = m;
    }
    if (a[m].compareTo(target) > 0) {
      tPos = binSearchRec(a, target, lo, m - 1);     
    }
    if (a[m].compareTo(target) < 0) {
      tPos = binSearchRec(a, target, m + 1, hi);
    }

    return tPos;
  }//end binSearchRec


  public static int binSearchIter( Comparable[] a,
                                   Comparable target,
                                   int lo, int hi )
  {

    int tPos = -1; //init return var to flag value -1
    int m = (lo + hi) / 2; //init mid pos var

    while(!(hi < lo)) { // run until lo & hi cross

      //update mid pos var
      m = (lo + hi) / 2;

      // target found
      if (a[m].compareTo(target) == 0) {
        tPos = m;
        break;
      }

      // value at mid index higher than target
      if (a[m].compareTo(target) > 0) {
        hi = m - 1;
      }

      // value at mid index lower than target
      if (a[m].compareTo(target) < 0) {
        lo = m + 1;
      }

    }
    return tPos;
  }//end binSearchIter



  //tell whether an array is sorted in ascending order
  private static boolean isSorted( Comparable[] arr )
  {

    boolean retBoo = true; //init to true, assume array is sorted

    //Q: Why would a FOREACH loop not suffice here?
    for( int i=0; i < arr.length-1; i++ ) {
      if ( ( arr[i].compareTo(arr[i+1]) > 0 ) ) {
        return false;
      }
    }
    return retBoo; //if entire array was traversed, it must be sorted
  }


  // utility/helper fxn to display contents of an array of Objects
  private static void printArray( Comparable[] arr ) {
    String output = "[ "; 

    for( Comparable c : arr )
      output += c + ", ";

    output = output.substring( 0, output.length()-2 ) + " ]";

    System.out.println( output );
  }


  //main method for testing
  //minimal -- augment as necessary
  public static void main ( String[] args )
  {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    System.out.println("\nNow testing binSearch on Comparable array...");

    //Declare and initialize array of Comparables
    Comparable[] iArr = { 2, 4, 6, 8, 6, 42 };
    printArray( iArr );
    System.out.println( "iArr1 sorted? -- " + isSorted(iArr) ); // printed false

    Comparable[] iArr2 = { 2, 4, 6, 8, 13, 42 };
    printArray( iArr2 );
    System.out.println( "iArr2 sorted? -- " + isSorted(iArr2) ); // printed true

    Comparable[] iArr3 = new Integer[10000];
    for( int i = 0; i < iArr3.length; i++ ) {
    iArr3[i] = i * 2;
    }

    // printArray( iArr3 ); // printing worked as intended
    System.out.println( "iArr3 sorted? -- " + isSorted(iArr3) ); // printed true

    //search for 6 in array 
    System.out.println( binSearch(iArr2,2) ); // should be 0 // printed 0
    System.out.println( binSearch(iArr2,4) ); // should be 1 // printed 1
    System.out.println( binSearch(iArr2,6) ); // should be 2 // printed 2
    System.out.println( binSearch(iArr2,8) ); // should be 3 // printed 3
    System.out.println( binSearch(iArr2,13) ); // should be 4 // printed 4
    System.out.println( binSearch(iArr2,42) ); // should be 5 // printed 5

    //search for 43 in array 
    System.out.println( binSearch(iArr2,43) );

    System.out.println( "now testing binSearch on iArr3..." );
    System.out.println( binSearch(iArr3,4) ); // should be 2 // printed 2
    System.out.println( binSearch(iArr3,8) ); // should be 4 // printed 4
    System.out.println( binSearch(iArr3,5) ); // should be -1 // printed -1

    //search for 43 in array 
    System.out.println( binSearch(iArr3,43) ); // should be -1 // printed -1  

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  }//end main()

}//end class BinSearch2
