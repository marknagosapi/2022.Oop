package lab10_2;

import java.util.Date;

public class Student {
    private final String NeptunId;
    private final String firstName;
    private final String lastName;
    private int credits;
    private final MyDate date;


    //Constructor

    public Student(String n, String fn,String ln, int c, int by, int bm ,int bd) throws InvalidDateException {

        this.date = new MyDate(by,bm,bd);
        this.NeptunId = n;
        this.firstName = fn;
        this.lastName = ln;
        this.credits = c;
    }

    @Override
    public String toString() {
        return "Student{" +
                "NeptunId='" + NeptunId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", credits=" + credits +
                '}';
    }
}
