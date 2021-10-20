/*
Nafiz Labib, Jing Yi Feng, Jomin Zhang - Heroes of the Zeroes
APCS
HW 19 - Mo Money Mo Problems...MORE AWESOME
2021-10-18
DISCO -
 - Creating an instance variable with type boolean does not help when trying to return boolean values, because Java tries converting int and String to boolean, which it can't.
Instead, just return true and false depending on if conditions are met, then print out result by adding ba.authenticate() method in the parentheses.
QCC -
 - How compound can if methods be (there's two so far, if and else)?
 */

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
    if (newPin >= 1000 && newPin <= 9999){
      short oldPin = pin;
      pin = newPin;
      return oldPin;
    }
    else{
      short oldPin = pin;
      pin = (short)9999;
      System.out.println("PIN should be set as a 4 digit combination, has been set to 9999 by default");
      return oldPin;
    }
  }

  public int setAcctNum( int newAcctNum ) {
    if (newAcctNum >= 100000000 && newAcctNum <= 999999999){
      int oldAcctNum = acctNum;
      acctNum = newAcctNum;
      return oldAcctNum;
    }
    else {
      int oldAcctNum = newAcctNum;
      acctNum = 999999999;
      System.out.println("Account Number should be set as a 9 digit number, has been set to 999999999 by default");
      return oldAcctNum;
    }
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
    if (balance >= withdrawAmount){
      balance = balance - withdrawAmount;
      return true;
    }
    else {
      System.out.println("Not enough money in account");
      return false;
    }
  }
 // Deleted semicolon after enteredPasswd);
  public boolean authenticate(int enteredAccNum, String enteredPasswd){
    if (enteredAccNum == acctNum && enteredPasswd == passwd){
      return true;
    }
    else {
      return false;
    }
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

public static void main( String[] args ) {

    BankAccount ba = new BankAccount();
    ba.setName("BA");
    ba.setPasswd("bank");
    ba.setPin((short) 124);
    ba.setAcctNum(1234567);
    ba.setPin((short) 3333);
    ba.setAcctNum(123456789);
    ba.setBalance(10);
    ba.deposit(20.0);
    ba.withdraw(90.0);
    System.out.println(ba.toString());
    System.out.println("Account Login: " + ba.authenticate(123456789, "bank"));
    System.out.println("Account Login: " + ba.authenticate(101010101, "robber"));
  }
}
