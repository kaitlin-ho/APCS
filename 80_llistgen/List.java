/**
MR. K: May Qiu, Kaitlin Ho, Raven (Ruiwen) Tang
APCS pd06
HW80 -- Generically Speaking
2022-03-24
time spent: 1.0 hr

DISCO:
- When updating our list implementation to allow for generic typing, the best first step is to edit the interface first.
- DLLNode should have been replaced with DLLNode<T> everywhere, even if it appears in the parameters.
- T, or <T> is generally accepted for "type"
- Find and replace is scary, make sure to go through each phrase individually; beware of using replace all

QCC:
- Why does our list implementation work with both DLLNode and DLLNode<T> in the constructor? Is there a difference between the two?
 */

/***
 * interface List
 * subset of actual Java List interface
 * Specifies actions a List must be able to perform.
 *
 * If placed in current working dir, will be consulted instead of
 *  built-in Java library interface.
 *
 * new in version 2.0:
 * REMOVE-AT-INDEX
 * ADD-AT-INDEX
 **/

public interface List<T>
{
  //add node to list, containing input T as its data
  public boolean add( T x );

  //insert at specified index
  public void add( int index, T newVal );

  //remove node from list, return its data
  public T remove( int index );

  //return data in element at position i
  public T get( int i );

  //overwrite data in element at position i
  public T set( int i, T x );

  //return length of list
  public int size();

}//end interface
