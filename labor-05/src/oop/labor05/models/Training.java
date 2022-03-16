package oop.labor05.models;

import java.util.ArrayList;

public class Training {

    //Variables
    private final Course course;
    private final MyDate startDate;
    private final MyDate endDate;
    private final double pricePerStudent;
    private ArrayList<Student> enrolledStudents;

    //Constructor

    public Training(Course course, MyDate startDate, MyDate endDate, double pricePerStudent){
        this.course = course;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pricePerStudent = pricePerStudent;
    }

    //Methods
    public boolean enroll(Student student){

    }

    public Student findStudentById(String ID){

    }

    public Course getCourse() {
        return course;
    }

    public int numEnrolled(){
        return enrolledStudents.size();
    }

    public void printToFile(){

    }

    public void unEnroll(String ID){

    }

    @Override
    public String toString() {
        return "Training{" +
                "course=" + course +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", pricePerStudent=" + pricePerStudent +
                ", enrolledStudents=" + enrolledStudents +
                '}';
    }
}
