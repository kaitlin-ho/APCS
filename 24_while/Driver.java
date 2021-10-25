/***
    driver for class Coin
    ~~~ SUGGESTED WORKFLOW: ~~~
    1. Compile this file and run. Note anything notable.
    2. Move the "TOP" line down, so that it is below the first statement.
    (emacs: with cursor at beginning of TOP line, C-k C-k, DOWN, DOWN, C-y)
    (your editor: ???)
    3. Compile and run again.
    4. Resolve errors one at a time until it works.
    5. Repeat 2-4 until TOP meets BOTTOM.
***/

public class Driver {

  public static void counter(int x, int y, Coin person1, Coin person2) {
        int matches = 0
  	while ((person1.headsCtr + person2.headsCtr) < x) && (matches < y) && (matches < 65536) && (!(matches % 2005 == 0))) {
  		person1.flip();
  		person2.flip();
  		if person1.equals(person2) { matches += 1; } 
  		else { matches = matches; }
  	}
  	System.out.println(person1);
  	System.out.println(person2);
  	System.out.println(matches);
  	
  }
  
  public static void main( String[] args ) {
  	coin person1 = new Coin("quarter");
  	coin person2 = new Coin("dime");
 
  
  
    /*===================TOP==========================
    //build Objects from blueprint specified by class Coin


    //test default constructor
      Coin mine = new Coin();
      //test 1st overloaded constructor
      Coin yours = new Coin( "quarter" );
      //test 2nd overloaded constructor
      Coin wayne = new Coin( "dollar", "heads" );
      //test toString() methods of each Coin
      System.out.println("mine: " + mine);
      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);
      //test flip() method
      System.out.println("\nAfter flipping...");
      yours.flip();
      wayne.flip();
      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);
      //test equals() method
      if ( yours.equals(wayne) ) {
        System.out.println( "Matchee matchee!" );
      }
      else {
        System.out.println( "No match. Firestarter you can not be." );
      }

     ====================BOTTOM======================*/

  }//end main()

}//end class
