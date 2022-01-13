/*
Erica's Fans and Hugo
APCS
HW56 - Turing Training Wheels
2022-1-12
time spent: 2

QCC:
- In activty4 there was an out of bounds issue with the I You statement and response. In line 67, removing the space from "I " (changed to "I") solved the out of bounds issue. Why is this? How could a single space cause this error.

DISCO:
- Learned how to open html files in java and in terminal
- User input obtained from the scanner can easily be manipulated (i.e using methods like an overridden indexOf, transform methods using substring, etc)
*/

import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner4
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		Magpie4 maggie = new Magpie4();
		
		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye"))
		{
			System.out.println (maggie.getResponse(statement));
			statement = in.nextLine();
		}
	}

}
