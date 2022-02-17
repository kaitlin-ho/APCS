/***
Kaitlin Ho, Courtney Huang
APCS pd06
Hw65
2022-02-16

 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Transcribe your KtS verbiage into block comments preceding each method where necessary.
 * 2. Implement solver method.

 */

public class QueenBoard
{

  private int[][] _board;

  public QueenBoard( int size )
  {
    _board = new int[size][size];
  }


  /***
   * precondition: board is filled with 0's only.
   * postcondition:
   * If a solution is found, board shows position of N queens,
   * returns true.
   * If no solution, board is filled with 0's,
   * returns false.
   */

  public boolean solve()
  {
    boolean solution = solveH(0);
    printSolution();
    return solution;
  }

  /**
   *Helper method for solve.
   */
   private boolean solveH( int col )
   {
    if (col == _board.length - 1){ // base case: you want to have the same number of queens as there are columns
      return true;
    }
    for (int row = 0; row < _board.length; row++){
      if (addQueen(row, col) == true){ //adds a queen
          if (solveH(col+1) == true){ //adds queens to other columns (can't add queen if the space is a -1 or 1)
          return true;
        }
      }
      //when the space is a 1 or -1 (basically can't put a queen in this space)
      removeQueen(row, col); //removes the queen --does nothing if it is a -1
    }
    return false; //(note to self--> it is for when recurive solveH is false and so it can backtrack and remove the last queen placed and then continue on with for loop...)
  }




  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */

    for (int[] row : _board){
      for (int column : row){
        if (column == 1){
          System.out.print(" Q ");
        }
        else {
          System.out.print(" _ ");
        }
      }
      System.out.print("\n");
    }

    // for printing out -1s
    // for (int[] row : _board){
    //   for (int column : row){
    //     if (column == 1){
    //       System.out.print(" Q ");
    //     }
    //     else if (column == -1) {
    //       System.out.print(" X ");
    //     }
    //     else {
    //       System.out.print(" - ");
    //     }
    //   }
    //   System.out.print("\n");
    // }

  }



  //================= YE OLDE SEPARATOR =================

  /***
   * Rules out array indexes where the queen cannot be placed. Every diagonal North-East
     relative to the placed queen (the 1 at the index specified by the parameters) and every
     horizontal to the right of it will change from -1 to 0.
   * precondition:
      * The array exists with at least one row and one column
      * The array index is within the bounds (so no negatives)
   * postcondition:
      * If true is returned, it means that the queens are placed
        properly (using the starting row and column)
      * If false, the queens cannot be placed properly (there is already
        a queen in this spot or a queen cannot be placed here)
   */
  private boolean addQueen(int row, int col)
  {
    if(_board[row][col] != 0){
      return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
      _board[row][col+offset]--;
      if(row - offset >= 0){
        _board[row-offset][col+offset]--;
      }
      if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
      }
      offset++;
    }
    return true;
  }


  /***
   * If there is a queen in the specified
     parameters, it removes it. When that queen was originally placed it ruled out array
     indexes where other queens cannot be placed. whitItDo makes those array indexes available
     spots for queens to be placed now that the queen ruling them out has been removed. (-1
     becomes 0)
   * precondition:
   * postcondition:
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
      return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
      _board[row][col+offset]++;
      if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
      }
      if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
      }
      offset++;
    }
    return true;
  }


  /***
   * <General description>
   * precondition:
   * postcondition:
   */
  public String toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
      }
      ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    System.out.println(b);
    /** should be...
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
    */

    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    /** should be...
       0	1	-1	-2	-1
       0	0	-2	0	0
       0	-1	0	-1	0
       1	-1	-1	-1	-2
       0	-1	0	0	0
    */

    b.removeQueen(3,0);
    System.out.println(b);
    /** should be...
       0	1	-1	-1	-1
       0	0	-1	0	0
       0	0	0	-1	0
       0	0	0	0	-1
       0	0	0	0	0
    */
    b.solve();
    System.out.println("___________________________________");
    QueenBoard c = new QueenBoard(8);
    c.solve();
  }
}//end class
