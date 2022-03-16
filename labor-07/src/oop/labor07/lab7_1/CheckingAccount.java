package oop.labor07.lab7_1;

public class CheckingAccount extends BankAccount{

    //Variables
    private double overdraftLimit;

    //Constructor
    public CheckingAccount(double overdraftLimit){
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit){
        this.overdraftLimit = overdraftLimit;
    }

    public boolean withdraw (double amount){
        if(amount <= this.overdraftLimit){
            //code
            super.withdraw(amount);
            return true;
        }
        System.out.println("Waay over the limit buddy! GO WORK");
        return false;
    }

    @Override
    public String toString() {
        return "\t\t\t- CheckingAccount\n "+ "\t\t\t\t-overDraftLimit: "+this.overdraftLimit + "\n";
    }
}
