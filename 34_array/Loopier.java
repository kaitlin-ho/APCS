public class Loopier {


static int[] test = new int [10];
static int[] test2 = {1,2,3,30};
	
	//A static method to populate an existing array with randomly generated ints
	public static int[] popInt(int[] A) {
		for(int i = 0; i < A.length; i++){
			A[i] = (int)(Math.random()*100);
		}
		return A;
	}		
	//A static method to return a String version of an array of ints
	public static String sVer(int[] A) {
		String result = "";
		for(int i = 0; i < A.length; i++){
			result = result + A[i];
		}
		return result;
	}
	
	//public static implementations of a linear search function that will return 
	//the index of the first occurrence of a target in an existing array, or -1 if not found
	
	//Iterative
	public static int linSearch(int[] A, int target){
		for(int i = 0; i < A.length; i++){
			if (A[i] == target){
				return target;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		System.out.println(sVer(popInt(test)));
		System.out.println(linSearch(test2, 3));
	}

}
