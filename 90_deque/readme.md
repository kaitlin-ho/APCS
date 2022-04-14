# Mr. K: May Qiu, Raven (Ruiwen) Tang, Kaitlin Ho  
APCS pd6  
HW90 -- Swabbing the Deque / implementing Deque in compliance with interface  
2022-04-12  
time spent: 1.0 hr


We chose to make our Deque based in LinkedList because it has faster add() runtimes than ArrayList and we have also started to like it more than ArrayList. We didn't throw any exceptions ourselves since LinkedList should handle any issues. In cases where we needed to return true if the method was possible and we used a pass-through method with different return type, we always returned true.

# To-do list
*based on complexity and importance*
1) isEmpty() -> size()  
    ...because this method can be tested on an empty Deque, does not require enqueueing or dequeueing  
2) enqueueBack() -> addLast()  
    ...because we want to enqueue items before we try to peek any items or dequeue any items. Also, we begin with enqueueBack() because it is most similar to enqueueing for a Queue.  
    We also grouped this method with add(D), offer(D), offerLast(D)
3) enqueueFront() -> addFirst()  
    ...because we want to enqueue items, and this method is one step away from what we already know for a Queue.  
    We also grouped this method with addFirst(), offerFirst(), push()
4) peekFront() -> peekFirst()  
    ...because we want to check items after we have enqueued them. We're also more familiar with peeking the front from Queue.  
    We also grouped this method with element(), getFirst(), peek()
5) peekBack() -> peekLast()
    ...because we want to check items. This method is one step away from peeking the front, which we already know for a Queue.  
    We also grouped this method with getLast()
6) dequeueFront() -> removeFirst()
    ...because we want to remove items after enqueueing them. We begin with dequeueFront() because it is nearly the same as dequeue() for Queue.  
    We also grouped this method with poll(), pollFirst(), remove(), pop()
7) dequeueBack() -> removeLast()
    ...because we want to remove items after enqueueing them. This method is one step away from dequeueing at the front, which we already know for a Queue.  
    We also grouped this method with pollLast()

8) contains(), remove(x), removeFirstOccurrence(x), removeLastOccurrence(x)  

9) iterator(), descendingIterator()
