/*
Erica's Fans and Hugo (Hugo Jenkins, Kaitlin Ho, Ariella Katz)
APCS pd 6
L09: Some Folks Call It A Charades
2022-04-26
time spent: hrs
*/
/**
 * Celebrity base class for the Celebrity game.
 * @author cody.henrichsen
 * @version 1.4 17/09/2018
 */
public class Celebrity
{
	/**
	 * The clue to determine the celebrity
	 */
	String _clue;
	String _answer;
	/**
	 * The answer or name of the celebrity.
	 */
	public Celebrity()
	{
		_clue = "He inspires learnination and greatness";
		_answer = "Mykolyk";
	}
	/**
	 * Creates a Celebrity instance with the supplied answer and clue
	 * @param answer
	 * @param clue
	 */
	public Celebrity(String answer, String clue)
	{
		_clue = clue;
		_answer = answer;
	}

	/**
	 * Supplies the clue for the celebrity
	 * @return
	 */
	public String getClue()
	{
		return _clue;
	}

	/**
	 * Supplies the answer for the celebrity.
	 * @return
	 */
	public String getAnswer()
	{
		return _answer;
	}

	/**
	 * Updates the clue to the provided String.
	 * @param clue The new clue.
	 */
	public void setClue(String clue)
	{
		_clue = clue;
	}

	/**
	 * Updates the answer to the provided String.
	 * @param answer The new answer.
	 */
	public void setAnswer(String answer)
	{
		_answer = answer;
	}

	/**
	 * Provides a String representation of the Celebrity.
	 */
	@Override
	public String toString()
	{
		String s = "";
		s += _answer + ": " + _clue;
		return s;
	}

}
