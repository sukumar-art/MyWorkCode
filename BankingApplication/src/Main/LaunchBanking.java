package Main;

import java.util.InputMismatchException;
/* Class Imported */
import java.util.Scanner;
import Controller.Controller;

public class LaunchBanking {

    public static Integer bal = 0;
    /* Boolean Variale for Checking Login in True or False */
    static Boolean checkLogin;
    {
        System.out.printf("%80s", "\"Welcome to Banking Application\"" + "\n");
        System.out.printf("%79s", "------------------------------" + "\n");
    }
    /* Main Method */

    // public static void main(final String[] args) {
    public LaunchBanking() {
        try (Scanner scan = new Scanner(System.in)) {

            /* Registetration Module */
            do {
                System.out.println("Complete the registetration first");
            } while (!new Controller().register());
            {
                System.out.println("Registetration Successfull");
            }
            /* Iteration after Registetration */
            while (true) {

                System.out.println("Press 1 For Logging");
                final int i = scan.nextInt();
                if (i == 1)
                    try {
                        checkLogin = new Controller().logIn();
                        break;
                    } catch (final UnsupportedOperationException o) {
                        System.out.println(o.getMessage());
                        try {
                            checkLogin = new Controller().logIn();
                            break;
                        } catch (final UnsupportedOperationException o1) {
                            System.out.println(o1.getMessage());
                            try {
                                checkLogin = new Controller().logIn();
                                break;
                            } catch (final UnsupportedOperationException o2) {
                                System.out.println("Your are Blocked for 24hrs...");
                                break;
                            }
                        }
                    }
            }
            /* Module After LogIn */
            while (!checkLogin) {

                System.out.println("----------------------");
                System.out.println("Press 1 for Balance   Enquiry");
                System.out.println("Press 2 for Deposit   Amount");
                System.out.println("Press 3 for Withdrawl Amount");
                System.out.println("Press 4 for LogOut ");
                final int i = scan.nextInt();

                if (i == 1) {
                    new Controller().chekBalance();
                    continue;
                } else if (i == 2) {
                    // new LaunchBanking();
                    bal = LaunchBanking.setDeposit(new Controller()).deposit(scan.nextInt());
                    System.out.println("Amount: Deposited " + bal);
                    continue;
                } else if (i == 3) {
                    try {
                        new Controller().withdrawl();
                        continue;
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        try {
                            new Controller().withdrawl();
                            continue;
                        } catch (InputMismatchException e1) {
                            System.out.println("Try Entering Again");
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (i == 4) {
                    System.out.println("Happy Banking With Us...");
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong Entry: Try Digits");

        }
    }

    Controller c;

    /* Has a Relationship - Dependency Injection */
    public static Controller setDeposit(Controller c) {
        System.out.println("Enter Amount to Deposit: ");
        c.deposit(c.deposit);
        return c;
    }

}
