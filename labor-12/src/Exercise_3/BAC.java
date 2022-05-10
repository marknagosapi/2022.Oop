package Exercise_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BAC {
    //Variable
    private final ArrayList<Student> students = new ArrayList<>();
    private final ArrayList<Student> studentsWhoNotPassed = new ArrayList<>();
    private static int passedBAC = 0;

    //Constructor

    public BAC(String inputStudents) {
        try(Scanner scanner = new Scanner(new File("inputFiles/"+inputStudents))){
            String temp;
            String[] temp2;
            while(scanner.hasNextLine()){
                temp = scanner.nextLine();
                temp2 = temp.split(" ");
                if(temp2.length > 0){
                    students.add(new Student(Integer.parseInt(temp2[0].trim()),temp2[1].trim(),temp2[2].trim()));

                }
            }
            Collections.sort(students);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    //Methods


    public void sortByComparator(Comparator<Student> comp){
        studentsWhoNotPassed.sort(comp);
    }

    public int passed(){

        for(Student student: students)
        {
            double average = (student.getMagyar()+student.getRoman()+student.getMatek())/3;
            if(student.getMagyar() >= 5 && student.getMatek() >= 5 && student.getRoman() >=5 && average >= 6 ){
               passedBAC++;

            } else {
                studentsWhoNotPassed.add(student);
            }
        }
        return passedBAC;
    }



    public void printStudents(){
        for(Student student:students){
            System.out.println(student);
        }
    }

    public void printNoBacStudents(){

        for(Student student:studentsWhoNotPassed){
            System.out.println(student);
        }

    }
    public void getNotes(String fileName) {
        try (Scanner scanner = new Scanner(new File("inputFiles/" + fileName))) {
            String temp;
            String[] temp2;
            while (scanner.hasNextLine()) {
                temp = scanner.nextLine();
                temp2 = temp.split(" ");
                if (temp2.length > 0) {
                    //int id = Collections.binarySearch(students,Integer.parseInt(temp2[0].trim()));
                    int id = binarySearch(students,0,students.size(),Integer.parseInt(temp2[0].trim()));
                            if(fileName.equals("magyar.txt")) {
                                students.get(id).setMagyar(Double.parseDouble(temp2[1].trim()));
                            } else if(fileName.equals("roman.txt")){
                                students.get(id).setRoman(Double.parseDouble(temp2[1].trim()));
                            } else {
                                students.get(id).setMatek(Double.parseDouble(temp2[1].trim()));
                            }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int binarySearch(ArrayList<Student> products,int e,int u, int key){
        if(e<=u){
            int mid = (e+u)/2;
            if(products.get(mid).getID()==key){
                return mid;
            }

            if(products.get(mid).getID() > key){
                return binarySearch(products,e,mid-1,key);
            }

            return binarySearch(products,mid+1, u,key);
        } else {
            return -1;
        }
    }

}
