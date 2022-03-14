package people;

import date.MyDate;
import interfaces.IDoctor;
import interfaces.IMedicalCenter;
import interfaces.IPatient;
import pets.Pet;
import utils.Enums;
import utils.PetType;

import java.util.ArrayList;
import java.util.Locale;

import static Util.Util.treatmentsByDiseaseType;

public class Veterinarian extends Person implements IDoctor{

    //Variables
    public static int MAX_PATIENTS_PER_DAY = 10;
    private ArrayList<IPatient> patients = new ArrayList<IPatient>();

    private final PetType speciality;
    public boolean available = true;
    private String fullName;
    protected int numberOfCurrentPatients = 0;

    //Constructor
    public Veterinarian(MyDate date, Enums.Gender gender, String firstName, String lastName, String contact, PetType speciality){
        super(date,gender,firstName,lastName,contact);
        this.speciality = speciality;
    }

    public void addNewPatient(IPatient patient){
        if(MAX_PATIENTS_PER_DAY > numberOfCurrentPatients) {
            patients.add(patient);
            numberOfCurrentPatients++;
        } else {
            available = false;
        }
    }

    public boolean isAvailable(){
        return available;
    }
    public boolean treatPatient(IPatient patient){
        System.out.println(this.toString());
        System.out.println("Number of possible appointments for "+((Pet) patient).getPetName() + ": ");
        System.out.println(((Pet) patient).getPetName() + " successfully assigned to " + this.firstName + " " +this.lastName);
        System.out.println("Dr. "+this.firstName + " " + this.lastName + " started to heal your pet...");
        System.out.println("\t Generating required treatment...");
        ArrayList<String> k = new ArrayList<String>();
        k = ((Pet) patient).diseases();

        System.out.println("\t Treatments for " + k.get(0) +" disease: ");
        ArrayList<String> helper = new ArrayList<String>();
        for(String temp: ((Pet) patient).diseases()){

            helper = treatmentsByDiseaseType(temp);
            for(String h: helper){
                System.out.println("\t\t- " + h);
            }
        }
        System.out.println("\t Your pet should recover soon. Take care.");
        System.out.println("\t Pet removed from patient list.");
        return true;
    }

    public PetType getSpeciality() {
        return speciality;
    }

    public ArrayList<IPatient> getPatients() {
        return patients;
    }

    public int getNumberOfCurrentPatients() {
        return numberOfCurrentPatients;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(this.firstName + " " + this.lastName + " is a " + speciality + " specialist veterinarian\n");
        result.append("\tContact information:\n");
        result.append("\t\t- Personal ID: "+ personId +"\n");
        result.append("\t\t- Date of birth: "+dateOfBirth.toString() + "\n");
        if(patients.size() <= 0) {
            if(gender.equals(Enums.Gender.MALE)) {
                result.append("\t\t- He does not have any patients\n");
            } else {
                result.append("\t\t- She does not have any patients\n");
            }
        }
        return result.toString();
    }
}
