package com.events;

import org.springframework.context.ApplicationListener;

public class TransactionEventHandler implements ApplicationListener<WithdrawalEvent> {
	private void sendSMS(String message) {
		System.out.println(message);
	}

	public void onApplicationEvent(WithdrawalEvent event) {
		sendSMS(event.toString());
	}

}