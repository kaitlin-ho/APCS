/**
MR. K: May Qiu, Kaitlin Ho, Raven (Ruiwen) Tang
APCS pd06
HW80 -- Generically Speaking
2022-03-24
time spent: 1.0 hr

DISCO:
- When updating our list implementation to allow for generic typing, the best first step is to edit the interface first.
- DLLNode should have been replaced with DLLNode<T> everywhere, even if it appears in the parameters.
- T, or <T> is generally accepted for "type"
- Find and replace is scary, make sure to go through each phrase individually; beware of using replace all

QCC:
- Why does our list implementation work with both DLLNode and DLLNode<T> in the constructor? Is there a difference between the two?
 */

/***
 * class DLLNode v1
 * Implements a node, for use in lists and other container classes.
 * Stores a String as cargo.
 **/

public class DLLNode<T>
{
  private T _cargo;
  private DLLNode<T> _nextNode, _prevNode; //pointers to next, prev DLLNodes


  // constructor -- initializes instance vars
  public DLLNode( T value, DLLNode<T> prev, DLLNode<T> next )
  {
    _cargo = value;
    _nextNode = next;
    _prevNode = prev;
  }


  //--------------v  ACCESSORS  v--------------
  public T getCargo() { return _cargo; }

  public DLLNode<T> getNext() { return _nextNode; }

  public DLLNode<T> getPrev() { return _prevNode; }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public T setCargo( T newCargo )
  {
    T foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public DLLNode<T> setNext( DLLNode<T> newNext )
  {
    DLLNode<T> foo = getNext();
    _nextNode = newNext;
    return foo;
  }

  public DLLNode<T> setPrev( DLLNode<T> newPrev )
  {
    DLLNode<T> foo = getPrev();
    _prevNode = newPrev;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString() { return _cargo.toString(); }


  //main method for testing
  public static void main( String[] args )
  {
    //Below is an exercise in creating a linked list...

 /*********************
    //Create a node
    DLLNode first = new DLLNode( "cat", null );

    //Create a new node after the first
    first.setNext( new DLLNode( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new DLLNode( "cow", null ) );

    DLLNode temp = first;
    while( temp != null ) {
      System.out.println( temp );
      temp = temp.getNext();
    }
   ***********************/
  }//end main

}//end class DLLNode
