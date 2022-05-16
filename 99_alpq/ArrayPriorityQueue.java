/*
AKH+D :: Ariella Katz, Kaitlin Ho, Hugo Jenkins
APCS pd6
HW 99 - Some Are More Equal Than Others, Codified
2022-05-13
time spent: 1.0 hrs
*/

import java.util.*;

public class ArrayPriorityQueue {

  private ArrayList<Integer> _pq;

  public ArrayPriorityQueue() {
    _pq = new ArrayList<Integer>();
  }

  //O(1)
  public void add(Integer x) {
    _pq.add(x);
  }

  //O(1)
  public boolean isEmpty() {
    return (_pq.size() == 0);
  }

  //O(n)
  public Integer peekMin() {
    if (!isEmpty()) {
      Integer min = Integer.MAX_VALUE;
      for (int i = 0; i < _pq.size(); i++) {
        if ((int) _pq.get(i) < (int) min) {
          min = _pq.get(i);
        }
      }
      return min;
    }
    else {
      return null; //returns null if the whole thing is empty
    }
  }

  //O(n)
  public Integer removeMin() {
    if (!isEmpty()) {
      int minInd = 0;
      for (int i = 0; i < _pq.size(); i++) {
        if ((int) _pq.get(i) < (int) _pq.get(minInd)) {
          minInd = i;
        }
      }
      return _pq.remove(minInd);
    }
    else {
      return null; //returns null if it's already empty
    }
  }

  public static void main(String[] args) {
    ArrayPriorityQueue dn = new ArrayPriorityQueue();
    dn.add(5);
    dn.add(3);
    dn.add(4);
    dn.add(7);
    dn.add(8);
    dn.add(1);
    System.out.println("dn: "+  dn);

    System.out.println();
    System.out.println("min: " + dn.peekMin());
    System.out.println("removeMin: " + dn.removeMin());
    System.out.println("min: " + dn.peekMin());
    System.out.println("removeMin: " + dn.removeMin());
    System.out.println("min: " + dn.peekMin());
    System.out.println("removeMin: " + dn.removeMin());

    System.out.println();
    System.out.println("dn: "+  dn);
  }

}
