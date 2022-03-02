// Soggy Crackers
// APCS pd06
// HW68 -- ...and T-,Tr-, Tri-, Tries Again Until It's Done
// 2022-03-1
// time spent: 1 hrs

/***
 * SKELETON
 * class KnightTour (and supporting class TourFinder)
 * Animates generation of a Knight's Tour on a square chess board.
 *
 * USAGE: (default N value: 8)
 * $ javac KnightTour.java
 * $ java KnightTour
 * $ java KnightTour [N]
 *
 * ALGO
 * - we did findTour on every possible move the knight could go on
 * - If that move didn't work, it would backtrack and try the next posisble move (or branch)
 * DISCO
 * - You can just list the recursions and if the tour is solved, it will exit
 * QCC
 * - How would you display all possible tours? Or at least the number of possible tours
 *
 * Mean execution times for boards of size n*n:
 * n=5   __s    across __ executions
 * n=6   __s    across __ executions
 * n=7   __s    across __ executions
 * n=8   __s    across __ executions
 *
 * POSIX PROTIP: to measure execution time from BASH, use time program:
 * $ time java KnightTour 5
 * real    0m17.204s
  user    0m0.015s
  sys     0m0.000s

 ***/


import java.io.*;
import java.util.*;


public class KnightTour
{
  public static void main( String[] args )
  {
    int n = 8;

    try {
      n = Integer.parseInt( args[0] );
    } catch( Exception e ) {
      System.out.println( "Invalid input. Using board size "
                          + n + "..." );
    }

    TourFinder tf = new TourFinder( n );

    //clear screen using ANSI control code
    System.out.println( "[2J" );

    //display board
    System.out.println( tf );

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for fixed starting location, use line below:
    //tf.findTour( 2, 2, 1 );
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for random starting location, use lines below:
    //int startX = (int)(Math.random()*n);
    //int startY = (int)(Math.random()*n);
    //if (startX == 0) { startX += 2 };
    //if (startX == 1) { startX += 1 };
    //if (startY == 0) { startY += 2};
    //if (startY == 1) { startY += 1};
    //tf.findTour( startX, startY, 1 );   // 1 or 0 ?
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // PUSHING FARTHER...
    // Systematically attempt to solve from every position on the board?
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    for (int i = 2; i < n + 2; i++){ //runs through x values
      for (int a = 2; i < n; a++){ //runs through y values
        tf.findTour(i, a, 1);
      }
    }

  }//end main()

}//end class KnightTour


class TourFinder
{
  //instance vars
  private int[][] _board;
  private int _sideLength; //board has dimensions n x n
  private boolean _solved = false;

  //constructor -- build board of size n x n
  public TourFinder( int n )
  {
    _sideLength = n;

    //init 2D array to represent square board with moat
    _board = new int [_sideLength+4][_sideLength+4];

    //SETUP BOARD --  0 for unvisited cell
    //               -1 for cell in moat
    //---------------------------------------------------------

    for (int row = 0; row < _board.length; row++){
      for (int col = 0; col < _board[row].length; col++){
        if (row == 0 || row == 1 || row == _board.length-1 || row == _board.length-2){
          _board[row][col] = -1;
        }
      }
    }

    for (int col = 0; col < _board.length; col++){
      for (int row = 0; row < _board[col].length; row++){
        if (col == 0 || col == 1 || col == _board.length-1 || col == _board.length-2){
          _board[row][col] = -1;
        }
      }
    }

    //---------------------------------------------------------

  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, then press ESC
    //emacs shortcut: M-x quoted-insert, then press ESC

    int i, j;
    for( i=0; i < _sideLength+4; i++ ) {
      for( j=0; j < _sideLength+4; j++ )
        retStr = retStr + String.format( "%3d", _board[j][i] );
      //"%3d" allots 3 spaces for each number
      retStr = retStr + "\n";
    }
    return retStr;
  }


  /**
   * helper method to keep try/catch clutter out of main flow
   * @param n      delay in ms
   **/
  private void delay( int n )
  {
    try {
      Thread.sleep(n);
    } catch( InterruptedException e ) {
      System.exit(0);
    }
  }


  /**
   * void findTour(int x,int y,int moves) -- use depth-first w/ backtracking algo
   * to find valid knight's tour
   * @param x      starting x-coord
   * @param y      starting y-coord
   * @param moves  number of moves made so far
   **/
  public void findTour( int x, int y, int moves )
  {
    //delay(50); //slow it down enough to be followable

    //if a tour has been completed, stop animation
    if ( _solved ) System.exit(0);

    //primary base case: tour completed
    if (moves == _sideLength*_sideLength + 1) { // if n^2 is in the array (the middle board) then the tour is completed
      _solved = true;
      System.out.println( this ); //refresh screen
      return;
    }
    //other base case: stepped off board or onto visited cell
    if ( _board[x][y] != 0 ) {
      return;
    }
    //otherwise, mark current location
    //and recursively generate tour possibilities from current pos
    else {

      //mark current cell with current move number
      _board[x][y] = moves;

      System.out.println( this ); //refresh screen

      //delay(1000); //uncomment to slow down enough to view

      /******************************************
       * Recursively try to "solve" (find a tour) from
       * each of knight's available moves.
       *     .  e  .  d  .
       *     f  .  .  .  c
       *     .  .  @  .  .
       *     g  .  .  .  b
       *     .  h  .  a  .
      ******************************************/

      // for(moves = moves + 1; moves<_sideLength*_sideLength; moves++){
      //   findTour(x+2,y+1,moves);
      //   if (_solved == false){
      //     findTour(x+1, y+2, moves);
      //   }
      // }

      findTour(x+1, y+2, moves +1);
      findTour(x+1, y-2, moves +1);
      findTour(x+2, y+1, moves +1);
      findTour(x+2, y-1, moves +1);
      findTour(x-1, y-2, moves +1);
      findTour(x-1, y+2, moves +1);
      findTour(x-2, y-1, moves +1);
      findTour(x-2, y+1, moves +1);


      //If made it this far, path did not lead to tour, so back up...
      // (Overwrite number at this cell with a 0.)

      _board[x][y] = 0;

      System.out.println( this ); //refresh screen
    }
  }//end findTour()

}//end class TourFinder
