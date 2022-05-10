package oop.labor10.lab10_2;

import oop.labor10.lab10_1.MyDate;

import java.util.Comparator;

public class Main {
    public static void main(String[] args){
        System.out.println("EMPLOYEES");

        Company company = new Company("Apple");
        /*
        company.hire(new Manager("Alpar","Reszeg",7000, new MyDate(2001,8,4),"Almaszedes"));
        company.hire(new Manager("GIGA","NIGA",4244, new MyDate(2002,1,4),"Almaszedes"));
        company.hire(new Employee("Alfonz","Biro",4230, new MyDate(2000,5,8)));
        company.hire(new Employee("Etele","Botond",10, new MyDate(2005,12,3)));
        company.hire(new Employee("Anita","Nagy",5250, new MyDate(2002,2,31)));
        */

        company.hireAll("employees.csv");

        company.printAll(System.out);

        company.sortByComparator(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getBirthDate().compareTo(o2.getBirthDate());
            }
        });

        System.out.println();
        System.out.println("EMPLOYEES SORTED BY BIRTHDAY");
        System.out.println();
        company.printAll(System.out);

        company.sortByComparator(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(o1.getSalary() > o2.getSalary()){
                    return -1;
                } else if(o1.getSalary() == o2.getSalary()) {
                    return 0;
                } else {return 1;
                }
            }
        });

        System.out.println();
        System.out.println("EMPLOYEES SORTED BY DECREASING SALARY");
        System.out.println();
        company.printAll(System.out);

        System.out.println();
        System.out.println("EMPLOYEES SORTED BY MANAGER-EMPLOYEE ALPHABETICALLY");
        System.out.println();

        company.sortByComparator(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //Próbáld inkább a getClass-t
               if(o1 instanceof Manager && o2 instanceof Employee || o2 instanceof Manager && o1 instanceof Employee){
                   return 1;
               }
               //itt hasznalhatod az alap compareTo-t, mert megirtad
                return (o1.getFirstName() + o1.getLastName()).compareTo(o2.getFirstName() + o2.getLastName());

            }
        });
        company.printAll(System.out);
        System.out.println();



    }
}
