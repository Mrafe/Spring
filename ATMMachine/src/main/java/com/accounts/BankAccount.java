package com.accounts;

public abstract class BankAccount {
	private int accNum;
	private String accHolder;
	private double accBalance;

	protected BankAccount(int accNum, String accHolder, double accBalance) {
		this.accNum = accNum;
		this.accHolder = accHolder;
		this.accBalance = accBalance;
	}

	public int getAccNum() {
		return accNum;
	}

	public String getAccHolder() {
		return accHolder;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public abstract double withdraw(double amount);

	public abstract double deposit(double amount);

	@Override
	public String toString() {
		return "[accNum=" + accNum + ", accHolder=" + accHolder + ", accBalance=" + accBalance + "]";
	}

}