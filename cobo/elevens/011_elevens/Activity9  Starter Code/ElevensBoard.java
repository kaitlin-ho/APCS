import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		return(containsPairSum11(selectedCards) || containsJQK(selectedCards));
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		// method is supposed to be short, but i don't see how?
		// also doesn't work
		boolean pair = false;
		List<Integer> boardLeft = cardIndexes();
		if (boardLeft.size() == 2) {
			return containsPairSum11(boardLeft);
		} else if (boardLeft.size() == 3) {
			return containsJQK(boardLeft);
		} else {
			ArrayList<Integer> pairSum11 = new ArrayList<Integer>();
			pairSum11.add(boardLeft.get(0));
			pairSum11.add(boardLeft.get(1));

			ArrayList<Integer> tripletJQK = new ArrayList<Integer>();
			tripletJQK.add(boardLeft.get(0));
			tripletJQK.add(boardLeft.get(1));
			tripletJQK.add(boardLeft.get(2));

			for (int card1 = 0; card1 < boardLeft.size(); card1++) {
				pairSum11.set(0, boardLeft.get(card1));
				tripletJQK.set(0, boardLeft.get(card1));

				for (int card2 = 1; card2 < boardLeft.size(); card2++) {
					pairSum11.set(1, boardLeft.get(card2));
					tripletJQK.set(1, boardLeft.get(card2));

					for (int card3 = 2; card3 < boardLeft.size(); card3++) {
						tripletJQK.set(2, boardLeft.get(card3));
						if (pair) {
							pair = isLegal(pairSum11) || isLegal(tripletJQK);
						}
					}
				}
			}
		}

		return pair;
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		if (selectedCards.size() != 2) {
			return false;
		}
		if (cardAt(selectedCards.get(0)).pointValue() + cardAt(selectedCards.get(1)).pointValue() == 11) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		if (selectedCards.size() != 3) {
			return false;
		}
		if (cardAt(selectedCards.get(0)).pointValue() + cardAt(selectedCards.get(1)).pointValue() + cardAt(selectedCards.get(2)).pointValue() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
