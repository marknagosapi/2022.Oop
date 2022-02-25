package oop.labor04.lab4_2;

import java.util.ArrayList;

public class Customer {

    private String firstName;
    private String lastName;
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public Customer(String lN, String fN){
        this.firstName = lN;
        this.lastName = fN;
    }

    public void addAccount(BankAccount account){

        this.accounts.add(account);

    }

    public BankAccount getAccount(String accountNumber) {
        int result = 0;
        int i = 0;
        for(BankAccount item : accounts){
            if(item.getAccountNumber().equals(accountNumber)){
                result = 1;
                break;
            }
            i++;
        }

        if(result < 0){
            return null;
        } else {
            return accounts.get(i);
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void closeAccount(String accountNumber) {
        int result = -1;
        int i=0;
        for(BankAccount item: accounts){
            if(item.getAccountNumber().equals(accountNumber)){
                result = 0;
                break;
            }
            i++;
        }

        if (result == -1) {
            System.out.println("[ERROR] Invalid Account Number!\n");
        } else {
            accounts.remove(i);
        }
    }

    public String toString(){

        StringBuffer result = new StringBuffer();
        result.append(firstName + " " + lastName + " accounts:\n");
        for(BankAccount item : accounts){
            result.append("\t" + item.toString() + "\n");
        }
        return result.toString();
    }
}
