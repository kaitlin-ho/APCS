public class Loopier {


static int[] test = new int [10];
static int[] test2 = {1,2,3,30, 2140, 222, 124, 1, 1, 24, 30, 1, 3};
	
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
		for(int i = 0; i < a.length; i++){
			result = result + a[i] + ", ";
		}
		return result.substring(0,result.length()-2);
	}
	
	//public static implementations of a linear search function that will return 
	//the index of the first occurrence of a target in an existing array, or -1 if not found
	
	//Iterative
	public static int linSearch(int[] a, int target){
		for(int i = 0; i < a.length; i++){
			if (a[i] == target){
				return i;
			}
		}
		return -1;
	}
	
	//Recursive
	public static int linSearchR(int[] a, int target) {

                if (a.length == 0) { return -1; }
		
                else {
			//base case
                        if (a[0] == target) { return 0;}
                        else {
				//new array that is essentially the input array without index 0
                                int[] aNew = new int[a.length-1];
				//filling new array
                                for (int i = 1; i < a.length; i++) {
                                        aNew[i-1] = a[i];
                                }
				
				//recursive call
                                return 1 + linSearchR(aNew, target);
                        }
                }
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
		if (a[0] == target) {return 1;}

		int[] aNew = new int[a.length-1];
		
		for (int i = 1; i < a.length; i++){
			aNew[i-1] = a[i];
		}
		
		return 1 + freqR(aNew, target);
	}
	
	public static void main(String[] args){
		// System.out.println(sVer(popInt(test)));
		System.out.println(linSearch(test2, 1)); // should be 0
		System.out.println(freq(test2, 1)); //should be 4
		// System.out.println(linSearchR(test2, 4)); // should be -1 because 4 is not in the array
      		System.out.println(linSearchR(test2,3)); // should be 2
		System.out.println(freqR(test2, 1)); // should be 4
		System.out.println(freqR(test2, 24100)); // should be -1 because it is not in the array
	}

}
