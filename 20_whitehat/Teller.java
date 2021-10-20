/*
NIWWD: Kevin Xiao + Mr. Swag, Jeffery Tang + Mathias, Kaitlin Ho + Apple 
APCS
HW20 -- External Audit
2021-10-20
DISCO:
1. Removed ; on line 87 after parameters (all of the below statements only apply after this revision)
2. When entered 999999999 and 9999 for the accountnumber and pin, there was no error message
returned.
3. Withdraw works.
4. Authenticate has full functionality
5. Prints out error message if pin is not a 4 digit number, and also prints out an error message if account number is not 9 digits.
6. They can have negative balance, doesn't make sense in a context where you can't withdraw more than you have.
7. When you withdraw a negative number, it adds to your account balance. This makes sense mathematically because you are subtracting a negative from your bank
account but it doesn't make sense in a bankAccount context.
8. When you deposite a negative number, it subtracts from your account balance. It also goes through and allow your balance to go into the negatives.
9. It might not be able to utilize objects created in BankAccount.java's main() method in Teller.java
QCC:
How would we implement a method into our code to prevent a negative number in our balance account?
*/
public class Teller{
  public static void main(String[] args){
  BankAccount NIWWD = new BankAccount();
    NIWWD.setPin((short)9999);
    NIWWD.setAcctNum(999999999);
    NIWWD.setPasswd("Hello World!");
    NIWWD.setName("Mykolyk");
    NIWWD.setBalance(123214);
    NIWWD.withdraw(1000000000);
    NIWWD.deposit(123123103);
    //Overloading
    NIWWD.setPin((short)1234);
    // Testing good password + good account number
    System.out.println(NIWWD.authenticate(999999999, "Hello World!"));
    // Testing good password + bad account number
    System.out.println(NIWWD.authenticate(999999989, "Hello World!"));
    // Testing bad password + good account number
    System.out.println(NIWWD.authenticate(999999999, "Hello Wrld!"));
    // Testing bad password + bad account number
    System.out.println(NIWWD.authenticate(999988999, "Hello Word!"));
    System.out.println(NIWWD.toString());
    //New objects but with bad arguments
    BankAccount Thinkeren = new BankAccount();
    Thinkeren.setPin((short)123);
    Thinkeren.setAcctNum(21345);
    Thinkeren.setPasswd("213");
    Thinkeren.setName("001");
    Thinkeren.setBalance(-004);
    Thinkeren.withdraw(-123213);
    Thinkeren.deposit(-213123);
    System.out.println(Thinkeren.toString());
    }
}
