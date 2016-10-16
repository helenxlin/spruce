package com.minime;

public class BankAccount {

	//Constructor: creates BankAccount object
	public BankAccount() {
		this.money = 546;
	}
	
	//current amount of money in the bank
	int money;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
