/*
AKH+D :: Ariella Katz, Kaitlin Ho, Hugo Jenkins
APCS pd6
HW 103 - Erica's Friends, Hugo, and The One in the Middle
2022-05-18
time spent: 1.0 hrs
*/

import java.util.NoSuchElementException;

public class RunMed {

  ALHeapMax lilVals;
  ALHeapMin bigVals;

  public RunMed() {
    lilVals = new ALHeapMax();
    bigVals = new ALHeapMin();
  }

  public Integer getMedian() throws NoSuchElementException {
      if (lilVals.size() == bigVals.size()) {
        return (lilVals.peekMax() + bigVals.peekMin())/2;
      }
      else {
        if (lilVals.size() > bigVals.size()) {
          return lilVals.peekMax();
        }
        else {
          return bigVals.peekMin();
        }
      }
  }

  public void add(Integer newVal) {
    if (lilVals.size() == 0 && bigVals.size() == 0) {
      lilVals.add(newVal);
    }
    else if (bigVals.size() == 0) {
      bigVals.add(newVal);
    }
    else if (newVal < lilVals.peekMax()) {
      lilVals.add(newVal);
    }
    else {
      bigVals.add(newVal);
    }

    if (lilVals.size() > bigVals.size()+1) {
      while(lilVals.size() > bigVals.size()+1) {
        bigVals.add(lilVals.removeMax());
      }
    }
    else if (bigVals.size() > lilVals.size()+1) {
      while(bigVals.size() > lilVals.size()+1) {
        lilVals.add(bigVals.removeMin());
      }
    }
  }

}
