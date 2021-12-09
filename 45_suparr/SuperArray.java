
// Four {Fang, Jing, Kaitlin}
// APCS1 pd06
// HW45 -- Array of Titanium
// 2021-12-09
// time spent: .4 hr

/***************************
 * class SuperArray version 2.0
 * Wrapper class for array. Facilitates
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 ***************************/

/*
DISCO
- An interface can't contain a constructor and cannot be used to create objects. 
QCC
-Why does public int set(int index) not work in ListInt?
-
*/

public class SuperArray implements ListInt
{

  private int[] _data;  //underlying ("encapsulated") container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new int[10];
    _size = 0;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String foo = "[";
    for( int i = 0; i < _size; i++ ) {
      foo += _data[i] + ",";
    }
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length()-1 );
    foo += "]";
    return foo;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] temp = new int[ _data.length * 2 ];
    for( int i = 0; i < _data.length; i++ )
      temp[i] = _data[i];
    _data = temp;
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
    int temp = _data[index];
    _data[index] = newVal;
    return temp;
  }


  //adds an item after the last item
  public void add( int newVal )
  {
    // {1, 2, 0, 0 ,,,}
    if (_data.length > _size){
      _data[_size] = newVal;
    }
    // when we use "<" rather than ">", _data.length increases from 10 to 10240 to 20480 instead of 10, 10, 40
    // according to our print statements. we could not figure out why.
    
    else{
      this.expand();
      _data[_size] = newVal;
    }
    _size = _size + 1;
  }


  //inserts an item at index
  public void add( int index, int newVal )
  {
    if (index > _size + 1) {
      System.out.println("Invalid index");
    } else {

      // expand if necessary
      if (index == _data.length) {
        expand();
      }

      //temp copy of the array
      int[] temp = new int[_data.length];
      for(int i = 0; i < _size; i++){
        temp[i] = _data[i];
      }
     
      //inserting element
      _data[index] = newVal;
      _size = _size + 1;

      for(int i = index + 1; i < _size; i ++){
        _data[i] = temp[i-1];
      }

    }
      
  }


  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  public void remove( int index )
  {
    for( int i = index; i < _size; i++){
      _data[i] = _data[i+1];
    }
    _size = _size - 1;
  }


  //return number of meaningful items in _data
  public int size()
  {
    return _size;
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
      System.out.println("new length of underlying array: "
      + curtis._data.length );
      }
    
      SuperArray mayfield = new SuperArray();
      System.out.println("Printing empty SuperArray mayfield...");
      System.out.println(mayfield);
      System.out.println(mayfield._data.length);
      mayfield.add(5);
      mayfield.add(4);
      mayfield.add(3);
      mayfield.add(2);
      mayfield.add(1);
    // extra tests
      mayfield.add(5);
      mayfield.add(4);
      mayfield.add(3);
      mayfield.add(2);
      mayfield.add(1);
      System.out.println(mayfield._data.length);
      mayfield.add(5);
      System.out.println(mayfield._data.length);
      mayfield.add(4);
      mayfield.add(3);
      mayfield.add(2);
      mayfield.add(1);
      System.out.println("Printing populated SuperArray mayfield...");
      System.out.println(mayfield);
   
      mayfield.remove(3);
      System.out.println("Printing SuperArray mayfield post-remove...");
      System.out.println(mayfield);
      // System.out.println(mayfield.temp);
      // mayfield.remove(3);
      // System.out.println("Printing SuperArray mayfield post-remove...");
      // System.out.println(mayfield);
      mayfield.add(3,99);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      mayfield.add(2,88);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      mayfield.add(1,77);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
     /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class
