/*
Erica's Fans and Hugo (Hugo Jenkins, Kaitlin Ho, Ariella Katz)
APCS pd 6
L09: Some Folks Call It A Charades
2022-04-26
time spent: 5 hrs
*/
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The framework for the Celebrity Game project
 *
 * @author cody.henrichsen
 * @version 2.3 25/09/2018 refactored the prepareGame and play methods
 */
public class CelebrityGame
{
	/**
	 * A reference to a Celebrity or subclass instance.
	 */

	/**
	 * The GUI frame for the Celebrity game.
	 */

	/**
	 * The ArrayList of Celebrity values that make up the game
	 */
	 private ArrayList<Celebrity> _celebGameList;
	 private Celebrity _gameCelebrity;
	 private CelebrityFrame _gameWindow;
	 private int _t1score;
	 private int _t2score;
	/**
	 * Builds the game and starts the GUI
	 */
	public CelebrityGame()
	{
		_celebGameList = new ArrayList<Celebrity>();
		_gameWindow = new CelebrityFrame(this);
		prepareGame();
	}

	/**
	 * Prepares the game to start by re-initializing the _celebGameList and having the gameFrame open the start screen.
	 */
	public void prepareGame()
	{
		_celebGameList = new ArrayList<Celebrity>();
		_gameWindow.replaceScreen("START");
	}

	/**
	 * Determines if the supplied guess is correct.
	 *
	 * @param guess
	 *            The supplied String
	 * @return Whether it matches regardless of case or extraneous external
	 *         spaces.
	 */
	public boolean processGuess(String guess)
	{
		if (guess.toLowerCase().trim().equals(_gameCelebrity.getAnswer().toLowerCase().trim())) {
			_celebGameList.remove(_gameCelebrity);
			return true;
		} else return false;
	}

	/**
	 * Asserts that the list is initialized and contains at least one Celebrity.
	 * Sets the current celebrity as the first item in the list. Opens the game
	 * play screen.
	 */
	/*
How to play:

	*/
	public void play()
	{
		/*
		if (_celebGameList.size() == 0){
			System.out.println("Take turns entering your celebs!");
			for (int i = 0; i < 4; i++){
				System.out.println("Input celeb name:");
				Scanner in = new Scanner(System.in);
				String name = in.nextLine();
				System.out.println("Input celeb clue:");
				Scanner it = new Scanner(System.in);
				String clue = it.nextLine();
				if (validateClue(clue, "Celebrity") && validateCelebrity(name)){
					_celebGameList.add(new Celebrity(name, clue));
				}
				else{
					System.out.println("Invalid");
					i--;
				}
			}
		}

		int ctr = 0;
		long start = System.currentTimeMillis();
		while ((System.currentTimeMillis() < start + 60000) &&
		(_celebGameList.size() > 0)) {
*/
			if (_celebGameList!= null && _celebGameList.size()>0){
				this._gameCelebrity=_celebGameList.get(0);
				_gameWindow.replaceScreen("GAME");
			}
/*
			if (ctr % 2 == 0) { System.out.println("Team 1, guess"); }
			else { System.out.println("Team 2, guess"); }
			System.out.println(_gameCelebrity.getClue());
			Scanner is =  new Scanner(System.in);
			if (processGuess(is.nextLine())){
				System.out.println("Correct");
				if (ctr % 2 == 0) { _t1score ++; }
				else { _t2score ++; }
			}
			else{
				System.out.println("Wrong");
				if (ctr % 2 == 0) { _t1score --; }
				else { _t2score --; }
			}
			_celebGameList.remove(0);

			if (_celebGameList.size() == 0){
				System.out.println("You've finished off the celebs!");
				if (_t1score > _t2score) {
					System.out.println("Team 1 is victorious!");
				}
				else {
					System.out.println("Team 2 is victorious!");
				}
				return;
			}
*/
		}


	/**
	 * Adds a Celebrity of specified type to the game list
	 *
	 * @param name
	 *            The name of the celebrity
	 * @param guess
	 *            The clue(s) for the celebrity
	 * @param type addCelebrity(String name, String guess, String ty
	 *            What type of celebrity
	 */
	public void addCelebrity(String name, String guess, String type)
	{
		if (type.equals("Literature")) _celebGameList.add(new LiteratureCelebrity(name,guess));
		else if (type.equals("Political")) _celebGameList.add(new PoliticalCelebrity(name,guess));
		else {_celebGameList.add(new Celebrity(name,guess));}
	}

	/**
	 * Validates the name of the celebrity. It must have at least 4 characters.
	 * @param name The name of the Celebrity
	 * @return If the supplied Celebrity is valid
	 */
	public boolean validateCelebrity(String name)
	{
		return (name.trim().length() >= 4);
	}

	/**
	 * Checks that the supplied clue has at least 10 characters or is a series of clues
	 * This method would be expanded based on your subclass of Celebrity.
	 * @param clue The text of the clue(s)
	 * @param type Supports a subclass of Celebrity
	 * @return If the clue is valid.
	 */
	public boolean validateClue(String clue, String type)
	{
		boolean validClue = false;
		if (clue.trim().length() >= 10) {
			validClue = true;
			if (type.equalsIgnoreCase("litterature")) {
				String[] temp = clue.split(",");
				if (temp.length > 1) {
					validClue = true;
				} else {
					validClue = false;
				}
			}	else {
					String[] temp = clue.split(",");
					if (temp.length > 1) {
						validClue = true;
					}
				}
			}
			return validClue;
		}


	/**
	 * Accessor method for the current size of the list of celebrities
	 *
	 * @return Remaining number of celebrities
	 */
	public int getCelebrityGameSize()
	{
		return _celebGameList.size();
	}

	/**
	 * Accessor method for the games clue to maintain low coupling between
	 * classes
	 *
	 * @return The String clue from the current celebrity.
	 */
	public String sendClue()
	{
		return _gameCelebrity.getClue();
	}

	/**
	 * Accessor method for the games answer to maintain low coupling between
	 * classes
	 *
	 * @return The String answer from the current celebrity.
	 */
	public String sendAnswer()
	{
		return _gameCelebrity.getAnswer();
	}
}
