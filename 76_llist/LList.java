
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
    System.out.println( james ); //[test1, test2]
    james.add("test3");
    System.out.println( james ); //[test1, test2, test3]
    System.out.println( "size: " + james.size() ); //3
    james.add("beat");
    System.out.println( james ); //[test1, test2, test3, beat]
    System.out.println( "size: " + james.size() ); //4
    james.add("a");
    System.out.println( james ); //[test1, test2, test3, beat, a]
    System.out.println( "size: " + james.size() ); //5
    james.add("need");
    System.out.println( james ); //[test1, test2, test3, beat, a, need]
    System.out.println( "size: " + james.size() ); //6
    james.add("I");
    System.out.println( james ); //[test1, test2, test3, beat, a, need, I]
    System.out.println( "size: " + james.size() ); //7
    System.out.println( "2nd item is: " + james.get(1) ); //test2
    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") ); //got
    System.out.println( james ); //[test1, got, test3, beat, a, need, I]
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class LList
