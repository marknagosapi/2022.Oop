package oop.labor03.lab3_1;

public class CustomerOld {
    private String firstName;
    private String lastName;
    private BankAccount account;

    public CustomerOld(String lN, String fN){
        this.firstName = lN;
        this.lastName = fN;
    }

    public void setAccount(BankAccount account){
        this.account = account;
    }

    public BankAccount getAccount() {
        return account;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void closeAccount(){
        this.account = null;
    }

    public String toString(){
        return this.lastName + " " + this.firstName + " " + this.account;
    }
}
