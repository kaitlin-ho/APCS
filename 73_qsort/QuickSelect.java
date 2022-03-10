public class QuickSelect{
  public static int findY(int[] arr, int y, int lower, int upper){
  //printArr(arr);
  int swapShift = Partition.partition(arr, lower, upper);
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
