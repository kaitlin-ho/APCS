public class Rof {
	//fence using for loop, this works
	public static String fenceF(int posts) {
		String result = "|";
		for (int postCounter = 1; postCounter < posts; postCounter++) {
			result += "--|";
		}
		return result;
	}
	
	//reversing string using for loop, this works
	public static String reverseF(String s) {
		String result = "";
		for (int character = s.length(); character>=0;character--){
			if (character != 0){
				result+=s.substring(character - 1,character);
			} else {
				break;
			}
		}
		return result;
		
	}
	
	public static String reverseR(String s){
		if (s.length()==1){
			return s;
		}
		return reverseR(s.substring(1))+s.substring(0,1);
	}

	
	public static void main(String[] args) {
		System.out.println(fenceF(3));
		System.out.println(fenceF(10));
		System.out.println(reverseF("joe mama"));
		System.out.println(reverseR("reversed"));
	}
}
