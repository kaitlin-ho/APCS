/**
   NIWWD: Kevin Xiao + Mr. Swag, Jeffery Tang + Mathias, Kaitlin Ho + Apple 
   APCS
   HW26 -- GCD Three Ways
   2021-10-27
   time spent: 0.5 hours
**/

/**
   DISCO:
   When finding the GCD of a pair of numbers, the GCD for that pair is the same GCD for the smaller number of the pair and the bigger number minus the
   smaller number. Therefore, we can find the GCD of a pair of numbers if we keep replacing the bigger number of the pair with the bigger number minus the
   smaller one, until we get zero for one of the numbers. The other number will be our gcd.
   QCC:
   What is the logic behind gcd staying same even if we subtract smaller number from bigger number?
   Algo:
   We keep subtracting the smaller number from the bigger number out of the pair, and then taking the GCD of those too numbers. We continue
   this process until we reach 0 with one of the numbers, and then the other number that is nonzero will be our GCD. If the two numbers are equal at any time
   of the process, then that number will just be the GCD.
**/


public class Stats {
 
  public static int gcd(int a, int b) {
    int counter = 1;
    int g = 1;
    if (a > b) {
      while (counter <= b) {
        if (a % counter == 0 && b % counter == 0) {
          g = counter;
        }
        counter += 1;
      }
    }
    else {
      while (counter <= a) {
        if (a % counter == 0 && b % counter == 0) {
          g = counter;
        }
        counter += 1;
      }
    }
    return g;
  }
  public static int gcdER(int a, int b) {
     // If a is our bigger number and both a and b are bigger than 0, we take the smaller number (b) and the bigger number (a) minus the smaller one (b)
     if (a > b && b > 0){
        return gcdER(b, (a - b));
     // When b reaches 0, we return the other number (a)
     }else if(b == 0){
        return a;
     }
     // If a is our bigger number and both a and b are bigger than 0, we take the smaller number (b) and the bigger number (a) minus the smaller one (b)
     else if (a < b && a > 0){
        return gcdER(a, (b - a));
     // Then a will reach 0 first, so we return b.
     }else{
        return b;
     }
  }
  
  public static int gcdEW(int a, int b) {
     while (a > 0 && b > 0){
        if (a < b){
           b = b - a;
        }else if (a > b){
           a = a - b;
        }else{
           return a;
        }
     }
     if (a == 0){
        return b;
     } else {
        return a;
     } 
  }
  public static void main(String[] args) {
    System.out.println("gcd test:");
    System.out.println(gcd(3, 3));
    System.out.println(gcd(3, 6));
    System.out.println(gcd(6, 10));
    System.out.println(gcd(1000, 870));
    System.out.println("gcdER test:");
    System.out.println(gcdER(3, 3));
    System.out.println(gcdER(3, 6));
    System.out.println(gcdER(6, 10));
    System.out.println(gcdER(1000, 870));
    System.out.println("gcdEW test:");
    System.out.println(gcdEW(3, 3));
    System.out.println(gcdEW(3, 6));
    System.out.println(gcdEW(6, 10));
    System.out.println(gcdEW(1000,870));
  }
}
