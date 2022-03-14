package pets;

import date.MyDate;
import utils.*;

public class Turtle extends Pet {

    //Variables
    protected PetType patientType;
    protected final int numHibernatingMonths;
    protected Seriosity SerioseriosityOfCase;
    protected TurtleClassification classification;

    //Constructor
    public Turtle(int numHibernatingMonths, MyDate date,String s, double w){
        super(date,s,w);
        this.numHibernatingMonths = numHibernatingMonths;
        patientType = PetType.Turtle;
        this.taxonomy = Taxonomy.REPTILES;
        int classification = Util.Util.random.nextInt(TurtleClassification.values().length);
        this.classification = TurtleClassification.values()[classification];
        this.patientType = PetType.Turtle;
    }

    //Methods
    public String speak(){
        return "Silent guy!:D\n";
    }

    @Override
    public String toString() {
        String result = "a " + this.classification + " turtle, named "+ petName + " born in: " + birthDate.toString();
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
