package org.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewSubmissionSystem {
    private int numofStudents;
    private int poolSize;
    private SubmissionStats submissionStats;
    private ExecutorService executor;

    public NewSubmissionSystem(int poolSize, int numofStudents){
        this.poolSize = poolSize;
        this.submissionStats = new SubmissionStats();
        this.numofStudents = numofStudents;
    }
    // The new system uses a threadpool with multiple threads processing concurrently
    // Each student submission is a separated task submitted to the pool
    public void processSubmission(){
        System.out.println("The new submissions system");
        System.out.println(" Processing "+ numofStudents+ " submissions concurrently ");
        System.out.println("Thread pool size " + poolSize);
        System.out.println();

        //Create thread pool with specified number of threads
        executor = Executors.newFixedThreadPool(poolSize);

        //CountdownLatch to wait for all submissions to complete
        // Initiated with the number of students - counts down to zero
        CountDownLatch countDownLatch = new CountDownLatch(numofStudents);

        submissionStats.setStartTime();

        //submit each student as a separate task to the thread pool
        for (int i = 0; i< numofStudents; i++){

        }
    }

}
