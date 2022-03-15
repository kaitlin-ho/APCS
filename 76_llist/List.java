
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
 * interface List
 * subset of actual Java List interface
 * Specifies actions a List must be able to perform.
 * 
 * If placed in current working dir, will be consulted instead of
 *  built-in Java library interface.
 **/

public interface List
{
  //add node to list, containing input String as its data
  public boolean add( String x );

  //return data in element at position i
  public String get( int i );

  //overwrite data in element at position i
  public String set( int i, String x );

  //return length of list
  public int size();

}//end interface
