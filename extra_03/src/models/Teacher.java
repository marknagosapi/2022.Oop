package models;

import enums.Degree;
import enums.Department;

public class Teacher {

    public int currentNumberOfTeachers;
    //Variables (Adattagok)
    private String lastName;
    private String firstName;
    private Degree degree;
    private Department department;
    private int teacherID;

    //Constructor
    public Teacher(String lastName, String firstName, Degree degree, Department department){
        this.lastName = lastName;
        this.firstName = firstName;
        this.degree = degree;
        this.department = department;
    }

    //Methods


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Degree getDegree() {
        return degree;
    }

    public Department getDepartment() {
        return department;
    }

    public int getCurrentNumberOfTeachers() {
        return currentNumberOfTeachers;
    }

    public int getTeacherID() {
        return teacherID;
    }

    //toString method
    public String toString(){
        return this.firstName + " " + this.lastName + " - " + this.degree + " from " + this.department + " department";
    }
}
