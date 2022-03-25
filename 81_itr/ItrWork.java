/**
Mr. K: May Qiu, Kaitlin Ho, Raven (Ruiwen) Tang
APCS pd06
HW81 -- Thank You, Next / Iterator work
2022-03-24
time spent: 0.6 hrs
**/

/***
 * class ItrWork
 *  SKELETON
 * Facilitates familiarization with iterators
 **/

/***
    DISCO
    * List is an interface, so it can't be instantiated. Therefore, there will be a compilation error if you attempt to do List<Integer> nums = new List<Integer>();
    * It's important to type Iterator (for example, Iterator<Integer>), because the interface is generically typed and will attempt to return an Object for the method next(). This can lead to compilation errors, since Java cannot convert an Object into something like an Integer.
    * For loops and Iterators can be used to find/check/print/collect elements. However, an Iterator has the advantage of being a more straightforward way to remove elements from a List, since it has the remove() method.

    QCC
    * Iterator is an interface, so it doesn't have a constructor. Instead, you need to use the iterator() method of the List you are attempting to iterate over.
    * We noticed that when we tried to implement the same method using Iterator instead of a foreach loop, we simply used a while loop to check if the List had a next element and then completed the actions inside of this loop.

    SUMMARY THE FIRST:
      hasNext() checks if the next element exists. If it does, returns true. Otherwise, returns false.
      next() returns the value of the next element.
      remove() takes out the value of the last element that was iterated through (the last element that was returned by next()).

    SUMMARY THE SECOND:
      The ItrWork class demonstrates how the same tasks can be completed with foreach loops and iterators. These tasks include checking if an element is present in a list and returning the odd elements of a list. An additional method for iterators is removing the even elements from a list.

**/

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{

  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key,
                                List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    for (Integer i : L){
      if(i.equals(key)){
        return true;
      }
    }
    return false;
  }

  //explicitly using an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key,
                                List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    Iterator<Integer> it = L.iterator();
    while(it.hasNext()){
      if(it.next() == key){
        return true;
      }
    }
    return false;
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsA( List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    List<Integer> odds = new ArrayList<Integer>();
    for(Integer i : L){
      if(i%2 == 1){
        odds.add(i);
      }
    }
    return odds;
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsB( List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    List<Integer> odds = new ArrayList<Integer>();
    Iterator<Integer> it = L.iterator();
    while(it.hasNext()){
      Integer nxt = it.next();
      if(nxt %2 == 1){
        odds.add(nxt);
      }
    }
    return odds;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    Iterator<Integer> it = L.iterator();
    while(it.hasNext()){
      if(it.next()%2 == 0){
        it.remove();
      }
    }
  }


  public static void main( String [] args )
  {

    //var type: List   obj type: ArrayList
    List<Integer> L = new ArrayList<Integer>();

    for( int i = 0; i < 10; i++ )
      L.add(i);

    //System.out.println(L);

    // TASK: write code to print the contents of L...

    // a) using a FOREACH loop
    for( Integer i : L){
      System.out.println(i);
    }

    // b) explicitly using an iterator
    Iterator<Integer> it = L.iterator();
    while(it.hasNext()){
      System.out.println(it.next());
    }


    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) ); //should return true
    System.out.println("13 in L? -> " + foundA(13,L) ); //should return false


    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) ); //should return true
    System.out.println("13 in L? -> " + foundB(13,L) ); //should return false

    System.out.println("\nTesting oddsA...");
    List<Integer> A = oddsA(L);
    for( int n : A ) System.out.println(n); //should be {1,3,5,7,9}

    System.out.println("\nTesting oddsB...");
    List<Integer> B = oddsB(L);
    for( int n : B ) System.out.println(n); //should be {1,3,5,7,9}

    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for( int n : L ) System.out.println(n);
    /*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class ItrWork
