package Menu;

import Patients.Patient;
import Patients.PatientsLits;
import Stuff.Doctor;

import java.util.List;
import java.util.Scanner;

public class InspectionMenu {
    public static void call() throws InterruptedException {
        Scanner s = new Scanner(System.in);
        String option;
        int patientID = -1;
        List<Patient> patients = PatientsLits.getPatients().getList();

        while (true) {
            try{
                System.out.println("Choose option for this patient:");
                System.out.println("1. Give drugs.");
                System.out.println("2. Inspect.");
                System.out.println("3. Exit.");
                option = s.nextLine();

                switch (option) {
                    case "1": {
                        System.out.println("Input patients ID.");
                        patientID = Integer.valueOf(s.nextLine()) - 1;
                        if (patientID < 0 || patientID >= patients.size()){
                            throw new RuntimeException("Invalid id");
                        }
                        Doctor.getDoctor().giveDrugs(patients.get(patientID));
                    } break;
                    case "2": {
                        System.out.println("Input patients ID.");
                        patientID = Integer.valueOf(s.nextLine()) - 1;
                        if (patientID < 0 || patientID >= patients.size()){
                            throw new RuntimeException("Invalid id");
                        }
                        patients.get(patientID).invoke();
                    } break;
                    case "3": return;
                    default: System.out.println("Sir, you need to input number, not junks of bunks.");break;
                }

            }
            catch (RuntimeException exception){
                System.out.println(exception.getMessage());
                if (!(patientID < 0 || patientID >= patients.size())){
                    if (patients.get(patientID).getHealth() <= 0){
                        patients.remove(patientID);
                    }
                }
            } catch (Exception e) {
                System.out.println(
                        "Congratulations! " +
                                patients.get(patientID).getName() + " bit the doctor to death."
                        );
                System.exit(0);
            }

        }
    }
}
