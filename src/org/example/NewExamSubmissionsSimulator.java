package org.example;

public class NewExamSubmissionsSimulator {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("EASTMINSTER UNIVERSITY - NEW EXAM SUBMISSION SYSTEM");

        // first test with smaller number first to see the difference clearly
        int testStudents = 500;
        int poolsize = Runtime.getRuntime().availableProcessors()*2;
        NewSubmissionSystem newSubmissionSystem = new NewSubmissionSystem(poolsize, testStudents);
        long newStartTime = System.currentTimeMillis();

        newSubmissionSystem.processSubmission();

        long newEndTime = System.currentTimeMillis();
        long newTotalTime = newEndTime - newStartTime;

        newSubmissionSystem.shutdown();

        System.out.println("NEW submission system results");
        System.out.println("_____________________________");
        newSubmissionSystem.getStats().displayStats();
        System.out.println("Actual total time in ms: "+ newTotalTime);
        System.out.println();

        System.out.println("Advantages of the system: ");
        System.out.println(" "+poolsize + "threads working simultaneously");
        System.out.println(" therefore a much faster completion time. ");

        System.out.println();


    }
}
