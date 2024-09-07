package Stuff;

import Patients.Patient;

import javax.print.Doc;

public class Doctor {
    private static final Doctor doctor = new Doctor();
    private int age;
    private String name;
    private int health;

    private Doctor(){
        age = 40;
        name = "Livsey";
        health = 20;
    }
    public static Doctor getDoctor(){
        return doctor;
    }
    public void giveDrugs(Patient patient){
        if (patient.isDrugsTaken()){
            System.out.println("Doctor says: You already got your pills. Go to your cell.");
            return;
        }
        patient.setDrugsTaken(true);
    }

    public String getName() {
        return name;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
