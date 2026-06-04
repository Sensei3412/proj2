public class SavingsAccount extends BankAccount {

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (getBalance() - amount < 1500) {
            System.out.println("Transaction Denied: Balance cannot fall below PHP 1,500.");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Withdrew: PHP " + amount + " from Savings Account.");
        }
    }
}