package pets;

import date.MyDate;
import interfaces.IPatient;
import utils.*;

public class Dog extends Pet{

    //Variables
    private DogBreed dogBreed;
    private PetType patientType = PetType.Dog;
    private boolean goodHouseKeeper;
    private Seriosity seriosityOfCase;

    //Constructor
    public Dog(boolean goodHouseKeeper, MyDate date, String a, double weight){
        super(date, a,weight);
        this.goodHouseKeeper = goodHouseKeeper;
        this.taxonomy = Taxonomy.MAMMALS;
        int breed = Util.Util.random.nextInt(dogBreed.values().length);
        this.dogBreed = DogBreed.values()[breed];
    }

    //Methods
    public String speak(){
        return "Woof woof\n";
    }

    @Override
    public String toString() {
        String result = "a " + this.dogBreed + " dog, named "+ petName + " born in: " + birthDate.toString();
        return result;
    }

    @Override
    public PetType patientType() {
        return patientType;
    }

    @Override
    public Seriosity seriosityOfCase() {
        return null;
    }
}
