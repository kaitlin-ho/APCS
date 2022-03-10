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
    What is the best pivot point? We think that the worst pivot choice is the one that results in subwindows that reduce by very little every time. This means that the element at pivot choice moves only a few indices to the left or right, as this results in a greater number of elements that need to be iterated through. Since you cannot find out the best/worst pivot choice without tracing or processing the array beforehand, we've decided to hard-code the pivot choice as the average of the upper and lower bounds.
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):
 The method's base case is if the array length is 1 or the difference
 between the upper and lower bounds is equal to 1 or the elements between lower and upper-1 are equal. If so, the method ends.
 If not, it continously runs partitions with new upper and lower bounds until the
 base case is fulfilled. The pivot position is the average of the bounds.
 We use the return value of non-base cases to repeat this method from the beginning, but with an updated window. One recursive call uses the return value as the new upper bound, and the other recursive call uses the return value as the new lower bound.
 and lower bound.
 *
 * 2a. Worst pivot choice and associated run time:
 *  What is the best pivot point? We think that the worst pivot choice is the one that results in subwindows that reduce by very little every time. This means that the element at pivot choice moves only a few indices to the left or right, as this results in a greater number of elements that need to be iterated through. Since you cannot find out the best/worst pivot choice without tracing or processing the array beforehand, we've decided to hard-code the pivot choice as the average of the upper and lower bounds.
    Run-time: O(n^2)
 * 2b. Best pivot choice and associated run time:
 *  What is the best pivot point? We think that the best pivot choice is the one that results in subwindows that halve every time. This means that the element at pivot choice moves to the middle of the window, as this results in more similar sizes for the next subwindows. Since you cannot find out the best/worst pivot choice without tracing or processing the array beforehand, we've decided to hard-code the pivot choice as the average of the upper and lower bounds.
    Run-time: O(nlog(n))
 * 3. Approach to handling duplicate values in array:
 *  We add a condition to the base case that checks if all the values from lower to upper-1 are equal. If so, we may end the method without upper and lower necessarily having a difference of less than 1.
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
    int l = d[lower];
    int i = lower;
    while(i < d.length && d[i] == l ){
        i++;
    }
    if(upper-lower <= 1 || d.length <= 1 || i >= upper-1){
        return;
    }
    int s = Partition.partition(d, lower, upper);
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

    qsort( arr1 ); //should be example of best case
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    int [] arr0 = {0, 2, 7, 1, 5};
    System.out.println("\narr0 init'd to: " );
    printArr(arr0);

    qsort( arr0 ); //should be example of worst case
    System.out.println("arr0 after qsort: " );
    printArr(arr0);

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
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
