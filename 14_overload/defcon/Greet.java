//BARK: Brian, Apple (ducky), Ryan, Kaitlin; Duckies: Jon, Vivian 
//APCS
//HW14 - Customize Your Creation
//2021-10-07

/*
DISCO
- Things in the default constructor can be overwritten 
- static before a variable means that it is shared across all instances of the class
	e.g. static String helloMsg would mean that the last new BigSib instance created (in this case it was "Salutations") would be used as the helloMsg for all 4 BigSibs 

QCC
- What is the purpose of making a method static versus making it nonstatic?

*/

public class Greet {
    public static void main(String[] args) {
        String greeting;

        BigSib richard = new BigSib();
        BigSib grizz = new BigSib();
        BigSib dotCom = new BigSib();
        BigSib tracy = new BigSib();

        greeting = richard.greet("freshman");
        System.out.println(greeting);

        greeting = tracy.greet("Dr. Spaceman");
        System.out.println(greeting);

        greeting = grizz.greet("Kong Fooey");
        System.out.println(greeting);

        greeting = dotCom.greet("mom");
        System.out.println(greeting);
    }
}
