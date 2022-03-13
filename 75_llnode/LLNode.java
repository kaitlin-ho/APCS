/*
Mr.K (Raven, Kaitlin, May )
APCS
HW75 -- Nodal Recall/Linked Lists/Implements a node, for use in lists and other container classes.
2022-03-12
time spent: 1 hr
 **/
import java.util.ArrayList;
public class LLNode
{
  //instance vars
  private String _value;
  private LLNode _next;

  // constructor
  public LLNode( String value, LLNode next )
  {
    _value = value;
    _next = next;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return _value;
  }

  public LLNode getNext()
  {
    return _next;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    String temp = _value;
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


  // override inherited toString
  public String toString()
  {
    return _value;
  }

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

    /* A naive list traversal, has side effects.... ?? */
       // while( first != null ) {
       // System.out.println( first );
       // first = first.getNext();
       // }
       ArrayList<String> APPLESARENASTY = new ArrayList<String>();
       while( first != null ) {
       System.out.println( first );
       APPLESARENASTY.add(first.getCargo());
       first = first.getNext();
       }
      for(String i:APPLESARENASTY){
        System.out.println(i);
      }
    //Q: when head ptr moves to next node in list, what happens to the node it just left?

    // The node can't be returned to.

  }//end main

}//end class LLNode
