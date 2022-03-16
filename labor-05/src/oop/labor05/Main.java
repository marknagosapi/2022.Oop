package oop.labor05;

import oop.labor05.models.Course;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Course> readCourses(String fileName){
        Scanner scanner = null;
        ArrayList<Course> course = new ArrayList<>();
        try{
            scanner = new Scanner(new File("inputFiles/"+fileName));
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        String temp;
        String[] temp2;
        while(scanner.hasNextLine()){
            temp = scanner.nextLine();
            temp2 = temp.split(",");

            course.add(new Course(temp2[0].trim(),temp2[1].trim(),Integer.parseInt(temp2[2].trim())));
        }
        return course;
    }

    public static void main(String[] args){

    }
}
