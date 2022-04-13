/*
Mr. K: May Qiu, Raven (Ruiwen) Tang, Kaitlin Ho
APCS pd6
HW90 -- Swabbing the Deque / implementing Deque in compliance with interface
2022-04-12
time spent: 1.0 hr
*/

public interface Deque<Card>{
	public int size();

	public void addLast(Card x);

	public void addFirst(Card x);

	public Card peekFirst();

	public Card peekLast();

	public Card removeFirst();

	public Card removeLast();
	/*
	*/
}
