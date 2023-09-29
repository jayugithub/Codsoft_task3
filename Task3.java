import java.util.Scanner;

public class ATM {
    private static Scanner scanner = new Scanner(System.in);
    private static double balance = 1000.0; // Starting balance for demonstration purposes

    public static void main(String[] args) {
        showWelcomeScreen();

        int option;
        do {
            showMenu();
            option = getChoice();
            handleOption(option);
        } while (option != 4);

        System.out.println("Thank you for using the ATM. Have a nice day!");
    }

    private static void showWelcomeScreen() {
        System.out.println("Welcome to the ATM!");
    }

    private static void showMenu() {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    private static int getChoice() {
        int choice;
        do {
            System.out.print("Enter your choice (1-4): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter your choice (1-4): ");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 4);
        return choice;
    }

    private static void handleOption(int option) {
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                depositMoney();
                break;
            case 3:
                withdrawMoney();
                break;
            case 4:
                // Exit, handled in the main loop
                break;
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance: $" + balance);
    }

    private static void depositMoney() {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Deposited $" + amount + " successfully.");
    }

    private static void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal canceled.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " successfully.");
        }
    }
}