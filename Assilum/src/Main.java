import Menu.MainMenu;
import Patients.*;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Patient> patients = PatientsLits.getPatients().getList();

        patients.add(new Shizo("Zina", 62, 6));
        patients.add(new Dementi("Sergei", 75, 5));
        patients.add(new Epileptic("Kesha", 34, 8));
        MainMenu.call();
    }
}