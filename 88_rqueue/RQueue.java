/***
 * class RQueue
 * SKELETON
 * A node-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 **/


public class RQueue<SWASHBUCKLE> implements Queue<SWASHBUCKLE>
{
  //instance variables
  private LLNode<SWASHBUCKLE> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
  {

  }


  public void enqueue( SWASHBUCKLE enQVal )
  {

  }//O(?)


  // remove and return thing at front of queue
  // assume _queue ! empty
  public SWASHBUCKLE dequeue()
  {

  }//O(?)


  public SWASHBUCKLE peekFront()
  {
    return _front.getCargo();
  }//O(?)


  /***
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   *   < YOUR SUCCINCT SUMMARY HERE >
   **/
  public void sample ()
  {

  }//O(?)


  public boolean isEmpty()
  {
    return _front == null;
  } //O(?)


  // print each node, separated by spaces
  public String toString()
  {
    String foo = "";
    LLNode<SWASHBUCKLE> tmp = _front;
    while ( tmp != null ) {
      foo += tmp.getCargo() + " ";
      tmp = tmp.getNext();
    }
    return foo;
  }//end toString()

  /***
   * class LLNode
   * Implements a node, for use in lists and other container classes.
   * Stores its data as a T
   **/
  public class LLNode<SWASHBUCKLE>
  {
    //instance varst
    private SWASHBUCKLE _cargo;    //cargo may only be of type T
    private LLNode<SWASHBUCKLE> _nextNode; //pointer to next LLNode<T>

    // constructor -- initializes instance vars
    public LLNode( SWASHBUCKLE value, LLNode<SWASHBUCKLE> next ) {
      _cargo = value;
      _nextNode = next;
    }


    //--------------v  ACCESSORS  v--------------
    public SWASHBUCKLE getCargo() { return _cargo; }

    public LLNode<SWASHBUCKLE> getNext() { return _nextNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public SWASHBUCKLE setCargo( SWASHBUCKLE newCargo ) {
      SWASHBUCKLE foo = getCargo();
      _cargo = newCargo;
      return foo;
    }

    public LLNode<SWASHBUCKLE> setNext( LLNode<SWASHBUCKLE> newNext ) {
      LLNode<SWASHBUCKLE> foo = getNext();
      _nextNode = newNext;
      return foo;
    }
  }

  //main method for testing
  public static void main( String[] args )
  {

    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

    Queue<String> PirateQueue = new RQueue<String>();

    System.out.println("\nnow enqueuing...");
    PirateQueue.enqueue("Dread");
    PirateQueue.enqueue("Pirate");
    PirateQueue.enqueue("Roberts");
    PirateQueue.enqueue("Blackbeard");
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");

    System.out.println("\nnow testing toString()...");
    System.out.println( PirateQueue ); //for testing toString()...

    System.out.println("\nnow dequeuing...");
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );

    System.out.println("\nnow dequeuing fr empty queue...\n" +
                       "(expect NPE)\n");
    System.out.println( PirateQueue.dequeue() );

      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
