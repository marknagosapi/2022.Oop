package oop.labor05.lab5_1;

import java.awt.image.BaseMultiResolutionImage;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Customer {

    //Variables
    private static int numCustomers = 0;
    private final int id;
    private String firstName;
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
        return "Customer{" +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
