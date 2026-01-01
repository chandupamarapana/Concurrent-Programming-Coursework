package org.example;

public class ExamSubmissionSimulator {
    public static void main(String[] args) {
        System.out.println("EASTMINSTER UNIVERSITY - EXAM SUBMISSION COMPARISON");

        // first test with smaller number first to see the difference clearly
        int testStudents = 1000;

        int poolsize = Runtime.getRuntime().availableProcessors()*2;

        System.out.println("Simulator Configuration");
        System.out.println("number of students: "+ testStudents);
        System.out.println("Thread pool size "+ poolsize);
        System.out.println();


        //test old system
        System.out.println(" The old system ");
        System.out.println();

        OldSubmissionSystem oldSubmissionSystem = new OldSubmissionSystem(testStudents, poolsize);
        long oldStartTime = System.currentTimeMillis();

        oldSubmissionSystem.processSubmissions();

        long oldEndTime = System.currentTimeMillis();
        long oldTotalTime = oldEndTime - oldStartTime;

        System.out.println(" Old system results ");
        System.out.println();
        oldSubmissionSystem.getSubmissionStats().displayStats();
        System.out.println(" Actual total time in ms: "+ oldTotalTime);
        System.out.println();

        //calculate average time per student
        double oldTotalTimeDouble = (double) oldTotalTime;
        double averageWaitTime = oldTotalTimeDouble / testStudents;


    }

}
