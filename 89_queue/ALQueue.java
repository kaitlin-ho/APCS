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

**/import java.util.ArrayList;
public class ALQueue<QUASAR> implements Queue<QUASAR>{
  private ArrayList<QUASAR> baahah;
  public ALQueue(){
    baahah = new ArrayList<QUASAR>();
  }//means of removing an element from collection:
  //Dequeues and returns the first element of the queue.
  public QUASAR dequeue(){
    return baahah.remove(0);
  }
  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( QUASAR x ){
    baahah.add(x);
  }
  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty(){
    return baahah.isEmpty();
  }
  //Returns the first element of the queue without dequeuing it.
  public QUASAR peekFront(){
    return baahah.get(0);
  }
  public static void main(String[] args) {

  }
}
