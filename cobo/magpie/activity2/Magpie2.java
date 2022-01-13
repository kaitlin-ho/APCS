/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */

 /*
 * Keyword:	Response:
 * homework	Homework is evil, how late do you stay up every night?
 * track	Lettuce is the best!
 * Erica	I heard that you are her fan.
 *  When more than one keyword appears in a String, it gives the
 * response that corresponds to the first, or leftmost, keyword.
 * This is due to the use of else if statements to declare what the
 * response should be. To prioritize a certain response, move it
 * earlier in the chain of else if statements.
 * Q1:
 *   The problem with these statements is that the statements contain
 *  keywords within other words. For example, "no" is in "know" and
 *  "mother" is in "smothered". The indexOf() the respective keyword
 *  would be >= 0 and therefore the response corresponding to that
 *  keyword would be outputted.
 */

public class Magpie2
{
	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
    		else if (statement.indexOf("cat") >= 0
		    || statement.indexOf("dog") >= 0
		    || statement.indexOf("fish") >= 0)
		{
			response = "Tell me more about your pets.";
		}
		else if (statement.indexOf("Mykolyk") >= 0)
		{
			response = "They sound like a good teacher.";
		}
		else if ((statement.trim()).length() == 0)
		{
			response = "Say something, please.";
		}
		else if ((statement.indexOf("homework") >= 0)
		{
			response = "Homework is evil, how late do you stay up every night?";
		}
		else if ((statement.indexOf("track") >= 0)
		{
			response = "Lettuce is the best!";
		}
		else if ((statement.indexOf("Erica") >= 0)
		{
			response = "I heard that you are her fan.";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4)
		{
			response = "Come see me in my office!";
		}
		else if (whichResponse == 5)
		{
			response = "You're boring.";
		}

		return response;
	}
}
