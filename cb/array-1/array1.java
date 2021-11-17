public class array1 {
  //Given an array of ints, return true if 6 appears as either the first or last element in the array. The array will be length 1 or more.
  public static boolean firstLast6(int[] nums) {
    return (nums[0] == 6 || nums[nums.length-1] == 6);
  }

//Given an array of ints, return true if the array is length 1 or more, and the first element and the last element are equal.
  public static boolean sameFirstLast(int[] nums) {
  if (nums.length >= 1){
    return (nums[0] == nums[nums.length-1]);
    }
  else {return false;}
  }
//Return an int array length 3 containing the first 3 digits of pi, {3, 1, 4}.
  public static int[] makePi() {
    int[] result = {3, 1, 4};
    return result;
  }
//Given 2 arrays of ints, a and b, return true if they have the same first element or they have the same last element. Both arrays will be length 1 or more.
  public static boolean commonEnd(int[] a, int[] b) {
    return (a[0] == b[0] || a[a.length-1] == b[b.length-1]);
  }
//Given an array of ints length 3, return the sum of all the elements.
  public static int sum3(int[] nums) {
  int sum = 0;
  sum = nums[0] + nums[1] + nums[2];
  return sum;
}
//Given an array of ints length 3, return an array with the elements "rotated left" so {1, 2, 3} yields {2, 3, 1}.
public static int[] rotateLeft3(int[] nums) {
  int[] result = {nums[1], nums[2], nums[0]};
  return result;
}
//Given an array of ints length 3, return a new array with the elements in reverse order, so {1, 2, 3} becomes {3, 2, 1}.
public static int[] reverse3(int[] nums) {
  int[] result = {nums[2], nums[1], nums[0]};
  return result;
}
//Given an array of ints length 3, figure out which is larger, the first or last element in the array, and set all the other elements to be that value. Return the changed array
public static int[] maxEnd3(int[] nums) {
  // when int[] result is declared outside of the if/else statements, there is an illegal start of expression error
  // most likely because that meant declaring the values of an array after it was already intialized
  if (nums[0] > nums[2]){
    int[] result = {nums[0], nums[0], nums[0]};
    return result;
  }
  else {
    int[] result = {nums[2], nums[2], nums[2]};
    return result;
  }
}
//Given an array of ints, return the sum of the first 2 elements in the array. If the array length is less than 2, just sum up the elements that exist, returning 0 if the array is length 0.
public static int sum2(int[] nums) {
  if (nums.length == 0){
    return 0;
  }
  else {
    if (nums.length < 2) {return nums[0];}
    else {
      int sum = nums[0] + nums[1];
      return sum;
    }
    }
  }
//Given 2 int arrays, a and b, each length 3, return a new array length 2 containing their middle elements.
public static int[] middleWay(int[] a, int[] b) {
  int[] result = {a[1], b[1]};
  return result;
}
//Given an array of ints, return a new array length 2 containing the first and last elements from the original array. The original array will be length 1 or more.
public static int[] makeEnds(int[] nums) {
  int[] result = {nums[0], nums[nums.length-1]};
  return result;
}
//Given an int array length 2, return true if it contains a 2 or a 3
public static boolean has23(int[] nums) {
  return (nums[0] == 2 || nums[0] == 3 || nums[1] == 2 || nums[1] == 3);
}
//Given an int array length 2, return true if it does not contain a 2 or 3
public static boolean no23(int[] nums) {
  return !(nums[0] == 2 || nums[0] == 3 || nums[1] == 2 || nums[1] == 3);
}
//Given an int array, return a new array with double the length where its last element is the same as the original array, and all the other elements are 0. The original array will be length 1 or more. Note: by default, a new int array contains all 0's.
public static int[] makeLast(int[] nums) {
  int[] result = new int[nums.length*2];
  result[result.length-1] = nums[nums.length-1];
  return result;
}
//Given an int array, return true if the array contains 2 twice, or 3 twice. The array will be length 0, 1, or 2.
public static boolean double23(int[] nums) {
  if (nums.length == 0 || nums.length == 1) {return false;}
  else {
    return ((nums[0] == 2 && nums [1] == 2) || (nums[1] == 3 && nums[0] == 3));
    }
}
//Given an int array length 3, if there is a 2 in the array immediately followed by a 3, set the 3 element to 0. Return the changed array.
public static int[] fix23(int[] nums) {
  int[] result = nums;
  if (nums[0] == 2 && nums[1] == 3){
    result[1] = 0;
    return result;
  }
  if (nums[1] == 2 && nums[2] == 3){
    result[2] = 0;
    return result;
  }
  else { return nums; }
}


  public static void main(String args[]){
    /*
   NOTE: [] for arrays do not work in this case, arrays must be declared outside (but I ran out of time, will fix later)
   
    System.out.println(firstLast6([1, 2, 6]) + "... true");
    System.out.println(firstLast6([6, 1, 2, 3]) + "... true");
    System.out.println(firstLast6([13, 6, 1, 2, 3]) + "... false");

    System.out.println(sameFirstLast([1, 2, 3]) + "... false");
    System.out.println(sameFirstLast([1, 2, 3, 1]) + "... true");
    System.out.println(sameFirstLast([1, 2, 1]) + "... true");

    System.out.println(makePi() + "... [3, 1, 4]";

    System.out.println(commonEnd([1, 2, 3], [7, 3]) + "... true");
    System.out.println(commonEnd([1, 2, 3], [7, 3, 2]) + "... false");
    System.out.println(commonEnd([1, 2, 3], [1, 3]) + "... true");

    System.out.println(sum3([1, 2, 3]) + "... 6");
    System.out.println(sum3([5, 11, 2]) + "... 18");
    System.out.println(sum3([7, 0, 0]) + "... 7");

    System.out.println(rotateLeft3([1, 2, 3]) + "... [2, 3, 1]");
    System.out.println(rotateLeft3([5, 11, 9]) + "... [11, 9, 5]");
    System.out.println(rotateLeft3([7, 0, 0]) + "... [0, 0, 7]");

    System.out.println(reverse3([1, 2, 3]) + "... [3, 2, 1]");
    System.out.println(reverse3([5, 11, 9]) + "... [9, 11, 5]");
    System.out.println(reverse3([7, 0, 0]) + "... [0, 0, 7]");

    System.out.println(maxEnd3([1, 2, 3]) + "... [3, 3, 3]");
    System.out.println(maxEnd3([11, 5, 9]) + "... [11, 11, 11]");
    System.out.println(maxEnd3([2, 11, 3]) + "... [3, 3, 3]");

    System.out.println(sum2([1, 2, 3]) + "... 3";
    System.out.println(sum2([1, 1]) + "... 2");
    System.out.println(sum2([1, 1, 1, 1]) + "... 2");

    System.out.println(middleWay([1, 2, 3], [4, 5, 6]) + "... [2, 5]");
    System.out.println(middleWay([7, 7, 7], [3, 8, 0]) + "... [7, 8]");
    System.out.println(middleWay([5, 2, 9], [1, 4, 5]) + "... [2, 4]");

    System.out.println(makeEnds([1, 2, 3]) + "... [1, 3]");
    System.out.println(makeEnds([1, 2, 3, 4]) + "... [1, 4]");
    System.out.println(makeEnds([7, 4, 6, 2]) + "... [7, 2]");

    System.out.println(has23([2, 5]) + "... true");
    System.out.println(has23([4, 3]) + "... true");
    System.out.println(has23([4, 5]) + "... false");

    System.out.println(no23([4, 5]) + "... true");
    System.out.println(no23([4, 2]) + "... false");
    System.out.println(no23([3, 5]) + "... false");

    System.out.println(makeLast([4, 5, 6]) + "... [0, 0, 0, 0, 0, 6]");
    System.out.println(makeLast([1, 2]) + "... [0, 0, 0, 2]");
    System.out.println(makeLast([3]) + "... [0, 3]");

    System.out.println(double23([2, 2]) + "... true");
    System.out.println(double23([3, 3]) + "... true");
    System.out.println(double23([2, 3]) + "... false");

    System.out.println(fix23([1, 2, 3]) + "... [1, 2, 0]");
    System.out.println(fix23([2, 3, 5]) + "... [2, 0, 5]");
    System.out.println(fix23([1, 2, 1]) + "... [1, 2, 1]");
    
    */
  }
}
