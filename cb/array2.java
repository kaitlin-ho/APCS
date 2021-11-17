public class array2 {
  //Return the number of even ints in the given array. Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1.
  public int countEvens(int[] nums) {
    int numOfEven = 0;
    for (int i = 0; i < nums.length; i++){
      if ((nums[i]%2) == 0){
        numOfEven++;
      }
    }
    return numOfEven;
  }
  
  //Given an array of ints, return true if the sum of all the 2's in the array is exactly 8
  public boolean sum28(int[] nums) {
  int sum = 0;
  for (int i = 0; i < nums.length; i ++){
    if (nums[i] == 2){
      sum += 2;
    }
  }
  if (sum == 8){
    return true;
  }
  else{
    return false;
  }
}


  
public static void main(Strings args[]){
/* test cases
countEvens([2, 1, 2, 3, 4]) → 3
countEvens([2, 2, 0]) → 3
countEvens([1, 3, 5]) → 0

sum28([2, 3, 2, 2, 4, 2]) → true
sum28([2, 3, 2, 2, 4, 2, 2]) → false
sum28([1, 2, 3, 4]) → false
*/

  }
  
}
