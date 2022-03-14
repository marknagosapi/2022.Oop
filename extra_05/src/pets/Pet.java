package pets;

import Util.Util;
import date.MyDate;
import interfaces.IPatient;
import utils.PetType;
import utils.Seriosity;
import utils.Taxonomy;

import java.util.ArrayList;

public abstract class Pet implements IPatient {

    //Variables
    protected static int numPets;
    protected int petID;
    protected Taxonomy taxonomy;
    protected boolean healthy;
    protected MyDate birthDate;
    protected String petName;
    protected String disease;
    protected double currentWeight;

    protected static ArrayList<String> diseases;

    //Constructors
    public Pet(MyDate data, String name, double d){
        this.birthDate = data;
        this.petName= name;
        this.healthy = true;
        this.currentWeight = d;
        petID = getNumPets();
        numPets++;
    }

    //Methods
    public String speak(){
        return "Woof!";
    }

    public void unexpectedIllnessOccurred(){
        //System.out.println(Util.getNumOfDiseasesByPetType(this.patientType()));
        int randomIllness = Util.random.nextInt(Util.getNumOfDiseasesByPetType(this.patientType()));
        diseases = new ArrayList<String>();
        diseases.add(Util.getDiseasesByPetType(this.patientType()).get(randomIllness).getDisease());
        this.healthy = false;
    }

    public void checkHealthStatus(){
        if(healthy){
            System.out.println(this.petName + " is healthy\n");
        } else {
            System.out.println(this.petName + " is suffering from the following diseases:");
            for(String disease: diseases){
                System.out.println("\t\t-"+disease);
            }
        }
    }

    public void healing(){

    }

    public String getPetName() {
        return petName;
    }

    public int getNumPets() {
        return numPets;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petID=" + petID +
                ", taxonomy=" + taxonomy +
                ", healthy=" + healthy +
                ", birthDate=" + birthDate +
                ", petName='" + petName + '\'' +
                ", disease='" + disease + '\'' +
                ", currentWeight=" + currentWeight +
                '}';
    }
    public ArrayList<String> diseases(){
        return diseases;
    }
    public abstract PetType patientType();
    public abstract Seriosity seriosityOfCase();
}
