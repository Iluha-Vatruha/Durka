package Patients;

import java.util.ArrayList;
import java.util.List;

public class PatientsLits {
    private static PatientsLits patients = new PatientsLits();

    private List<Patient> list;

    public PatientsLits() {
        list = new ArrayList<>();
    }

    public static PatientsLits getPatients(){
        return patients;
    }

    public List<Patient> getList() {
        return list;
    }
}
