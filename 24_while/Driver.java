/*
oops: Ariella Katz, Kaitlin Ho, Tom, Apple
APCS
HW24 -- Get It While You Can
2021-10-25
time spent: 1.1 hours
*/

/*
DISCO:
0. In a while loop, combining boolean expressions with || ("or") will cause the loop to run
   if at least one expression is true. Using && will cause the loop to run only if all of the
   individual expressions are true.
1. Using =+ instead of += will get past the compiler, but it will cause the code to run for
   an indefintely long amount of time.
QCC:
0. If you don't include "public" or "private" when declaring an instance variable, is it
   automatically public?
*/

/***
    driver for class Coin
***/

public class Driver {

  public static void counter(int x, int y, Coin person1, Coin person2) {
        int matches = 0;
  	while (((person1.headsCtr + person2.headsCtr) < x) || (y > matches)
	|| (matches < 65536) || (!(matches % 2005 == 0))) {
  		person1.flip();
  		person2.flip();
  		if (person1.equals(person2)) { matches += 1; }
  	}
  	System.out.println(person1);
  	System.out.println(person2);
  	System.out.println(matches);
	System.out.println(person1.headsCtr);
	System.out.println(person2.headsCtr);
  }

  public static void main( String[] args ) {
  	Coin person1 = new Coin("quarter");
  	Coin person2 = new Coin("dime");
	counter(10000,10000,person1,person2);

  }//end main()

}//end class
