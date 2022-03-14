package oop.labor03.lab3_2;

import oop.labor03.lab3_1.BankAccount;
import oop.labor03.lab3_1.CustomerOld;

public class Main {
    public static void main(String[] args) {

        Customer customer1 = new Customer("John", "Doe");
        Customer customer2 = new Customer("Marylin", "Rosetta");

        customer1.addAccount(new BankAccount("OTP0001"));
        customer1.addAccount(new BankAccount("OTP0002"));
        customer1.addAccount(new BankAccount("OTP0003"));
        customer1.addAccount(new BankAccount("OTP0004"));
        customer1.addAccount(new BankAccount("OTP0005"));
        customer1.addAccount(new BankAccount("OTP0006"));

        customer2.addAccount(new BankAccount("OTP0001"));
        customer2.addAccount(new BankAccount("OTP0002"));
        customer2.addAccount(new BankAccount("OTP0003"));
        customer2.addAccount(new BankAccount("OTP0004"));
        customer2.addAccount(new BankAccount("OTP0005"));
        customer2.addAccount(new BankAccount("OTP0006"));


        String OTP = "OTP";
        System.out.println(customer2);
        customer1.getAccount("OTP0001").deposit(1000);
        System.out.println(customer1);
        customer1.closeAccount("OTP0001");
        customer2.closeAccount("OTP0006");
        System.out.println(customer1);
        System.out.println(customer2);

    }

}
