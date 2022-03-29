package com.events;

import java.sql.Timestamp;

import org.springframework.context.ApplicationEvent;

public class WithdrawalEvent extends ApplicationEvent {
	double accBalance;

	public WithdrawalEvent(Object source, double accBalance) {
		super(source);
		this.accBalance = accBalance;
	}

	@Override
	public String toString() {
		return "You have made an withdrawal" + "\n" + "Updated Account Balance : " + this.accBalance
				+ "\n"+"Transaction made on : "+new Timestamp(System.currentTimeMillis());
	}

}