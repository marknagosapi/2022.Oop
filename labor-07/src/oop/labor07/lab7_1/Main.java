package oop.labor07.lab7_1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //Creating the BANK
        Bank OTP_BANK = new Bank("OTP");

        //Creating the Customers
        Customer John = new Customer("John", "Smith");
        Customer George = new Customer("George", "Bud");

        //Adding the Customers to the BANK
        OTP_BANK.addCustomer(John);
        OTP_BANK.addCustomer(George);

        //Creating Accounts(Saving & Checking)
        SavingsAccount s_account1 = new SavingsAccount(1.5);
        SavingsAccount s_account2 = new SavingsAccount(0.5);
        CheckingAccount c_account1 = new CheckingAccount(500);
        CheckingAccount c_account2 = new CheckingAccount(1250.23);


        //Adding Checking and Saving accounts to Customers
        John.addAccount(s_account1);
        John.addAccount(c_account1);
        George.addAccount(s_account2);
        George.addAccount(c_account2);

        //Deposit money to the accounts
        //to John
        for (BankAccount account : John.getAccount()) {
            Random r = new Random();
            account.deposit(r.nextDouble(2750));
        }
        //to George
        for (BankAccount account : George.getAccount()) {
            Random r = new Random();
            account.deposit(r.nextDouble(2750));
        }

        //Printing the customers of the Bank

        for (Customer customer : OTP_BANK.customers) {
            System.out.println(customer);
        }


        //Adding the interest to the accounts
        //to John
        for (BankAccount accounts : John.getAccount()) {
            boolean isInstance = accounts instanceof SavingsAccount;
            if (isInstance) {
                ((SavingsAccount) accounts).addInterest();
            }
        }
        //to George
        for (BankAccount accounts : George.getAccount()) {
            boolean isInstance = accounts instanceof SavingsAccount;
            if (isInstance) {
                ((SavingsAccount) accounts).addInterest();
            }
        }

        //Printing the customers of the Bank

        for (Customer customer : OTP_BANK.customers) {
            System.out.println(customer);
        }

        //Withdrawing money from the accounts
        //to John
        for (BankAccount account : John.getAccount()) {
            Random r = new Random();
            account.withdraw(r.nextDouble(2750));
        }
        //to George
        for (BankAccount account : George.getAccount()) {
            Random r = new Random();
            account.withdraw(r.nextDouble(2750));
        }

        //Printing the customers of the Bank
        for (Customer customer : OTP_BANK.customers) {
            System.out.println(customer);
        }
    }
}
