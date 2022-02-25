package oop.labor04.lab4_1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void readFilePrintItsLineNumbered( String fileName ) {
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File("inputFiles/"+fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String temp;
        int i = 1;
        while(scanner.hasNextLine()){
                temp = scanner.nextLine();
            System.out.println(i++ + " " + temp);
        }
    }

    public static ArrayList<Person> readFromCSVFile(String fileName){
// Open the file
// ...
// Read data from file
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File("inputFiles/"+fileName));
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
        ArrayList<Person> persons = new ArrayList<>();
        while( scanner.hasNextLine() ){
            String line = scanner.nextLine();
            if( line.isEmpty() ){
                continue;
            }
            String[] items = line.split(",");
// trim: eliminates leading and trailing spaces
            String firstName = items[0].trim();
            String lastName = items[1].trim();
// Convert String → int: Integer.parseInt( String)
            int birtYear = Integer.parseInt(items[2].trim());
            persons.add( new Person(firstName, lastName, birtYear));
        }
        return persons;
    }

    public static void main(String[] args) {

        //readFilePrintItsLineNumbered("lab4_1_input.txt");
        ArrayList<Person> persons = new ArrayList<Person>();

        persons = readFromCSVFile("lab4_1_input.csv");
        System.out.println(persons);
    }
}
