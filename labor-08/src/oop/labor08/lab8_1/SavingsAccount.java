package oop.labor08.lab8_1;

public class SavingsAccount extends  BankAccount {

    //Variables
    private double interestRate;

    //Constructor
    public SavingsAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    //Methods

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double amount) {
        this.interestRate = amount;
    }

    public void addInterest() {
        super.balance = super.balance * this.interestRate;
    }

    @Override
    public String toString() {
        return "\t\t\t- Overall Balance:" + super.balance + "\n" +"\t\t\t- SavingsAccount: \n" +
                "\t\t\t\t-interst-Rate: " + this.interestRate + "\n";
    }
}
