package interfaces;

import pets.Pet;
import utils.PetType;

import java.util.ArrayList;

public interface IMedicalCenter {

   void hireDoctor(IDoctor doctor);
   void fireDoctor(IDoctor doctor);
   int getNumberOfDoctors();
   int getNumberOfPatients();
   IDoctor assignPatientToADoctor(IPatient patient);
   ArrayList<IDoctor> getDoctorsByPatientType(PetType type);
   int getNumberOfFreeAppointmentsByPatient(IPatient patient);
   boolean getAvailabilityByDoctor(IDoctor doctor);

}
