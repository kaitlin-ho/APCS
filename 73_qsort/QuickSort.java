
//Mr. K (Kaitlin, Raven, May)
//APCS pd0
//HW72 -- QuickSort
//2022-03-09w
//time spent: 1 h

/***
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
    Question:
    What is the best pivot point?
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):
 The method's base case is if the array length is 1 or the difference
 between the upper and lower bounds is equal to 1. If so, the method ends.
 If not, it continously runs partitions with new upper and lower bounds until the
 base case is fulfilled. These upper and lower bounds are when we choose the pivot
 position to be the average of the bounds. We use that return value as the new upper
 and lower bound.
 *
 * 2a. Worst pivot choice and associated run time:
 *  Worst pivot choice is the extremes.
    Run-time: O(n^2)
 * 2b. Best pivot choice and associated run time:
 *  Best pivot choice would be the median of the numbers.
    Run-time: O(nlog(n))
 * 3. Approach to handling duplicate values in array:
 *
 **/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d )
  {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------




  /**
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   */
  public static void qsort( int[] d )
  {
    if(d.length <= 1){
      return;
    }
    qHelper(d, 0, d.length-1);

  }

  public static void qHelper(int[] d, int lower, int upper){
    int s = Partition.partition(d, lower, upper);
    if(upper-lower <= 1){
      return;
    }
    qHelper(d,s,upper);
    qHelper(d,lower,s);
  }

  //main method for testing
  public static void main( String[] args )
  {


    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);



    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);
    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);
    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );
    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);
    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);
    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
