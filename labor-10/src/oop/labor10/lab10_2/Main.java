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

        company.sortByComparator(Comparator.comparing(Employee::getBirthDate));

        System.out.println();
        System.out.println("EMPLOYEES SORTED BY BIRTHDAY");
        System.out.println();
        company.printAll(System.out);

        company.sortByComparator((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));

        System.out.println();
        System.out.println("EMPLOYEES SORTED BY DECREASING SALARY");
        System.out.println();
        company.printAll(System.out);

        System.out.println();
        System.out.println("EMPLOYEES SORTED BY MANAGER-EMPLOYEE ALPHABETICALLY");
        System.out.println();

        company.sortByComparator((o1, o2) -> {

           if(o1.getClass() == Manager.class && o2.getClass()==Employee.class || o2.getClass() == Manager.class && o1.getClass()==Employee.class){
               return 1;
           }
            return (o1.getFirstName() +" "+ o1.getLastName()).compareTo(o2.getFirstName() +" "+ o2.getLastName());

        });
        company.printAll(System.out);
        System.out.println();



    }
}
