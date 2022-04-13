package oop.labor08.lab8_1;

import static java.lang.Math.floor;

public class BankAccount {
    //Variables
    protected final String accountNumber;
    private static int numAccounts = 0;
    public int ACCOUNT_NUMBER_LENGTH;
    public static final String PREFIX = "OTP";
    protected double balance = 0;


    //Constructor
    protected BankAccount(){
        numAccounts++;
        this.accountNumber = createAccountNumber();
    }

    //Methods
    private String createAccountNumber(){
        //public static int numAccounts = 0;
        int lengthOfNum = (int) floor(Math.log10(numAccounts))+1;
        int n = 7 - lengthOfNum;
        String accountNumber = PREFIX;
        for(int i=0;i<n;i++){
            accountNumber += "0";
        }
        accountNumber += Integer.toString(numAccounts);
        return accountNumber;
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
        if(amount > this.balance){
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