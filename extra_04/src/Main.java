import utils.Degree;
import utils.Department;
import utils.Major;
import models.Course;
import models.Student;
import models.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //public static int MAX_COURSES = 50;
    //public static Course[] courses = new Course[MAX_COURSES];
    public static ArrayList<Course> courses = new ArrayList<>();

    public static void enrolledStudentsByMajor(Major major, String courseId){
        for(Course item: courses){
            if(item.getCourseID().equals(courseId)){
                ArrayList<Student> student = new ArrayList<>();
                student = item.getEnrolledStudents();
                for(Student item2 : student) {
                    if(item2.getMajor().equals(major)){
                        System.out.println(item2);
                    }
                }
            }
        }

    }

    public static ArrayList<Course> coursesByTeacherDegree(Degree degree){
        //int index = 0;
        //Course[] course = new Course[MAX_COURSES];
        ArrayList<Course> course = new ArrayList<>();

        for(Course item: courses){
            if(item.getTeacher().getDegree().equals(degree)){
                course.add(item);
            }
        }

        return course;
    }

    public static int nrOfCoursesByDay(DayOfWeek day){
        int counter = 0;
        for(Course item: courses){
            if(item.getDayOfCourse().equals(day)){
                counter++;
            }
        }
        return counter;
    }

    public static void cancelEnrollments(String fileName) {
        Scanner inputCancel = null;
        try {
            inputCancel = new Scanner(new File("inputFiles/" + fileName));
        } catch (FileNotFoundException s) {
            System.out.println("File not found, try again!\n");
        }


        while (inputCancel.hasNext()) {
            String code = inputCancel.next();
            //System.out.println(code);
            for (Course item : courses) {
                item.cancelEnrollmentOfStudent(code);
                /*
                ArrayList<Student> students = new ArrayList<>();
                students = item.getEnrolledStudents();
                for (Student item2 : students) {
                    if (item2.getNeptunCode().equals(code)) {
                        item.cancelEnrollmentOfStudent(code);
                    }
                }

                 */
            }

        }
    }
    public static void main(String[] args){
        /*
        Student student1 = new Student("AVLMO7", "Anne", "Bell", Major.CHEMISTRY);

        Teacher teacher1 = new Teacher("Suzanne", "Grey", Degree.DOCTOR, Department.MEDICAL_DEPARTMENT);

        Student student2 = new Student("AVLMO9", "LOL", "Bella", Major.AUTOMATION_AND_APPLIED_INFORMATICS);

        Teacher teacher2 = new Teacher("Mary", "GGreg", Degree.DOCENT, Department.HORTICULTURE);

        Student student3 = new Student("AVLM12", "Alpar", "Bello", Major.MECHATRONICS);

        Teacher teacher3 = new Teacher("SMark", "Domokos", Degree.DOCENT, Department.APPLIED_SOCIAL_SCIENCE);

        Course course1 = new Course("MB_INFO20", 5, DayOfWeek.FRIDAY);

        course1.setTeacher(teacher1);
        course1.enrollStudent(student1);
        course1.enrollStudent(student2);
        course1.enrollStudent(student3);
        System.out.println(course1);

         */


        Scanner inputUniversity = null;
        try {
            inputUniversity = new Scanner(new File("inputFiles/university.csv"));
        }catch(FileNotFoundException s){
            System.out.println("File does Not Exist Please Try Again: ");
        }

        Scanner inputStudents = null;
        try {
            inputStudents = new Scanner(new File("inputFiles/students.csv"));
        }catch(FileNotFoundException s){
            System.out.println("File does Not Exist Please Try Again: ");
        }
        int index = 0;
        int lineNum = 0;

        while(inputUniversity.hasNext())
        {
            if(lineNum%2==0){
                String contents = inputUniversity.next();
                String[] s = contents.split(",");
                int info = Integer.parseInt(s[1]);
                int day = Integer.parseInt(s[2]);
                courses.add(new Course(s[0],info,DayOfWeek.values()[day]));
                //courses[index] = new Course(s[0],info,DayOfWeek.values()[day]);
            } else {
                String contents = inputUniversity.next();
                String[] s = contents.split(",");

                int info2 = Integer.parseInt(s[3]);
                Teacher teacher = new Teacher(s[0],s[1],Degree.valueOf(s[2]),Department.values()[info2-1]);
                courses.get(index++).setTeacher(teacher);
                // courses[index++] = new Course()

                //System.out.println(contents);
            }
            lineNum++;
        }

        int lineNum2 = 0;
        Student student = null;
        while(inputStudents.hasNext()){

            if(lineNum2%2==0) {
                String contents = inputStudents.next();
                String[] s = contents.split(",");

                //Print for [debugging] purposes
                /*
                for (int i = 0; i < s.length; i++) {
                    System.out.println(s[i]);
                }
                 */

                student = new Student(s[0], s[1], s[2], Major.valueOf(s[3]));
            } else {
                String contents = inputStudents.next();
                String[] s = contents.split(",");
                for(Course item: courses){
                    for(int j=0;j<s.length;j++){
                        if(item.getCourseID().equals(s[j])){
                            item.enrollStudent(student);
                        }
                    }
                }
            }
            lineNum2++;
        }

        System.out.println(courses);

        System.out.println("********************************************************");
        System.out.println("Specific Major {MACHATRONICS} Students in course KL737: ");
        enrolledStudentsByMajor(Major.MECHATRONICS,"KL737");
        System.out.println("********************************************************");
        System.out.println("Courses which are held by a teacher with a given degree [DODCENT]:");
        ArrayList<Course> c = new ArrayList<>();
        c = coursesByTeacherDegree(Degree.DOCENT);
        System.out.println(c);
        System.out.println("********************************************************");
        System.out.println("The nr. of courses which are held on a given day {Tuesday}: " + nrOfCoursesByDay(DayOfWeek.TUESDAY));
        System.out.println("********************************************************");
        System.out.println("After cancellation of students: ");
        cancelEnrollments("cancellation.csv");
        System.out.println(courses);

    }
}
