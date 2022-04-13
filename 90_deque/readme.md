# Mr. K: May Qiu, Raven (Ruiwen) Tang, Kaitlin Ho
APCS pd6  
HW90 -- Swabbing the Deque / implementing Deque in compliance with interface  
2022-04-12  
time spent: 1.0 hr

# To-do list
*based on complexity and importance*
1) isEmpty() -> size()  
    ...because this method can be tested on an empty Deque, does not require enqueueing or dequeueing
2) enqueueBack() -> addLast()  
    ...because we want to enqueue items before we try to peek any items or dequeue any items. Also, we begin with enqueueBack() because it is most similar to enqueueing for a Queue.
3) enqueueFront() -> addFirst()  
    ...because we want to enqueue items, and this method is one step away from what we already know for a Queue.
4) peekFront() -> peekFirst()  
    ...because we want to check items after we have enqueued them. We're also more familiar with peeking the front from Queue. 
5) peekBack()  
    ...because we want to check items. This method is one step away from peeking the front, which we already know for a Queue.
6) dequeueFront()  
    ...because we want to remove items after enqueueing them. We begin with dequeueFront() because it is nearly the same as dequeue() for Queue.
7) dequeueBack()  
    ...because we want to remove items after enqueueing them. This method is one step away from dequeueing at the front, which we already know for a Queue.
8) extra: contains(), removeFirstOccurrence(), Iterator methods, Stack methods, etc.
