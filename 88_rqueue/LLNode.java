/** 
Mr. K: May Qiu, Raven (Ruiwen) Tang, Kaitlin Ho
APCS pd6
HW87: The English Do Not Wait In Line for Soup / node-based queue 
2022-04-03
time spent: 0.7 hrs
**/

/**
DISCO:
* We had a discussion on if the instance variable in NodeQueue should keep track of the front or end of the queue. We realized that either way, dequeue() or enqueue() would be O(n), and the other would be O(1). However, peekFront() would only be O(1) if the instance variable kept track of the front of the queue, so that's why we decided to go with the front.
QCC:
* We ran into the same problem that we ran into with generic typing of MyIterator. We realized that we were trying to use a default constructor for LLNode, when the class only has an overloaded constructor.
* For classes like Stack and Queue, does it even make sense to have a toString() method? Does having a toString() method defeat the purpose of only being able to view a certain end of the list? We noticed that toString() was not in the Queue interface.
* We discovered that quasar stands for "quasi-stellar radio source."
**/

import java.util.ArrayList;
public class LLNode<QUASAR>
{
  //instance vars
  private QUASAR _value;
  private LLNode _next;

  // constructor
  public LLNode( QUASAR value, LLNode<QUASAR> next )
  {
    _value = value;
    _next = next;
  }


  //--------------v  ACCESSORS  v--------------
  public QUASAR getCargo()
  {
    return _value;
  }

  public LLNode getNext()
  {
    return _next;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public QUASAR setCargo( QUASAR newCargo )
  {
    QUASAR temp = _value;
    _value = newCargo;
    return temp;
  }

  public LLNode setNext( LLNode newNext )
  {
    LLNode temp = _next;
    _next = newNext;
    return temp;
  }
  //--------------^  MUTATORS  ^--------------



  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...
    LLNode test = new LLNode("ice cream",null);
    test.setNext( new LLNode ("Oreos", null));
    test.setCargo("Strawberries");
    /* A naive list traversal, has side effects.... ?? */
       while( test != null ) {
       System.out.println( test );
       test = test.getNext();
       }

    //Create a node
    LLNode first = new LLNode( "cat", null );

    //Create a new node after the first
    first.setNext( new LLNode( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new LLNode( "cow", null ) );

  }//end main

}//end class LLNode