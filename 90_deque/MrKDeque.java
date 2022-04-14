/*
Mr. K: May Qiu, Raven (Ruiwen) Tang, Kaitlin Ho
APCS pd6
HW90 -- Swabbing the Deque / implementing Deque in compliance with interface
2022-04-12
time spent: 1.0 hr
*/

import java.util.LinkedList;
import java.util.Iterator;

public class MrKDeque<D> implements Deque<D>{
    private LinkedList<D> _baaha;

    public MrKDeque(){
        _baaha = new LinkedList<D>();
    }

    public int size(){
        return _baaha.size();
    }

    public void addLast(D x){
        _baaha.addLast(x);
    }

    public boolean add(D x){
    	addLast(x);
    	return true;
    }
    
    public boolean offer(D x){
    	return add(x);
    }
    
    public boolean offerLast(D x){
    	return offer(x);
    }
    
    public void addFirst(D x){
        _baaha.addFirst(x);
    }
    
    public boolean offerFirst(D x){
    	addFirst(x);
    	return true;
    }

    public void push(D x){
        addFirst(x);
    }
    
    public D peekFirst(){
        return _baaha.getFirst();
    }
    
    public D element(){
    	return peekFirst();
    }
    
    public D getFirst(){
    	return peekFirst();
    }
    
    public D peek(){
    	return peekFirst();
    }

    public D peekLast(){
        return _baaha.getLast();
    }
    
    public D getLast(){
    	return peekLast();
    }

    public D removeFirst(){
        return _baaha.removeFirst();
    }
    
    public D poll(){
    	return removeFirst();
    }
    
    public D pollFirst(){
    	return removeFirst();
    }

    public boolean remove(){
        removeFirst();
        return true;
    }

    public D pop(){
        return removeFirst();
    }

    public D removeLast(){
        return _baaha.removeLast();
    }

    public D pollLast(){
        return _baaha.removeLast();
    }

    public boolean contains(D x){
        return _baaha.contains(x);
    }

    public boolean remove(D x){
        return _baaha.remove(x);
    }

    public boolean removeFirstOccurrence(D x){
        return remove(x);
    }

    public boolean removeLastOccurrence(D x){
        return _baaha.removeLastOccurrence(x);
    }

    public Iterator<D> iterator(){
        return _baaha.iterator();
    }

    public Iterator<D> descendingIterator(){
        return _baaha.descendingIterator();
    }
}
