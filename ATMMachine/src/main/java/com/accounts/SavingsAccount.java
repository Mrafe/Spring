package com.accounts;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(int accNum, String accHolder, double accBalance) {
        super(accNum, accHolder, accBalance);
    }

    @Override
    public double withdraw(double amount) {
        if (amount > super.getAccBalance()) {
            return -1;
        }
        if (amount > 30000) {
            return 0;
        }
        super.setAccBalance(super.getAccBalance() - amount);
        return super.getAccBalance();
    }

    @Override
    public double deposit(double amount) {
        if (amount > 1000000) {
            return -1;
        }
        super.setAccBalance(super.getAccBalance() + amount);
        return super.getAccBalance();
    }
}