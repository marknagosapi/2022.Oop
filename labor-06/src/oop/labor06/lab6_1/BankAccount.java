package oop.labor06.lab6_1;

import static java.lang.Math.floor;

public class BankAccount {
    //Variables
    private final String accountNumber;
    public static int numAccounts = 0;
    public static final int  ACCOUNT_NUMBER_LENGTH = 10;
    public static final String PREFIX = "ERSTE";
    private double balance = 0;


    //Constructor
    public BankAccount(){
        numAccounts++;
        this.accountNumber = createAccountNumber();
    }

    //Methods
    private String createAccountNumber(){
        //public static int numAccounts = 0;
        int lengthOfNum = (int) floor(Math.log10(numAccounts))+1;
        int prefixLength = PREFIX.length();
        int n = ACCOUNT_NUMBER_LENGTH - lengthOfNum - prefixLength;
        StringBuilder accountNumber = new StringBuilder(PREFIX);
        for(int i=0;i<n;i++){
            accountNumber.append("0");
        }
        accountNumber.append(Integer.toString(numAccounts));
        return accountNumber.toString();
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