/*
NIWWD: Kevin Xiao + Mr. Swag, Jeffery Tang + Mathias, Kaitlin Ho + Apple
DISCO: We discovered that you can declare a new object within the main method, and then it also eliminates the need to have static in your methods.
Declaring a new object in the main method can allow you to initialize it using non-static methods inside a static context.
QCC: Why does the main method have to be static?
Why does printing the object sometime print the string representation and sometime print the BankAccount info?
How would we create a method that allows the user to create their own account via their own inputs?
Team NIWWD's Latest and Greatest Q2 Response: We know that Java provides a default contructor before we wrote our own constructor because we can call upon a new 
object in the main method without creating a constructor in our file. We can then also initialize all of the instance variables of our object within our main
method. Thus, we can assume that java provides for us a default constructor.
Team NIWWD's Latest and Greatest Q3 Response: We simply create an object and then run System.out.println(Object). For our specific object that we created,
we found that it prints out BankAccount@49476842, essentially a string representation of the object.
*/

public class BankAccount {
  public String holderName;
  private String accountPassword;
  private int pin;
  public int accountNumber;
  private double accBalance;

  private void withdraw (double withdrawAmount) {
    accBalance = accBalance - withdrawAmount;
    }
  private void deposit (double depositAmount) {
    accBalance = accBalance + depositAmount;
    }
  private String setHolderName (String name) {
    holderName = name;
    return holderName;
    }
  private int setAccountNumber (int accNum) {
    accountNumber = accNum;
    return accountNumber;
    }
  private String setAccountPassword (String accPW) {
    accountPassword = accPW;
    return accountPassword;
    }
  private int setPin (int accPIN) {
    pin = accPIN;
    return pin;
    }
  public double setBalance(double newBalance ) {
     accBalance = newBalance;
    return accBalance;
  }
  public String toString () {
    return("" + holderName + "\n" + accountNumber + "\n" + accBalance);
    }
  public static void main(String[] args) {
    BankAccount Account = new BankAccount ();
    Account.setHolderName("John");
    Account.setAccountPassword("hellotheremyfriends");
    Account.setPin(2131);
    Account.setAccountNumber(123456789);
    Account.setBalance(1000.00);
    Account.deposit(500);
    Account.withdraw(241);
    System.out.println(Account.toString());
    }
}
