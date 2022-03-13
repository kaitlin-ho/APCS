/*
Mr.K (Raven, Kaitlin, May )
APCS
HW75 -- Nodal Recall/Linked Lists/Implements a node, for use in lists and other container classes.
2022-03-12
time spent: 1 hr
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
