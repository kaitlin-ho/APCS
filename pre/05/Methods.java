// extra
public class Methods { // entire code

/*    public static void isDivisible(int n, int m){ // int params
        boolean a = true; // boolean describes a
        boolean z = false;
        if (n % m == 0) { // remainder stuff
            System.out.println(a); // prints a, which is true
        } else {
            System.out.println(z);
        }
    }


    public static void isTriangle(int b, int c, int d){ // 3 ints
        boolean e = true; // similar to the last
        boolean y = false;
        if (((b + c) > d) || ((c + d) > b) || ((d + b) > c)) {
            System.out.println(y);
        } else {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        isDivisible(4, 2);
        isTriangle(3, 4, 5);
    }

*/

    public static int ack(int m, int n){

      if (m == 0) {
        n = n+1;
        return (n);
      }

      if (m>0 && n==0) {
        m = m-1;
        n = 1;
        return ack(m,n);
      }

      if (m>0 && n>0) {
        return ack(m-1,ack(m,n-1));
      }

      else{
        return 0;
      }
    }

    public static void main(String[] args){
      System.out.println(ack(2,0));
      System.out.println(ack(3,2));
      System.out.println(ack(0,1));      //ack(0,1);
        //ack(2,0);
      //ack(3,2);
    }

}
