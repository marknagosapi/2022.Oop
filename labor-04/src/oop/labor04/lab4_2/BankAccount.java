package oop.labor04.lab4_2;

public class BankAccount {
    private final String accountNumber;
    private double balance = 0;

    public BankAccount(String acNum){
        this.accountNumber = acNum;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void deposit(double depo){
        if(depo>=0) {
            this.balance += depo;
        }
    }

    public boolean withdraw(double amount){
        if(amount >= this.balance){
            return false;
        } else {
            this.balance = this.balance - amount;
            return true;
        }
    }

    public String toString(){

        return this.accountNumber + ": " + this.balance;
    }
}