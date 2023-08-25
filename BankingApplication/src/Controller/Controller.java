package Controller;

import java.util.InputMismatchException;
/* Class Imported */
import Main.LaunchBanking;
import Model.FunctionImpl;

/* Interface Implemented for Overriding */
public class Controller implements FunctionImpl {

    java.util.Scanner scan = new java.util.Scanner(System.in);
    /* User Registetration Credentials */
    static String name;
    static String userName;
    static Integer pw;
    /* Members for transactions */
    static Integer balance = 0;
    public Integer deposit = 0;
    static Integer withdrawl = 0;

    /* Registetration Method */
    @Override
    public boolean register() {
        System.out.println("Open Account with us");
        System.out.println("Enter your Full Name");
        name = scan.nextLine();
        System.out.println("Enter a User Name: ");
        userName = scan.nextLine();
        System.out.println("Enter your PassWord: ");
        pw = scan.nextInt();
        System.out.println("Your Banking Details Are");
        System.out.println("-------------------------");
        System.out.println("Your Name: " + name);
        System.out.println("Your userName: " + userName);
        System.out.println("Your pw: " + pw);
        return true;
    }

    /* Login Method */
    @Override
    public boolean logIn() {
        System.out.println("Enter userName: ");
        String Name = scan.next();
        System.out.println("Enter PW: ");
        Integer pww = scan.nextInt();

        if (userName.equals(Name) && pw.equals(pww)) {
            System.out.println("Details Correct");
            System.out.println("Logged In Successfull");
        } else {
            throw new UnsupportedOperationException("Oh\" Wrong details! \'Try again\'");
        }
        return false;
    }

    /* Balance Checking Method */
    @Override
    public void chekBalance() {
        if (LaunchBanking.bal > 0) {
            balance += LaunchBanking.bal;
            LaunchBanking.bal = 0;
            System.out.println("Your Updated A/c Balance Is: " + balance);
        } else {
            balance -= withdrawl;
            System.out.println("Your A/c Balance Is " + balance);
        }
    }

    /* Deposit Method */
    @Override
    public Integer deposit(Integer deposit) {
        this.deposit = deposit;
        return deposit;
    }

    /* Withdrawl Method */
    @Override
    public void withdrawl() {
        try {
            if (balance == 0) {
                System.out.println("Your don't have funds");
            } else {
                System.out.println("Enter the amount you want to Withdraw");
                withdrawl = scan.nextInt();
                System.out.println("Amount withdrawn " + withdrawl);
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Wrong entry for 'withdrawl'");
        }
    }

}
