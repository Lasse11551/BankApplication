//The design have been made with GUI, and the functions/methods have been coded by me
//Throughout the making of this program i have been seeking information from the Internet and from friends
//I have been getting of help from Kasper Kronborg and Jeppe Paaske 

package Miniprojekt;

import javax.swing.JOptionPane;

public class Account {
	public double consumerBalance;
	public double savingsBalance;
	
	//This is my getter and setter class
	public Account() {
		consumerBalance = 0.0;
		savingsBalance = 0.0;
	}
	
	public Account(double spendBalance, double savingsBalance) {
		
	}
	
	public double getConsumerBalance(double spendBalance) {       //does actually not get used                                           
		return this.consumerBalance = spendBalance;
	}
	
	public double getSavingsBalance(double savingsBalance) {      //does actually not get used
		return this.savingsBalance = savingsBalance;
	}
	
	public void setSavingsDeposit(double amount) {
		this.savingsBalance = savingsBalance + amount;
	}
	
	public void setConsumerDeposit(double amount) {
		this.consumerBalance = consumerBalance + amount;
		}
	
	public void setConsumerWithdraw(double amount) {
		if(this.consumerBalance < amount) {
			JOptionPane.showMessageDialog(null, "You do not have enough money for that transaction");
		} else {
		this.consumerBalance = consumerBalance - amount;
		}
	}
	
	public void setSavingsWithdraw(double amount) {
		this.savingsBalance = savingsBalance - amount;
	}
	
	public void setToConsumerTransfer(double amount) {
		if(this.savingsBalance < amount) {
			JOptionPane.showMessageDialog(null, "You do not have enough money for that transaction");
		} else {
		this.consumerBalance = this.consumerBalance + amount;
		this.savingsBalance = this.savingsBalance - amount;
		}
	}
	
	public void setToSavingsTransfer(double amount) {
		if(this.consumerBalance < amount) {
			JOptionPane.showMessageDialog(null, "You do not have enough money for that transaction");
		} else {
		this.consumerBalance = this.consumerBalance - amount;
		this.savingsBalance = this.savingsBalance + amount;
		}
	}
	
	
}

