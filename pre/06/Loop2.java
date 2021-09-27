public class Loop2{

public static void power(double x, int n){
  double current = x;
  while (n>1){
    current = current*x;
    n = n-1;
  }
  System.out.println(current);
}

public static void factorial(int a){
        int j = 1;
        int b = 1;
        while (j <= a){
            b = b * j;
            j = j + 1;
        }
        System.out.println(b);
    }

public static void myexp(int x, int n){
  double beginning = 1;
  int i = 1;
  double denominator = 1;
  double final2 = 1;
  double termx = 1;
  while (i <= n){
    i = i+1;
    termx = termx*x;
    denominator = denominator*i;
    final2 = final2 + termx/denominator;
  }
  System.out.println(1 + final2);
}



public static void main(String[] args){
  power(2,3);
  factorial(3);
  myexp(1,20);
}

}
