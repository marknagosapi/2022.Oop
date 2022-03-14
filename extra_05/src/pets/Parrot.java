package pets;

import Util.Util;
import date.MyDate;
import utils.*;

import java.util.ArrayList;

public class Parrot extends Pet {

    //Variables
    private final ArrayList<String> alreadyKnownWords = new ArrayList<String>();

    public PetType patientType = PetType.Parrot;
    public Seriosity seriosityOfCase;
    public boolean canSpeak;
    public BodyType bodyType;

    //Constructor
    public Parrot(boolean canSpeak, MyDate date, String word, double d){
        super(date,word,d);
        this.canSpeak = canSpeak;
        this.taxonomy = Taxonomy.BIRDS;
        int bd = Util.random.nextInt(BodyType.values().length);
        this.bodyType = BodyType.values()[bd];
    }

    //Methods
    private void initializeKnownWords(){

        if(Util.commonWords.isEmpty()) {
            Util.readCommonWordsFromFile("commonWords.txt");
        }
        int randomNumberOfKnownWords = Util.random.nextInt(Util.commonWords.size());
        for(int i = 0; i < randomNumberOfKnownWords; ++i) {
            int generatedIndex = Util.random.nextInt(Util.commonWords.size());
            this.alreadyKnownWords.add(Util.commonWords.get(generatedIndex));
        }
    }

    public String speak(){

        if(canSpeak) {
            initializeKnownWords();
            String tmp = "The parrot already knows the following words:\n";
            //System.out.println("The parrot already knows the following words:");
            for(String item: alreadyKnownWords){
                tmp += item + " ";
            }
            return tmp;
        } else {
            return "This parrot is silent guy!\n";
        }
    }

    @Override
    public String toString() {
        String result = "a " + this.bodyType + " size parrot, named "+ petName + " born in: " + birthDate.toString();
        return result;
    }

    @Override
    public PetType patientType() {
        return patientType;
    }

    @Override
    public Seriosity seriosityOfCase() {
        return seriosityOfCase;
    }
}
