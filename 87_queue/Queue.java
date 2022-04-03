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

/***
 * interface Queue
 * Includes only methods listed in AP subset of Java
 * (Local version, to override built-in Java implementation.)
 **/

public interface Queue<QUASAR>
{
  //~~~~~~~~~~~~~~~~~~begin AP subset~~~~~~~~~~~~~~~~~~
  //means of removing an element from collection:
  //Dequeues and returns the first element of the queue.
  public QUASAR dequeue();

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( QUASAR x );

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty();

  //Returns the first element of the queue without dequeuing it.
  public QUASAR peekFront();
  //~~~~~~~~~~~~~~~~~~~end AP subset~~~~~~~~~~~~~~~~~~~

}//end interface Queue
