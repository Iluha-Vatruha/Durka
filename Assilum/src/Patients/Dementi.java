package Patients;

import Illnesses.ISleepIssue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Dementi extends Patient implements ISleepIssue {
    public static final List<Dementi> patients = new ArrayList<>();
    public Dementi(String name, int age, int health) {
        super(name, age, health);
    }

    @Override
    public void fallAsleep() throws InterruptedException {
        if (drugsTaken){
            drugsTaken = false;
            System.out.println("Patient " + name + " had good sleep at this night.");
        }
        else{
            System.out.println("Patient " + name + " trying to sleep...");
            for (int i = 0; i < 10; i++) {

                System.out.println("Sheep " + (i+1));
                TimeUnit.SECONDS.sleep(1);
            }
            age += 5;
            System.out.println("Patient " + name + " looks older that you saw hiw last time.");
        }
    }

    @Override
    public void invoke() throws InterruptedException {
        System.out.println("Patient " + name + " cant remember how he got here.");
        Random random = new Random();
        int value = random.nextInt(2);
        switch (value){
            case 0: fallAsleep(); break;
            case 1: System.out.println("Nothing happened. Everything good.");break;
        }
    }
}
