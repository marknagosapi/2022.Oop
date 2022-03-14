package people;

import date.MyDate;
import utils.Enums.Gender;

import java.util.Random;

public class Person {
    //Variables
    protected static String personId;
    protected static Gender gender;
    protected static MyDate dateOfBirth;

    protected String lastName;
    protected String contact;
    protected String fullName;
    protected String firstName;

    //Constructor

    public Person(MyDate data , Gender gender, String firstName, String lastName, String contact){
        this.dateOfBirth = data;
        this.gender = gender;
        this.lastName = lastName;
        this.firstName = firstName;
        this.contact = contact;
        personId = generatePersonalID();
    }

    //Methods


    public static Gender getGender() {
        return gender;
    }

    private String generatePersonalID(){
        String personID = "";
        if(gender.equals(Gender.MALE)){
            personID += "1";
        } else {
            personID += "2";
        }

        String yy;
        String mm;
        String dd;

        yy = Integer.toString(this.dateOfBirth.getYear());
        personID  += yy.charAt(2);
        personID  += yy.charAt(3);
        if(dateOfBirth.getMonth() >= 10){
             mm = Integer.toString(dateOfBirth.getMonth());
        } else {
             mm = "0" + Integer.toString(dateOfBirth.getMonth());
        }

        if(dateOfBirth.getDay() < 10){
            dd = "0" + Integer.toString(dateOfBirth.getDay());
        } else {
            dd = Integer.toString(dateOfBirth.getDay());
        }

        personID += mm;
        personID += dd;

        Random rand = new Random();
        personID += Integer.toString((int)Math.floor(Math.random()*(999999-10000)+1)+100000);

        return personID;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", contact='" + contact + '\'' +
                ", fullName='" + fullName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
