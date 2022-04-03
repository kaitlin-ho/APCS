/** 
Mr. K: May Qiu, Raven (Ruiwen) Tang, Kaitlin Ho
APCS pd6
HW87: The English Do Not Wait In Line for Soup / node-based queue 
2022-04-03
time spent: 0.7 hrs
**/

/**
DISCO:
* We had a discussion on if the instance variable in NodeQueue should keep track of the front or end of the queue. We realized that either way, dequeue() or enqueue() would be O(n), and the other would be O(1). However, peekFront() would only be O(1) if the instance variable kept track of the front of the queue, so that's why we decided to go with the front.
QCC:
* We ran into the same problem that we ran into with generic typing of MyIterator. We realized that we were trying to use a default constructor for LLNode, when the class only has an overloaded constructor.
* For classes like Stack and Queue, does it even make sense to have a toString() method? Does having a toString() method defeat the purpose of only being able to view a certain end of the list? We noticed that toString() was not in the Queue interface.
* We discovered that quasar stands for "quasi-stellar radio source."
**/

public class NQDriver{
    public static void main(String[] args){
        NodeQueue<String> testQ = new NodeQueue<String>();
        System.out.println(testQ.isEmpty()); //should be true
        testQ.enqueue("one"); 
        System.out.println(testQ.peekFront()); //should be one
        testQ.enqueue("two");
        System.out.println(testQ.peekFront()); //should be one
        testQ.enqueue("three");
        System.out.println(testQ.peekFront()); //should be one
        System.out.println(testQ.dequeue()); //should be one
        System.out.println(testQ.peekFront()); //should be two
        System.out.println(testQ.dequeue()); //should be two
        System.out.println(testQ.peekFront()); //should be three
        System.out.println(testQ.dequeue()); //should be three
    }
}