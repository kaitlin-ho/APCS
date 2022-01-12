//Kaitlin Ho + Apple
//APCS
//HW54 -- One File to Bring Them All
//2022-01-11
//time spent: 0.1

import java.util.ArrayList;

public class MySorts {

/*
BubbleSort Optimized
*/
  public static void exitBubble(ArrayList<Comparable> data) {
    for(int passes = 0; passes < data.size(); passes++) {
          boolean sorted = true;
          for(int index = data.size()-1; index > passes; index--) {
            if(data.get(index).compareTo(data.get(index-1)) <= 0) {
              Comparable temp = data.get(index);
              data.set(index, data.get(index-1));
              data.set(index-1, temp);
              sorted = false; 
            }
          }
          if(sorted) {
            break; // optimized 
          }
        }
      }

/*
InsertionSort
*/
  public static void insertion(ArrayList<Comparable> data) {
    for(int partition = 1; partition < data.size(); partition++) {

      for(int i = partition; i > 0; i--) {
        if ((data.get(i).compareTo(data.get(i-1)))<0) {
          Comparable x = data.get(i-1);
          data.set(i-1, data.get(i));
          data.set(i, x);
        }
        else
          break;
        }
      }
    }

/*
SelectionSort Algo
*/
  public static void selection(ArrayList<Comparable> data) {
    int maxPos = 0;
    for(int pass = 0; pass < data.size(); pass++) {
        maxPos=0;
      for(int i = 0; i < data.size()-pass; i++ ) {
        if (data.get(i).compareTo(data.get(maxPos))>0) {
          maxPos = i;
        }
      }
      Comparable x= data.get(data.size()-1-pass);
      data.set(data.size()-1-pass, data.get(maxPos));
      data.set(maxPos, x);
    }
  }

}
