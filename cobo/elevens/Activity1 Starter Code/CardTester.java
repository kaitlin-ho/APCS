/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card one = new Card("Diamond", "seven", 7);
		System.out.println(one.rank());
		System.out.println(one.suit());
		System.out.println(one.pointValue());
		System.out.println(one.toString());
		Card two = new Card("Diamond", "seven", 7);
		System.out.println(two.rank());
		System.out.println(two.suit());
		System.out.println(two.pointValue());
		System.out.println(two.toString());
		Card three = new Card("Spade", "King", 13);
		System.out.println(three.rank());
		System.out.println(three.suit());
		System.out.println(three.pointValue());
		System.out.println(three.toString());

		System.out.println("One and two: " +  one.matches(two));
	}
}
