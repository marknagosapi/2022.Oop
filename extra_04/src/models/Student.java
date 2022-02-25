package models;

import utils.Major;

public class Student {

    //Variables (Adattagok)
    private String lastName;
    private String firstName;
    private String neptunCode;
    private Major major;

    //Constructor
    public Student(String neptunCode, String firstName, String lastName, Major major){
        this.lastName = lastName;
        this.firstName = firstName;
        this.neptunCode = neptunCode;
        this.major = major;
    }

    //Get Methods
    public Major getMajor() {
        return major;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getNeptunCode() {
        return neptunCode;
    }

    //toString method
    public String toString(){
        return this.firstName + " " + this.lastName + " (" + this.neptunCode + ") ";
    }


}
