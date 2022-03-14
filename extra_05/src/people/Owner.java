package people;

import pets.Pet;
import utils.*;
import date.*;

import java.util.ArrayList;

public class Owner extends Person {
    //Variables

    protected ArrayList<Pet> pets = new ArrayList<>();

    //Constructor

    public Owner(MyDate date, Enums.Gender gender, String firstName, String lastName, String phoneNumber){
        super(date,gender,firstName,lastName,phoneNumber);
        //Person person = new Person(date,gender,firstName,lastName,phoneNumber);
    }

    //Methods
    public void addNewPets(Pet a){
        //pets = new ArrayList<Pet>();
        pets.add(a);
        //System.out.println(pets.size());
    }

    public Pet getPet(String petName) {
        for(Pet item: pets){
            if(item.getPetName().equals(petName)){
                return item;
            }
        }
            System.out.println("No such pet!\n");
            return null;
    }

    public String toString(){
        StringBuffer result = new StringBuffer();
        result.append(this.firstName + " "+ this.lastName + " is an owner\n");
        result.append("\t\tContact information:\n" +
                     "\t\t\t-Personal ID: "+ personId + "\n" +
                     "\t\t\t-Date of birth: " + dateOfBirth.toString() + "\n"
                );
        if(pets==null || pets.size() <=0){
            if(Enums.Gender.FEMALE == gender) {
                result.append("\t\t\t-She doesn't have any pets\n");
            } else {
                result.append("\t\t\t-He doesn't have any pets\n");
            }
        } else {
            if(Enums.Gender.FEMALE == gender) {
                result.append("\t\t\t-She has " + pets.size() + " pets:\n");
                for(int i=0;i<pets.size();i++){
                    result.append("\t\t\t\t* " + pets.get(i).toString() +" \n");
                }
            } else {
                result.append("\t\t\t-He has " + pets.size() + " pets:\n");
                for(int i=0;i<pets.size();i++){
                    result.append("\t\t\t\t* " + pets.get(i).toString() +" \n");
                }
            }
        }
        return result.toString();
    }

    public String noiseInOwnersHouse(){
        String temp = this.firstName + " " + this.lastName;
            if (pets.size() <= 0) {
                temp += "'s house is quiet because does not have any pets!\n";
            } else {
                temp += "'s house is noisy. Listen...!\n";
                for (int i = 0; i < pets.size(); i++) {
                    temp += "\t-" + pets.get(i).speak();
                }
            }
            return temp;
    }
}
