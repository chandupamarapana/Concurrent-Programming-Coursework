package org.example;

import java.util.Random;

public class Student {
    private int studentId;
    private String name;
    private Random random;

    public Student(int studentId, String name){
        this.studentId = studentId;
        this.name = name;
        this.random = new Random();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
    public void setName(String name){
        this.name = name ;
    }

    public Random getRandom() {
        return random;
    }

    public boolean submitExam(String name) throws InterruptedException{
        // to simulate a random processing time
        int simulateTime = random.nextInt(100);
        Thread.sleep(simulateTime); // Simulate the time that took for the submission
        int randomNumber = random.nextInt(100); //this represents real-world issues
        if (randomNumber < 5){ // To indicate that the simulator is falling
            System.out.println("Student name "+ name + " 's submission FAILED");
            return false;
        }
        else{
            System.out.println("Student name "+ name + " 's assignment submitted SUCCESSFULLY");
            return true; // 95% chance of success
        }
    }
}




