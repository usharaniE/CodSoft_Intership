import java.util.Scanner;

public class ATM_Interface {
public static void main(String[] args) {
    //Initialize user's bank account with an initial balnce of Rs.1000.0
    BankAccount userAccount= new BankAccount(1000.0);
    //Create an ATM  object with the user's bank account
    ATM atm= new ATM(userAccount);
    //Main ATM Interface loop
     while(true){
        //print the ATM menu
        printMenu();
        Scanner sc=new Scanner(System.in);
        System.out.println("\u001B[36m Enter your choice:  \u001B[0m");
        int choice =sc.nextInt();
        //Process the user's choice
        atm.ProcessOption(choice);
     }
}

//Method to print the ATM menu

private static void printMenu() {
System.out.println("\u001B[33m****************************\u001B[0m"); //yellow color for border
System.out.println("\u001B[33m**            \u001B[32mWelcome To ATM \u001B[33m     **\u001B[0m");  //green color for header
System.out.println("\u001B[33m****************************\u001B[0m");
System.out.println("\u001B[36m1. Check Balance\u001B[0m");
System.out.println("\u001B[36m2. Withdraw\u001B[0m");
System.out.println("\u001B[36m3. Deposit\u001B[0m");
System.out.println("\u001B[36m4. Exit \u001B[0m");
System.out.println("\u001B[33m****************************\u001B[0m");
}
    }
    //class representing the users bank account

class BankAccount{
    private double balance; //Store the balance
    
    //Constructor to initialize the account with an initial balance  
    public BankAccount(double initialBalance) {
        this.balance=initialBalance;

    }

    //Method to get the account balance
public double getBalance(){
    return balance;

}
  //Method to deposite money into account 
  public void deposit(double amount){
    balance += amount;
    
  }
  // Method to withdraw money from the account
  //Return true if withdraw is successful. false if there are insufficient funds
  public boolean withdraw(double amount){
    if(balance >= amount){
        balance -= amount;
        return true;
    }else {
        return false;

    }
  }
}
//Class representing the ATM Machine
class ATM{
    private BankAccount account; //Reference to the user's bank account
   
    //Constructor to initialize the ATM with a user;s bank account
    public ATM(BankAccount account){
        this.account = account;
    }
      // method to process the user's  choice and perform corresponding actions
      public void ProcessOption(int option){
        Scanner sc= new Scanner(System.in);
        double amount ;// variable to store the transaction amount entered by the user


        //Switch statement to handle different user choices
        switch (option) {
            case 1:
                //display users balance
                System.out.println("\u001B[32mYour balance: RS" + account.getBalance() + "\u001B[0m" ); //green color for balance

                break;
            case 2:
                //Withdraw Money
                System.out.println("\u001B[36mEnter amount to withdraw: RS\u001B[0m" ); //cyan color for input text
                amount = sc.nextDouble();
                if(account.withdraw(amount)){
                    //withdraw successful
                    System.out.println("\u001B[32m withdrawal successful. Remaing balance: RS" + account.getBalance() + "\u001B[0m"); //green color for success mesg

                }else {
                    //Insufficient funds for withdrawal
                    System.out.println("\u001B[31mInsufficient funds. withdrawal failed.\u001B[0m");//Red color for error mesg

                }
                
                break;
            case 3:
                 //Deposit money
                 
                System.out.print("\u001B[36mEnter amount to deposite: RS\u001B[0m" ); //cyan color for input text
                amount = sc.nextDouble();
                account.deposit(amount);
                //Deposit successful
                System.out.println("\u001B[36m Deposit successful.Updated balance:  RS" + account.getBalance() + "\u001B[0m" ); //green color for success mesg
                
                break;
                case 4:
                //Exit the ATM Interface
                System.out.println("\u001B[32m Thank you for using the ATM. goodbye! \u001B[0m" ); //green color for exit mesg
                System.exit(0);
                
                break;

            default:
            //Invalid option 
            System.out.println("\u001B[31m Invalid option . please try agian.\u001B[0m");//REd color for error mesg
                break;
        }
      }

} 