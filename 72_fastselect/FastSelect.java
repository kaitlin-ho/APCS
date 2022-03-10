/**
Mr. K: May Qiu, Kaitlin Ho, Raven (Ruiwen) Tang
APCS pd06
HW72 -- So So Fast / using partition to find the _y_th smallest element
2022-03-08
time spent: 01.0 hrs
**/

/**
 ALGO
 * 1. Run partition on the window you're given. c is an index value within this window. Here, we've chosen it to be the average of the lower bound and the upper bound.
 * 2. partition() will return where the element originally at c has been moved to. This value is where the new partition is, and you know all elements to the left are less than it, and all elements to the right are greater than it.
 * 3. If the partition() return value is equal to y-1, then it must be the _y_th smallest element. Return the value at the index.
 * 4. Otherwise, check if the return value is greater than y-1. If it is, you know the _y_th smallest element is to the left of this new partition. Repeat from the beginning of this algorithm, with the upper bound of the window reduced to the new partition-1.
 * 5. If you've reached this step, the return value is smaller than y-1. You now know the _y_th smallest element is to the right of this new partition. Repeat from the beginning of this algorithm, wih the lower bound of the window updated to the new parition+1.
 * 
 * Execution time in Big-Oh: O(n*logn). Each time partition is run, it takes linear time. Partition is run up to log base 2 of n times because the possible window for the _y_th element is halved each time the method is called. Multiply, and get O(n*logn).
 BEST CASE SCENARIO
 * The _y_th smallest element is in the exact middle of the array, as the method will only call partition() once. This case will take O(n), based on the runtime of partition().
 * 
 WORST CASE SCENARIO
 * The _y_th smallest element requires log(n) splits to reach, as this requires the window to be reduced log(n) times and the partition to be called log(n) times. This case will take O(n*logn), as it runs an O(n) process log(n) times.
 * 
 DISCO
 * partition() returns the new index of the element originally at c.
 * findY() uses a similar approach as partition and binary search, with lower and upper bounds.
 * The whole array does not actually have to be sorted. You simply need to know which elements still have the potential to be the _y_th smallest element, and if you know a group of elements is greater than or less than the _y_th smallest element (even if you don't know their ordering), you can eliminate them from consideration.
 * 
 QCC
 * This seems very similar to binary search, because we recursively call the method while updating the lower and upper bounds based on comparisons. 
 * Why should be assume that there are no duplicates? Would having duplicates negatively affect us?
 * We know that sorting the array and then finding the element at y-1 would take O(n*logn). Our method takes O(n*logn) in the "best" case, which isn't better than sorting. How can we improve our method and reduce runtime? It seems like partition() will always take linear time, so any solution involving it will have a factor of n.
**/

public class FastSelect{
    public static int partition( int[] arr, int a, int b, int c)
  {
    int v = arr[c];

    swap( c, b, arr);
    int s = a;

    for( int i = a; i < b; i++ ) {
      if ( arr[i] <= v) {
        swap( i, s, arr );
        s++;}
    }
    swap(s,b,arr);

    return s;
  }//end mysterion

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

  public static int findY(int[] arr, int y, int lower, int upper){
    //printArr(arr);
    int c = (lower+upper)/2; // also possible but less certainty when tracing, less efficient (possibly?): (int)(Math.random() * (upper-lower)) + lower
    int swapShift = partition(arr, lower, upper, c);
    if(swapShift == y-1){ //s = the wall
        return arr[y-1];
    }
    if(swapShift < y-1){
        return findY(arr, y, swapShift+1, upper);
    }
    return findY(arr, y, lower, swapShift-1);
  }

  public static void main(String[] args){
    int[] arr1 = {7, 1, 5, 12, 3};
    System.out.println(findY(arr1, 3, 0, 4)); //should be 5, example of best case
    int[] arr2 = {7, 1, 5, 12, 3};
    System.out.println(findY(arr2, 4, 0, 4)); //should be 7
    int[] arrayTwo = {122, 12, 24, 2, 124};
    System.out.println(findY(arrayTwo, 5, 0, 4)); //should be 124
    int[] arrayThree = {1000, 1, 5, 12, 3, 2, 4, 153, 23};
    System.out.println(findY(arrayThree, 1, 0, 8 )); //should be 1
    int[] arrayFour = {0, 2, 7, 1, 5};
    System.out.println(findY(arrayFour, 2, 0, 4)); //should be 1, example of worst case
  }
}
