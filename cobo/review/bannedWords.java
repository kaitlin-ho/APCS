// Soggy Crackers - Courtney, Kaitlin
// APCS pd06

import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

public class bannedWords{
  private static ArrayList<String> badWords = new ArrayList<String>();

  static{
    try {
     Scanner input = new Scanner(new File("badWords.txt"));
     while(input.hasNextLine()){
       badWords.add(input.nextLine().trim());
       System.out.println(badWords);
     }
     input.close();
   }
   catch(Exception e){
     System.out.println("Error reading or parsing badWords.txt");
   }
  }

  /**
   * Returns the ending punctuation of a string, or the empty string if there is none
   */
  public static String getPunctuation( String word )
  {
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }

    /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }

    return word;
  }

  public static String textToString( String fileName )
  {
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));

      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();

    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }

  public static boolean findBadWords(String word)
  {
    boolean test = false;
    for (int x = 0; x < badWords.size(); x++){
      if (word.equals(badWords.get(x)))
      {
        test = true;
      }
    }
    return test;
  }


  // public static String removeNoNoWords( String fileName ){
  //   String returnText = "";
  //   String text = textToString(fileName);
  //   String[] splitString = text.split(" ");
  //   for (int x = 0; x < splitString.length; x++){
  //     if (findBadWords(removePunctuation(splitString[x])) == true){
  //       if (x == splitString.length-1){
  //         splitString[x] = "[REDACTED].";
  //       }
  //       else{
  //         splitString[x] = "[REDACTED]";
  //       }
  //     }
  //
  //     returnText += splitString[x] + " ";
  //   }
  //   return returnText;
  // }

  public static String removeNoNoWords( String fileName ){
    String returnText = "";
    String text = textToString(fileName);
    String[] splitString = text.split(" ");
    for (int x = 0; x < splitString.length; x++){
      if (findBadWords(removePunctuation(splitString[x])) == true){
      while (x==splitString.length-1){
        splitString[x] = "[REDACTED]";
        break;
      }
      splitString[x] = "[REDACTED].";
      }

      returnText += splitString[x] + " ";
    }
    return returnText;
  }

  //   for (String x : splitString){
  //     if (x == badWords.get(x)){
  //       x = "[REDACTED]";
  //     }
  //   }
  //   return splitString;
  //   }
  //
  // }

  public static void main(String[] args){
    System.out.println(removeNoNoWords("testing.txt"));
  }//end main

}//end class
