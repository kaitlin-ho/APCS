// Team Four {Fang, Kaitlin, Jing}
// APCS pd06
// HW40 -- 2D arrays
// 2021-11-30SS

/*
DISCO:
- Foreach loops are very handy for printing arrays in arrays (2D arrays)

QCC:
- What do 3D arrays look like? Would it be an array in an array in an array? Or something different?
- Would the process for printing and summing 3D arrays be similar to those for 1D and 2D arrays?
- Can a 2D array have certain indexes null? For example: a[1][2] is 2 but a[1][3] is null. (Most likely)
*/

public class TwoDimArray
{
  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOR loop
  public static void print1( int[][] a )
  {
    for (int r = 0; r < a.length; r ++) {
      for (int c = 0; c < a[r].length; c ++) {
        System.out.print(a[r][c]);
      }
    System.out.print("\n");
    }
  }


  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOREACH loop
  public static void print2( int[][] a )
  {
    for (int[] b: a) {
      for (int c: b) {
        System.out.print(c);
      }
      System.out.print("\n");
    }
  }


  //postcond: returns sum of all items in 2D int array a
  public static int sum1( int[][] a )
  {
    int sum = 0;
    for (int[] b: a) {
      for (int c: b) {
        sum += c;
      }
    }
    return sum;
  }


  //postcond: returns sum of all items in 2D int array a
  //          * uses helper fxn sumRow
  public static int sum2( int [][] m )
  {
    int sum = 0;
    for (int i = 0; i < m.length; i++) {
      sum += sumRow2(i, m);
    }
    return sum;
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOR loop
  public static int sumRow( int r, int[][] a )
  {
    int sum = 0;
    for (int i = 0; i < a[r].length; i ++) {
      sum += a[r][i];
    }
    return sum;
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOREACH loop
  public static int sumRow2(int r, int[][] m)
  {
    int summer = 0;
    for (int num: m[r]) {
      summer += num;
    }
    return summer;
  }


  public static void main( String [] args )
  {

    int [][] m1 = new int[4][2];
    int [][] m2 = { {2,4,6}, {3,5,7} };
    int [][] m3 = { {2}, {4,6}, {1,3,5} };
    print1(m1);
    print1(m2);
    print1(m3);
    print2(m1);
    print2(m2);
    print2(m3);

    System.out.print("testing sum1...\n");
    System.out.println("sum m1 : " + sum1(m1));
    System.out.println("sum m2 : " + sum1(m2));
    System.out.println("sum m3 : " + sum1(m3));
    System.out.print("testing sum2...\n");
    System.out.println("sum m1 : " + sum2(m1));
    System.out.println("sum m2 : " + sum2(m2));
    System.out.println("sum m3 : " + sum2(m3));

  // your own custom test cases welcomed and encouraged
  }

}//end class TwoDimArray
