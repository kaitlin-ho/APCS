public static void zoop() {
    baffle();
    System.out.print("You wugga ");
    baffle();
}

public static void main(String[] args) {
    System.out.print("No, I ");
    zoop();
    System.out.print("I ");
    baffle();
}

public static void baffle() {
    System.out.print("wug");
    ping();
}

public static void ping() {
    System.out.println(".");
}

/*
1)  ping prints . and baffle prints wug.
  Full output:
  No I wug.
  You wugga wug.
  I wug.

2)
  main |
  zoop |
  baffle |
  ping |

3) loop? or error / wont run to completion because they will invoke each other

*/
