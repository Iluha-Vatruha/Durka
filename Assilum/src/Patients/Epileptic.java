package Patients;
import Illnesses.IAgression;
import Illnesses.IOrientDisorder;
import Illnesses.ISleepIssue;
import Stuff.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Epileptic extends Patient implements IAgression, IOrientDisorder, ISleepIssue {
    public static final List<Epileptic> patients = new ArrayList<>();
    public Epileptic(String name, int age, int health) {
        super(name, age, health);
    }

    @Override
    public void bite(Doctor doctor) throws Exception {
        if (drugsTaken){
            drugsTaken = false;
            System.out.println("Patient " + name + " tried to bite the doctor.");
        }
        else{
            doctor.setHealth(doctor.getHealth() - 1);
            if (doctor.getHealth() <= 0){
                throw new Exception ("Patients killed the doctor.");
            }
            else{
                System.out.println("Patient " + name + " bit doctor. It hurts.");
            }
        }
    }

    @Override
    public void smackTheWall() {
        if (drugsTaken) {
            drugsTaken = false;
            System.out.println("Patient" + name + " tried to smack the wall");
        }
        else {
            health -= 1;
            System.out.println("Patient " + name + " smacked the wall.");
            if (health <= 0){
                throw new RuntimeException("You failed. Patient is dead");
            }
        }
    }

    @Override
    public void fallAsleep() {
        if (drugsTaken){
            drugsTaken = false;
            System.out.println("Patient " + name + " had a good sleep at this night.");
        }
        else{
            age += 5;
            System.out.println("Patient " + name + " looks older that you saw hiw last time.");
        }
    }

    @Override
    public void invoke() throws Exception {
        System.out.println("Patient " + name + " spits everywhere");
        Random random = new Random();
        int value = random.nextInt(4);
        switch (value){
            case 0: bite(Doctor.getDoctor()); break;
            case 1: smackTheWall(); break;
            case 2: fallAsleep(); break;
            case 3: System.out.println("Nothing happened. Everything good.");
        }
    }
}
