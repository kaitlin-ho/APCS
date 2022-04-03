/**
Mr. K: May Qiu, Raven (Ruiwen) Tang, Kaitlin Ho
APCS pd6
HW86 -- What a Racket / Scheme arithmetic interpreter
2022-03-31
time spent: 0.7 hrs
**/

/**
DISCO
- Integer.parseInt() was extremely helpful for converting Strings into numbers.
- It's not valid to assume that operations will each only have two operands. Therefore, it was important for us to keep this in mind when coding and planning. We couldn't just pop off two numbers. Instead, popping them into a Stack allowed us to take care of all the operands.

QCC
- For "\\s" in REGEX, the slashes are BACKSLASHES, not FORWARD SLASHES. Also, if you give split() an argument that is not in the String, the entire String is placed as the first element of the array, which makes sense.
- We used the fact that intVar+"" (attempting to concatenate "" with an integer) will make intVar a String. We confirmed that trying to typecast a String with (int) is invalid. Are there any other ways to change an integer into a String?
- We were also thinking of using an ArrayList to store the numbers that you want to perform an operation with. We think doing this procedure would be very similar to unload(), and you would just have to pop the numbers off of the storage Stack.

**/
/***
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. For each operator, parens, and operand in the expression:
 *   2. If it is an operator, operand, or open paren, push it onto a storage stack.
 *   3a. Otherwise, pop and push all numbers from the top of the storage stack into a numbers stack.
 *   3b. Peek the next element of the stack to determine which operation you will be performing. Pop all the numbers off of the numbers stack, performing the operation as you go.
 *   3c. Pop off the operator and open paren from the top of the storage stack. Repeat steps 2-3 until you have gone through every operator, parens, and operand in the expression.
 *   4. Return the remaining element in the storage stack.
 *
 * STACK OF CHOICE: ALStack by library code
 * b/c we are able to understand how it works and were therefore prepared to troubleshoot if any issues came up with ALStack. For example, we received a compile-time error because we forgot to add the Stack interface file, but we were able to recognize and resolve this problem.
 **/

public class Scheme
{
  /***
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and 
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   **/
  public static String evaluate( String expr )
  {
    String[] separated = expr.split("\\s");
    ALStack<String> storage = new ALStack<String>();
    ALStack<String> numbers = new ALStack<String>();
    for(int i = 0; i < separated.length; i++){
      if(separated[i].equals(")")){
        while(isNumber(storage.peekTop())){
          numbers.push(storage.pop());
        }
        String result = "";
        if(storage.peekTop().equals("+")){
          result = unload(1, numbers);
        }
        else if(storage.peekTop().equals("-")){
          result = unload(2, numbers);
        }
        else{
          result = unload(3, numbers);
        }
        storage.pop();
        storage.pop();
        storage.push(result);
      }
      else{
        storage.push(separated[i]);
      }
    }
    return storage.peekTop();
  }//end evaluate()


  /***
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   **/
  public static String unload( int op, ALStack<String> numbers )
  {
    int result = 0;
    if(op == 1){
      result = 0;
      while(isNumber(numbers.peekTop())){
        result += Integer.parseInt(numbers.pop());
      }
    }
    else if(op == 2){
      result = Integer.parseInt(numbers.pop());
      while(isNumber(numbers.peekTop())){
        result -= Integer.parseInt(numbers.pop());
      }
    }
    else{
      result = 1;
      while(isNumber(numbers.peekTop())){
        result *= Integer.parseInt(numbers.pop());
      }
    }
    return result+"";
  }//end unload()



  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
  }
  catch( NumberFormatException e ) {
  return false;
  }
  }


  //main method for testing
  public static void main( String[] args )
  {


      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4

      String zoo5 = "( ( + ( * 5 8 ) ( - 4 2 ) 2 ) )";
      System.out.println(zoo5);
      System.out.println("zoo5 eval'd: " + evaluate(zoo5) );
      // ...44
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main()

}//end class Scheme
