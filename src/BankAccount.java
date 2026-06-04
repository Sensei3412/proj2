public class BankAccount {

    private String accountNumber;
    private double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposits(double amount) {
        if (amount > 0) {
            balance += amount; 
            System.out.println("Deposited: PHP " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) { 
            balance -= amount; 
            System.out.println("Withdrew: PHP " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: PHP " + balance);
    }
}