//KHB: Kaitlin, Hugo; (duckies:) Boary, Apple
//APCS
//HW09 - What Are BigSibs
//2021-10-02

/*
DISCOVERIES
- Both java files have to be compiled using `javac` before it is able to run
- <class>.<method> runs the <method> in the file under name <class>
- `main` isn't needed here

UNRESOLVED QUESTIONS
- What is the difference between public/private class? Would this method work differently if the class was private rather than public?
- Does a method need a potential argument type (why is String[] args needed?)
*/

public class BigSib {
  public static void greet(String n){
    String s = "Why, hello, there, " + n + ". How do you do?";
    System.out.println(s);
  }
}
