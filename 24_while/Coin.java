/*
oops: Ariella Katz, Kaitlin Ho, Tom, Apple
APCS
HW24 -- Get It While You Can
2021-10-25
time spent: 1.1 hours
*/

/*
DISCO:
0. System.out.println(objectName) automatically call's Java's toString, at which point Java 
   looks for a toString method and sees that we have an overriden one... and uses that instead
   (see QCC).
QCC:
0. How can we make it so that creating a new objecting and printing that object doesn't 
   automatically call our overridden toString?
1. Why is it that Java uses our overriden toString and not Java's toString, since they both 
   have the same parameter lists?
*/

public class Coin {

  //attributes aka instance vars
  public double value;
  public String upFace;
  public String name;
  public int flipCtr;
  public int headsCtr;
  public int tailsCtr;
  public double bias = 0.50; //didn't know where else to set this


  /***
   *  Coin() -- default constuctor
   *  precond:
   *  postcond:
   ***/
  public Coin() {
    reset("heads", 0.5);
  }


  /***
      Coin(String) -- overloaded constructor
      precond: input is one of
      "penny",
      "nickel",
      "dime",
      "quarter",
      "half dollar",
      "dollar"
      postcond:
  ***/
  public Coin( String s ) {
    this();
    name = s;
  }


  /***
      Coin(String,String) -- *see comments below (added param)
      precond:
      postcond:
  ***/
  public Coin( String s, String nowFace ) {
    this(s);
    name = s;
    upFace = nowFace;
  }


  // Accessors...
  // ----------------------------
  public String getUpFace() {
    return upFace;
  }

  public int getFlipCtr() {
    return flipCtr;
  }

  public double getValue() {
    return value;
  }

  public int getHeadsCtr() {
    return headsCtr;
  }

  public int getTailsCtr() {
    return tailsCtr;
  }
  // ----------------------------


  /***
   * assignValue() -- set a Coin's monetary value based on its name
   * precond:  input String is a valid coin name ("penny", "nickel", etc.)
   * postcond: instvar value gets appropriate value
   * Returns value assigned.
   ***/
  private double assignValue( String s ) {
    if (name == "penny"){
	value = 0.01;
	}
    if (name == "nickel"){
	value = 0.05;
	}
    if (name == "dime"){
    	value = 0.10;
    	}
    if (name == "quarter"){
    	value = 0.25;
    	}
    if (name == "half dollar"){
	value = 0.50;
	}
    if (name == "dollar"){
	value = 1.00;
	}
    return value;
  }


  /***
      reset() -- initialize a Coin
      precond:  s is "heads" or "tails", 0.0 <= d <= 1.0
      postcond: Coin's attribs reset to starting vals
  ***/
  public void reset( String s, double d ) {
    flipCtr = 0;
    tailsCtr = 0;
    headsCtr = 0;
    upFace = s;
    bias = d; //is d for bias? the value can't be 0, so we're assuming so
  }


  /***
   * String flip() -- simulates a Coin flip
   * precond:  bias is a double on interval [0.0,1.0]
   * (1.0 indicates always heads, 0.0 always tails)
   * postcond: upFace updated to reflect result of flip.
   * flipCtr incremented by 1.
   * Either headsCtr or tailsCtr incremented by 1, as approp.
   * Returns "heads" or "tails"
   ***/
  public String flip() {
    double ht = Math.random();
    if (ht < bias) {
      flipCtr = flipCtr + 1;
      headsCtr = headsCtr + 1;
      upFace = "heads";
      return upFace;
    }
    else {
      flipCtr = flipCtr + 1;
      tailsCtr = tailsCtr + 1;
      upFace = "tails";
      return upFace;
    }
  }


  /***
   * boolean equals(Coin) -- checks to see if 2 coins have same face up
   * precond: other is not null
   * postcond: Returns true if both coins showing heads
   * or both showing tails. False otherwise.
   ***/
  public boolean equals( Coin other ) {
    return (upFace == other.upFace);
  }


  /***
   * String toString() -- overrides toString() provided by Java
   * precond: n/a
   * postcond: Return String comprised of name and current face
   ***/
  public String toString() {
    return name + " -- " +  upFace; 
  }

}//end class
