/*
AKH+D :: Ariella Katz, Kaitlin Ho, Hugo Jenkins
APCS pd6
HW 102 - Heap On Heapin' On
2022-05-17
time spent: 1.0 hrs
*/

/*
DISCO:
0. Ryan be hating
1. Heaps can be stored and communicated in ArrayLists
QCC:
0. Sometimes, just add more if statements to account for all case
1. Could we store the other types of trees we have learned in ArrayLists?
*/

/**
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 */

import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /**
   * default constructor  ---  inits empty heap
   */
  public ALHeap()
  {
    _heap = new ArrayList<Integer>();
  }



  /**
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   */
  public String toString()
  {
    if (_heap.size() == 0) return "{ }";
    String retStr = "{";
    for (Integer x : _heap) {
      retStr += x + ", ";
    }
    retStr = retStr.substring(0, retStr.length()-2) + "}";
    return retStr;
  }//O(n)


  /**
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   */
  public boolean isEmpty()
  {
    return _heap.size() == 0;
  }//O(1)


  /**
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   */
  public Integer peekMin()
  {
    return _heap.get(0);
  }//O(1)


  /**
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * ALGO:
   * Add addVal to the end of the ArrayList.
   * Find its parent (the parent's index is equal to half of one less addVal's
      index).
   * If it's less than its parent, swap them.
   * Keep doing that until it either gets to the root or is greater than its
   *  parent.
   */
  public void add( Integer addVal )
  {
    _heap.add(addVal);
    Integer parentIndex = (_heap.indexOf(addVal) - 1)/2;
    while (addVal > _heap.get(parentIndex)) {
      int ind = _heap.indexOf(addVal);
      _heap.set(ind, _heap.get(parentIndex));
      _heap.set(parentIndex, addVal);
      if (_heap.indexOf(addVal) != 0) {
        parentIndex = (_heap.indexOf(addVal) - 1)/2;
      }
      else {
        break;
      }
    }
  }//O(logn)


  /**
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * ALGO:
   * Overwrite the root with the last leaf.
   * Walk the "leaf" down, swapping it with the lesser of its children until
   *  it's less than both children.
   */
  public Integer removeMin()
  {
    if(_heap.size() == 1) {
      return _heap.remove(0);
    }
    Integer lastLeaf = _heap.get(_heap.size()-1);
    Integer prev = _heap.remove(_heap.size()-1);
    _heap.set(0, lastLeaf);
    int ind = 0;
    while ((ind*2+1 <= _heap.size()-1 && ind*2+2 <= _heap.size()-1) &&
    (lastLeaf > _heap.get(ind*2+1) || lastLeaf > _heap.get(ind*2+2))) {
      swap(ind, minChildPos(ind));
      ind = _heap.indexOf(lastLeaf);
    }
    if (ind*2+1 < _heap.size() && lastLeaf > _heap.get(ind*2+1)) {
      swap(ind, ind*2+1);
    }
    return prev;
  }//O(logn)


  /**
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   */
  private int minChildPos( int pos )
  {
    if (pos*2+1 <= _heap.size()-1 && pos*2+2 <= _heap.size()) {
      if (_heap.get(pos*2+1) < _heap.get(pos*2+2)) {
        return pos*2+1;
      }
      else { return pos*2+2; }
    }
    else if (pos*2+1 <= _heap.size()-1) {
      return pos*2+1;
    }
    else { return -1; }
  }//O(1)


  //~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
      return a;
    else
      return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  //main method for testing
  public static void main( String[] args )
  {
      ALHeap pile = new ALHeap();

      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);

      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);

      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
