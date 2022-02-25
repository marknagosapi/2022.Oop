package oop.labor04.lab4_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Customer> fillArray(String fileName){
        ArrayList<Customer> customers = new ArrayList<>();
        int index = -1;
        Scanner inputData = null;
        try{
            inputData = new Scanner(new File("inputFiles/"+fileName));
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }

        while(inputData.hasNextLine()){

            String temp = inputData.nextLine();
            String[] temp2 = temp.split(",");
            //Debug [PRINT]
            /*
            for(int i=0;i<temp2.length;i++){
                System.out.println(temp2[i]);
            }

             */
            if(temp2[0].equals("Customer")){
                index++;
                customers.add(index, new Customer(temp2[1],temp2[2]));
            } else {
                BankAccount bk = new BankAccount(temp2[1].trim());
                int amount = Integer.parseInt(temp2[2].trim());
                bk.deposit(amount);
                customers.get(index).addAccount(bk);
            }
        }
        return customers;
    }
    public static void main(String[] args){
        ArrayList<Customer> customers = new ArrayList<Customer>();

        customers = fillArray("lab4_2_input.txt");
        System.out.println(customers);

    }
}
