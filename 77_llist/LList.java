/**
 * Mr. K: May Qiu, Kaitlin Ho, Raven (Ruiwen) Tang
 * APCS pd06
 * HW77 -- Insert|Remove
 * 2022-03-15
 * time spent: 1.5 hr
 * KTS used: 1
 * DISCO
 * We realized that we needed to split remove() into a few cases, because the desired index of removal might not point to a non-null node. In this case,
 * we want to set the node before the desired index to point to null. Additionally, if we want to remove the first index, there won’t be a node before it,
 * so we want to change where _head points.
 *
 * add() actually adds an element to the beginning of the list, rather than the end (which is what we thought in HW76). This means it should take O(1) time
 * since it is only changing _head, instead of O(n) time.
 *
 * In other Lists, we usually have to shift all the elements after the removed element back one index. However, for LinkedList remove(), we don’t even need
 * to look at the later elements. We only need to change the pointer of the element before the remove index.
 *
 * QCC
 * Would it be reasonable to also make a add at index method?
 *
 * ALGO ADD
 * Create a new node temp with cargo newVal and link it to _head. Then, let _head point to temp. Return true.
 *
 * ALGO REMOVE
 * If index is out of bounds, throw IndexOutOfBoundsException.
 * If index is 0, store the value at head and change the head to the next node. Return stored value.
 * If _size - index is less than two, create a temp pointing to head. Move temp until it is at index - 1. Store temp's next node's value. Set temp's next node to null. Return the stored value.
 * Else, create a temp pointing to head. Move temp until it is at index - 1. Store temp's next node's value. Set temp's next node to the node 2 indices from temp. Return the stored value.
 **/

/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 *
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    // YOUR CODE HERE
    _head = null;
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    // YOUR CODE HERE
    /*
    if(_size == 0){
        _head = new LLNode(newVal, null);
        _size = 1;
        return true;
    }
    else{
        LLNode temp = _head;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(new LLNode(newVal, null));
        _size += 1;
        return true;
    }
*/
    LLNode temp = new LLNode(newVal, _head);
    _head = temp;
    _size += 1;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    // YOUR CODE HERE
    LLNode temp = _head;
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
    LLNode temp = _head;
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
      return ans;
  }
    if((_size-index)<2){
      LLNode temp = _head;
      for(int i = 0; i < index - 1; i++){
          temp = temp.getNext();
      }
      String ans = temp.getNext().getCargo();
      temp.setNext(null);
      return ans;
    }
    LLNode temp = _head;
    for (int i = 0; i < index - 1; i++){
      temp = temp.getNext();
    }
    temp.setNext(temp.getNext().getNext());
    return previous;
  }
  //--------------^  List interface methods  ^--------------



  // override inherited toString
  public String toString()
  {
    // YOUR CODE HERE
    LLNode temp = _head;
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
