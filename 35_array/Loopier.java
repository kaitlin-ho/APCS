/*
* TNPG: Four {Fang Chen, Kaitlin Ho, Jing yi Feng, }
* APCS
* HW35 
* 2021-11-15
* time spent: 0.7 hr
*/

/* 
	(Continued) Algorithm for Team Strawberry Jam {Melody, Sophia, Josiah}
	linSearchR: (recursive)
	Given an array and target, if the length of the array, the function will return
	-1 immediately. If the first value of the array is equal to the target, it will 
	return 0, thusly ending the recursion (explained later). If neither conditions 
	are met, the method will create a new array (aNext) with one less index count and
	use a for function to fill it in with all the values of the original array except
	the first value (index 0). Declares an int value next, which is set to the return
	value of linSearchR(aNext, target). If next is equal to -1, the function will
	return a -1. If not, the function returns 1 + next.
	* Essentially the recursive function run and checks every value in the array by
	* removing every value it has already checked. Every time a value is checked for
	* whether it's equal to the target, the return will add one and rerun the function
	* to check for the next value. If until the last value is checked and the array is
	* left with nothing, it will return -1 which causes to the previous recursion to
	* also return one. Through everything, the original method that was run would 
	* return -1.
	freq: (iterative) 
	Declares int variable named result and sets the value to 0.
	Using a for function to check every index of the array a and if 
	a[i] is equal to the target, the result adds one. Method returns the
	final result.
	freqR: (recursive)
	If the length of the array, return 0. 
	Otherwise the function creates a new int array (aNext) with 1 less index.
	Uses a for function to shift all the values of the original array (a) to
	index - 1 in the new array, where a[0] is not added to aNext.
	If a[0] is equal to the target, the function returns 1 + freqR(aNext, target).
	If it is not equal to the target, it returns freqR(aNext, target).
	* Essentially the recursive function runs and checks every value in the array
	* and adds 1 to the final return if it is equal to the target.
*/

/*
	DISCO
	00: You can set a variable to the return of a recursive within that method.
	QCC
	00: When is it more effective to use recursive rather than iterative?
*/


public class Loopier {


static int[] test = new int [10];
static int[] test2 = {1,2,3,30, 2140, 222, 124, 1, 1, 24, 30, 1};
	
	//A static method to populate an existing array with randomly generated ints
	public static int[] popInt(int[] a) {
		for(int i = 0; i < a.length; i++){
			a[i] = (int)(Math.random()*100);
		}
		return a;
	}

	//A static method to return a String version of an array of ints
	public static String sVer(int[] a) {
		String result = "";
		for(int i = 0; i < a.length; i++) {
			result = result + a[i] + ", ";
		}
		return result.substring(0, result.length() - 2);
	}
	
	//public static implementations of a linear search function that will return 
	//the index of the first occurrence of a target in an existing array, or -1 if not found
	
	//Iterative
	public static int linSearch(int[] a, int target){
		for(int i = 0; i < a.length; i++) {
			if (a[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	//Recursive
	public static int linSearchR(int[] a, int target) {

		if (a.length == 0) {
			return -1;
		}

		//base case
        if (a[0] == target) {
        	return 0;
 		}
		//new array that is essentially the input array without index 0
		int[] aNew = new int[a.length-1];
		//filling new array
            for (int i = 1; i < a.length; i++) {
                    aNew[i-1] = a[i];
            }
	    //recursive call
        int next = linSearchR(aNew, target);
        if (next == -1) {
        	return -1;
        }
    	return 1 + linSearchR(aNew, target);
        }
        
	//public, static implementations of a frequency function that will return the number of 
	//occurrences of a target in an existing array
	
	//Iterative
	public static int freq(int[] a, int target){
		int freqCount = 0;
		for(int i = 0; i < a.length; i++){
			if (a[i] == target){
				freqCount += 1;
			}
		}
		return freqCount;
	}
	
	//Recursive
	public static int freqR(int[] a, int target){

		if (a.length == 0){
			return 0;
		} else {
			int[] aNew = new int[a.length - 1];
			for (int i = 1; i < a.length; i ++) {
				aNew[i-1] = a[i];
			}
			if (a[0] == target) {
				return 1 + freqR(aNew, target);
			} else {
				return freqR(aNew, target);
			}
		}

	}

	
	public static void main(String[] args){
		System.out.println(sVer(popInt(test)));
		System.out.println(linSearch(test2, 1)); // should be 0
		System.out.println(freq(test2, 1)); //should be 4
		System.out.println(linSearchR(test2, 4)); // should be -1
  		System.out.println(linSearchR(test2, 3)); // should be 2
		System.out.println(freqR(test2, 1)); // should be 4
		System.out.println(freqR(test2, 24100)); // should be 0
	}

}
