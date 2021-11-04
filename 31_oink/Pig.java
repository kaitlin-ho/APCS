/*
NIWWD: Kevin Xiao + Mr. Swag, Jeffery Tang + Mathias, Kaitlin Ho + Apple
APCS
HW31 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
2021-11-03
time spent: 0.5
*/

/*
DISCO:
- Makes things way easier if previously coded methods are called upon.
- indexOf() was not needed
- We can modify this code so it can be compatible with capital lettersby either adding the captial letters into the initial VOWELS string or using .lowercase.

QCC:
- Why is final useful in this case?

*/

public class Pig
{
//Q: How does this initialization make your life easier?
//A: Can be used as a comparison; we don't need to keep writing out the vowels.
  private static final String VOWELS = "aeiou";


  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter ) {
	if (w.length() == 0) {
		return false;
	}else {
		for (int i = 0 ; i < w.length() ; i += 1) {
			if ((w.substring(i, i + 1)).equals(letter)) {
				return true;
			}
		}
		return false;
	}
}//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter ) {
	return hasA(VOWELS, letter);
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w ) {
	int v = 0;
	if (w.length() == 0) {
		return v;
	}else {
		for (int i = 0 ; i < w.length() ; i += 1) {
			if (hasA(VOWELS, w.substring(i, i + 1))) {
				v += 1;
			}
		}
		return v;
	}
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w ){
	if (w.length() == 0) {
		return false;
	}else {
		for (int i = 0 ; i < w.length() ; i += 1) {
			if (hasA(VOWELS, w.substring(i, i + 1))) {
				return true;
			}
		}
		return false;
	}
}


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w ){
	String v = "";
	if (w.length() == 0) {
		return v;
	}else {
		for (int i = 0 ; i < w.length() ; i += 1) {
			if (hasA(VOWELS, w.substring(i, i + 1))) {
				v += w.substring(i, i + 1);
			}
		}
		return v;
	}
  }

  public static void main( String[] args ){
	System.out.println(hasA("cat", "a"));
	System.out.println(hasA("cat", "p"));
	System.out.println(isAVowel("o"));
	System.out.println(isAVowel("k"));
	System.out.println(countVowels("meatball"));
	System.out.println(countVowels("b1g"));
	System.out.println(hasAVowel("cat"));
	System.out.println(hasAVowel("zzz"));
	System.out.println(allVowels("meatball"));
	System.out.println(allVowels("soy de los eeuu"));
  }//end main()

}//end class Pig
