package models;

import java.time.DayOfWeek;

public class Course {

    //Variables
    public int MAX_STUDENTS = 100;
    private Teacher teacher;
    private String courseID;
    private int numberOfCredits = 0;
    private int numberOfEnrolledStudents = 0;
    private Student[] enrolledStudents = new Student[MAX_STUDENTS];
    private DayOfWeek dayOfCourse;

    //Constructor
    public Course(String courseID, int b, DayOfWeek dOw){
        this.courseID = courseID;
        this.MAX_STUDENTS = b;
        this.dayOfCourse  = dOw;
    }

    //Methods
    public int getNumberOfEnrolledStudents(){
        return numberOfEnrolledStudents;
    }

    public Student[] getEnrolledStudents() {
        return enrolledStudents;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public DayOfWeek getDayOfCourse() {
        return dayOfCourse;
    }

    public int getMAX_STUDENTS() {
        return MAX_STUDENTS;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void enrollStudent(Student student){
        if(MAX_STUDENTS > numberOfEnrolledStudents){
            enrolledStudents[numberOfEnrolledStudents++] = student;
        } else {
            System.out.println("All The Places Are Occupied!\n");
        }
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    public String getCourseID(){
        return this.courseID;
    }
    public void cancelEnrollmentOfStudent(String student){

            for (int i = 0; i < numberOfEnrolledStudents; i++) {
                if (enrolledStudents[i].getNeptunCode().equals(student)) {
                    //System.out.println(enrolledStudents[i].toString());
                    for (int j = i; j < numberOfEnrolledStudents-1; j++) {
                        enrolledStudents[j] = enrolledStudents[j + 1];
                    }
                    numberOfEnrolledStudents--;

                }
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
        for(int i=0;i<numberOfEnrolledStudents;i++) {
            result.append("\t\t- " + enrolledStudents[i].toString() + "\n");
        }

        return result.toString();
    }
}
