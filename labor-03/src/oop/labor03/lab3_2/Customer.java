package oop.labor03.lab3_2;

import oop.labor03.lab3_1.BankAccount;
import java.util.Arrays;


public class Customer {
    public static final int MAX_ACCOUNTS = 11;

    private int numAccounts = 0;

    private String firstName;
    private String lastName;
    private BankAccount accounts[] = new BankAccount[MAX_ACCOUNTS];

    public Customer(String lN, String fN){
        this.firstName = lN;
        this.lastName = fN;
    }

    public void addAccount(BankAccount account){
        numAccounts++;
        if(numAccounts <= MAX_ACCOUNTS) {
            this.accounts[numAccounts] = account;
        }
    }

    public BankAccount getAccount(String accountNumber) {
        int result = 0;
        for(int i=1;i<=numAccounts;i++){
            if(accounts[i].getAccountNumber().equals(accountNumber)){
                result = 1;
            }
        }
        if(result < 0){
            return null;
        } else {

            String[] s2 = accountNumber.split("0");
            int index = Integer.parseInt(s2[s2.length - 1]);
            return accounts[index];
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getNumAccounts() {
        return this.numAccounts;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void closeAccount(String accountNumber) {
        int result = -1;
        for (int i = 1; i <= numAccounts; i++) {
            if ((accounts[i].getAccountNumber().equals(accountNumber))) {
                //System.out.println(accounts[i].getAccountNumber() + " " + accountNumber);
                result = 0;
                break;
            }
        }

            if (result == -1) {
                System.out.println("[ERROR] Invalid Account Number!\n");
            } else {
                String[] s2 = accountNumber.split("0");
                int index = Integer.parseInt(s2[s2.length - 1]);

                //System.out.println(index);
                for(int j=index;j<=numAccounts;j++) {
                    accounts[j] = accounts[j+1];
                }
                numAccounts--;

            }
        }

    public String toString(){
        StringBuffer result = new StringBuffer();
        result.append(firstName + " " + lastName + " accounts:\n");
        for(int i=1;i<=numAccounts;i++){
            result.append("\t" + accounts[i].toString() + "\n");
        }
        return result.toString();
    }
}
