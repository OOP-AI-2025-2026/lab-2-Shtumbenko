package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee = 0.0;

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        double totalAmount = amount + transactionFee;
        if (totalAmount <= balance) {
            balance -= totalAmount;
            return true;
        }
        return false;
    }

    public boolean transfer(BankAccount receiver, double amount) {
        if (amount <= 0) {
            return false;
        }
        double totalAmount = amount + transactionFee;
        if (this.balance >= totalAmount) {
            this.balance -= totalAmount;
            receiver.deposit(amount); // Комісія не застосовується до отримувача
            return true;
        }
        return false;
    }

    public void setTransactionFee(double fee) {
        if (fee >= 0) {
            this.transactionFee = fee;
        }
    }
}
