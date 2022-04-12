/***
 * interface Queue
 * Includes only methods listed in AP subset of Java
 * (Local version, to override built-in Java implementation.)
 **/
/**Mr.K (May, Raven, Kaitlin)
APCS
HW89 -- Queue Two Ways
2022-04-11
time spent: 1 hr

DISCO
* On the API, we noticed that it actually explicitly says that operations in the List interface "allow linked lists to be used as a stack, queue, or double-eneded queue (deque)."
* We also read on the API that all Linked List operations perform as could be expected for a doubly linked list. If an index needs to be accessed, it will be traversed to from the beginning or the end, whichever is closer.

QCC
* On the assignments page, it states that ALQueue and LLQueue should be wrapper classes for ArrayList and LinkedList. We think this wrapper class idea is connected to how we "pass through" methods, but we're not sure if we did it completely correctly.

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
