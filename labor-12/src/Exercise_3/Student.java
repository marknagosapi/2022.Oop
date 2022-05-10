package Exercise_3;

public class Student implements Comparable<Student>{

    //Variables
    private final int ID;
    private final String firstName;
    private final String lastName;
    private double matek;
    private double magyar;
    private double roman;

    //Constructor

    public Student(int ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Methods

    public int getID() {
        return ID;
    }

    public void setMagyar(double magyar) {
        this.magyar = magyar;
    }

    public void setRoman(double roman) {
        this.roman = roman;
    }

    public void setMatek(double matek) {
        this.matek = matek;
    }

    public double getMagyar() {
        return magyar;
    }

    public double getMatek() {
        return matek;
    }

    public double getRoman() {
        return roman;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", matek=" + matek +
                ", magyar=" + magyar +
                ", roman=" + roman +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.ID - o.getID();
    }
}

