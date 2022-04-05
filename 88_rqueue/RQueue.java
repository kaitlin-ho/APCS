/***
Mr.K: May Qiu, Raven (Ruiwen) Tang, Kaitlin HHo
APCS
HW88 --BPC Kiddies Do Not Wait in Line Either
2022-04-04
time spent: 1hr

QCC
Is there a way to use only one temp pointer instead of two in sample?

DISCO
When we shuffle, we do not need to shuffle all the nodes. We only have to pick a random node to put in the front because we only need the front anyways.
We needed to be careful when there is only one node left in the queue, because we no longer need sample in that case.

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
    _front = null;
    _end = null;
    _size = 0;
  }


  public void enqueue( SWASHBUCKLE enQVal )
  {
    //special case: when enqueuing to an empty list,
  //make _front && _end point to same node
  if ( isEmpty() ) {
    _front = _end = new LLNode<SWASHBUCKLE>( enQVal, null );
  }
  else {
    _end.setNext( new LLNode<SWASHBUCKLE>( enQVal, null ) );
    _end = _end.getNext();
  }
  _size++;
  System.out.println("enqueued " + enQVal);
}//O(1)


  // remove and return thing at front of queue
  // assume _queue ! empty
  public SWASHBUCKLE dequeue()
  {
    if(_size == 1){
      return _front.getCargo();
    }
    SWASHBUCKLE retVal = peekFront();
    _front = _front.getNext();

    if ( _front == null ) //just moved past last node
      _end = null;      //update _end to reflect emptiness

    _size--;

    return retVal;
  }//O(n)


   public SWASHBUCKLE peekFront()
   {
     sample();
     return _front.getCargo();
   }//O(n)


  /***
   * void sample() -- a means of "shuffling" the queue
   * Algo:
      We used a for loop to traverse to a random node and set temp to this node. We then set a new pointer to the node right of temp.
      Then, we set temp's next node to the node 2 after it. Temp2 is then pointed to front. Front is finally set to temp2. 
   *
   **/
  public void sample ()
  {
    LLNode<SWASHBUCKLE> temp = _front;
    for(int i = 0; i < (Math.random() * (_size-2)); i++){
      temp = temp.getNext();
    }
    LLNode<SWASHBUCKLE> temp2 = temp.getNext();
    temp.setNext(temp.getNext().getNext());
    temp2.setNext(_front);
    _front = temp2;
  }//O(n)


  public boolean isEmpty()
  {
    return _front == null;
  } //O(1)


  // print each node, separated by spaces
  public String toString(){
    String ans = "";
    LLNode<SWASHBUCKLE> temp = _front;
    for(int i = 0; i < _size; i++){
      ans += temp.getCargo() + " ";
      temp = temp.getNext();
    }
    return ans;
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {



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


  }//end main
}//end class RQueue
