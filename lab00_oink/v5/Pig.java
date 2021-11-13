/***
 * The Greyducks: Ariella Katz, Kaitlin Ho, Hugo Jenkins, Tom, Apple, Boary
 * APCS
 * L00 -- Etterbay Odincay Oughthray Ollaborationcay
 * 2021-11-09
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
X Debug Thluffy’s Pig.java
X Adding methods and instance variables supplied
Multiple consonants at the beginning of the word
X Capitalization
X Punctuation (at the end)
Apostrophes (Or punctuation in the middle of words))
Numbers
Words with no vowels
Improve readability (with more methods so nothing is too crowded)
*/

/*
DISCO:
0. next() considers any blank space (line breaks or spaces) to divide tokens.
QCC:
0. Is it built into nextLine() to not move the cursor to the next line if there isn't
   one?
HOW WE UTILIZED SCANNER DEMO (v4):
Used the while loop and creation of a new scanner, sc, but used nextLine() instead of next().
WHAT CAUSES THE RUNTIME ERROR IN THE SCANNER DEMO:
next() is called twice, so once the loop gets to the last token, it still runs because the code
does have one more line, but the second next() is called for another token, which Java looks for
in the next next line (since there is a line break), and there isn't actually another line, so 
there is an error.
Make it work for phrases, not just words
*/


import java.util.Scanner;  //Scanner is not part of java's std lib

public class Pig
{

  //Q: How does this initialization make your life easier?
  //A: We can use VOWELS in any method without creating a local variable whenever we need it.
  private static final String VOWELS = "aeiouyAEIOUY";
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
//If the word starts with a vowel, append -way to the end
    if ( beginsWithVowel(w) ) { 
//If the word starts with a vowel and the last character is a punctuation, append the punctuation
//to the end of the translated word
      if (isPunc(w.substring(w.length()-1))) { 
        ans = w.substring(0,w.length()-1) + "way" + w.substring(w.length()-1);
      }
//If the word doesn't end with a punctuation and it starts with a vowel, just add -way
      else {ans = w + "way";} 
    }
//It doesn't matter if the first letter is uppercase because it starts with a vowel so no
//letters are being moved to the end.

//If the word doesn't start with a vowel...
    else {
      int vPos = w.indexOf( firstVowel(w) );
//...and it begins with an uppercase letter...
      if (beginsWithUpper(w)) {
//...and the last character is a punctuation, make everything lowercase, move all the consonants
//up to the first vowel to the end of the word, make the first letter uppercase, append -way to
//the end of the word, and append the punctuation mark to the end of that
        if (!hasPunc(w)) {
          ans = (w.substring(vPos, vPos+1)).toUpperCase() + w.substring(vPos+1)
          + (w.substring(0,vPos)).toLowerCase() + "ay";
        }
//...and the last character isn't a punctuation, do all of that but without the punctuation stuff
        else {ans = (w.substring(vPos, vPos+1)).toUpperCase() + w.substring(vPos+1,w.length()-1)
              + (w.substring(0,vPos)).toLowerCase() + "ay" + w.substring(w.length()-1);}
      }
//...and it doesn't begin with an uppercase letter...
      else {
//...and the last character is a punctuation, make move all the consonants up to the first vowel
//to the end of the word, appen -way to the end of the word, and append the punctuation mark to
//the end of that
        if (!hasPunc(w)) { 
          ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
        }
//...and the last character isn't a punctuation, do all of that but without the punctuation stuff
        else {ans = w.substring(vPos,w.length()-1) + w.substring(0,vPos) + "ay" + 
              w.substring(w.length()-1);}
    }
    }
    return ans;
  }

   public static String phraseToPig (String phrase) {
      String ans = "";
      int i = 0;
      int len = phrase.length();
       while (i < len) {
        if (phrase.indexOf(" ") != -1) {
          int n = phrase.indexOf(" ");
          ans += engToPig(phrase.substring(0,n)) + " ";
          phrase = phrase.substring(n+1);
          i = n+1; }
        else {
          ans += engToPig(phrase);
          i = len;
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

//instantiate a Scanner with STDIN as its bytestream
    Scanner sc = new Scanner( System.in );

    while( sc.hasNext() ) {
      System.out.println(phraseToPig(sc.nextLine()));
      }

     for( String word : args ) {
       System.out.println( "allVowels \t" + allVowels(word) );
       System.out.println( "firstVowels \t" + firstVowel(word) );
       System.out.println( "countVowels \t" + countVowels(word) );
       System.out.println( "engToPig \t" + engToPig(word) );
       System.out.println( "---------------------" );
     }

   }//end main()

}//end class Pig
