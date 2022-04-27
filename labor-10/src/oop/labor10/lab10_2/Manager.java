package oop.labor10.lab10_2;

import oop.labor10.lab10_1.MyDate;

public class Manager extends Employee{

    //Variables

    private String department;


    //Constructor

    public Manager(String firstName, String lastName, double salary, MyDate date,String dep) {
        super(firstName, lastName, salary, date);
        this.department = dep;
    }

    //Methods

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Manager{" + super.toString() +
                "department='" + department + '\'' +
                '}';
    }
}
