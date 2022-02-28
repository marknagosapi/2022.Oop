package oop.labor05.lab5_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        ArrayList<BankAccount> accounts = new ArrayList<>();
        for (int i = 1; i <= 150; i++) {
            accounts.add(new BankAccount());
        }
        //System.out.println(accounts);

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        customers.get(0).addAccount(accounts.get(0));
        customers.add(new Customer());
        customers.get(1).addAccount(accounts.get(2));
        customers.add(new Customer());
        customers.get(2).addAccount(accounts.get(3));
        System.out.println(customers);

         */

        Bank bank = new Bank("OTP");
        bank.addCustomer(new Customer("Simo", "Robert"));
        bank.addCustomer(new Customer("Peter", "Lajos"));
        bank.addCustomer(new Customer("Mark", "Nagy"));
        bank.getCustomer(1).addAccount(new BankAccount());
        bank.getCustomer(1).addAccount(new BankAccount());
        bank.getCustomer(2).addAccount(new BankAccount());
        bank.getCustomer(2).addAccount(new BankAccount());

        System.out.println(bank.getCustomer(1));

        for(int i=1;i<=bank.numCustomers();i++){
            //System.out.println(bank.getCustomer(i).getAccount());
            for(int j=0;j<bank.getCustomer(i).getAccount().size();j++){
                bank.getCustomer(i).getAccount().get(j).deposit(15000);
            }
            //System.out.println(bank.getCustomer(i).getFirstName());
        }
        System.out.println(bank.getCustomer(2));
        bank.printCustomersToFile("bank_customers.csv");
    }
}
