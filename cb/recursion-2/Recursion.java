/*
Team AK: Ariella Katz, Kaitlin Ho, Tom, Apple
APCS
HW64: Revisitation
2022-02-14
time spent: 0.5 hrs
*/

public class Recursion2{

/*
Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target? This is a classic backtracking recursion problem. Once you understand the recursive backtracking strategy in this problem, you can use the same pattern for many problems to search a space of choices. Rather than looking at the whole array, our convention is to consider the part of the array starting at index start and continuing to the end of the array. The caller can specify the whole array simply by passing start as 0. No loops are needed -- the recursive calls progress down the array.
groupSum(0, [2, 4, 8], 10) → true
groupSum(0, [2, 4, 8], 14) → true
groupSum(0, [2, 4, 8], 9) → false
*/
  public boolean groupSum(int start, int[] nums, int target) {
    if (start >= nums.length) {
      if (target == 0) { return true; }
      else { return false; }
    }
    else {
      return (groupSum(start+1, nums, target-nums[start]) ||
      groupSum(start+1, nums, target));
    }
  }

/*
Given an array of ints, is it possible to choose a group of some of the ints, beginning at the start index, such that the group sums to the given target? However, with the additional constraint that all 6's must be chosen. (No loops needed.)
groupSum6(0, [5, 6, 2], 8) → true
groupSum6(0, [5, 6, 2], 9) → false
groupSum6(0, [5, 6, 2], 7) → false
*/
  public boolean groupSum6(int start, int[] nums, int target) {
    if (start >= nums.length) {
      if (target == 0) { return true; }
      else { return false; }
    }
    else {
      if (nums[start] == 6) {
        return (groupSum6((start+1), nums, target-nums[start]));
      }
      else {
        return (groupSum6(start+1, nums, target-nums[start]) ||
        groupSum6(start+1, nums, target));
      }
    }
  }

/*
Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target with this additional constraint: If a value in the array is chosen to be in the group, the value immediately following it in the array must not be chosen. (No loops needed.)
groupNoAdj(0, [2, 5, 10, 4], 12) → true
groupNoAdj(0, [2, 5, 10, 4], 14) → false
groupNoAdj(0, [2, 5, 10, 4], 7) → false
*/
  public boolean groupNoAdj(int start, int[] nums, int target) {
    if (start >= nums.length) {
      if (target == 0) { return true; }
      else { return false; }
    }
    else {
      return (groupNoAdj(start+2, nums, target-nums[start]) ||
      groupNoAdj(start+1, nums, target));
    }
  }

  public static void main(String[] args) {
    Recursion2 recurse = new Recursion2();

    System.out.println("Expecting true...");
    System.out.println(recurse.groupSum(0, new int[] {2, 4, 8}, 10));
    System.out.println("Expecting true...");
    System.out.println(recurse.groupSum(0, new int[] {2, 4, 8}, 14));
    System.out.println("Expecting false...");
    System.out.println(recurse.groupSum(0, new int[] {2, 4, 8}, 9));
    System.out.println("Expecting true...");
    System.out.println(recurse.groupSum(0, new int[] {2, 4, 8}, 8));
    System.out.println("Expecting true...");
    System.out.println(recurse.groupSum(1, new int[] {2, 4, 8}, 8));
    System.out.println("Expecting false...");
    System.out.println(recurse.groupSum(1, new int[] {2, 4, 8}, 2));
    System.out.println("Expecting true...");
    System.out.println(recurse.groupSum(0, new int[] {1}, 1));
    System.out.println("Expecting false...");
    System.out.println(recurse.groupSum(0, new int[] {9}, 1));
    System.out.println("Expecting true...");
    System.out.println(recurse.groupSum(1, new int[] {9}, 0));
    System.out.println("Expecting true...");
    System.out.println(recurse.groupSum(0, new int[] {}, 0));

    System.out.println("-------------------------");

    System.out.println("Expecting true...");
    System.out.println(recurse.groupSum6(0, new int[] {5, 6, 2}, 8));
    System.out.println("Expecting false...");
    System.out.println(recurse.groupSum6(0, new int[] {5, 6, 2}, 9));
    System.out.println("Expecting false...");
    System.out.println(recurse.groupSum6(0, new int[] {5, 6, 2}, 7));
    System.out.println("Expecting true...");
    System.out.println(recurse.groupSum6(0, new int[] {1}, 1));
    System.out.println("Expecting false...");
    System.out.println(recurse.groupSum6(0, new int[] {9}, 1));
    System.out.println("Expecting true...");
    System.out.println(recurse.groupSum6(0, new int[] {}, 0));
    System.out.println("Expecting false...");
    System.out.println(recurse.groupSum6(0, new int[] {3, 2, 4, 6}, 9));
    System.out.println("Expecting true...");
    System.out.println(recurse.groupSum6(0, new int[] {6, 2, 4, 3}, 8));
    System.out.println("Expecting false...");
    System.out.println(recurse.groupSum6(0, new int[] {5, 2, 4, 6}, 9));
    System.out.println("Expecting false...");
    System.out.println(recurse.groupSum6(0, new int[] {6, 2, 4, 5}, 9));

    System.out.println("-------------------------");

    System.out.println("Expecting true...");
    System.out.println(recurse.groupNoAdj(0, new int[] {2, 5, 10, 4}, 12));
    System.out.println("Expecting false...");
    System.out.println(recurse.groupNoAdj(0, new int[] {2, 5, 10, 4}, 14));
    System.out.println("Expecting false...");
    System.out.println(recurse.groupNoAdj(0, new int[] {2, 5, 10, 4}, 7));
    System.out.println("Expecting true...");
    System.out.println(recurse.groupNoAdj(0, new int[] {2, 5, 10, 4, 2}, 7));
    System.out.println("Expecting true...");
    System.out.println(recurse.groupNoAdj(0, new int[] {2, 5, 10, 4}, 9));
    System.out.println("Expecting true...");
    System.out.println(recurse.groupNoAdj(0, new int[] {10, 2, 2, 3, 3}, 15));
    System.out.println("Expecting false...");
    System.out.println(recurse.groupNoAdj(0, new int[] {10, 2, 2, 3, 3}, 7));
    System.out.println("Expecting true...");
    System.out.println(recurse.groupNoAdj(0, new int[] {}, 0));
    System.out.println("Expecting true...");
    System.out.println(recurse.groupNoAdj(0, new int[] {1}, 1));
    System.out.println("Expecting false...");
    System.out.println(recurse.groupNoAdj(0, new int[] {9}, 1));

  }

}
