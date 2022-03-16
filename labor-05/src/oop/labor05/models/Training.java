package oop.labor05.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Training {

    //Variables
    private final Course course;
    private final MyDate startDate;
    private final MyDate endDate;
    private final double pricePerStudent;
    private ArrayList<Student> enrolledStudents = new ArrayList<>();

    //Constructor

    public Training(Course course, MyDate startDate, MyDate endDate, double pricePerStudent){
        this.course = course;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pricePerStudent = pricePerStudent;
    }

    //Methods
    public boolean enroll(Student student){
        for(Student students: enrolledStudents){
            if(students.getID().equals(student.getID())){
                return false;
            }
        }
        enrolledStudents.add(student);
        return true;
    }

    public Student findStudentById(String ID){
        for(Student students: enrolledStudents){
            if(students.getID().equals(ID)){
                return students;
            }
        }
        return null;
    }

    public Course getCourse() {
        return course;
    }

    public int numEnrolled(){
        return enrolledStudents.size();
    }

    public void printToFile(){

        try(PrintStream output = new PrintStream("output.txt")) {

        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void unEnroll(String ID){
        for(Student students: enrolledStudents){
            if(students.getID().equals(ID)){

            }
        }
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("Training: \n");
        result.append("\t- "+this.course.toString() + "\n");
        result.append("\t- "+"startDate= " + this.startDate.toString() + " \n");
        result.append("\t- "+"endDate= "+ this.endDate.toString() + "\n");
                for(Student item: enrolledStudents) {
                    result.append("\t\t- " + item.toString() + "\n");
                }
                return result.toString();
    }
}
