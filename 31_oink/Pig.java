/***
 * Clyde "Thluffy" Sinclair
 * APCS
 * HW31 --
 * 2021-11-04r
 * time spent: _hrs
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

public class Pig
{
  //Q: How does this initialization make your life easier?
  //A: Can be used as a comparison to our values; we don't need to keep writing out the vowels
  private static final String VOWELS = "aeiou";


  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter ) 
  {
    for (int i = 0; i < w.length(); i = i + 1){
      if (w.substring(i,i+1).equals(letter)){
        return true;
      }
    }
    return false;
  }//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter ) 
  {
    return hasA(VOWELS, letter);
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w ) 
  {
    int count = 0;
    for (int i = 0; i < w.length(); i = i + 1){
      if (isAVowel(w.substring(i, i+1)) == true) {
        count += 1;
      }
    }
    return count;
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  //public static boolean hasAVowel( String w ) 
  //{
    /* YOUR IMPLEMENTATION HERE */
  //}


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  //public static String allVowels( String w ) 
  //{
    /* YOUR IMPLEMENTATION HERE */
  //}


 public static void main( String[] args ) 
  {
    /* YOUR TEST CALLS HERE */
    System.out.println(hasA("cat", "a"));
    System.out.println(hasA("cat", "p"));
  }//end main()

}//end class Pig