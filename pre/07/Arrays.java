
  public class Arrays {
    /*  public static void powArray(double[] a, int n){
          int i  = 0;
          int arrayLength = a.length;
          String finalString = "{ ";
          while (i < (arrayLength - 1)) {
              double num = a[i];
              double numPow = num;
              int j = 1;
              while (j < n) {
                  numPow = num * numPow;
                  j = j + 1;
              }
              finalString = finalString + numPow + ", ";
              i = i + 1;
          }
          double numEnd = a[arrayLength - 1];
          int k = 1;
          double numEndPow = numEnd;
          while (k < n) {
              numEndPow = numEnd * numEndPow;
                  k = k + 1;
              }
          finalString = finalString + numEndPow;
          System.out.println(finalString + " }");
      }



    /*  public static void indexOfMax(int[] x){
        int[] array2 = {2, 4, 5, 1};
        int count = array2[0];
        int index1 = -1;
        for (int i : array2){
        index1 = index1 + 1;
          if (array2[i] > count){
            count = array2[i];
            if index1
          }
        }
        System.out.print(index1);
      }

*/

    public static void indexOfMax(int[] x){
        int[] array2 = {9,0,1,20,0,200};
        int count = array2[0];
        int index1 = -1;
        for (int i = 0; i<x.length; i++){
          count = array2[i];
          index1 ++;
          }
        System.out.println(index1);
      }

    public static void sieve(int n){
      boolean[] primecheck = []
      
    }

      public static void main(String[] args) {
          int[] array2 = {9,0,1,20,0,200};
          //double[] array = {1.0, 2.0, 3.0};
          //powArray(array, 3);
          indexOfMax(array2);
      }

  }
