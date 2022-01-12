/*
Erica's Fans and Hugo (EFH) -- Hugo Jenkins, Ariella Katz, Kaitlin Ho, Boary, Tom, Apple
APCS
HW55 -- Never Fear, Big Oh Is Here!
2022-01-11
*/

/*
DISCO:
0. The order of a function that is the sum of multiple terms is
   the same as the order of the term that increases the fastest
   as x approaches infinity.
QCC:
0. The order of logn + n is n because as n goes to infinity, n
   increases faster than logn.
*/

/**********************************************
 * class OrderedArrayList
 * wrapper class for ArrayList
 * maintains invariant that elements are ordered (ascending)
 *
 * typed for Integers
 *
 * ArrayList spec at
 * https://www2.cs.duke.edu/csed/ap/subset/doc/ap/java/util/ArrayList.html
 **********************************************/


import java.util.ArrayList;

public class OrderedArrayList
{

  // instance of class ArrayList, holding objects of type Integer
  // (i.e., objects of a class that implements interface Integer)
  private ArrayList<Integer> _data;


  // default constructor
  // initializes instance variables
  public OrderedArrayList()
  {
    _data = new ArrayList<Integer>();
  }

/*
BestCase: N/A
WorstCase: N/A
toString() is data-insensitive.
Order: O(n)
  toString iterates through the list, appending each element to the
 String representation. Increasing the number of elements increases
 the number of appends by the same amount.
*/
  //pass-tru functionality
  public String toString()
  {
    return _data.toString();
  }

/*
BestCase: Element being removed is the last element
BestCase Order: O(1)
  If the last element is the element removed, no elements must be
 shifted over and there is a constant number of operations (only those
 necessary to change the value at the index to 0 and decrease _size by
 1).
WorstCase: Element being removed is the first element
WorstCase Order: O(n)
  If the first element is removed, all of the other elements must be
 shifted over to the left. Increasing the number of elements increases
 the number of shifts by the same amount.
*/
  //pass-tru functionality
  public Integer remove( int index )
  {
    return _data.remove(index);
  }

/*
BestCase: N/A
WorstCase: N/A
size() is data-insensitive.
Order: O(1)
  A set number of operations is done: _data.size() is called and
 _size is returned. Any updates to _size are done as necessary in
 other methods.
*/
  //pass-tru functionality
  public int size()
  {
    return _data.size();
  }

/*
BestCase: N/A
WorstCase: N/A
get() is data-insensitive
Order: O(1)
  A set number of operations is done: _data.get() is called and
 _data[index] is returned.
*/
  //pass-tru functionality
  public Integer get( int index )
  {
    return _data.get(index);
  }

/*
BestCase: See addLinear()
BestCase Order: See addLinear()
WorstCase: See addLinear()
WorstCase Order: See addLinear()
*/
  //modified functionality
  //insert at appropriate location to maintain sortedness
  public boolean add( Integer newVal )
  {
    //call exactly 1 of the helper methods below...  your favorite?

    addLinear(newVal);
    //addBinary(newVal);
    return true;
  }

/*
BestCase: N/A
WorstCase: N/A
  Suppose newVal belongs at index i. i+1 iterations of the for
 loop in addLinear() (i+1 compares) must be completed in order to
 determine what i is. Then, _data.add() is called to add newVal at
 i, which shifts _data._size-(i+1) elements over to the right to
 make space. Regardless of i, (i+1)+(_data._size-(i+1)), or
 _data._size, operations must be completed.
Order: O(n)
  Since _data._size operations are completed, increasing
 _data._size increases the number of operations by the same amount.
*/
  // inserts newVal at the appropriate index
  // maintains ascending order of elements
  // uses a linear search to find appropriate index
  public void addLinear(Integer newVal)
  {
    for( int p = 0; p < _data.size(); p++ ) {
      if ( newVal.compareTo( _data.get(p) ) < 0 ) {
        //newVal < oal[p]
        _data.add( p, newVal );
        return; //Q:why not break?
      }
    }
    _data.add( newVal ); //newVal > every item, so add to end
  }

/*
BestCase: newVal belongs in the middle of the ArrayList
BestCase Order: O(n)
  Only one compare will be done in addBinary() before the proper index,
 i, of newVal is found. Then, half of the elements must be shifted to
 the right in _data.add(). Increasing the number of elements by n
 increases the number of shifts by n/2 and has no effect on the number
 of compares, so it is on the order of n.
WorstCase: newVal belongs at index i = 0
WorstCase Order: O(n)
  Since newVal is at one of the extremes of the ArrayList, the maximum
 number of compares, (log_2)(n), are completed. Then, in _data.add(),
 all of the elements must be shifted over to the right. The total
 number of operations is (log_2)(n) + n, which is on the order of n.
*/
  // inserts newVal at the appropriate index
  // maintains ascending order of elements
  // uses a binary search to find appropriate index
  public void addBinary(Integer newVal)
  {
    //initialize high, low, midpt indices
    int lo = 0;
    int med = 0;
    int hi = _data.size()-1;

    while ( lo <= hi ) { //running until target is found or bounds cross

      med = (lo + hi) / 2;
      int x = _data.get(med).compareTo( newVal );

      if ( x == 0 ) {
        //equal value found, insert here
        _data.add( med, newVal );
        return;
      }
      else if ( x > 0 )
        //newVal < med, so look at lower half of data
        hi = med - 1;
      else
        //newVal > med, so look at upper half of data
        lo = med + 1;
    }
    // If you made it this far, newVal is not present.
    // So insert at lo.
    _data.add( lo, newVal );
    //Q: How do you know lo is correct insertion index?
  }


  // main method solely for testing purposes
  public static void main( String[] args )
  {

    OrderedArrayList franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
      franz.addLinear( (int)( 50 * Math.random() ) );
    System.out.println( franz );

    // testing binary search
    franz = new OrderedArrayList();
    for( int i = 0; i < 15; i++ )
      franz.addBinary( (int)( 50 * Math.random() ) );
    System.out.println( franz );

    /*-----v-------move-me-down-----------------v--------
      =====^====================================^=========*/

  }//end main()

}//end class OrderedArrayList
