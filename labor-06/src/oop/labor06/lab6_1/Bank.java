package oop.labor06.lab6_1;

import java.io.*;
import java.util.ArrayList;

public class Bank {
    //Variables (Adattagok)
    private final String name;
    ArrayList<Customer> customers = new ArrayList<>();

    //Constructor
    public Bank(String name){
        this.name = name;
    }

    public Customer getCustomer(int id){
        for(Customer customer: this.customers){
            if(customer.getId() == id){
                return customer;
            }
        }
        System.out.println("Could not found the customer with the ID" + id);
        return null;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public int numCustomers(){
        return customers.size();
    }

    private void printCustomers(PrintStream ps){
        ps.println("ID, Firstname, Last name, Number of bank accounts");
        for( Customer customer: customers ){
            ps.println( customer.getId()+", " + customer.getFirstName() +", "+
                    customer.getLastName()+", "+customer.getAccountNumbers());
        }
        ps.close();
    }

    public void printCustomersToStdout(){
        printCustomers(System.out);
        //System.out.println(customers);
    }

    public void printCustomersToFile(String fileName){
        /*
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File("inputFiles/"+ fileName));
        } catch(FileNotFoundException e){
            System.out.println("Unsuccessul file opening! [ERROR]");
            e.printStackTrace();
        }

          */
        File f = new File("outputFiles/" + fileName);
        try{
            PrintStream output = new PrintStream(f);
            printCustomers(output);
        }catch(IOException e){
            e.printStackTrace();
        }

//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("outputFiles/" + fileName));
//            for(Customer item: customers){
//                writer.write(item.toString() + "\n");
//            }
//            //writer.write(String.valueOf(customers));
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
