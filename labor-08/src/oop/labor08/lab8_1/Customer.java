package oop.labor08.lab8_1;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Customer {

    //Variables
    private static int numCustomers = 0;
    private final int id;
    private final String firstName;
    private String lastName;
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = setId();
    }
    //Methods

    public int setId(){
        ++numCustomers;
        return numCustomers;
    }
    public ArrayList<String> getAccountNumbers(){
        ArrayList<String> accountNumbers = new ArrayList<>();
        for(BankAccount item: accounts){
            accountNumbers.add(item.getAccountNumber());
        }
        return accountNumbers;
    }

    public void addAccount(BankAccount account){
        this.accounts.add(account);
    }

    public int getNumAccounts(){
        return accounts.size();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void closeAccounts(String acNum){
        Predicate<BankAccount> condition = n -> n.getAccountNumber().equals(acNum);
        accounts.removeIf(condition);
    }

    public int getId() {
        return id;
    }

    public int getNumCustomers() {
        return numCustomers;
    }

    public ArrayList<BankAccount> getAccount() {
        return accounts;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("*********************************\n");
        result.append("Customer " + this.firstName + " " + this.lastName + ": \n");
        result.append("\t\t-ID: " + this.id + "\n");
        result.append("\t\t-Accounts ("+this.getNumAccounts()+"): " + "\n");

        for(BankAccount accounts: this.getAccount()){
            result.append(accounts);
        }
        result.append("\n**********************************\n");
        return result.toString();
    }
}
