package Util;

import pets.Pet;
import utils.PetType;

import java.util.ArrayList;
import java.util.List;

public class Disease {
    //Variables
    protected  ArrayList<String> treatments = new ArrayList<>();

    protected final PetType petType;
    protected final String disease;

    //Constructor
    public Disease(String s, PetType type){
        this.petType = type;
        this.disease = s;
    }

    //Methods
    public void addTreatments(List<String> List){
        for(String l: List){
            treatments.add(l);
        }
        //System.out.println(treatments);
        //treatments.addAll(List);
    }

    public PetType getPetType() {
        return petType;
    }

    public String getDisease() {
        return disease;
    }

    public ArrayList<String> getTreatments() {
        return treatments;
    }

    @Override
    public String toString() {
        StringBuffer temp = new StringBuffer();
        temp.append(" ^ Treatments for "+this.disease +":\n");
        for(String item: treatments) {
            temp.append("\t\t- "+ item.trim() + "\n");
        }
        return temp.toString();
    }
}
