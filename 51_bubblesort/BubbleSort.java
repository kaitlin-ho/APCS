// Four: Kaitlin, Jing, Fang
// APCS pd06
// HW51 -- implementing bubblesort
// 2022-01-04
// time spent:  hrs

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 *
 * ALGO:
 * 1) (Begin at index 0) Compare the element at index with the element at index+1 and swap the two if the latter is greater
 * 2) Repeat with index+1 as index
 * 3) Traverse the list arraylength-1 times
 *
 * DISCO:
 * 
 *
 * QCC:
 * q0: If a pass requires no swaps, what do you know?
 * a0: The array is sorted
 * q1: After pass p, what do you know?
 * a1: The first p numbers from the left (assuming the passes start from the right) are correctly ordered
 * q2: How many passes are necessary to completely sort?
 * a2: One less than the array length
 * 
 * Running javac -Xlint BubbleSort.java gave [rawtypes], [unchecked], missing type arguments,
 *    and more errors (NOTE: only on my (Kaitlin) end)
 * It worked for everyone else who ran my code; it also worked with an online compiler.
 *
 ******************************/

import java.util.ArrayList;

public class BubbleSort
{
//~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond:  lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    /* YOUR IMPLEMENTATION HERE */
    for (int passes = 0; passes < data.size() - 1; passes++){
      for (int num = 0; num < data.size() - 1; num ++){
        Comparable test = data.get(num);
        Comparable adj = data.get(num+1);
        if (test.compareTo(adj) > 0){
          data.set(num, adj);
          data.set(num+1, test);
        }
      }
    }
  }


//   ArrayList-returning bubbleSort
//   postcondition: order of input ArrayList's elements unchanged
//                  Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
    /* YOUR IMPLEMENTATION HERE */
    ArrayList<Comparable> result = new ArrayList();
    
    // copying arraylist 
    for(int i = 0; i < input.size(); i++){
      result.add(input.get(i));
    }
    
    // sorting new arraylist
    bubbleSortV(result);
    return result;
  }


  public static void main( String [] args )
  {


      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );
/*
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = bubbleSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
*/

  }//end main

}//end class BubbleSort
