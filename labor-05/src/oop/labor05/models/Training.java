package oop.labor05.models;


import java.io.*;
import java.util.ArrayList;
import java.util.SplittableRandom;

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
        String courseName = this.course.getName();
        String startDate = this.startDate.toString();
        String endDate = this.endDate.toString();
        String[] t = startDate.split("/");
        String[] t2 = endDate.split("/");

        String endDate2 = "";
        String startDate2 = "";
        for(int i =0;i<t.length;i++){
            if(i==t.length-1){
                startDate2 += t[i].trim();
            }else {
                startDate2 += t[i].trim() + ".";
            }
        }
        for(int i =0;i<t2.length;i++){
            if(i==t2.length-1){
                endDate2 += t2[i].trim();
            } else {
                endDate2 += t2[i].trim() + ".";
            }
        }

        String filepath = courseName+"_"+startDate2+"_"+endDate2+".csv";

        File file = new File("outputFiles/"+filepath);
        boolean result;
        try{
            result = file.createNewFile();
            if(result){

            } else {
                System.out.println("File already exists!");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        try(PrintStream ps = new PrintStream(file)){
            ps.println("ID, Firstname, Last name,");
            for( Student customer: enrolledStudents ){
                ps.println( customer.getID()+", " + customer.getFirstName() +", "+
                        customer.getLastName());
            }
            ps.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public void unEnroll(String ID){
        enrolledStudents.removeIf(students -> students.getID().equals(ID));
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
