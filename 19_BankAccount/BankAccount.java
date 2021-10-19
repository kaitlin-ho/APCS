/**
   NIWWD: Kevin Xiao + Mr. Swag, Jeffery Tang + Mathias, Kaitlin Ho + Apple 
   APCS
   HW19 -- Better BankAccount in Java
   2021-10-19
**/

/**
   DISCO: We can use boolean if statements within methods. We have to declare our variables outside of our if statements.
   QCC: When we put our return line before our print line, why didn't we return anything?
   How would we allow the user to input into the machine? (How would we implement scanners into our program?)
   Is there any way to cheat our authentication?
   
   How to return 
**/

public class BankAccount {

  //instance variables
  private String name;
  private String passwd;
  private short pin;
  private int acctNum;
  private double balance;
  //---------------------------------------------


  //mutators
  public String setName( String newName ) {
    String oldName = name;
    name = newName;
    return oldName;
  }

  public String setPasswd( String newPasswd ) {
    String oldPasswd = passwd;
    passwd = newPasswd;
    return oldPasswd;
  }

  public short setPin( short newPin ) {
    short oldPin = pin;
    if ((newPin >= 1000) && (newPin <= 9998)) {
      pin = newPin;
    }
     else {
        System.out.println("The entered PIN is not a four digit number, please enter a four digit number");
        pin = 9999;
   }
    return oldPin;
  }

  public int setAcctNum( int newAcctNum ) {
    int oldAcctNum = acctNum;
    if ((newAcctNum >= 100000000) && (newAcctNum <= 999999998)) {
      acctNum = newAcctNum;
    }
    else {
       System.out.println("The entered Account Number is not a 9 digit number; please enter a 9 digit number");
       acctNum = 999999999;
   }
    return oldAcctNum;
  }

  public double setBalance( double newBalance ) {
    double oldBalance = balance;
    balance = newBalance;
    return oldBalance;
  }
  //---------------------------------------------


  public void deposit( double depositAmount ) {
    balance = balance + depositAmount;
  }

  public boolean withdraw( double withdrawAmount ) {
    if (withdrawAmount <= balance){
      balance = balance - withdrawAmount;
      return true;
  }
    else {
       System.out.println("There are not enough sufficient funds to be withdrawn.");
       return false;
    }
  }
 public boolean authenticate(int accountNum, String password){
       return acctNum == accountNum && passwd == password;
  }


  //overwritten toString()
  public String toString() {
    String retStr = "\nAccount info:\n=======================";
    retStr = retStr + "\nName: " + name;
    retStr = retStr + "\nPassword: " + passwd;
    retStr = retStr + "\nPIN: " + pin;
    retStr = retStr + "\nAccount Number: " + acctNum;
    retStr = retStr + "\nBalance: " + balance;
    retStr = retStr + "\n=======================";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args ) {
    BankAccount ba = new BankAccount();
    ba.setName("John");
    ba.setPasswd("hellotheremyfriends");
    ba.setPin((short) 2131);
    ba.setAcctNum(123456789);
    ba.setBalance(1000.00);
    ba.deposit(500.0);
    ba.withdraw(241.0);
    System.out.println(ba.toString());
    System.out.println("Bad TestID and bad password.");
    System.out.println(ba.authenticate(123213512,"holacomaestas!"));
    System.out.println("Good TestID and bad password.");
    System.out.println(ba.authenticate(123456789,"holacomaestas!"));
    System.out.println("Bad TestID and good password.");
    System.out.println(ba.authenticate(121235,"hellotheremyfriends"));
    System.out.println("Good TestID and good password.");
    System.out.println(ba.authenticate(123456789, "hellotheremyfriends"));
     
    BankAccount TEST1 = new BankAccount();
    TEST1.setName("TEST1");
    TEST1.setPasswd("testpassword");
    TEST1.setPin((short) 3333);
    TEST1.setAcctNum(1234567891);
    TEST1.setBalance(1.0);
    TEST1.deposit(0.0);
    TEST1.withdraw(200.0);
    System.out.println(TEST1.toString());
  }

}
