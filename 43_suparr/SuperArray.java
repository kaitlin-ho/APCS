// Four {Fang, Kaitlin, Jing}
// APCS pd06
// HW43 -- encapsulation (basic SuperArray functionality)
// 2021-12-07
// time spent: .5

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

/*
DISCO
- You can use a class to interface with and add additional functionality to an existing data type.
QCC
- Is it possible to assign an array to a new array without using a loop to set each index individually?
*/


public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new int[10];
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String array = "[";
    for (int i = 0; i < _data.length; i++) {
      array += _data[i] + ",";
    }
    array = array.substring(0, array.length() - 1) + "]";
    return array;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] tempArray = new int[_data.length];
    for (int i = 0; i < _data.length; i++) {
      tempArray[i] = _data[i];
    }
    _data = new int[_data.length * 2];
    for (int i = 0; i < tempArray.length; i++) {
      _data[i] = tempArray[i];
    }
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    int tempValue = _data[index];
    _data[index] = newVal;
    return tempValue;
  }


  //main method for testing
  public static void main( String[] args )
  {
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );

      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      }
  }//end main()


}//end class
