/** 
Mr. K: May Qiu, Raven (Ruiwen) Tang, Kaitlin Ho
APCS pd6
HW84: Stack: What Is It Good For? / using Stack to flip string, match parens
2022-03-29
time spent: 00.5 hrs
*/
/**
 * DISCO
 * It's important to check if a stack is empty before you attempt to pop, because you don't want to end up with an exception or a null return value.
 * 
 * QCC
 * One tip that was given to us was that implementing peek() could be helpful. However, we were able to perform the tasks without peek(). Instead, we checked if the stack was empty first and then stored the value of pop() in a String. If the next character was valid, we could just continue with the for loop since we had already popped the corresponding open parentheses off. If the next character was not valid, we were able to compare the popped off value since we had stored it.
 * After the for loop in allMatched(), it's necessary  to check if the stack is empty, because we need to make sure there aren't any unmatched open parentheses.
 * Is there an easier, Java syntactic sugar way to more simply write: cur.equals("(") || cur.equals("{") || cur.equals("[") ?
 * /

/***
 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
 **/

public class LatKtS
{

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **/
  public static String flip( String s )
  {
    Latkes str = new Latkes(s.length());
    for(int i = 0; i < s.length(); i++){
      str.push(s.substring(i,i+1));
    }
    String ret = "";
    while(str.isEmpty() == false){
      ret += str.pop();
    }
    return ret;
  }


  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **/
  public static boolean allMatched( String s )
  {
   Latkes parens = new Latkes(s.length());
    for(int i = 0; i < s.length(); i++){
      String cur = s.substring(i,i+1);
      if(cur.equals("(") || cur.equals("{") || cur.equals("[")){ 
        parens.push(cur);
      }
      else if(parens.isEmpty()){
        return false;
      }
      else{
        String top = parens.pop();
        if(top.equals("(") && !cur.equals(")")){
          return false;
        }
        if(top.equals("{") && !cur.equals("}")){
          return false;
        }
        if(top.equals("[") && !cur.equals("]")){
          return false;
        }
      }
    }
    if(parens.isEmpty()){
      return true;
    }
    return false;
  }


  //main method to test
  public static void main( String[] args )
  {
    
    System.out.println(flip("stressed")); //desserts
    System.out.println(flip("book")); //koob
    System.out.println(flip("Mr. K")); //K .rM
    System.out.println(flip("12345")); //54321
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    System.out.println(allMatched( "" ) ); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class
