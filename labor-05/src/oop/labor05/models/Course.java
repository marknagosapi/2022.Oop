package oop.labor05.models;

public class Course {

    //Variables
    private final String name;
    private final String description;
    private final int numHours;

    //Constructor
    public Course(String name, String description, int numHours) {
        this.name = name;
        this.description = description;
        this.numHours = numHours;
    }

    //Methods


    public String getDescription() {
        return description;
    }

    public int getNumHours() {
        return numHours;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", numHours=" + numHours +
                '}';
    }
}
