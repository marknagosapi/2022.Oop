package oop.labor03.lab3_1;

public class Main {
    public static void main(String[] args) {
        CustomerOld customer1 =new CustomerOld("John", "BLACK");
        System.out.println(customer1);
        customer1.setAccount( new BankAccount("OTP00001"));
        customer1.getAccount().deposit(1000);
        System.out.println(customer1.getLastName());
        System.out.println(customer1);
        CustomerOld customer2 = new CustomerOld("Mary", "WHITE");
        customer2.setAccount( new BankAccount("OTP00002"));
        System.out.println(customer2);
        customer2.closeAccount();
        System.out.println(customer2);
        customer2.setAccount(customer1.getAccount());
        System.out.println(customer1);
        System.out.println(customer2);

    }
}
