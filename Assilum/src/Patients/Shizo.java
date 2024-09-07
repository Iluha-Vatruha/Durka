package Patients;

import Illnesses.IOrientDisorder;
import Illnesses.ISleepIssue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shizo extends Patient implements ISleepIssue, IOrientDisorder {
    public static final List<Shizo> patients = new ArrayList<>();
    public Shizo(String name, int age, int health) {
        super(name, age, health);
    }

    @Override
    public void smackTheWall() {
        Random random = new Random();
        if (random.nextBoolean()){
            return;
        }
        if (drugsTaken) {
            drugsTaken = false;
            System.out.println("Patient " + name + " tried to smack the wall, but nothing happened.");
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
            System.out.println("Patient " + name + " had good sleep at this night.");
        }
        else{
            age += 5;
            System.out.println("Patient " + name + " looks older that you saw hiw last time.");
        }
    }

    @Override
    public void invoke() {
        System.out.println("Patient " + name + " talks with walls. Walls not answer him.");
        Random random = new Random();
        int value = random.nextInt(3);
        switch (value){
            case 0: smackTheWall(); break;
            case 1: fallAsleep(); break;
            case 2: System.out.println("Nothing happened. Everything good.");
        }
    }
}
