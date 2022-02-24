import enums.Degree;
import enums.Department;
import enums.Major;
import models.Course;
import models.Student;
import models.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.util.Scanner;

public class Main {
    public static int MAX_COURSES = 50;
    public static Course[] courses = new Course[MAX_COURSES];
    public static void enrolledStudentsByMajor(Major major, String courseId){
        for(int i=0;i<MAX_COURSES;i++){
            if(courses[i].getCourseID().equals(courseId)){
                Student[] students = courses[i].getEnrolledStudents();
                int nrOfStudents = courses[i].getNumberOfEnrolledStudents();
                for(int j=0;j<nrOfStudents;j++){
                    if(students[j].getMajor().equals(major)){
                        System.out.println(students[j]);
                    }
                }

            }
        }
    }

    public static Course[] coursesByTeacherDegree(Degree degree){
        int index = 0;
        Course[] course = new Course[MAX_COURSES];

        for(int i=0;i<MAX_COURSES;i++){

            if(courses[i].getTeacher().getDegree().equals(degree)){
                course[index++] = courses[i];
            }

        }

        return course;
    }

    public static int nrOfCoursesByDay(DayOfWeek day){
        int counter = 0;
        for(int i=0;i<courses.length;i++){
            if(courses[i].getDayOfCourse().equals(day)){
                counter++;
            }
        }
        return counter;
    }

    public static void cancelEnrollments(String fileName){
        Scanner inputCancel = null;
        try {
            inputCancel = new Scanner(new File("inputFiles/" + fileName));
        } catch(FileNotFoundException s){
            System.out.println("File not found, try again!\n");
        }


        while(inputCancel.hasNext()){
            String code = inputCancel.next();
            //System.out.println(code);
            for(int i=0;i<MAX_COURSES;i++){
                Student[] student = courses[i].getEnrolledStudents();
                int nrOfStudents = courses[i].getNumberOfEnrolledStudents();
                for(int j=0;j<nrOfStudents;j++){
                    if(student[j].getNeptunCode().equals(code)){
                        courses[i].cancelEnrollmentOfStudent(code);
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        /*
        Student student1 = new Student("AVLMO7", "Anne", "Bell", Major.INFORMATION_SCIENCE);

        Teacher teacher1 = new Teacher("Suzanne", "Grey", Degree.DOCENT, Department.MATHEMATICS_INFORMATICS);

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
                courses[index] = new Course(s[0],info,DayOfWeek.values()[day]);
            } else {
                String contents = inputUniversity.next();
                String[] s = contents.split(",");

                int info2 = Integer.parseInt(s[3]);
                Teacher teacher = new Teacher(s[0],s[1],Degree.valueOf(s[2]),Department.values()[info2-1]);
                courses[index++].setTeacher(teacher);
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
                for(int i=0;i<MAX_COURSES;i++){
                    for(int j=0;j<s.length;j++){
                        if(courses[i].getCourseID().equals(s[j])){
                            courses[i].enrollStudent(student);
                        }
                    }
                }
            }
            lineNum2++;
        }

        for(int i=0;i<MAX_COURSES;i++){

            System.out.println(courses[i]);
        }

        System.out.println("********************************************************");
        System.out.println("Specific Major {MACHATRONICS} Students in course KL737: ");
        enrolledStudentsByMajor(Major.MECHATRONICS,"KL737");
        System.out.println("********************************************************");
        System.out.println("Courses which are held by a teacher with a given degree [DODCENT]:");
        Course[] c = coursesByTeacherDegree(Degree.DOCENT);
        for(int i=0;i<c.length;i++){
            if(c[i] != null) {
                System.out.println(c[i]);
            }
        }
        System.out.println("********************************************************");
        System.out.println("The nr. of courses which are held on a given day {Tuesday}: " + nrOfCoursesByDay(DayOfWeek.TUESDAY));
        System.out.println("********************************************************");
        System.out.println("After cancellation of students: ");
        cancelEnrollments("cancellation.csv");
        for(int i=0;i<courses.length;i++) {
            System.out.println(courses[i]);
        }

    }
}
