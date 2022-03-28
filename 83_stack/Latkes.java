/**
Mr. K: May Qiu, Kaitlin Ho, Raven (Ruiwen) Tang
APCS pd6
HW83 -- Stacks on Stacks
2022-03-28
time spent: 0.3 hrs
**/

/***
 * class Latkes
 * v1
 * SKELETON
 * Implements a stack of Strings using an encapsulated array
 **/

/***
    DISCO
    * It's most efficient to consider the left side of the array the top of the stack. So, we push items on, moving from index 0 to the right. This inner mechanism is more efficient than treating the front of the array as the top of the stack, because it's not necessary to shift all the items after every move.

    QCC
    * We noticed that these methods were really similar to ArrayList. Both have an inner array, and both have an instance variable that acts as a "window" that you are allowed to access.

 **/


public class Latkes
{
  private String [] _stack;
  private int _stackSize;


  //constructor
  public Latkes( int initCapacity )
  {
    /* your
       SIMPLE
       SMART
       magicks
       here
    */
    _stack = new String[initCapacity];
    _stackSize = 0;
  }// O(1)


  //means of insertion
  public void push( String s )
  {
    /* your
       SIMPLE
       SMART
       magicks
       here
    */
    if (isFull()){
      String[] storage = new String[_stackSize];
      for(int i = 0; i < _stackSize; i++){
        storage[i] = _stack[i];
      }
      _stack = new String[_stackSize*2];
      for(int i = 0; i < _stackSize; i ++){
        _stack[i] = storage[i];
      }
    }
    _stack[_stackSize] = s;
    _stackSize += 1;
  }// O(n)


  //means of removal
  public String pop( )
  {
    /* your
       SIMPLE
       SMART
       magicks
       here
    */
    if(isEmpty()){
      return "null";
    }
    else{
      String old = _stack[_stackSize-1];
      _stackSize -= 1;
      return old;
    }
  }// O(1)


  //chk for emptiness
  public boolean isEmpty()
  {
    /* your
       SIMPLE
       SMART
       magicks
       here
    */
    return (_stackSize == 0);
  }// O(1)


  //chk for fullness
  public boolean isFull()
  {
    /* your
       SIMPLE
       SMART
       magicks
       here
    */
    return (_stackSize == _stack.length);
  }// O(1)


  //main method for testing
  public static void main( String[] args )
  {

    Latkes tastyStack = new Latkes(10);

    tastyStack.push("aoo");
    tastyStack.push("boo");
    tastyStack.push("coo");
    tastyStack.push("doo");
    tastyStack.push("eoo");
    tastyStack.push("foo");
    tastyStack.push("goo");
    tastyStack.push("hoo");
    tastyStack.push("ioo");
    tastyStack.push("joo");
    tastyStack.push("coocoo");
    tastyStack.push("cachoo");

    //cachoo
    System.out.println( tastyStack.pop() );
    //coocoo
    System.out.println( tastyStack.pop() );
    //joo
    System.out.println( tastyStack.pop() );
    //ioo
    System.out.println( tastyStack.pop() );
    //hoo
    System.out.println( tastyStack.pop() );
    //goo
    System.out.println( tastyStack.pop() );
    //foo
    System.out.println( tastyStack.pop() );
    //eoo
    System.out.println( tastyStack.pop() );
    //doo
    System.out.println( tastyStack.pop() );
    //coo
    System.out.println( tastyStack.pop() );
    //boo
    System.out.println( tastyStack.pop() );
    //aoo
    System.out.println( tastyStack.pop() );
    //stack empty by now; SOP(null)
    System.out.println( tastyStack.pop() );
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main()

}//end class Latkes
