package oop.labor10.lab10_2;

import oop.labor10.lab10_1.MyDate;

import java.util.Objects;

public class Employee implements Comparable<Employee>{

    //Variables

    private final int ID;
    private String firstName;
    private String lastName;
    private double salary;
    private final MyDate birthDate;
    private static int counter = 0;

    //Constructor

    public Employee(String firstName, String lastName, double salary, MyDate date){
        this.ID = ++counter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthDate = date;
    }

    //Methods

    public int getID()
    {
        return ID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getSalary() {
        return salary;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return ID == employee.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return (this.firstName+ " " +this.lastName).compareTo(o.firstName+" "+o.lastName);
    }
}
