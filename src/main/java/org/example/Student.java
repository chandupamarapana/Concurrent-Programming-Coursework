package org.example;

import java.util.Random;

public class Student {
    private int studentId;
    private String name;
    private Random random;

    public Student(int studentId, String name, Random random){
        this.studentId = studentId;
        this.name = name;
        this.random = random;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public Random getRandom() {
        return random;
    }

    public boolean submitExam(int id, String name) throws InterruptedException{
        int simulateTime = random.nextInt(100);
        Thread.sleep(simulateTime); // Simulate the time that took for the submission
        int randomNumber = random.nextInt(100);
        if (randomNumber < 5){ // To indicate that thesimulator is falling
            System.out.println("Student id "+ id + " 's submission FAILED");
            return false;
        }
        else{
            System.out.println("Student name "+ name + " 's assignment submitted SUCCESSFULLY");
            return true;
        }
    }
}




