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

public class NodeQueue<QUASAR> implements Queue<QUASAR>{

    private LLNode<QUASAR> _front;

    public NodeQueue(){
        _front = null;
    }

    public QUASAR dequeue(){
        if(isEmpty()){
            return null;
        }
        QUASAR saveVal = _front.getCargo();
        _front = _front.getNext();
        return saveVal;
    }

    public void enqueue( QUASAR x ){
        if(isEmpty()){
            _front = new LLNode(x, null);
        }
        else{
            LLNode<QUASAR> temp = _front;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            LLNode<QUASAR> addedNode = new LLNode(x, null);
            temp.setNext(addedNode);
        }
    }

    public boolean isEmpty(){
        return _front == null;
    }

    public QUASAR peekFront(){
        return _front.getCargo();
    }

}