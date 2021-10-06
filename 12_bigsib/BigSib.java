/*Kaitlin Ho, Brian Li; Duckies: Apple, Robert
APCS
HW12 - On Elder Individuality and the Elimination of Radio Fuzz
2021-10-05
Worked with Ariella, Ziying

DISCOVERIES
- System.out.print works with void
- you cannot use instanced variables with static

UNRESOLVED QUESTIONS
- What is an instanced variable?(actual definition)
- How do you use an instanced variable helloMsg AND print the rest of the message? e.g. after Word Up Freshmen

My partner's code: 
public class BigSib{
 String helloMsg;
 
  public String greet(String name){
    return(helloMsg + " " + name);
  }
 
  public void setHelloMsg(String msg){
   helloMsg = msg;
  }
 
}

The above uses the instanced variable and works, but I couldn't seem to add the rest of the message onto it, because 
of the type (void, String). The below is what I did to get the desired output, but does not use the instanced variable.

*/



public class BigSib {
	public static void setHelloMsg(String msg){
		System.out.print(msg + " ");
}
	public static String greet(String msg2){
		String s = msg2 + "\nSalutations Dr. Spaceman" + "\nHey ya Kong Fooey" + "\nSup mom";
		return s;
}


}


