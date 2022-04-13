/*
Mr. K: May Qiu, Raven (Ruiwen) Tang, Kaitlin Ho
APCS pd6
HW90 -- Swabbing the Deque / implementing Deque in compliance with interface
2022-04-12
time spent: 1.0 hr
*/

import java.util.LinkedList;

public class YourImplementationOfDeque<D> implements Deque<D>{
    private LinkedList<D> _baaha;

    public YourImplementationOfDeque(){
        _baaha = new LinkedList<D>();
    }

    public int size(){
        return _baaha.size();
    }

    public void addLast(D x){
        _baaha.addLast(x);
    }

    public void addFirst(D x){
        _baaha.addFirst(x);
    }

    public D peekFirst(){
        return _baaha.getFirst();
    }

    public D peekLast(){
        return _baaha.getLast();
    }

    public D removeFirst(){
        return _baaha.removeFirst();
    }

    public D removeLast(){
        return _baaha.removeLast();
    }
}