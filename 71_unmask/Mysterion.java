public class Mysterion{

// Soggy Crackers: Kaitlin, Courtney, Ari
// APCS pd06
// HW71 -- Whut Dis
// 2022-3-7
// time spent: 0.5 hrs

/*
DISCO:
- Everything to the right of arr[c] is less than arr[c]

QCC:
- What is this function supposed to do?

q0:
- Separate numbers? Arrange them? 

q1: O(n) (one for loop)


v = arr[c]
swap arr[c], arr[b]
s = a
for i in [a..b-1]
  if arr[i] < v
    swap arr[s], arr[i]
    s+=1
swap arr[b], arr[s]
*/

//mysterious method
public static void mysterion(int[] array, int a, int b, int c){
  int v = array[c];
  swap(array, c, b);
  int s = a;
  for (int i = a; i <= b; i++){
    if (array[i] < v){
      swap(array, s, i);
      s += 1;

    }
  }
  swap(array, b, s);
}

//to use to swap elements in the array (just like in the psuedo code)
//swap array[x] with array[y]
public static void swap(int[] array, int x, int y){
  int save = array[x];
  array[x] = array[y];
  array[y] = save;
}

//so we can see what the final is
public static String toString(int[] a){
  String s = "";
  for (int i: a){
    s += i + ", ";
  }
  s= s.substring(0, s.length() - 2);
  return s;
}

public static void main( String[] args ){
  int[] arrayOne = {7, 1, 5, 12, 3};
  mysterion(arrayOne, 0, 4, 2);
  System.out.println(toString(arrayOne));

  int[] arrayTwo = {122, 12, 24, 2, 124};
  mysterion(arrayTwo, 0, 3, 1);
  System.out.println(toString(arrayTwo));

  int[] arrayThree = {1000, 1, 5, 12, 3, 2, 4, 153, 23};
  mysterion(arrayThree, 0, 8, 3);
  System.out.println(toString(arrayThree));

  int[] arrayFour = {1, 2, 7, 1, 5};
  mysterion(arrayFour, 0, 4, 2);
  System.out.println(toString(arrayFour));
}


}
