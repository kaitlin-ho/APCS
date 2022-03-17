/**
 * Mr. K: May Qiu, Kaitlin Ho, Raven (Ruiwen) Tang
 * APCS pd06
 * HW78 -- Double Up
 * 2022-03-16
 * time spent: 1.5 hr
 * KTS used: 1
 * 
 * DISCO
 * Nodes on the ends of the list point to nulls, since they are linked in both directions.
 * Now, since each node has two pointers, we need to be more careful about identifying when a node will be eaten by the garbage collector (BOTH pointers must be deleted). 
 
 * QCC
 * We had trouble adding a tail pointer. Can _head and _tail point to the same node (in the case of a one-element list)?
  
 * We are getting the following runtime error: 
 * Exception in thread "main" java.lang.NullPointerException: Cannot invoke "DLLNode.setPrev(DLLNode)" because the return value of "DLLNode.getNext()" is null
	at LList.remove(LList.java:139)
	at ListTester.main(ListTester.java:83)
  Based on print statements, it seems like this error occurs because the program is attempting to remove something at index _size, which is out of bounds. However, our throw-catch is not catching this exception, and we're not sure how to resolve this.
 
 * Is it worth it to identify when an index of interest is closer to the head or the tail? For example, if you wanted to remove the node at index 98 (in a 100-node list), perhaps you would want to traverse from the tail instead of the head. O(n) runtime processes would be O(n/2) = O(n) with this modification, so we are still unsure about how helpful it would be?
 * ALGO ADD
 * If index is out of bounds, throw IndexOutOfBoundsException.
 * If index is 0, create a new node with desired cargo, pointing to _head next and null prev. Change the head to this new node. Increase size by 1. Return.
 * If _size - index is less than two, create a temp pointing to head. Move temp until it is at index - 1. Set temp's next node to a new node with desired cargo, temp as prev, and null as next. Increase size by 1. Return.
 * Else, create a temp pointing to head. Move temp until it is at index - 1. Set temp's next node to a new node with desired cargo, temp as prev, and temp's next as next. Set temp's next's next's prev to the new node. Increase size by 1. Return.
 * 
 * ALGO REMOVE
 * If index is out of bounds, throw IndexOutOfBoundsException.
 * If index is 0, store the value at head and change the head to the next node. Set head's prev to null. Decrease size by 1. Return stored value.
 * If _size - index is less than two, create a temp pointing to head. Move temp until it is at index - 1. Store temp's next node's value. Set temp's next node to null. Decrease size by 1. Return the stored value.
 * Else, create a temp pointing to head. Move temp until it is at index - 1. Store temp's next node's value. Set temp's next node to the node 2 indices from temp. Set that node's prev to temp. Decrease size by 1. Return the stored value.
 **/

/***
 * class LList
 * Implements a linked list of DLLNodes, each containing String data
 *
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private DLLNode _head;
  private DLLNode _tail;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    // YOUR CODE HERE
    _head = null;
    _tail = null;
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    // YOUR CODE HERE
    DLLNode temp = new DLLNode(newVal, _head, null);
    if(_size > 0){
      _head.setPrev(temp);
    }
    _head = temp;
    if(_size == 0){
      _tail = temp;
    }
    _size += 1;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    // YOUR CODE HERE
    DLLNode temp = _head;
    for(int i = 0; i < index; i++){
        temp = temp.getNext();
    }
    return temp.getCargo();
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    // YOUR CODE HERE
    DLLNode temp = _head;
    for(int i = 0; i < index; i++){
        temp = temp.getNext();
    }
    return temp.setCargo(newVal);
  }


  //return number of nodes in list
  public int size()
  {
    // YOUR CODE HERE
    return _size;
  }

  //remove at index
  public String remove(int index){
    if ( index < 0 || index >= size() ) throw new IndexOutOfBoundsException();
    if(index == 0){
      String ans = _head.getCargo();
      _head = _head.getNext();
      _size -=1;
      if(_size > 0){
        _head.setPrev(null);
      }
      return ans;
  }
    if((_size-index)<2){
      DLLNode temp = _head;
      for(int i = 0; i < index - 1; i++){
          temp = temp.getNext();
          System.out.println(temp);
      }
      String ans = temp.getNext().getCargo();
      temp.setNext(null);
      _size -= 1;
      return ans;
    }
    DLLNode temp = _head;
    for (int i = 0; i < index - 1; i++){
      temp = temp.getNext();
    }
    String ans = temp.getNext().getCargo();
    temp.setNext(temp.getNext().getNext());
    temp.getNext().setPrev(temp);  
    _size -= 1;
    return ans;
  }

  //add at index
  public void add(int index, String newVal){
    if ( index < 0 || index >= size() ) throw new IndexOutOfBoundsException();
    if(index == 0){
      DLLNode temp = new DLLNode(newVal, _head, null);
      _head.setPrev(temp);
      _head = temp;
      _size += 1;
      return;
    }
    if((_size-index)<2){
      DLLNode temp = _head;
      for(int i = 0; i < index - 1; i++){
          temp = temp.getNext();
      }
      temp.setNext(new DLLNode(newVal, null, temp));
      _size += 1;
      return;
    }
    DLLNode temp = _head;
    for (int i = 0; i < index - 1; i++){
      temp = temp.getNext();
    }
    temp.setNext(new DLLNode(newVal, temp.getNext(), temp));
    temp.getNext().getNext().setPrev(temp.getNext());
    _size += 1;
    return;
  }
  //--------------^  List interface methods  ^--------------



  // override inherited toString
  public String toString()
  {
    // YOUR CODE HERE
    DLLNode temp = _head;
    String s = "[";
    while(temp != null){
        s+= temp.toString() + ", ";
        temp = temp.getNext();
    }
    if(s.length() > 2){
        return s.substring(0,s.length()-2) + "]";
    }
    else{
        return s + "]";
    }
  }


  //main method for testing
  public static void main( String[] args )
  {
    LList james = new LList();
    System.out.println( james ); //[]
    james.add("test1");
    System.out.println( james ); //[test1]
    james.add("test2");
    System.out.println( james ); //[test2, test1]
    james.add("test3");
    System.out.println( james ); //[test3, test2, test1]
    System.out.println( "size: " + james.size() ); //3
    james.add("beat");
    System.out.println( james ); //[beat, test3, test2, test1]
    System.out.println( "size: " + james.size() ); //4
    james.add("a");
    System.out.println( james ); //[a, beat, test3, test2, test1]
    System.out.println( "size: " + james.size() ); //5
    james.add("need");
    System.out.println( james ); //[need, a, beat, test3, test2, test1]
    System.out.println( "size: " + james.size() ); //6
    james.add("I");
    System.out.println( james ); //[I, need, a , beat, test3, test2, test1]
    System.out.println( "size: " + james.size() ); //7
    System.out.println( "2nd item is: " + james.get(1) ); //need
    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") ); //got
    System.out.println( james ); //[I, got, a, beat, test3, test2, test1]
    System.out.println("TIME TO REMOVEEEEEE");
    james.remove(2);
    System.out.println(james);
    james.remove(5);
    System.out.println(james);
    james.remove(0);
    System.out.println(james);
    james.remove(1);
    System.out.println(james);
    james.remove(2);
    System.out.println(james);
    james.remove(0);
    System.out.println(james);
    james.remove(0);
    System.out.println(james);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class LList
