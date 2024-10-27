import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

class Transaction {
    String type;
    double amount;
    String date;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    @Override
    public String toString() {
        return type + " - " + String.format("%,.0f", amount) + " VND - " + date;
    }
}

class BankAccount {
    private String accountHolder;
    private double balance;
    private double monthlyInterestRate;
    private ArrayList<Transaction> transactionHistory;
    private int withdrawalCount;
    private final int MAX_WITHDRAWALS = 3;

    public BankAccount(String accountHolder, double initialBalance, double monthlyInterestRate) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.monthlyInterestRate = monthlyInterestRate;
        this.transactionHistory = new ArrayList<>();
        this.withdrawalCount = 0;
    }

    // Getter for accountHolder
    public String getAccountHolder() {
        return accountHolder;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount));
            System.out.println("Deposited " + String.format("%,.0f", amount) + " VND");
        }
    }

    public void withdraw(double amount) {
        if (withdrawalCount >= MAX_WITHDRAWALS) {
            System.out.println("Withdraw " + String.format("%,.0f", amount) + " VND - Error: You have reached the monthly withdrawal limit.");
            return;
        }

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            withdrawalCount++;
            transactionHistory.add(new Transaction("Withdraw", amount));
            System.out.println("Withdrew " + String.format("%,.0f", amount) + " VND");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void applyMonthlyInterest() {
        double interest = balance * monthlyInterestRate;
        balance += interest;
        transactionHistory.add(new Transaction("Interest Applied", interest));
    }

    public void printTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (int i = 0; i < transactionHistory.size(); i++) {
            System.out.println((i + 1) + ". " + transactionHistory.get(i));
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class EX5_7_Sol {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Nguyen Van A", 5000000, 0.0055);

        // Use getAccountHolder() instead of directly accessing accountHolder
        System.out.println("Created new account: " + account.getAccountHolder());
        System.out.println("Initial balance: " + String.format("%,.0f", account.getBalance()) + " VND");

        // Perform transactions
        account.deposit(1000000);
        account.withdraw(500000);
        account.withdraw(500000); // Attempting to withdraw again beyond limit
        account.withdraw(500000); // Will exceed withdrawal limit

        System.out.println("\nCurrent balance: " + String.format("%,.0f", account.getBalance()) + " VND");

        // Apply monthly interest
        account.applyMonthlyInterest();
        System.out.println("\nBalance after interest: " + String.format("%,.0f", account.getBalance()) + " VND");

        // Print transaction history
        account.printTransactionHistory();
    }
}
