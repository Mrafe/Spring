package com.mainApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.events.*;
import com.accounts.*;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		WithdrawalEventPublisher publisher = (WithdrawalEventPublisher) context.getBean("customEventPublisher");
		Scanner sc = new Scanner(System.in);
		BankAccount acc1 = new SavingsAccount(1221, "Mai Sakurajama", 18000);
		System.out.print("Amount to withdraw : ");
		double amt = sc.nextDouble();
		double balance=acc1.withdraw(amt);
		if(balance==0) {
			System.out.println("Amount exceeds the daily withdrawal amount");
		}
		else if(balance == -1) {
			System.out.println("Insufficient Balance");
		}
		else {
			publisher.publish(balance);
		}
		System.out.print("Enter the amount to be deposisited : ");
		amt = sc.nextDouble();
		balance = acc1.deposit(amt);
		if(balance == -1 ) {
			System.out.println("Amount exceeds the daily deposit Amount");
		}
		else {
			publisher.publish(balance);
		}

	}

}
