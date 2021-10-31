public class hw28 {

//Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
  public static String helloName(String name) {
    String result;
      result = "Hello " + name + "!";
      return result;
    }

// Given two strings, a and b, return the result of putting them together in the order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi".
  public static String makeAbba(String a, String b) {
    String result;
      result = a + b + b + a;
      return result;
  }

  public static void main(String[] args) {
    System.out.println(helloName("Bob"));
    System.out.println(helloName("Alice"));
    System.out.println(helloName("X"));

    System.out.println(makeAbba("Hi", "Bye"));
    System.out.println(makeAbba("Yo", "Alice"));
    System.out.println(makeAbba("What", "Up"));
  }
}
