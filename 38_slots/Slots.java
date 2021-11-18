/*****************************************************
 * TNPG: Four {Fang Chen, Kaitlin Ho, Jing yi Feng}
 * APCS pd06
 * HW38 -- Shmoney
 * 2021-11-18
 * time spent: 0.7 hr
 *****************************************************/

/*
  DISCO
  00: If you declare a non-static object inside the default constructor with the 
      same name as a non-static object declared above the default constructor, it will 
      create a new object and the original object will be given the value null. So when 
      you try to call the object in any non-static method, the terminal will return a
      NullPointerException.
  01: By using Math.floor() with Math.random() as in Math.floor(Math.random() * int a),
      you are returned a double value between [0, a).
  QCC
  00: Is there another way to swap elements in an array without first storing the value
      in a separate variable?
  01: Why is it in any way significant to allocate memory for _fruits (simply setting
      _fruits to FRUITS without allocating memory doesn't seem to return any errors)?
*/

public class Slots {

  //instance variable to represent master copy for slot machine
  private static final String[] FRUITS = {
    "lime", "lime", "lime",
    "lemon", "lemon", "lemon",
    "cherry", "cherry", "cherry",
    "orange", "orange", "orange",
    "apple", "apple", "apple",
    "peach", "peach", "peach",
    "tomato", "tomato", "tomato"
  };

  private String[] _fruits; //to be init'd by each instance


  /*=====================================
    Slots() -- default constructor
    pre:  constant array FRUITS exists, has been initialized
    post: mutable array _fruits contains same elements as FRUITS
    =====================================*/
  public Slots()
  {
    //allocate memory for _fruits based on size of FRUITS:
    _fruits = new String[FRUITS.length];

    //copy elements of FRUITS into _fruits:
    _fruits = FRUITS;
  }


  /*=====================================
    String toString() -- overrides inherited toString()
    pre:
    post: returns String of elements in slots 0 thru 2, separated by tabs
    =====================================*/
  public String toString()
  {
    String fruits = "";
    fruits += _fruits[0] + "\t"; 
    fruits += _fruits[1] + "\t";
    fruits += _fruits[2];
    return fruits;
  }


  /*=====================================
    void swap(int,int) -- array swap util fxn
    pre:  _fruits array exists
    post: elements at indices i, j are swapped
    =====================================*/
  private void swap( int i, int j )
  {
    String fromI = _fruits[i];
    String fromJ = _fruits[j];
    _fruits[i] = fromJ;
    _fruits[j] = fromI;
  }


  /*=====================================
    void spinOnce() -- simulate a pull of the slot machine lever
    pre:  _fruits array exists
    post: randomized order of elements in _fruits array
    =====================================*/
  public void spinOnce()
  {
    // A simple approach to shuffling:
    // iterate through the array, swapping
    // the val at each index with a randomly chosen other index
    int swapper = -1;
    for(int i = 0; i < _fruits.length; i++) {
      swapper = (int) Math.floor(Math.random() * _fruits.length);
      swap(i, swapper);
    }
  }


  /*=====================================
    boolean jackpot() -- checks for a winning combo
    pre:  _fruits is existing array
    post: returns true if first 3 slots represent winning combo,
    false otherwise
    =====================================*/
  public boolean jackpot()
  {
    boolean retBoo = false;
    if (_fruits[0].equals(_fruits[1]) && _fruits[1].equals(_fruits[2])) {
      retBoo = true;
    }
    return retBoo;
  }


  /*=====================================
    boolean miniWin() -- checks for a winning combo
    pre:  _fruits is existing array
    post: returns true if first 3 slots represent winning combo,
    or if first 3 slots mutually distinct,
    false otherwise
    =====================================*/
  public boolean miniWin()
  {
    boolean retBoo = false;
    boolean endsEqual = _fruits[0].equals(_fruits[2]);
    boolean firstTwoEqual = _fruits[0].equals(_fruits[1]);
    boolean lastTwoEqual = _fruits[1].equals(_fruits[2]);
    if (!(endsEqual || firstTwoEqual || lastTwoEqual)) {
      retBoo = true;
    }
    return retBoo;
  }


  //main() method for testing
  public static void main( String[] args ) {
    //usage: move bar below down 1 line at a time to test functionality...

    Slots machine01 = new Slots();
    Slots machine02 = new Slots();
    //test to verify slot machines function indepently
    System.out.println();
    System.out.println( "Machine01 initial state:\t" + machine01 );
    System.out.println( "Machine02 initial state:\t" + machine02 );
    System.out.println( "\nSpinning machine01...\n" );
    machine01.spinOnce();
    System.out.println();
    System.out.println( "Machine01 state:\t" + machine01 );
    System.out.println( "Machine02 state:\t" + machine02 );
    System.out.println();
    //test gamble-until-you-win mechanism
    System.out.println( "Preparing to spin until a mini win! . . ." );
    System.out.println( "------------------------------------" );
    //if you haven't won, spin again until you win!
    while( machine01.miniWin() == false ) {
      System.out.println( "Your spin..." + "\t" + machine01 );
      System.out.println( "LOSE\n" );
      machine01.spinOnce();
    }
    System.out.println( "====================================" );
    System.out.println( "Your spin..." + "\t" + machine01 );
    System.out.println( "WIN\n" );
    System.out.println( "Preparing to spin until...jackpot! . . ." );
    System.out.println( "------------------------------------" );
    //if you haven't won, spin again until you win!
    while( machine01.jackpot() == false ) {
      System.out.println( "Your spin..." + "\t" + machine01 );
      System.out.println( "LOSE\n" );
      machine01.spinOnce();
    }
    System.out.println( "====================================" );
    System.out.println( "Your spin..." + "\t" + machine01 );
    System.out.println( "JACKPOT!\n" );
  }//end main

}//end class Slots
