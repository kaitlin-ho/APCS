/*
AKH+D :: Ariella Katz, Kaitlin Ho, Hugo Jenkins
APCS pd6
HW 99 - Some Are More Equal Than Others, Codified
2022-05-13
time spent: 1.0 hrs
*/

public interface PriorityQueue<Integer> {

  public void add(Integer x);
  public boolean isEmpty();
  public Integer peekMin();
  public Integer removeMin();

}
