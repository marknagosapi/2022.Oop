package medCenters;

import interfaces.IDoctor;
import interfaces.IMedicalCenter;
import interfaces.IPatient;
import people.Veterinarian;
import pets.Pet;
import utils.PetType;

import java.util.ArrayList;

public class Veterinary implements IMedicalCenter {
    //Variables
    public static int numOfVeterinaries = 0;
    private static ArrayList<IDoctor> doctors = new ArrayList<IDoctor>();

    private final String name;
    private final String contact;
    private int numberOfPatients;
    private int numberOfDoctors;
    private final String address;
    private String medCenterInformation;
    private final int veterinaryId;

    //Constructor
    public Veterinary(String address, String contact, String name){
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.veterinaryId = numOfVeterinaries++;
        numOfVeterinaries++;
    }

    //Methods
    public void hireDoctor(IDoctor doctor){
        doctors.add(doctor);
        numberOfDoctors++;
        numberOfPatients += ((Veterinarian)doctor).getNumberOfCurrentPatients();
    }

    public void fireDoctor(IDoctor doctor){
        if(numberOfDoctors > 0) {
            doctors.remove(doctor);
            numberOfPatients -= ((Veterinarian) doctor).getNumberOfCurrentPatients();
            numberOfDoctors--;
        }
    }

    @Override
    public int getNumberOfDoctors() {
        return doctors.size();
    }

    @Override
    public int getNumberOfPatients() {
        return numberOfPatients;
    }

    @Override
    public IDoctor assignPatientToADoctor(IPatient patient) {
        for(IDoctor doctor: doctors){
            if(doctor instanceof Veterinarian) {
                if (patient instanceof Pet) {
                    if (((Veterinarian) doctor).isAvailable() && ((Veterinarian) doctor).getSpeciality().equals(((Pet) patient).patientType())) {
                        ((Veterinarian) doctor).addNewPatient(patient);
                        return doctor;
                    }
                }
            }
        }
        System.out.println("We're sorry but unfortunately there are no opportunities to treat your pet");
        return null;
    }

    @Override
    public ArrayList<IDoctor> getDoctorsByPatientType(PetType type) {
        ArrayList<IDoctor> allDocs = new ArrayList<IDoctor>();
        for(IDoctor doctor:doctors){
            if(doctor instanceof Veterinarian){
                if (((Veterinarian) doctor).getSpeciality().equals(type)){
                    allDocs.add(doctor);
                }
            }
        }
        return allDocs;
    }

    @Override
    public int getNumberOfFreeAppointmentsByPatient(IPatient patient) {
        int counter = 0;
        for(IDoctor doctor: doctors){
            if(doctor instanceof Veterinarian) {
                if (patient instanceof Pet) {
                    if (((Veterinarian) doctor).isAvailable() && ((Veterinarian) doctor).getSpeciality().equals(((Pet) patient).patientType())) {
                       counter++;
                    }
                }
            }
        }
        return counter;
    }

    @Override
    public boolean getAvailabilityByDoctor(IDoctor doctor) {
        if(doctor instanceof Veterinarian) {
            return ((Veterinarian) doctor).available;
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(this.name + " veterinary\n");
        result.append("\t\t- Address: " + this.address + "" +
                "\n" + "\t\t- Contact: " + this.contact + "" +
                "\n" + "\t\t- Number of doctors: " + this.numberOfDoctors+ "\n"+
                "\t\t- Number of current patients: " + this.numberOfPatients + "\n"
        );
        return result.toString();
    }
}
