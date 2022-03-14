package Util;

import pets.Dog;
import pets.Pet;
import utils.PetType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Util{

    //Variables
    public static Random random = new Random();
    public static ArrayList<String> commonWords = new ArrayList<String>();
    public static ArrayList<Disease> diseases = new ArrayList<Disease>();

    public static void readDiseasesAndTreatmentsFormFile(String fileName){
        Scanner inputDiseases = null;

        try{
            inputDiseases = new Scanner(new File("inputFiles/"+fileName));
        }catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("Disease file not found!\n");
        }

        String temp;
        String[] temp2;
        while(inputDiseases.hasNextLine()){
            temp = inputDiseases.nextLine();
            temp2 = temp.split(",");

            /*
            for(int i=0;i<temp2.length;i++){
                System.out.println(temp2[i]);
            }

             */


            switch(temp2[0].trim()){
                case "Dog":
                    //System.out.println(temp2[1].trim());
                     diseases.add(new Disease(temp2[1].trim(), PetType.Dog));
                    List<String> stringList = new ArrayList<String>();

                    for(int i=2;i<temp2.length;i++) {
                        stringList.add(temp2[i].trim());
                    }
                    diseases.get(diseases.size()-1).addTreatments(stringList);
                    break;
                case "Cat":
                   // System.out.println("Cat: " + temp2[1].trim());
                    diseases.add(new Disease(temp2[1].trim(), PetType.Cat));
                    List<String> stringList2 = new ArrayList<String>();

                    for(int i=2;i<temp2.length;i++) {
                        stringList2.add(temp2[i].trim());
                    }
                    diseases.get(diseases.size()-1).addTreatments(stringList2);
                    break;
                case "Parrot":
                    diseases.add(new Disease(temp2[1].trim(), PetType.Parrot));
                    List<String> stringList3 = new ArrayList<String>();

                    for(int i=2;i<temp2.length;i++) {
                        stringList3.add(temp2[i].trim());
                    }
                    //System.out.println(stringList3);
                    diseases.get(diseases.size()-1).addTreatments(stringList3);
                    break;
                case "Turtle":
                    diseases.add(new Disease(temp2[1].trim(), PetType.Turtle));
                    List<String> stringList4 = new ArrayList<String>();

                    for(int i=2;i<temp2.length;i++) {
                        stringList4.add(temp2[i].trim());
                    }
                    diseases.get(diseases.size()-1).addTreatments(stringList4);
                    break;
                default:
                    System.out.println("Unvalid input!\n");
            }
        }

    }

    public static void printAllDiseasesByPetType(PetType type){
        System.out.println("All diseases in case of "+ type);
        for(Disease item: diseases){
            if(item.getPetType().equals(type)){
                System.out.println(item.toString());
            }
        }
    }

    public static ArrayList<Disease> getDiseasesByPetType(PetType type) {
        ArrayList<Disease> diseasesToReturn = new ArrayList<Disease>();
        for(Disease item: diseases){
            if(item.getPetType().equals(type)){
               diseasesToReturn.add(item);
            }
        }
        return diseasesToReturn;
    }

    public static int getNumOfDiseasesByPetType(PetType type){
        int counter2 = 0;
        for(Disease item: diseases){
            if(item.getPetType().equals(type)){
                //System.out.println(item.getPetType());
                counter2++;
            }
        }
        return counter2;
    }

    public static void readCommonWordsFromFile(String fileName){
        Scanner inputWords = null;

        try{
            inputWords = new Scanner(new File("inputFiles/"+fileName));
        }catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("Disease file not found!\n");
        }

        String temp3;
        while(inputWords.hasNextLine()){
            temp3 = inputWords.nextLine();
            commonWords.add(temp3.trim());
        }
    }

    public String getRandomNumber(int a){
        return "";
    }

    public static ArrayList<String> treatmentsByDiseaseType(String a){
        //ArrayList<String> treatments = new ArrayList<String>();
        for(Disease item: diseases){
            if(item.getDisease().equals(a)){
                //System.out.println(item.getPetType());
                return item.getTreatments();
            }
        }
        return null;
    }
}
