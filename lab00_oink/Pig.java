/***
 * The Greyducks: Ariella Katz, Kaitlin Ho, Hugo Jenkins, Tom, __, __
 * APCS
 * L00 -- Etterbay Odincay Oughthray Ollaborationcay
 * 2021-11-08
 * time spent: 0.5hrs
 *
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

/*
To-Do:
Debug Thluffy’s Pig.java
Adding methods and instance variables supplied
Multiple consonants at the beginning of the word
Capitalization
Punctuation
Apostrophes
Numbers
Words with no vowels
*/

/*
DISCO:
0.
QCC:
0.
*/

/*import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;*/

public class Pig
{

  //Q: How does this initialization make your life easier?
  //A: We can use VOWELS in any method without creating a local variable whenever we need it.
  private static final String VOWELS = "aeiouyAEIOU";
  private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String PUNCS = ".,:;!?";



  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter )
  {
    return (w.indexOf(letter) != -1);
  }


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter )
  {
    return (VOWELS.indexOf(letter) != -1);
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w )
  {
    return allVowels(w).length();
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w )
  {
    return (countVowels(w) > 0);
  }


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w )
  {
    String vowStr = "";
    for (int i = 0; i < w.length(); i++) {
      if (isAVowel(w.substring(i, i+1))) { vowStr = vowStr + w.substring(i, i+1); }
    }
    return vowStr;
  }

  /*====================================
      String firstVowel(String) -- returns first vowel in a String
      pre:  w != null
      post: firstVowel("") --> ""
            firstVowel("zzz") --> ""
            firstVowel("meatball") --> "e"
    =======================================*/
  public static String firstVowel( String w ) {

    String ans = "";

    if ( hasAVowel(w) ) //Q: Why this necess?
      ans = allVowels(w).substring(0,1);

    return ans;
  }

  /*====================================
      boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
      pre:  w != null and w.length() > 0
      post: beginsWithVowel("apple") --> true
            beginsWithVowel("strong") --> false
    =======================================*/
  public static boolean beginsWithVowel( String w ) {
    return isAVowel( w.substring(0,1) );
  }

   /*====================================
      String engToPig(String) -- converts an English word to Pig Latin
      pre:  w.length() > 0
      post: engToPig("apple") --> "appleway"
            engToPig("strong") --> "ongstray"
            engToPig("java") --> "avajay"
    =======================================*/
  public static String engToPig( String w ) {

    String ans = "";

    if (beginsWithVowel(w) && !hasPunc(w)){
	  ans = w + "way";
    else if (isPunc(w.substring(w.length()-1))) {
    	String punc = w.substring(w.length()-1);
	ans = w.substring(0, w.length()) + "way" + punc;
    	}
    }

    else {
	if (beginsWithUpper(w)){
	   int vPos = w.indexOf( firstVowel(w) );
	   ans = (w.substring(vPos, vPos+1)).toUpperCase() + w.substring(vPos+1) + (w.substring(0,vPos)).toLowerCase() + "ay";
	   }
	else {
           int vPos = w.indexOf( firstVowel(w) );
           ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
	}
    }

    return ans;
  }


  /*=====================================
      boolean isPunc(String) -- tells whether a character is punctuation
      pre:  symbol.length() == 1
      post: isPunc(".") -> true
            isPunc("b") -> false
      =====================================*/
    public static boolean isPunc( String symbol ) {
	    return PUNCS.indexOf( symbol ) != -1;
    }


    /*=====================================
      boolean isUpperCase(String) -- tells whether a letter is uppercase
      pre:  letter.length() == 1
      post: isUpperCase("a") -> false
            isUpperCase("A") -> true
      =====================================*/
    public static boolean isUpperCase( String letter ) {
      return CAPS.indexOf ( letter ) != -1;
    }


    /*=====================================
      boolean hasPunc(String) -- tells whether a String contains punctuation
      pre:  w != null
      post: hasPunc(“cat.”) -> true
            hasPunc(“cat”) -> false
      =====================================*/
    public static boolean hasPunc( String w ) {
      for (int i = 0; i < w.length(); i += 1) {
        if (isPunc(w.substring(i,i+1))) { return true; }
      }
      return false;
    }


    /*=====================================
      boolean beginsWithUpper(String) -- tells whether 1st letter is uppercase
      pre:  w != null and w.length() > 0
      post: beginsWithUpper("Apple") -> true
            beginsWithUpper("apple") -> false
      =====================================*/
    public static boolean beginsWithUpper( String w ) {
	     return isUpperCase(w.substring(0,1) );
    }

  public static void main( String[] args ) {

/*     File words = new File("in.words");
     Scanner scanner = new Scanner(words);
     String[] wordList = new String[5];
     int n = 0;
     while (n < 5) {
       String word = scanner.nextLine();
       wordList[n] = word;
       n++;
     }
     String results = "";
     for (int i = 0; i < wordList.length; i++) {
       results += (engToPig(wordList[i]) + "\n");
     }
     System.out.println(results);
*/

     for( String word : args ) {
       System.out.println( "allVowels \t" + allVowels(word) );
       System.out.println( "firstVowels \t" + firstVowel(word) );
       System.out.println( "countVowels \t" + countVowels(word) );
       System.out.println( "engToPig \t" + engToPig(word) );
       System.out.println( "---------------------" );
     }

   }//end main()

}//end class Pig
