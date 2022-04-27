package oop.labor10.lab10_2;

import oop.labor10.lab10_1.MyDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Company {

    //Variables
    private String name;
    private ArrayList<Employee> employees = new ArrayList<>();

    //Constructor

     public Company(String name){
         this.name = name;
     }

     //Methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hire(Employee employee){
         if(!employees.contains(employee)) {
             employees.add(employee);
         }
    }

    public void hireAll(String fileName){
        try(Scanner scanner = new Scanner(new File("inputFiles/"+fileName))){
            String temp;
            String[] temp2;
            while(scanner.hasNextLine()){

                temp = scanner.nextLine();
                temp2 = temp.split(",");
                if(temp2.length==7){
                    employees.add(new Manager(temp2[0].trim(),temp2[1].trim(),Double.parseDouble(temp2[2].trim()),new MyDate(Integer.parseInt(temp2[3].trim()),Integer.parseInt(temp2[4].trim()),Integer.parseInt(temp2[5].trim())),temp2[6].trim()));
                } else {
                    employees.add(new Employee(temp2[0].trim(),temp2[1].trim(),Double.parseDouble(temp2[2].trim()),new MyDate(Integer.parseInt(temp2[3].trim()),Integer.parseInt(temp2[4].trim()),Integer.parseInt(temp2[5].trim()))));
                }
            }

        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void fire(int ID){
         for(Employee employee: employees){
             if (employee.getID() == ID) {
                  employees.remove(employee);
             }
         }
    }

    public void printAll(PrintStream ps){

         for(Employee employee: employees){
             ps.println(employee.toString());
         }
    }


    public void printManagers(PrintStream ps){
        for(Employee employee: employees){
            if(employee.getClass() == Manager.class) {
                ps.println(employee.toString());
            }
        }
    }


    public void sortByComparator(Comparator<Employee> comp){
        employees.sort(comp);
    }

}
