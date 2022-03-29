package com.mainApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.events.*;
import com.accounts.*;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		WithdrawalEventPublisher publisher = (WithdrawalEventPublisher) context.getBean("customEventPublisher");
		BankAccount acc1 = new SavingsAccount(1221, "Mai Sakurajama", 18000);
		double balance=acc1.withdraw(2000);
		publisher.publish(balance);
		balance = acc1.deposit(5000);
		publisher.publish(balance);

	}

}
