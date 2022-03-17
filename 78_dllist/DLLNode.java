import java.util.ArrayList;
public class DLLNode
{
  //instance vars
  private String _value;
  private DLLNode _next;
  private DLLNode _prev;

  // constructor
  public DLLNode( String value, DLLNode next, DLLNode prev)
  {
    _value = value;
    _next = next;
    _prev = prev;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return _value;
  }

  public DLLNode getNext()
  {
    return _next;
  }

  public DLLNode getPrev()
  {
      return _prev;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    String temp = _value;
    _value = newCargo;
    return temp;
  }

  public DLLNode setNext( DLLNode newNext )
  {
    DLLNode temp = _next;
    _next = newNext;
    return temp;
  }

  public DLLNode setPrev( DLLNode newPrev)
  {
      DLLNode temp = _prev;
      _prev = newPrev;
      return temp;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    return _value;
  }

  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...
    DLLNode test = new DLLNode("ice cream",null, null);
    test.setNext( new DLLNode ("Oreos", null, null));
    test.setCargo("Strawberries");
    /* A naive list traversal, has side effects.... ?? */
       while( test != null ) {
       System.out.println( test );
       test = test.getNext();
       }

    //Create a node
    DLLNode first = new DLLNode( "cat", null, null);

    //Create a new node after the first
    first.setNext( new DLLNode( "dog", null, first) );

    //Create a third node after the second
    first.getNext().setNext( new DLLNode( "cow", null, first.getNext() ) );

  }//end main

}//end class DLLNode
