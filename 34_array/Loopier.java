public class Loopier {


static int[] test = new int [10];
static int[] test2 = {1,2,3,30};
	
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
		return result.substring(0,result.length()-1);
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
	
	//public, static implementations of a frequency function that will return the number of 
	//occurrences of a target in an existing array
	
	//Iterative
	public static int freq(int[] a, int target){
		int freqCount;
		for(int i = 0; i < a.length; i++){
			if (a[i] == target){
				freqCount += 1;
			}
		}
		return freqCount;
	}
	
	public static void main(String[] args){
		System.out.println(sVer(popInt(test)));
		System.out.println(linSearch(test2, 3));
	}

}
