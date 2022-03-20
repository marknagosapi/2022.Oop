package oop.labor05;

import oop.labor05.models.Course;
import oop.labor05.models.MyDate;
import oop.labor05.models.Student;
import oop.labor05.models.Training;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
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

    private static ArrayList<Student> readStudents(String fileName){
        Scanner scanner = null;
        ArrayList<Student> course = new ArrayList<>();
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

            course.add(new Student(temp2[0].trim(),temp2[1].trim(),temp2[2].trim()));
        }
        return course;
    }

    public static void main(String[] args){
        ArrayList<Course> courses = new ArrayList<>();
        courses = readCourses("lab5_input01");
        ArrayList<Student> students = new ArrayList<>();
        students = readStudents("lab5_input02");
        //System.out.println(students);

        ArrayList<Training> trainings = new ArrayList<>();

        for(Course course: courses){
            Random r = new Random();
            MyDate startDate = new MyDate(2022,3,21);
            MyDate endDate = new MyDate(2022,3,25);

            double price = r.nextDouble(2000) + 1000;
            trainings.add(new Training(course,startDate,endDate,price));
        }


        for(Training item:trainings){
            Random r = new Random();
            for(int i=0;i<10;i++) {
                item.enroll(students.get(r.nextInt(students.size())));
            }
        }
        System.out.println(trainings);

        for(Training item:trainings){
            item.printToFile();
        }
    }
}
