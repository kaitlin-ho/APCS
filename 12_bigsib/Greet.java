/*
Kaitlin Ho, Brian Li; Duckies: Apple, Robert
APCS
HW12 - On Elder Individuality and the Elimiation of Radio Fuzz
2021-10-05

DISCO
- When we create variable richard of type BigSib, richard is able to use all of the methods associated with the class BigSib, such as setHelloMsg and greet, in the form variableName/className.method().
- A static method is unable to reference instance variables. That is, the method is incapable of referencing variables outside of its own class. To remedy this, remove static from the class construction.

QCC
- When creating a variable of a class type, what happens if you put something within the parentheses of the class (e.g. BigSib richard = new BigSib();)? What does that affect?
- What's the point of `BigSib richard = new BigSib()`? 

*/


public class Greet {
  public static void main( String[] args ) {
    String greeting;

    BigSib richard = new BigSib();
    richard.setHelloMsg("Word up");

    greeting = richard.greet("freshman");
    System.out.println(greeting);

  } //end main()
} //end Greet
