package Exercise_3;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        BAC bac2022 = new BAC("nevek1.txt");

        bac2022.getNotes("magyar.txt");
        bac2022.getNotes("roman.txt");
        bac2022.getNotes("matek.txt");

        System.out.println(bac2022.passed());
        bac2022.sortByComparator(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.getFirstName() + " "+o1.getLastName()).compareTo(o2.getFirstName() + " "+o2.getLastName());
            }
        });
        System.out.println();
        bac2022.printNoBacStudents();

    }
}
