// BestDuo -- Kaitlin, Brian Li; Duckies: Apple, Robert
// APCS
// HW13 -- Where do BigSibs Come From?
// 2021-10-06

/*
DISCO
 0. When assigning new <ClassName>() to the same variable again, it resets the class instance to its original state. 
 1. A constructor can accept arguments, similar to a method. The arguments can be supplied when initializing an instance of a class within the parentheses.
    
QCC
 0. Why is it necessary for the constructor to be public? And why does it have to be the same name of the class?
*/

public class Greet {
  public static void main( String[] args ) {
    String greeting;

    // Word up freshman
    BigSib richard = new BigSib("Word up");
   
    greeting = richard.greet("freshman");
    System.out.println(greeting);
   
    // Salutations Dr. Spaceman
    richard = new BigSib("Salutations");
   
    greeting = richard.greet("Dr. Spaceman");
    System.out.println(greeting);
   
    // Hey ya King Fooey
    richard = new BigSib("Hey ya");
   
    greeting = richard.greet("King Fooey");
    System.out.println(greeting);
   
    // Sup mom
    richard = new BigSib("Sup");
   
    greeting = richard.greet("mom");
    System.out.println(greeting);

  } //end main()
} //end Greet
