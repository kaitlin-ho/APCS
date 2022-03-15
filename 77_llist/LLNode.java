
/**
 * Mr. K: May Qiu, Kaitlin Ho, Raven (Ruiwen) Tang
 * APCS pd06
 * HW76 -- We Got a Little Ol' Convoy / LList implementation
 * 2022-03-14
 * time spent: 1.0 hr
 * KtS consumed: 2
 *
 * DISCO
 * Since LList implements the interface List, every method in the List interface has to be uncommented in LList. So instead of commenting out incomplete methods like we usually do, we can get around this by returning fake values to allow the methods to compile.
 * One can't set the cargo of a null node. So, when we're traversing, we need to check if temp.getNext() is null instead of if temp is null.
 * A lot of methods that are O(1) for arrays and ArrayLists, like set(), get(), size(), and add() [in many cases], take O(n) time for LinkedLists, because you're doing getNext() until you hit the end of the list or the desired index.
 *
 * QCC
 * We are still a bit confused about using temp as a pointer. When we set the next node of temp, we are able to also set the last node of the list beginning with _head, but we're still unsure of how this actually works. We also haven't really seen this with other variables and objects.
 * When you work on a new class, it's important to finish toString() before working on other methods, because it allows you to test if your other methods are correct.
 * You can traverse a LinkedList by a while loop that checks if nodes are null OR a for loop that counts elements until the size of the list is hit.
 * What is the benefit of using a LinkedList, especially because a lot of methods take longer runtime than ArrayLists.
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

  }//end main

}//end class LLNode
