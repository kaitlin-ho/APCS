/***
Soggy Crackers - Courtney, Kaitlin
APCS pd06
HW61 -- Instructions so Simple
2022-02-08
time spent: 2 hrs

  class MergeSort
  Implements mergesort on array of ints.
  Summary of Algorithm:
  Split the unsorted array in half until everything is sorted (1 element = sorted) then merge the sorted arrays together.
  (mergesort explanation commented down below)
  ***/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/

  private static int[] merge( int[] a, int[] b )
  {
    int[] returnArray = new int [a.length+b.length];
    int bnum = 0;
    int anum = 0;

    for (int i = 0; i < returnArray.length; i++){ //goes through each index of the output array
      if (anum == a.length){ // if we looked through all the elements of array a
        returnArray[i] = b[bnum]; //start adding the rest of the elements of array b to output array
        bnum = bnum +1; //counter to go through the rest of the elements
      }

      else if (bnum == b.length){ //^vice versa
        returnArray[i] = a[anum];
        anum = anum +1;
      }

      else{
        if (a[anum] < b[bnum]){ // if element anum is less add it to output array
            returnArray[i] = a[anum];
            anum = anum + 1;
          }
        else {
              returnArray[i] = b[bnum]; //^^vice versa
              bnum = bnum + 1;
            }
          }
        }
  return returnArray;
} //end merge


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
    if (arr.length < 2){
      return arr;
    }

    int avg = arr.length/2;
    int[] newR = new int [avg];
    int[] newL = new int [arr.length-avg];

    for (int i = 0; i < avg; i++){
      newR[i] = arr[i];
    }

    int index = 0;
    for (int i = arr.length - avg; i < arr.length; i++){
      newL[index] = arr[i];
      index ++;
    }

    return merge(sort(newR), sort(newL));

  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args )
  {

      // int[] arr0 = {3,6,9,10};
      // int[] arr1 = {2,8,9,13,16};
      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};
      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );
      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );
      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr4,arr6) );

      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );

  }//end main()

}//end class MergeSort
