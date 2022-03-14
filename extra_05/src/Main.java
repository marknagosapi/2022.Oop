import Util.Util;
import date.MyDate;
import interfaces.IDoctor;
import medCenters.Veterinary;
import people.Owner;
import people.Veterinarian;
import pets.*;
import utils.Enums;
import utils.PetType;


public class Main {
    public static void main(String[] args){

        Owner owner1 = new Owner(new MyDate(1997,7,8),Enums.Gender.FEMALE,"Anne","SMITH","+40-741-234-567");
        System.out.println(owner1);

        System.out.println(owner1.noiseInOwnersHouse());
        //Pet pet1 = new Pet(new MyDate(2019,8,11),"Lizzie",42.4);
        Util.readDiseasesAndTreatmentsFormFile("diseases.csv");
        Turtle turtle = new Turtle(3,new MyDate(2019,8,11),"Lucas",23.1);
        Dog dog = new Dog(true,new MyDate(2005,1,4),"Georgy",12.52);
        Cat cat = new Cat(true,new MyDate(1995,5,12),"Macska",512.52);
        Parrot parrot = new Parrot(true,new MyDate(2020,2,28),"Pityu",0.85);
        //turtle.checkHealthStatus();
        //turtle.unexpectedIllnessOccurred();

        turtle.checkHealthStatus();
        owner1.addNewPets(turtle);
        owner1.addNewPets(dog);
        owner1.addNewPets(cat);
        owner1.addNewPets(parrot);
        System.out.println(owner1);

        System.out.println(owner1.noiseInOwnersHouse());

        Veterinary medicalCenter = new Veterinary(
                "str. Suceava Nr. 4 Targu Mures 540366 Romania",
                "0740 491 345",
                "AssisiVet");

        System.out.println(medicalCenter);
        Util.printAllDiseasesByPetType(PetType.Dog);
        owner1.getPet("Georgy").unexpectedIllnessOccurred();
        owner1.getPet("Georgy").checkHealthStatus();
        Veterinarian vet1 = new Veterinarian(new MyDate(1997,7,8),Enums.Gender.FEMALE,"Anne","SMITH","+40-741-234-567",PetType.Dog);
        medicalCenter.hireDoctor(vet1);
        System.out.println(vet1);
        IDoctor doc = medicalCenter.assignPatientToADoctor(owner1.getPet("Georgy"));
        if(doc!=null){
            doc.treatPatient(owner1.getPet("Georgy"));
        }
    }
}
