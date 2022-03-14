package pets;

import date.MyDate;
import utils.CatBreed;
import utils.PetType;
import utils.Seriosity;
import utils.Taxonomy;

public class Cat extends Pet{

    //Variables
    private PetType patientType;
    private CatBreed catBreed;
    private Seriosity seriosityOfCase;
    private boolean hasPedigree;

    //Constructor
    public Cat(boolean hasPedigree, MyDate date, String a, double weight){
        super(date,a,weight);
        this.hasPedigree = hasPedigree;
        this.taxonomy = Taxonomy.MAMMALS;
        int breed = Util.Util.random.nextInt(CatBreed.values().length);
        this.catBreed = CatBreed.values()[breed];
        this.patientType = PetType.Cat;
    }

    public String toString(){
        String result = "a " + this.catBreed + " cat, named "+ petName + " born in: " + birthDate.toString();
        return result;
    }

    public String speak(){
        return "Pafu-pafu\n";
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
