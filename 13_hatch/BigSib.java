// BestDuo -- Kaitlin, Brian Li; Duckles: Apple, Robert
// APCS
// HW13 -- Where do BigSibs Come From?
// 2021-10-06

/*
DISCO
 0. When assigning new <ClassName>() to the same variable again, it resets the class instance to its original state. 
 1. A constructor can accept arguments, similar to a method. The arguments can be supplied when initializing an instance of a class within the parentheses.
    
QCC
 0. Why is it necessary for the constructor to be public? And why does it have to be the same name of the class?
*/

public class BigSib{
  //instanced variable, empty string 
  String helloMsg;
 
  // constructor
  public BigSib(String msg){
   helloMsg = msg;
  }
 
  // methods
  public String greet(String name){
    return(helloMsg + " " + name);
  }
 
}
