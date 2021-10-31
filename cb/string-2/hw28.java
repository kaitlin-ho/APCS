public class hw28 {

//Given a string, return a string where for every char in the original, there are two chars.
  public static String doubleChar(String str) {
    String result = "";  // String result; does not seem to work "variable not intialized"
    for (int index = 0; index < str.length(); index ++){
      result = result + str.substring(index, index + 1) + str.substring(index, index + 1);
    }
    return result;
  }

//Return the number of times that the string "hi" appears anywhere in the given string.
  public static int countHi(String str) {
    int result = 0;
    for (int i = 0; i < str.length() - 1; i++){
      if (str.substring(i, i + 2).equals("hi")){
        result = result + 1;
      }
    }
    return result;
  }

//Return true if the string "cat" and "dog" appear the same number of times in the given string.
  public static boolean catDog(String str) {
  int catCount = 0;
  int dogCount = 0;
  for (int i = 0; i < str.length() - 2; i++){
    if (str.substring(i, i+3).equals("cat")){
      catCount += 1;
    }
    else if (str.substring(i, i+3).equals("dog")){
      dogCount += 1;
    }
  }
  return catCount == dogCount;
}

//Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.
  public static int countCode(String str) {
    int counter = 0;
    for (int i = 0; i < str.length() - 3; i++){
      if ((str.substring(i, i + 2).equals("co") && (str.substring(i + 3, i + 4).equals("e")))){
        counter += 1;
      }
    }
    return counter;
  }

//Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences (in other words, the computation should not be "case sensitive").
  public static boolean endOther(String a, String b) {
    String lowercaseVerA = a.toLowerCase();
    String lowercaseVerB = b.toLowerCase();
    int aL = a.length();
    int bL = b.length();
    if (aL >= bL){
      return (lowercaseVerA.substring(aL-bL).equals(lowercaseVerB));
      // if aL = bL, the difference will be 0 so the substring would be the orignal string
    }
    else if (bL > aL){
      return (lowercaseVerB.substring(bL-aL).equals(lowercaseVerA));
    }
    return false;
  }

//Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.
  public static boolean xyzThere(String str) {
    //if xyz comes first
    if ((str.length() > 2) && (str.substring(0,3).equals("xyz"))){
      return true;
    }

    int counter = 0; //using a counter instead of directly returning T/F b/c that didn't seem to work
    // if there isn't "." and there is "xyz" add to the counter
    //this accounts for cases where there is ".xyzxyz" b/c we aren't just stopping once we see ONE .xyz
    for (int i = 0; i < str.length() - 3; i++){
      //!().equals()
      if ((!(str.substring(i, i+1).equals("."))) && (str.substring(i+1, i+4).equals("xyz"))){
        counter += 1;
      }
    }
    return counter > 0;
  }

  public static void main(String[] args) {
    System.out.println(doubleChar("The"));
    System.out.println(doubleChar("AAbb"));
    System.out.println(doubleChar("Hi-There"));

    System.out.println(countHi("abc hi ho"));
    System.out.println(countHi("ABChi hi"));
    System.out.println(countHi("hihi"));

    System.out.println(catDog("catdog"));
    System.out.println(catDog("catcat"));
    System.out.println(catDog("1cat1cadodog"));

    System.out.println(countCode("aaacodebbb"));
    System.out.println(countCode("codexxcode"));
    System.out.println(countCode("cozexxcope"));

    System.out.println(endOther("Hiabc", "abc"));
    System.out.println(endOther("AbC", "HiaBc"));
    System.out.println(endOther("abc", "abXabc"));

    System.out.println(xyzThere("abcxyz"));
    System.out.println(xyzThere("abc.xyz"));
    System.out.println(xyzThere("xyz.abc"));
  }
}
