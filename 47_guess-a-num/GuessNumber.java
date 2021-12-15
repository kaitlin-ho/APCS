// Four: Kaitlin, Fang, Jing
// APCS pd6
// HW47 -- Guess Again
// 2021-12-14
// time spent: 1 hr

/***
 * class GuessNumber -- fun fun fun!
 *
 * eg, sample interaction with end user:
 *
 * Guess a # fr 1-100: 50
 * Too high
 * Guess a # fr 1-49: 25
 * Too low
 * Guess a # fr 26-49: 38
 * Correct! It took 3 guesses.
 ***/

/***
    DISCO:
    - The method while(true) {} can be stopped with the keyword "return".
    QCC:
    - What limitations with data type conversions do we have with using Scanner?
 ***/
import java.util.Scanner;

public class GuessNumber
{

  //instance vars
  private int _lo, _hi, _guessCtr, _target;
  Scanner sc = new Scanner( System.in );


  /*==================================================
    constructor -- initializes a guess-a-number game
    pre:
    post: _lo is lower bound, _hi is upper bound,
    _guessCtr is 1, _target is random int on range [_lo,_hi]
    ==================================================*/
  public GuessNumber( int a, int b )
  {
    _lo = Math.min(a,b);
    _hi = Math.max(a,b);
    _guessCtr = 1;

    //pick random number in range [a,b]

    _target = (int)(Math.random() * (_hi - _lo + 1) + _lo);
  }


  /*==================================================
    void playRec() -- Prompts a user to guess until guess is correct.
    Uses recursion.
    ==================================================*/
  public void playRec()
  {
    System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
    int guess = sc.nextInt();

    //3 cases: we either found it, too hi, too lo

    // case 1, equal
    if (guess == _target){
      System.out.println("\nCorrect! It took " + _guessCtr + " guesses.");
      return;
    }

    //case 2, higher
    if (guess < _target){
      _lo = guess + 1;
      System.out.println("Too low");
    }

    //case 3, lower
    if (guess > _target){
      _hi = guess - 1;
      System.out.println("Too high");
    }

    _guessCtr++;
    playRec();
  }


  /*==================================================
    void playIter() -- Prompts a user to guess until guess is correct.
    Uses iteration.
    ==================================================*/
  public void playIter()
  {
    int guess;

    while( true ) {
      System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
      guess = sc.nextInt();

      //3 cases: we either found it, too hi, too lo

      // case 1, equal
      if (guess == _target){
        System.out.println("\nCorrect! It took " + _guessCtr + " guesses.");
        return;
      }

      //case 2, higher
      if (guess < _target){
        _lo = guess + 1;
        System.out.println("Too low");
      }

      //case 3, lower
      if (guess > _target){
        _hi = guess - 1;
        System.out.println("Too high");
      }

      _guessCtr++;
    }

  }


  //wrapper for playRec/playIter to simplify calling
  public void play()
  {
    //use one or the other below:
    // playRec();
    playIter();
  }


  //main method to run it all
  public static void main( String[] args )
  {

    //instantiate a new game
    GuessNumber g = new GuessNumber(1,100);
    //start the game
    g.play();
    /*-----------------------------
    -----------------------------*/
  }

}//end class GuessNumber
