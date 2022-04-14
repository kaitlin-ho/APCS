/*
Mr. K: May Qiu, Raven (Ruiwen) Tang, Kaitlin Ho
APCS pd6
HW90 -- Swabbing the Deque / implementing Deque in compliance with interface
2022-04-12
time spent: 1.0 hr
*/

import java.util.Iterator;

public class MRKPirateBae{
	public static void main(String[] args){
		Deque tester = new MrKDeque<String>();

		System.out.println(tester.size()); //0

		tester.addLast("item one"); // item one
		System.out.println(tester.size()); //1

		tester.add("item two"); // item one, item two
		System.out.println(tester.size()); //2

		tester.offer("item three"); // item one, item two, item three
		System.out.println(tester.size()); //3

		tester.offerLast("item four"); // item one, item two, item three, item four
		System.out.println(tester.size()); //4

		tester.addFirst("item five"); // item five, item one, item two, item three, item four
		System.out.println(tester.size()); //5

		tester.addFirst("item six");  // item six, item five, item one, item two, item three, item four
		System.out.println(tester.size()); //6

		tester.offerFirst("item seven"); // item seven, item six, item five, item one, item two, item three, item four
		System.out.println(tester.size()); //7

		tester.push("item eight"); // item eight, item seven, item six, item five, item one, item two, item three, item four
		System.out.println(tester.size()); //8

		System.out.println(tester.peekFirst()); // item eight	
		
		System.out.println(tester.element()); // item eight

		System.out.println(tester.getFirst()); // item eight

		System.out.println(tester.peek()); // item eight

		System.out.println(tester.peekLast()); // item four

		System.out.println(tester.getLast()); // item four

		System.out.println(tester.removeFirst()); // item eight

		System.out.println(tester.poll()); // item seven

		System.out.println(tester.pollFirst()); // item six

		System.out.println(tester.remove()); // true

		System.out.println(tester.pop()); // item one

		System.out.println(tester.removeLast()); // item four

		System.out.println(tester.pollLast()); // item three

		System.out.println(tester.contains("item one")); // false

		System.out.println(tester.contains("item two")); // true

		System.out.println(tester.remove("item one")); // false

		System.out.println(tester.contains("item two")); // true

		System.out.println(tester.removeFirstOccurrence("item one")); // false

		System.out.println(tester.removeLastOccurrence("item one")); // false

		System.out.println(tester.removeLastOccurrence("item two")); // true

		tester.add("A");
		tester.add("B");
		tester.add("C");
		tester.add("D");

		Iterator testIter = tester.iterator();
		System.out.println(testIter.next()); //A 
		System.out.println(testIter.next()); //B
		System.out.println(testIter.next()); //C
		System.out.println(testIter.next()); //D

		Iterator testDIter = tester.descendingIterator();
		System.out.println(testDIter.next()); //D
		System.out.println(testDIter.next()); //C
		System.out.println(testDIter.next()); //B
		System.out.println(testDIter.next()); //A
	}
}
