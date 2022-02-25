package models;

import java.time.DayOfWeek;
import java.util.ArrayList;

public class Course {

    //Variables
    //public int MAX_STUDENTS = 100;
    private Teacher teacher;
    private String courseID;
    private int numberOfCredits = 0;
    private int numberOfEnrolledStudents = 0;
    //private Student[] enrolledStudents = new Student[MAX_STUDENTS];
    private ArrayList<Student> enrolledStudents = new ArrayList<>();
    private DayOfWeek dayOfCourse;

    //Constructor
    public Course(String courseID, int b, DayOfWeek dOw){
        this.courseID = courseID;
        //this.MAX_STUDENTS = b;
        this.dayOfCourse  = dOw;
    }

    //Methods
    public int getNumberOfEnrolledStudents(){
        return numberOfEnrolledStudents;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return this.enrolledStudents;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public DayOfWeek getDayOfCourse() {
        return dayOfCourse;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void enrollStudent(Student student){

        enrolledStudents.add(student);

    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    public String getCourseID(){
        return this.courseID;
    }
    public void cancelEnrollmentOfStudent(String student){

            int index2 = 0;
            for(Student item: enrolledStudents){
                if(item.getNeptunCode().equals(student)){
                    enrolledStudents.remove(index2);
                    numberOfEnrolledStudents--;
                    break;
                }
                index2++;
            }

    }



    //ToString Method
    public String toString(){
        StringBuffer result = new StringBuffer();

        result.append("Course: " + courseID + ":\n");
        result.append("\tTeacher: " + teacher.toString() + "\n");
        result.append("\tCredits: " + numberOfCredits + "\n");
        result.append("\tOccurs every: "+ dayOfCourse + "\n");
        result.append("\tEnrolled students: \n");

        result.append("\t\t- " + enrolledStudents + "\n");


        return result.toString();
    }
}
