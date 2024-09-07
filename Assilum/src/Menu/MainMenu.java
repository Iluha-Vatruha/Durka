package Menu;


import Patients.Patient;
import Patients.PatientsLits;
import Stuff.Doctor;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public static void call() throws InterruptedException {
        Scanner s = new Scanner(System.in);
        String option;

        while (true){
            System.out.println("Welcome to the asylum, doctor. What do you what to do?");
            System.out.println("1. Show patients list.");
            System.out.println("2. Create new patient.");
            System.out.println("3. Start inspection.");
            System.out.println("4. Leave asylum.");
            System.out.println("Current doctors " + Doctor.getDoctor().getName() + " health: " + Doctor.getDoctor().getHealth());

            option = s.nextLine();
            switch (option){
                case "1": {
                    List<Patient> patients = PatientsLits.getPatients().getList();
                    for (int i = 0; i < patients.size(); i++) {
                        System.out.println(String.valueOf(i+1) + patients.get(i));
                    }
                } break;
                case "2": CreateMenu.call(); break;
                case "3": InspectionMenu.call(); break;
                case "4": return;
                default: System.out.println("Error. Try again."); break;
            }
        }

    }
}
