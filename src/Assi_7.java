import java.util.*;

class Assi_7 {

    private final String accountNumber;
    private String accountHolderName;
    protected double balance;

    public Assi_7(String accountNumber, String accountHolderName,
            double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void changeAccountHolderName(String newName) {
        this.accountHolderName = newName;
    }

    public void chargeFee(double feeAmount) {
        balance -= feeAmount;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "\nAccount Holder: "
                + accountHolderName + "\nBalance: ₹" + balance;
    }

    public static void main(String[] arcs) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter your name: ");
        String accountHolderName = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        Assi_7 account = new Assi_7(accountNumber,
                accountHolderName, initialBalance);
        System.out.println("\nAccount created successfully!\n");
        while (true) {
            System.out.println("\nChoose an option:\n");
            System.out.println("1. Deposit\n");
            System.out.println("2. Withdraw\n");
            System.out.println("3. Change Account Holder's Name\n");
            System.out.println("4. Charge Fee\n");
            System.out.println("5. Print Account Summary\n");
            System.out.println("6. Exit\n");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful.\n");
                    break;
                case 2:
                    System.out.print("Enter the withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful.\n");
                    } else {
                        System.out.println("Insufficient balance.\n");
                    }
                    break;
                case 3:
                    System.out.print("Enter the new account holder's name: ");
                    scanner.nextLine(); // Consume the newline character
                    String newName = scanner.nextLine();
                    account.changeAccountHolderName(newName);
                    System.out.println("Account holder's name changed.");
                    break;
                case 4:
                    System.out.print("Enter the fee amount: ");
                    double feeAmount = scanner.nextDouble();
                    account.chargeFee(feeAmount);
                    System.out.println("Fee charged.");
                    break;
                case 5:
                    System.out.println(account);
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class SavingsAccount extends Assi_7 {

    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance, double interestRate) {
        super(accountNumber, accountHolderName, initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
    }

    @Override
    public String toString() {
        return super.toString() + "\nAccount Type: Savings";
    }
}


class CurrentAccount extends Assi_7 {

    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolderName, double initialBalance, double overdraftLimit) {
        super(accountNumber, accountHolderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAccount Type: Current";
    }
}
