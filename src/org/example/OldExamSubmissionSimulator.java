package org.example;

public class OldExamSubmissionSimulator {
    public static void main(String[] args) {
        System.out.println("EASTMINSTER UNIVERSITY - OLD EXAM SUBMISSION SYSTEM");

        // first test with smaller number first to see the difference clearly
        int testStudents = 1000;

        int poolsize = Runtime.getRuntime().availableProcessors()*2;

        System.out.println("Simulator Configuration");
        System.out.println("number of students: "+ testStudents);

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
        double averageWaitTime = (double) oldTotalTime / testStudents;
        System.out.println(" The problems of the old system ");
        System.out.println(" The average wait time for a student "+ averageWaitTime+ " ms.");
        System.out.println(" The last student waited: "+ oldTotalTime/1000.0 +" seconds");
        System.out.println(" This would take a lot of time with 100,000 students");



    }

}
