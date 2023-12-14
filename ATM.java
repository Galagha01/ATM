import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to The Bank Of Alagha");

        // Initialization
        String restart = "Y";
        int chances = 3;
        float balance = 1000000000;

        // Main loop for login attempts
        while (chances >= 0) {
            // User input for PIN
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your four-digit PIN: ");
            int pin = scanner.nextInt();

            if (pin == 1234) {
                System.out.println("You entered your PIN correctly\n");

                // Inner loop for banking operations
                while (!restart.equalsIgnoreCase("n")) {
                    // Display options
                    System.out.println("Please Press 1 to Check your Balance");
                    System.out.println("Please Press 2 to Make Withdrawal");
                    System.out.println("Please Press 3 to Deposit");
                    System.out.println("Please Press 4 to Return Card");

                    System.out.print("What would you like to choose? ");
                    int option = scanner.nextInt();

                    // Option 1: Check Balance
                    if (option == 1) {
                        System.out.println("Your Balance is $ " + balance + "\n");
                        System.out.print("Would you like to go back? ");
                        restart = scanner.next();
                        if (restart.equalsIgnoreCase("n")) {
                            System.out.println("Thank you for your time :)");
                            break;
                        }
                    }
                    // Option 2: Make Withdrawal
                    else if (option == 2) {
                        System.out.print("How much would you like to withdraw? \n "
                                + "$10 $20 $30 $40 $50 $60 $70 $80 $90 $100 for other enter 1: ");
                        float withdrawal = scanner.nextFloat();

                        if (withdrawal == 1) {
                            System.out.print("Please Enter Your Desired Amount: $ ");
                            withdrawal = scanner.nextFloat();
                        } else if (withdrawal >= 10 && withdrawal <= 100) {
                            System.out.println("Your withdrawal of $" + withdrawal + " has been successful");
                            balance -= withdrawal;
                            System.out.println("\nYour Balance is now $" + balance);
                        } else {
                            System.out.println("Invalid amount, Please Re-try\n");
                            restart = "Y";
                            continue;
                        }

                        // Ask user if they want to go back
                        System.out.print("Would you like to go back? ");
                        restart = scanner.next();
                        if (restart.equalsIgnoreCase("n")) {
                            System.out.println("Thank you");
                            break;
                        }
                    }
                    // Option 3: Deposit
                    else if (option == 3) {
                        System.out.print("How much would you like to pay in? $");
                        float deposit = scanner.nextFloat();
                        balance += deposit;
                        System.out.println("\nYour Balance is $ " + balance);
                        
                        // Ask user if they want to go back
                        System.out.print("Would you like to go back? ");
                        restart = scanner.next();
                        if (restart.equalsIgnoreCase("n")) {
                            System.out.println("Thank you");
                            break;
                        }
                    }
                    // Option 4: Return Card
                    else if (option == 4) {
                        System.out.println("Please wait whilst your card is returned...");
                        System.out.println("Thank you for your service");
                        break;
                    }
                    // Invalid option
                    else {
                        System.out.println("Please Enter a correct number.\n");
                        restart = "y";
                    }
                }
            } else {
                // Incorrect PIN message
                System.out.println("Incorrect password\nTry again");
                chances--;
                if (chances == 0) {
                    System.out.println("\nNo more tries for you");
                    break;
                }
            }
        }
    }
}
